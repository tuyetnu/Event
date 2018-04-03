/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuntt.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import nuntt.daos.RegistrationDAO;
import nuntt.dtos.EventDTO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action(value = "/Detail", results = {
    @Result(name = "success", location = "/detail.jsp")
})
public class DetailAction extends ActionSupport {

    private String id;

    public DetailAction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = timeFormat.format(today.getTime());
        EventDTO dto = dao.getInfo(id);
        Map session = ActionContext.getContext().getSession();
        session.put("DTO", dto);
        return SUCCESS;
    }


}
