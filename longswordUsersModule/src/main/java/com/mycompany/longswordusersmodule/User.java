/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.longswordusersmodule;
import javax.xml.bind.annotation.*;

/**
 *
 * @author takalani
 */
@XmlRootElement(name = "User")
public class User {
    private String username;
    private String password;
    
    public User(String uName,String password)
    {
        this.username = uName;
        this.password = password;
    }
    @XmlElement(name = "username")
    public String getUsername()
    {
        return this.username;
    }
    
    public void setPassword(String tempPassword)
    {
        this.password = tempPassword;
    }
    
}
