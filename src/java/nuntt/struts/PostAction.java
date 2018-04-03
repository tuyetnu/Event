/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuntt.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import nuntt.daos.RegistrationDAO;
import nuntt.dtos.EventDTO;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action(value = "/Post", results = {
    @Result(name = "success", location = "/index.jsp")
    ,
    @Result(name = "fail", location = "/error.jsp")
    ,
    @Result(name = "input", location = "/post.jsp"),})
public class PostAction extends ActionSupport {

    String title, min, max;
    String startDate, endDate;
    String category;
    File image;
    String userPost, description;

    public PostAction() {
    }

    public String getTitle() {
        return title;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Tilte can't be blank")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getMin() {
        return min;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Min can't be blank")
    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Max can't be blank")
    public void setMax(String max) {
        this.max = max;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCategory() {
        return category;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Category can't be blank")
    public void setCategory(String category) {
        this.category = category;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getUserPost() {
        return userPost;
    }

    public void setUserPost(String userPost) {
        this.userPost = userPost;
    }

    public String getDescription() {
        return description;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Description can't be blank")
    public void setDescription(String description) {
        this.description = description;
    }

    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        int id = dao.getId();
        String fileName = id + ".jpg";
        String RealPath = ServletActionContext.getServletContext().getRealPath("/") + "upload\\" + fileName;
        File saveFile = new File(RealPath);
        FileUtils.copyFile(image, saveFile);
        String path = "/Event/upload/" + fileName;
        EventDTO dto = new EventDTO(id + "", userPost, title, startDate, endDate, min, max, category, description, path, "Pending", "");
        boolean check = dao.InsertPost(dto);
        if (check) {
            return "success";
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("ERROR", "Post isn't success");
        return "fail";
    }

}
