/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuntt.struts;

import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import nuntt.daos.RegistrationDAO;
import nuntt.dtos.EventDTO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class SearchEventAction extends ActionSupport {

    private String searchValue;
    List<EventDTO> result = new ArrayList<>();

    public SearchEventAction() {
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<EventDTO> getResult() {
        return result;
    }

    public void setResult(List<EventDTO> result) {
        this.result = result;
    }

    @Action(value = "/SearchEvent", results = {
        @Result(name = "success", location = "/admin/index.jsp")
    })
    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        result = dao.findEventLikeByUser(searchValue);
        return "success";
    }   

}
