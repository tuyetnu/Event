/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuntt.struts;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import nuntt.daos.RegistrationDAO;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action(value = "/DeleteUser", results = {
    @Result(name = "success", location = "/SearchUser.action", type = "redirect", params = {"searchValue", "%{searchValue}"})
    ,
    @Result(name = "go", location = "/admin/delete.jsp")
    ,
    @Result(name = "fail", location = "/error.jsp")
})
public class DeleteUserAction extends ActionSupport {

    String userDelete, searchValue, action;

    public DeleteUserAction() {
    }

    public String getUserDelete() {
        return userDelete;
    }

    public void setUserDelete(String userDelete) {
        this.userDelete = userDelete;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String execute() throws Exception {
        System.out.println("VL:" + userDelete + searchValue);
        if (action.equals("delete")) {
            RegistrationDAO dao = new RegistrationDAO();
            List<String> listOffer = dao.getAllListId(userDelete);
            for (int i = 0; i < listOffer.size(); i++) {
                dao.deleteEvent(listOffer.get(i));
            }
            boolean check = dao.delete(userDelete);
            if (check) {
                return "success";
            } else {
                HttpServletRequest request = ServletActionContext.getRequest();
                request.setAttribute("ERROR", "Delete user isn't success");
                return "fail";
            }
        } else if (action.equals("click")) {
            return "go";
        }
        return "success";
    }

}
