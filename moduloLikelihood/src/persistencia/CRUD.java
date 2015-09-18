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
    
    public CRUD(){
    }
    
    public void conectaBanco(){
        SessionFactory factory  = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
    }
    
    public void iniciaTransacao(){
        //Transaction tx = 
    }
}
