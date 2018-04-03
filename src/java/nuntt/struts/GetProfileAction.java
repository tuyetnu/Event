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

@Action(value = "/GetProfile", results = {
    @Result(name = "admin", location = "/admin/editprofile.jsp")
    ,
    @Result(name = "user", location = "/user/index.jsp"),
})
public class GetProfileAction extends ActionSupport {
    
    public GetProfileAction() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        String username = (String) session.get("USERLOGIN");
        RegistrationDAO dao = new RegistrationDAO();
        RegistrationDTO info = dao.findByPK(username);
        session.put("INFO", info);
        String role = (String) session.get("ROLELOGIN");
        return role;
    }
    
}
