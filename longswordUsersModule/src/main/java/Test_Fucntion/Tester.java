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
    //User temp = new User("Tk","1234",true,"Sigama","Takalani","sig@gmail.com");        
//    String val =  manager.getAuth();
//    System.out.println("added: "+val);
    
//    String val3 = manager.addUser("{'username':'Keanen2','password':'200','isAdmin':'False','activated':'False','lastname':'Jones2','firstname':'Blake2','email':'something3@gmail.com','activated':'True','activatedKey':'key1','resetKey':'key2'}");
//    System.out.println("test getUser: "+val3);
    
    //Test Grant admin writes
//    String val4 = manager.grantAdminRights("{'username':'Keanen2'}");
//    System.out.println("test getAdminRights: "+val4);
    
//Test getUser
//      String val5 = manager.getTestUser("{'username':'Keanen2'}");
//      System.out.println("test getAdminRights: "+val5);
      
//Test authenticate function
//    String val6 = manager.authenticateTR("{'username':'Keanen2'}","{'password':'2003'}");
//    System.out.println("test authenticate: "+val6);
    
//Test Delete project
    String val7 = manager.testDeleteUser("{'username':'John'}");
    System.out.println("test delete: "+val7);
}   
    
    
}
