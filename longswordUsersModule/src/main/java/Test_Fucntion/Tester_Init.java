/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Fucntion;

import com.mycompany.longswordusersmodule.User_Manager;

/**
 *
 * @author takalani
 */
public class Tester_Init extends User_Manager {
    
    public Tester_Init()
    {
        super();
    }
    
    public String getAuth(String json)
    {
        return super.isAuthenticated(json);
    }
    
    public String getTestUser(String name)
    {
        return super.getUser(name);
    }
    
    public String addUser(String json)
    {
        return super.registerAsUser(json);
    }
    
       
    public String grantAdminRights(String name)
    {
        return super.grantAdminRight(name);
    }
    
    public String authenticateTR(String usernameJson,String passwordJson)
    {
        return super.authenticate(usernameJson, passwordJson);
    }
    
    public String testDeleteUser(String userName)
    {
        return super.deleteUser(userName);
    }
    
 
    
}
