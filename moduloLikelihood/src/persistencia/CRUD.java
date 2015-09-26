/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author allan
 */
public class CRUD {
    
    private static Session session = null;
    private static SessionFactory factory = null;
    
    
    
    public CRUD(){
    }
    
    public static void criaSessaoHibernate(){
        factory  = HibernateUtil.getSessionFactory();
        session = factory.openSession();
    }
    public static void fechaSessaoHibernate(){
        session.getTransaction().commit();
    }
    
    public void iniciaTransacao(){
        //Transaction tx = 
    }
}
