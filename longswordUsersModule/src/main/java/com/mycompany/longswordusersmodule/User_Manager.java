/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.longswordusersmodule;
import Mocking.UserFacade;
import com.google.gson.Gson;
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
 
    public String getUser(String usernameJson){
        //Do a database request to find the user by username and return the user object
        User tempUser = new User();
        try{
            JSONObject jsonObj = new JSONObject(usernameJson);
            String username = jsonObj.getString("username");
            //go to databse and get the user using this username
            tempUser = getUserFromDb(username);
            //return the user and save the user into the tempUser Object
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        Gson gson = new Gson();
        String returnString = gson.toJson(tempUser);
        return returnString;
    }
    
    /**
     *Used to login user
     * @param username
     * @param password
     * @return
     */

    public String authenticate(String usernameJson,String passwordJson){
        //Takes in a username and password and finds a match from the db if not found then return false if found return true
        //If true then session will be created in the webservice an user will be logged in
        //the password needs to be hashed
     
        String userName = "";
        String password = "";
        User tempUser = null;
        Boolean auth = false;
        
      try{
          userName = new Gson().fromJson(usernameJson, String.class);
          password = new Gson().fromJson(passwordJson, String.class);
          //hash the password here
          
          //check if user with this username and password combo exists
           tempUser = getUserFromDb(userName);
           if(tempUser.getPassword() == password)
           {
               auth = true;
           }
      
      }
      catch(Exception e)
      {
          auth = false;
      }
      
        Gson gson = new Gson();
        String returnString = gson.toJson(auth);
        return returnString;
    }
    
        /**
     *Checks if user is already logged
     * @return
     */

    public String isAuthenticated(){
        //Checks if theres still an active session if not returnes false
        
        Boolean auth = true;
        Gson gson = new Gson();
        String returnString = gson.toJson(auth);
        return returnString;
    }
    
 
    public String registerAsUser(String json){
        //Register the user and return succes or failed
        //JSONObject jsonObj = new JSONObject(json);
        //User newUser = new User(jsonObj.getString("username"),jsonObj.getString("password"),Boolean.parseBoolean(jsonObj.getString("isAdmin")),jsonObj.getString("lastname"),jsonObj.getString("firstname"),jsonObj.getString("email"));
       Boolean success = false;
        try
        {
        
        User newUser = new Gson().fromJson(json, User.class);
        
         success = persistUser(newUser);
       
//        JSONObject retObj = new JSONObject();
//        retObj.put("success",success);
//        return retObj.toString();
        }catch(Exception e)
        {
            success = false;
        }
        
        Gson gson = new Gson();
        String returnString = gson.toJson(success);
        return returnString;
    }
    

//    public Boolean addUser(User user){
//        //add  the user and return true if the user has been added
//        //check if the current logged in user is an addmin if not return false
//         //User wantedUser = new User(4,user.getUsername(),"456",false);
//         
//        Boolean success = true;
//        return success;
//    }
//    
//
    public String deleteUser(String userName){
        //remove the user from the db and return success true if the user has been succesfully removed use try try and catch
        Boolean success = false;
        //code here
        User dUser = getUserFromDb(userName);
        try{
            String query ="DELETE * FROM users WHERE `username` = '"+dUser.getUsername()+"'"; 
            st.executeUpdate(query);
            System.out.println("Records from table");
            pw.println("");
            pw.println("================ Users Deleted ======================");
            success = true;
        }
        catch(Exception em)
        {
            success = false;
        }       
        
        //code here
        Gson gson = new Gson();
        String returnString = gson.toJson(success);
        return returnString;
    }
    
    
    public String grantAdminRight(String userName){
        //Modify admins rights to be an admin if successfull return success to true
        Boolean success = false;
        //code here
        
        
        
        //code here
        Gson gson = new Gson();
        String returnString = gson.toJson(success);
        return returnString;
    }
    
    //Temp functions will be removed
    private Boolean persistUser(User user)
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
    
        private User getUserFromDb(String username)
    {
        User dummyUser = null;
        try{
           //sql code to return user with this username
           dummyUser = new User();
           
           return dummyUser;
        }
        catch(Exception e){
            System.out.println("Erro with query: "+e);
            return dummyUser;
        }
    }
    
}

