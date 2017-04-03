/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mocking;
import java.util.List;
import com.mycompany.longswordusersmodule.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
/**
 *
 * @author takalani
 */
@Stateless
public class UserFacade extends AbstractFacade<User>{

    @Override
    public void create(User obj) {
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(User obj) {
 EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   @Override
    public List<User> getAll() {
         EntityManager em = getEntityManager();
     List<User> users = em.createQuery("SELECT u FROM User u").getResultList();
        em.close();
        return users;
    }

    @Override
    public User GetByKey(int key) {
         EntityManager em = getEntityManager();
         User u = em.find(User.class, key);
        em.close();
        return u;
    }
    
}
