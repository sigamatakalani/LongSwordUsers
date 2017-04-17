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
    
//    String val2 = manager.getTestUser("{username:Tk}");
//    System.out.println("test getUser: "+val2);
    
    String val3 = manager.addUser("{'username':'Pete2','password':'301','isAdmin':'True','activated':'True','lastname':'Doe','firstname':'Joey','email':'something2@gmail.com','activated':'True','activatedKey':'key1','resetKey':'key2'}");
    String val2 = manager.grantAdminRight("Pete2");
    System.out.println("test getUser: "+val3+val2);
    
    
}   
    
    
}
