/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.longswordusersmodule;
import java.util.ArrayList;
/**
 *
 * @author takalani
 */
public interface User_Interface {
    public User getUser(String userName);
    public Boolean authenticate(String userName, String password);
    public Boolean isAuthenticated();
    public Boolean registerAsUser(String userName, String Password, String firstName, String email, String lastName);
    public Boolean addUser(User user);
    public Boolean addUsers(ArrayList<User> users);
    public Boolean removeUser(User user);
    public Boolean grantAdminRight(User user);
}
