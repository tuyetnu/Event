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
import nuntt.dtos.RegistrationDTO;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action(value = "/SaveProfile", results = {
    @Result(name = "success", location = "/GetProfile.action", type = "redirect")
    ,
    @Result(name = "fail", location = "/error.jsp"),
})
public class SaveProfileAction extends ActionSupport {

    String username, fullname, password, confirm;

    public SaveProfileAction() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        String role = (String) session.get("ROLELOGIN");
        RegistrationDAO dao = new RegistrationDAO();
        RegistrationDTO dto = new RegistrationDTO(username, fullname, role);
        dto.setPassword(password);
        boolean check = dao.updateHasPass(dto);
        if (check) {
            return "success";
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("ERROR", "Save Profile is error");
        return "fail";
    }

}
