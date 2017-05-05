/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_Fucntion;

import com.mycompany.longswordusersmodule.User;
import com.mycompany.longswordusersmodule.User_Interface;
import com.mycompany.longswordusersmodule.User_Manager;

/**
 *
 * @author takalani
 */
public class Tester{
    
public static void main(String[] args)
{       
    System.out.println("Start");
    Tester_Init manager = new Tester_Init(){};

    System.out.println("--------------------------------------------------------------------------------------------------");
    System.out.println("Test add user functionality");
    System.out.println("Adding user: username: John, password: 1234, isAdmin: False, activated: False, lastname: Doe, firstname: Peter, email: johnsemail@gmail.com, activated:True, activatedKey: key1 ,resetKey: key2");
      String val3 = manager.addUser("{'username':'John','password':'1234','isAdmin':'False','activated':'False','lastname':'Doe','firstname':'Peter','email':'johnsemail@gmail.com','activated':'True','activatedKey':'key1','resetKey':'key2'}");
      System.out.println("test getUser: "+val3);
     
    System.out.println("");      
    System.out.println("--------------------------------------------------------------------------------------------------");
    System.out.println("Test Grant admin rightes");    
    String val4 = manager.grantAdminRights("{'username':'John'}");
    System.out.println("test getAdminRights: "+val4);
     
    System.out.println("");
    System.out.println("--------------------------------------------------------------------------------------------------");
    System.out.println("Test get user functionality");
    String val5 = manager.getTestUser("{'username':'John'}");
    System.out.println("returned user: "+val5);
    
//Test authenticate function
    System.out.println("");
    System.out.println("--------------------------------------------------------------------------------------------------");
    String val6 = manager.authenticateTR("{'username':'John'}","{'password':'1234'}");
    System.out.println("test authenticate: "+val6);
    
    //Test authenticated function
    System.out.println("");
    System.out.println("--------------------------------------------------------------------------------------------------");
    //Test authenticated function
    String val8 = manager.getAuth("{'authToken':'"+val6+"'}");
    System.out.println("test authenticated: "+val8);
    
//Test Delete project
//    String val7 = manager.testDeleteUser("{'username':'John'}");
//    System.out.println("test delete: "+val7);
}   
    
    
}
