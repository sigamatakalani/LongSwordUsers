/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.longswordusersmodule;
import java.util.*;

/**
 *
 * @author takalani
 */
public class User_Manager implements User_Interface{
  
    public ArrayList findAll(){
        ArrayList newList = new ArrayList<>();
        newList.add(new User(1,"taki","123",false));
        newList.add(new User(2,"Pete","typ",true));
        newList.add(new User(3,"Marry","retw",false));
        return newList;
    }

    //Required functions

    /**
     *Takes in a username string and returns the user object with the users data
     * @param username
     * @return
     */
 
    public User getUser(String username){
        User wantedUser = new User(4,username,"456",false);
        return wantedUser;
    }
    
    /**
     *Used to login user
     * @param username
     * @param password
     * @return
     */

    public Boolean authenticate(String username,String password){
        //check authenticate user then return true or false
        //create session
        Boolean isAuth = true;
        return isAuth;
    }
    
        /**
     *Checks if user is already logged
     * @return
     */

    public Boolean isAuthenticated(){
        //check authenticate user then return true or false using somekind of session management
        Boolean isAuth = true;
        return isAuth;
    }
    
  
    public Boolean registerAsUser(String username,String password){
        //Register the user and return succes or failed
         User newUser = new User(5,username,"456",false);
        Boolean success = true;
        return success;
    }
    

    public Boolean addUser(User user){
        //add  the user and return true if the user has been added
        //check if the current logged in user is an addmin if not return false
         User wantedUser = new User(4,user.getUsername(),"456",false);
        Boolean success = true;
        return success;
    }
    

    public Boolean removeUser(User user){
        //add  the user and return true if the user has been added
        Boolean success = true;
        return success;
    }
    
    
    public Boolean grantAdminRight(User user){
        //grant admin rights to this user
        Boolean success = true;
        return success;
    }
    
    
}

