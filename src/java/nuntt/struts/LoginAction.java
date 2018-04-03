/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuntt.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import nuntt.daos.RegistrationDAO;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action(value = "/Login", results = {
    @Result(name = "admin", location = "/SearchEvent.action", type = "redirect", params = {"searchValue", ""})
    ,
    @Result(name = "user", location = "/GetProfile.action", type = "redirect")
    ,
    @Result(name = "fail", location = "/error.jsp")
})
public class LoginAction extends ActionSupport {

    private String username, password;

    public LoginAction() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        String role = dao.checkLogin(username, password);
        HttpServletRequest request = ServletActionContext.getRequest();
        Map session = ActionContext.getContext().getSession();
        session.put("USERLOGIN", username);
        session.put("ROLELOGIN", role);
        if (role.equals("admin") || role.equals("user")) {
            return role;
        }
        if (role.equals("fail")) {
            request.setAttribute("ERROR", "Invalid Username or Password!");
            return role;
        }
        request.setAttribute("ERROR", "Role is error");
        return "fail";
    }

}
