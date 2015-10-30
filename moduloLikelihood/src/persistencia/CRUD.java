/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mapeamento.Estudoindividual;
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
                          QUERY_CONSULTA_ESTUDO_INDIVIDUAL_POR_ID     = "from mapeamento.Estudoindividual estInd where estInd.id like '";
    
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
    
    public static ArrayList executaConsulta(String id, String titulo) throws ModuloLikelihoodException{
        ArrayList list = null;
        if(!id.equals(null) && !id.equals("")){
            list = transacaoConsulta(QUERY_CONSULTA_ESTUDO_INDIVIDUAL_POR_ID + id + "'");
            if(!list.equals(null)) return list;
            else throw new moduloLikelihoodException.ModuloLikelihoodException("Nenhum resultado encontrado");
        }
        else if(!titulo.equals(null) && !titulo.equals("")) 
        {
            list = transacaoConsulta(QUERY_CONSULTA_ESTUDO_INDIVIDUAL_POR_TITULO + titulo + "'");
            if(!list.equals(null)) return list;
            else throw new moduloLikelihoodException.ModuloLikelihoodException("Nenhum resultado encontrado");
        }
        else{
            throw new moduloLikelihoodException.ModuloLikelihoodException("Nenhum dos parâmetros de busca são válidos");
        }
    }
    
    public static void executaCadastro(Estudoindividual estInd) throws ModuloLikelihoodException, NumberFormatException{
        if( !estInd.getTitulo().equals("")     &&
             estInd.getVp() > 0                &&
             estInd.getFp() > 0                &&
             estInd.getVn() > 0                &&
             estInd.getFn() > 0                
          )
        {
            transacaoCadastro(estInd);
        } else {
            throw new moduloLikelihoodException.ModuloLikelihoodException("O cadastro do Estudo Individual falhou. Verifique os valores fornecidos (título e tabela 2x2)");
        }
    }
    
    private static ArrayList transacaoConsulta(String query){
        ArrayList queryResults = null;
        try{
            session.beginTransaction();
            
            Query q = session.createQuery(query);
            queryResults = (ArrayList) q.list();
            
            session.getTransaction().commit();
            
        }catch(HibernateException he){
            he.printStackTrace();
        }
        return queryResults;
    }
    
    private static void transacaoCadastro(Estudoindividual estInd){
        try{
           session.beginTransaction();
           session.save(estInd);
           session.getTransaction().commit();
            
        }catch(HibernateException he){
            he.printStackTrace();
        }
    }
    
}
