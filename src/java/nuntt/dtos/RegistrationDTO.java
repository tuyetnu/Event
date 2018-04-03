/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuntt.dtos;

import java.io.Serializable;


public class RegistrationDTO implements Serializable{
    private String username, password, fullname, role;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String username, String fullname, String role) {
        this.username = username;
        this.fullname = fullname;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" + "username=" + username + ", password=" + password + ", fullname=" + fullname + ", role=" + role + '}';
    }
    
    
}
