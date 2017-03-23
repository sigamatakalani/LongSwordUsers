/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import com.mycompany.longswordusersmodule.*;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author takalani
 */
@Path("user")
public class UserRestFull {
  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findall")
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
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getuser")
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
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/authenticate")
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
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/isauthenticated")
    public Boolean isAuthenticated(){
        //check authenticate user then return true or false using somekind of session management
        Boolean isAuth = true;
        return isAuth;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registerssuser")
    public Boolean registerAsUser(String username,String password){
        //Register the user and return succes or failed
         User newUser = new User(5,username,"456",false);
        Boolean success = true;
        return success;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/adduser")
    public Boolean addUser(User user){
        //add  the user and return true if the user has been added
        //check if the current logged in user is an addmin if not return false
         User wantedUser = new User(4,user.getUsername(),"456",false);
        Boolean success = true;
        return success;
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/removeuser")
    public Boolean removeUser(User user){
        //add  the user and return true if the user has been added
        Boolean success = true;
        return success;
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/grantadminright")
    public Boolean grantAdminRight(User user){
        //grant admin rights to this user
        Boolean success = true;
        return success;
    }
    
    
}
