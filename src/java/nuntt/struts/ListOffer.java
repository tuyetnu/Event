/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuntt.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import nuntt.daos.RegistrationDAO;
import nuntt.dtos.EventDTO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author HaiNVSE62544
 */
@Action(value = "/ListOffer", results = {
    @Result(name = "success", location = "/user/listoffer.jsp")
})
public class ListOffer extends ActionSupport {

    List<EventDTO> result = new ArrayList<>();

    public ListOffer() {
    }

    public List<EventDTO> getResult() {
        return result;
    }

    public void setResult(List<EventDTO> result) {
        this.result = result;
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        String user = (String) session.get("USERLOGIN");
        RegistrationDAO dao = new RegistrationDAO();
        result = dao.findListOffer(user);
        return "success";
    }

}
