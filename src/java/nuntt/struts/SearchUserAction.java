/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuntt.struts;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import nuntt.daos.RegistrationDAO;
import nuntt.dtos.RegistrationDTO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action(value = "/SearchUser", results = {
    @Result(name = "success", location = "/admin/usermanager.jsp")
})
public class SearchUserAction extends ActionSupport {
    private String searchValue;
    List<RegistrationDTO> result = new ArrayList<>();
    public SearchUserAction() {
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<RegistrationDTO> getResult() {
        return result;
    }

    public void setResult(List<RegistrationDTO> result) {
        this.result = result;
    }
    
    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        result = dao.findByLikeFullname(searchValue);
        return "success";
    }
    
}
