/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.longswordusersmodule;
import org.codehaus.jettison.json.JSONException;
/**
 *
 * @author takalani
 */
public interface User_Interface {
   public String getUser(String userName);
    public String authenticate(String userName, String password);
    public String isAuthenticated();
    public String registerAsUser(String jsonUser);
    public String grantAdminRight(String userName);
    public String deleteUser(String userName);
}
