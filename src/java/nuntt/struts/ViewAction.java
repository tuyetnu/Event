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
import nuntt.dtos.EventDTO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;


@Action(value = "/View", results = {
    @Result(name = "success", location = "/view.jsp")
})
public class ViewAction extends ActionSupport {

    List<EventDTO> result = new ArrayList<>();

    public ViewAction() {
    }

    public List<EventDTO> getResult() {
        return result;
    }

    public void setResult(List<EventDTO> result) {
        this.result = result;
    }

    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        result = dao.getView();
        System.out.println(result.size());
        return "success";
    }

}
