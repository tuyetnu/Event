/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuntt.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import javax.servlet.http.HttpServletRequest;
import nuntt.daos.RegistrationDAO;
import nuntt.dtos.RegistrationDTO;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author HaiNVSE62544
 */
@Action(value = "/Update", results = {
    @Result(name = "success", location = "/SearchUser.action", type = "redirect", params = {"searchValue", "%{searchValue}"})
    ,
    @Result(name = "fail", location = "/error.jsp")
    ,
    @Result(name = "input", location = "/admin/edit.jsp"),})
public class UpdateAction extends ActionSupport {

    private String username, fullname;
    private boolean password;
    private String role, searchValue;

    public UpdateAction() {
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

    @Validations(requiredStrings = {
        @RequiredStringValidator(type = ValidatorType.FIELD, message = "Fullname must be blank!")})
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isPassword() {
        return password;
    }

    public void setPassword(boolean password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        RegistrationDTO dto = new RegistrationDTO(username, fullname, role);
        boolean check;
        if (password) {
            dto.setPassword("1234");
            check = dao.updateHasPass(dto);
        } else {
            check = dao.update(dto);
        }

        if (check) {
            return "success";
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("ERROR", "Update is error");
        return "fail";
    }

}
