/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.longswordusersmodule;
import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 *
 * @author takalani
 */
@XmlRootElement(name = "User")
public class User {
    private int id;
    private String username;
    private String password;
    private Boolean isAdmin;
    private String firstname;
    private String email;
    private String lastname;
    private Boolean activated;
    private String activatedKey;
    private String resetKey;
    private Date resetDate;
    
    public User(int id,String uName,String password,Boolean isadmin)
    {
        this.id = id;
        this.username = uName;
        this.password = password;
        this.isAdmin = isadmin;
        this.activated = true;
    }
    @XmlElement(name = "username")
    public String getUsername()
    {
        return this.username;
    }
    
    @XmlElement(name = "isAdmin")
    public Boolean getIsAdmin()
    {
        return this.isAdmin;
    }
    
    public void setPassword(String tempPassword)
    {
        this.password = tempPassword;
    }
    
    public void setIsAdmin(Boolean isAdmin)
    {
        this.isAdmin = isAdmin;
    }
    
}
