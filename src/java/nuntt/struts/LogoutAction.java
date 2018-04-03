/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuntt.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action(value = "/logout", results = {
    @Result(name = "success", location = "/index.jsp")
})
public class LogoutAction extends ActionSupport {

    public LogoutAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        session.put("USERLOGIN", "");
        session.put("ROLELOGIN", "");
        return "success";
    }

}
