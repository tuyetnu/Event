/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuntt.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import nuntt.daos.RegistrationDAO;
import nuntt.dtos.RegistrationDTO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action(value = "/EditUser", results = {
    @Result(name = "success", location = "/admin/edit.jsp")
})
public class EditUserAction extends ActionSupport {

    String userEdit, searchValue;

    public EditUserAction() {
    }

    public String getUserEdit() {
        return userEdit;
    }

    public void setUserEdit(String userEdit) {
        this.userEdit = userEdit;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        RegistrationDTO dto = dao.findByPK(userEdit);
        Map session = ActionContext.getContext().getSession();
        session.put("DTO", dto);
        return "success";
    }

}
