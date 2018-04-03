/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuntt.daos;

import nuntt.db.MyConnection;
import nuntt.dtos.RegistrationDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import nuntt.dtos.EventDTO;

public class RegistrationDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public String checkLogin(String username, String password) throws Exception {
        String role = "fail";
        try {
            String sql = "Select Role from Account where Username = ? and Password = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                role = rs.getString("Role");
            }
        } finally {
            closeConnection();
        }
        return role;
    }

    public RegistrationDTO findByPK(String user) throws Exception {
        RegistrationDTO dto = null;
        try {
            String sql = "Select Username, Fullname, Role from Account where username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, user);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String username = rs.getString("Username");
                String fullname = rs.getString("Fullname");
                String role = rs.getString("Role");
                dto = new RegistrationDTO(username, fullname, role);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<RegistrationDTO> findByLikeFullname(String search) throws Exception {
        List<RegistrationDTO> result = null;
        try {
            String sql = "Select Username, Fullname, Role from Account where Fullname LIKE ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            String username;
            String fullname;
            String role;
            result = new ArrayList<>();
            while (rs.next()) {
                username = rs.getString("Username");
                fullname = rs.getString("Fullname");
                role = rs.getString("Role");
                result.add(new RegistrationDTO(username, fullname, role));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean delete(String username) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete From Account Where Username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insert(RegistrationDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Account (Username, Password, Fullname, Role) values (?, ?, ?, ?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getRole());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(RegistrationDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Account set Fullname = ?, Role = ? where Username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getFullname());
            preStm.setString(2, dto.getRole());
            preStm.setString(3, dto.getUsername());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateHasPass(RegistrationDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Account set Password = ?, Fullname = ?, Role = ? where Username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getPassword());
            preStm.setString(2, dto.getFullname());
            preStm.setString(3, dto.getRole());
            preStm.setString(4, dto.getUsername());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

//    Upload
    // get last id from Post
    public int getId() throws Exception {
        int id = 0;
        try {
            String sql = "Select Id from EventInformation";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                // lấy id trong bảng. khi vòng while kết thúc. sẽ được id cuối trong bảng
                id = Integer.parseInt(rs.getString("Id"));
            }
        } finally {
            closeConnection();
        }
        // trả về id + 1; nếu insert thêm 1 record thì insert vs id + 1 này
        return id + 1;
    }

    // insert post vs thông tin từ postDTO
    public boolean InsertPost(EventDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into EventInformation (Id, UserPost, Title, StartDate, EndDate, Min, Max, Category, Description, Image, Status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getUserPost());
            preStm.setString(3, dto.getTitle());
            preStm.setString(4, dto.getStartDate());
            preStm.setString(5, dto.getEndDate());
            preStm.setString(6, dto.getMin());
            preStm.setString(7, dto.getMax());
            preStm.setString(8, dto.getCategory());
            preStm.setString(9, dto.getDescription());
            preStm.setString(10, dto.getImage());
            preStm.setString(11, dto.getStatus());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    // tìm kiếm tất cả các post với UserPost gần giống từ khóa searchValue đưa vào
    public List<EventDTO> findEventLikeByUser(String username) throws Exception {
        List<EventDTO> result = null;
        try {
            String sql = "Select Id, UserPost, Title, StartDate, EndDate, Status from EventInformation where UserPost LIKE ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + username + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            String id, userPost, title, startDate, endDate, status;
            Date today = new Date(System.currentTimeMillis());
            SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = timeFormat.format(today.getTime());
            while (rs.next()) {
                id = rs.getString("Id");
                userPost = rs.getString("UserPost");
                title = rs.getString("Title");
                startDate = rs.getString("StartDate");
                endDate = rs.getString("EndDate");
                status = rs.getString("Status");
                if (status.equals("Approved")) {
                    if (dateCompate(currentDate, startDate) >= 0 && dateCompate(currentDate, endDate) <= 0) {
                        status = "Opened";
                    } else if (dateCompate(currentDate, endDate) > 0) {
                        status = "Closed";
                    } else {
                        status = "Coming";
                    }
                } else if (status.equals("Pending") && dateCompate(currentDate, startDate) >= 0) {
                    status = "Exprired";
                }
                result.add(new EventDTO(id, userPost, title, startDate, endDate, status));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<EventDTO> findListOffer(String username) throws Exception {
        List<EventDTO> result = null;
        try {
            String sql = "Select Id, Title, StartDate, EndDate, Status, Reason from EventInformation where UserPost = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            String id, title, startDate, endDate, status, reason;
            while (rs.next()) {
                status = rs.getString("Status");
                if (status.equals("Deleted")) {
                    continue;
                }
                id = rs.getString("Id");
                title = rs.getString("Title");
                startDate = rs.getString("StartDate");
                endDate = rs.getString("EndDate");
                reason = rs.getString("Reason");
                result.add(new EventDTO(id, title, startDate, endDate, status, reason));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    //chỉnh sửa trang thái của 1 Post. Đưa vào Id để tìm kiếm bài đăng sau đó sửa Status vs status đưa vào (true, false, delete)
    public boolean editStatus(String id, String status, String reason) throws Exception {
        boolean check = false;
        try {
            String sql = "Update EventInformation set Status = ?, Reason = ? where Id = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, status);
            preStm.setString(2, reason);
            preStm.setString(3, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteEvent(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete From EventInformation Where Id = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    // lấy tất cả các thông tin của Post với trạng thái là True
    // Hiện thi list này lên view.jsp
    public List<EventDTO> getView() throws Exception {
        List<EventDTO> result = null;
        try {
            String sql = "Select Id, UserPost, Title, StartDate, EndDate, Min, Max, Category, Description, Image, Status from EventInformation where Status = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "Approved");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            String id, title, image;
            while (rs.next()) {
                id = rs.getString("Id");
                title = rs.getString("Title");
                image = rs.getString("Image");
                result.add(new EventDTO(id, title, image));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    // lay Account cua 1 Post 
    // de hien thi len trang detail.jsp
    public EventDTO getInfo(String id) throws Exception {
        EventDTO result = null;
        try {
            String sql = "Select Id, UserPost, Title, StartDate, EndDate, Min, Max, Category, Description, Image, Status from EventInformation where Id = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            String userPost, title, startDate, endDate, min, max, category, description, image, status;
            Date today = new Date(System.currentTimeMillis());
            SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = timeFormat.format(today.getTime());
            if (rs.next()) {
                id = rs.getString("Id");
                userPost = rs.getString("UserPost");
                title = rs.getString("Title");
                startDate = rs.getString("StartDate");
                endDate = rs.getString("EndDate");
                min = rs.getString("Min");
                max = rs.getString("Max");
                category = rs.getString("Category");
                description = rs.getString("Description");
                image = rs.getString("Image");
                status = rs.getString("Status");
                if (dateCompate(currentDate, startDate) >= 0 && dateCompate(currentDate, endDate) <= 0) {
                    status = "Opened";
                } else if (dateCompate(currentDate, endDate) > 0) {
                    status = "Closed";
                } else {
                    status = "Coming";
                }
                result = new EventDTO(id, userPost, title, startDate, endDate, min, max, category, description, image, status, "");
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<String> getAllListId(String username) throws Exception {
        List<String> result = null;
        try {
            String sql = "Select Id From EventInformation where UserPost = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                result.add(rs.getString("Id"));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public int dateCompate(String dateA, String dateB) {
        String[] tmpA = dateA.split("-");
        String[] tmpB = dateB.split("-");
        int dayA = Integer.parseInt(tmpA[0]);
        int monthA = Integer.parseInt(tmpA[1]);
        int yearA = Integer.parseInt(tmpA[2]);
        int dayB = Integer.parseInt(tmpB[0]);
        int monthB = Integer.parseInt(tmpB[1]);
        int yearB = Integer.parseInt(tmpB[2]);
        if (yearA < yearB || monthA < monthB || dayA < dayB) {
            return -1;
        } else if (yearA > yearB || monthA > monthB || dayA > dayB) {
            return 1;
        } else {
            return 0;
        }
    }

}
