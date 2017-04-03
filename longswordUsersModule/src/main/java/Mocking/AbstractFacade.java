/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mocking;

import com.mycompany.longswordusersmodule.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author takalani
 */
public abstract class AbstractFacade<T> {
    
    private static EntityManagerFactory emf = null;
    protected static EntityManager getEntityManager()
    {
        if(emf == null)
        {
            emf = Persistence.createEntityManagerFactory("MOCK_FU");
        }
        return emf.createEntityManager();
    }
    public abstract void create (T obj);
    public abstract void update (T obj);
    public abstract void delete (T obj);
    public abstract void deleteAll (T obj);
    public abstract List<User> getAll();
    
    public abstract T GetByKey(int key);
    public List<T> getAll;
}
