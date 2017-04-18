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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


/**
 *
 * @author takalani sigama
 */
public abstract class User_Manager implements User_Interface{
    
    UserFacade uFacade;
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    PrintWriter pw ;//= new PrintWriter(os, true);
  //  public static final byte[] SALT =  "Longsword-Users-Salt".getBytes();

    public User_Manager(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
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
        
        User temp = getUserFromDb(userName);
        if(temp == null)
            success = false;
        else if(temp.getIsAdmin() == true)
            success = false;
        else
            temp.setIsAdmin(true);
        
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
           int myInt = (user.getIsAdmin()) ? 1 : 0;
           int myInt2 = (user.getActivated()) ? 1 : 0;
           //java.sql.Date date = java.sql.Date.valueOf(user.getResetDate());
            //LocalDate localdate = sqlDate.toLocalDate();
           DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
           String Date = dateFormat.format(user.getResetDate());
           Password pObject = new Password();
           String hashedPassword = pObject.getSaltedHash(user.getPassword());
           
           if(!check(user.getUsername(),user.getEmail()))
           {
               return false;
           }
           
            query ="INSERT INTO user (`username`, `password`, `isAdmin`,`activated`,`lastname`,`firstname`,`email`,`activatedKey`,`resetKey`,`resetDate`) VALUES ('"+user.getUsername()+"', '"+hashedPassword+"', '"+myInt+"','"+myInt2+"','"+user.getLastname()+"','"+user.getFirstname()
            +"','"+user.getEmail()+"','"+user.getActivatedKey()+"','"+user.getResetKey()+"','"+Date+"')";
            int executeUpdate = st.executeUpdate(query);
            return true;
        }
        catch(Exception e){
            System.out.println("Erro with query: "+e);
            return false;
        }
    }
    
    //Checks if the User exist with either the email or username
    private Boolean check(String username, String email)
    {
        
            String query ="select * from user where username ='"+username+"' OR email ='"+email+"' ";
        try {
            rs = st.executeQuery(query);
            int count = 0;
             while(rs.next()){
                 count++;
             }
           if(count > 0)
           {
               return false;
           }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(User_Manager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
     private User getUserFromDb(String username)
    {
        User dummyUser = null;
        String query = "";
        ResultSet ret;
        try{
           //sql code to return user with this username
           query = "select * from user where username ='"+username+"'";
           
           dummyUser = new User();
           ret = st.executeQuery(query);
           dummyUser.setUsername(ret.getString("username"));
           dummyUser.setId(ret.getInt("id"));
           dummyUser.setPassword(ret.getString("password"));
           dummyUser.setIsAdmin(Boolean.valueOf(ret.getString("isadmin")));
           dummyUser.setFirstname(ret.getString("firstname"));
           dummyUser.setEmail(ret.getString("email"));
           dummyUser.setLastname(ret.getString("lastname"));
           dummyUser.setActivated(Boolean.valueOf(ret.getString("activated")));
           dummyUser.setActivatedKey(ret.getString("activatedKey"));
           dummyUser.setResetKey(ret.getString("resetKey"));
           dummyUser.setResetDate(java.sql.Date.valueOf(ret.getString("resetDate")));
           return dummyUser;
        }
        catch(SQLException ex){
           Logger.getLogger(User_Manager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}

