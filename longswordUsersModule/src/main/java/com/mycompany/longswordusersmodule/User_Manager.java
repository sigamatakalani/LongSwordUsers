/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.longswordusersmodule;
import Mocking.UserFacade;
import java.io.PrintWriter;
import java.util.*; 
import junit.framework.Assert;
import java.sql.*;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


/**
 *
 * @author takalani
 */
public abstract class User_Manager implements User_Interface{
    
    UserFacade uFacade;
    
        private Connection con;
    private Statement st;
    private ResultSet rs;
    PrintWriter pw ;//= new PrintWriter(os, true);

    User_Manager(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/longswordusermanager","root","");
            st= con.createStatement();
        }catch(Exception e){
            System.out.println("Erro: "+e);
        }
    }
    
    
  
    public List<User> findAll(){
        List<User> newList = uFacade.getAll();
        return newList;
    }

    //Required functions

    /**
     *Takes in a username string and returns the user object with the users data
     * @param username
     * @return
     */
 
    public User getUser(String username){
        //Do a database request to find the user by username and return the user object
        User wantedUser = new User();
        return wantedUser;
    }
    
    /**
     *Used to login user
     * @param username
     * @param password
     * @return
     */

    public Boolean authenticate(String username,String password){
        //Takes in a username and password and finds a match from the db if not found then return false if found return true
        //If true then session will be created in the webservice an user will be logged in
        Boolean isAuth = true;
        return isAuth;
    }
    
        /**
     *Checks if user is already logged
     * @return
     */

    public Boolean isAuthenticated(){
        //Checks if theres still an active session if not returnes false
        Boolean isAuth = true;
        return isAuth;
    }
    
 
    public String registerAsUser(String json) throws JSONException{
        //Register the user and return succes or failed
        JSONObject jsonObj = new JSONObject(json);
        
        User newUser = new User(jsonObj.getString("username"),jsonObj.getString("password"),Boolean.parseBoolean(jsonObj.getString("isAdmin")),jsonObj.getString("lastname"),jsonObj.getString("firstname"),jsonObj.getString("email"));
        Boolean success = persistUser(newUser);
       
        JSONObject retObj = new JSONObject();
        retObj.put("success",success);
       
        return retObj.toString();
    }
    

    public Boolean addUser(User user){
        //add  the user and return true if the user has been added
        //check if the current logged in user is an addmin if not return false
         //User wantedUser = new User(4,user.getUsername(),"456",false);
         
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
    
    //Temp functions will be removed
    public Boolean persistUser(User user)
    {
        try{
            this.pw=pw;
            String query;
           
            query ="INSERT INTO user (`username`, `password`, `isAdmin`,`activated`,`lastname`,`firstname`,`email`) VALUES ('"+user.getUsername()+"', '"+user.getPassword()+"', '"+user.getIsAdmin()+"','"+user.getActivated()+"','"+user.getLastname()+"','"+user.getFirstname()+"','"+user.getEmail()+"')";
            st.executeUpdate(query);
            System.out.println("Records from table");
            pw.println("");
            pw.println("================ Appointment Created ======================");
            return true;
        }
        catch(Exception e){
            System.out.println("Erro with query: "+e);
            return false;
        }
    }
    
}

