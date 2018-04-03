/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuntt.struts;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import nuntt.daos.RegistrationDAO;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action(value = "/EditStatus", results = {
    @Result(name = "success", location = "/SearchEvent.action", type = "redirect", params = {"searchValue", "%{searchValue}"})
    ,
    @Result(name = "fail", location = "/error.jsp")
})
public class EditStatusAction extends ActionSupport {

    private String id, status, searchValue, reason;

    public EditStatusAction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        boolean check = dao.editStatus(id, status, reason);
        if (check) {
            return "success";
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("ERROR", "Edit status is error!");
        return "fail";
    }

}
