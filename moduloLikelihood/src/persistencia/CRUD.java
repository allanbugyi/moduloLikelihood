/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.awt.List;
import moduloLikelihoodException.ModuloLikelihoodException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author allan
 */
public class CRUD {
    
    private static Session session = null;
    private static SessionFactory factory = null;
    
    //MySQL queries
    private static String QUERY_CONSULTA_ESTUDO_INDIVIDUAL_POR_TITULO = "from mapeamento.Estudoindividual estInd where estInd.titulo like '", 
                          QUERY_CONSULTA_ESTUDO_INDIVIDUAL_POR_ID     = "from mapeamento.Estudoindividual estInd where estInd.id like '",
                          QUERY_CADASTRA_ESTUDO_INDIVIDUAL            = "insert into Estudoindividual (id, titulo, descricao, vp, fp, vn, fn) select ";
 
    
    public CRUD(){
    }
    
    public static void criaSessaoHibernate(){
        factory  = HibernateUtil.getSessionFactory();
        session = factory.openSession();
    }
    
    public static void fechaSessaoHibernate(){
        try{
         session.close();
         factory.close();   
        }catch(HibernateException he){
            he.printStackTrace();
        }
    }
    
    public static List executaConsulta(String str1, String str2) throws ModuloLikelihoodException{
        if((!str1.equals(null) || !str1.equals("")) || (!str2.equals(null) || !str2.equals(""))){
            List list = transacao(QUERY_CONSULTA_ESTUDO_INDIVIDUAL_POR_ID + str1 + "'");
            if(!list.equals(null)) return list;
            else {
                list = transacao(QUERY_CONSULTA_ESTUDO_INDIVIDUAL_POR_ID + str2 + "'");
                if(!list.equals(null)){
                    return list;
                }
            }
        }
        else{
            throw new moduloLikelihoodException.ModuloLikelihoodException();
        }
        return null;
    }
    
    public static void executaCadastro(){
        
    }
    
    private static List transacao(String query){
        List queryResults = null;
        try{
            session.beginTransaction();
            
            Query q = session.createQuery(query);
            queryResults = (List) q.list();
            
            session.getTransaction().commit();
            
        }catch(HibernateException he){
            he.printStackTrace();
        }
        return queryResults;
    }
    
}
