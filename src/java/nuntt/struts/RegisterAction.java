/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuntt.struts;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import nuntt.daos.RegistrationDAO;
import nuntt.dtos.RegistrationDTO;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;


@Action(value = "/Register", results = {
    @Result(name = "success", location = "/login.jsp")
    ,
    @Result(name = "fail", location = "/error.jsp")
})
public class RegisterAction extends ActionSupport {

    private String username, fullname, password, confirm;

    public RegisterAction() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        RegistrationDTO dto = new RegistrationDTO(username, fullname, "user");
        dto.setPassword(password);
        boolean check = dao.insert(dto);
        if (check) {
            return "success";
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("ERROR", "Insert to DB is error");
        return "fail";
    }

}
