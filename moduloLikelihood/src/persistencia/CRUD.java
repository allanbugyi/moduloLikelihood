/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.ArrayList;
import mapeamento.EstudoGlobal;
import mapeamento.EstudoIndividual;
import mapeamento.MetanaliseEstudoIndividual;
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
    
    //Hibernate queries
    private static String QUERY_CONSULTA_ESTUDO_INDIVIDUAL_POR_TITULO = "from mapeamento.EstudoIndividual estInd where estInd.titulo like '", 
                          QUERY_CONSULTA_ESTUDO_INDIVIDUAL_POR_ID     = "from mapeamento.EstudoIndividual estInd where estInd.id like '",
                          QUERY_CONSULTA_TODOS_ESTUDOS_INDIVIDUAIS    = "from mapeamento.EstudoIndividual",
                          QUERY_CONSULTA_TODOS_ESTUDOS_GLOBAIS        = "from mapeamento.EstudoGlobal",
                          QUERY_CONSULTA__TODOS_ESTUDOS_INDIVIDUAIS_POR_ESTUDO_GLOBAL = "from mapeamento.EstudoIndividual where estudoGlobal=";
    
    public CRUD(){
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
    
    public static ArrayList executaConsulta(){
        return transacaoConsulta(QUERY_CONSULTA_TODOS_ESTUDOS_INDIVIDUAIS);
    }
    
    public static ArrayList executaConsulta(int estGlobID){
        return transacaoConsulta(estGlobID);
    }
    
    public static ArrayList executaConsulta(boolean EstudosGlobais){
        return transacaoConsulta(QUERY_CONSULTA_TODOS_ESTUDOS_GLOBAIS);
    }
    
    public static void executaCadastro(EstudoIndividual estInd) throws ModuloLikelihoodException, NumberFormatException{
        if( !estInd.getTitulo().equals("")     &&
             estInd.getVp() > 0               &&
             estInd.getFp() > 0               &&
             estInd.getVn() > 0               &&
             estInd.getFn() > 0                
          )
        {
            transacaoCadastro(estInd);
        } else {
            throw new moduloLikelihoodException.ModuloLikelihoodException("O cadastro do Estudo Individual falhou. Verifique os valores fornecidos (título e tabela 2x2)");
        }
    }
    
    public static void executaCadastro(MetanaliseEstudoIndividual metanalise_estInd) throws ModuloLikelihoodException{
        if(metanalise_estInd!=null){
            transacaoCadastro(metanalise_estInd);
        }else{
            throw new moduloLikelihoodException.ModuloLikelihoodException("O cadastro da metanálise falhou. Por favor, verifique os valores informados na tabela 2x2");
        }
    }
    
    public static void executaCadastro(EstudoGlobal estGlob){
        transacaoCadastro(estGlob);
    }
    
    public static void executaAtualizacao(EstudoIndividual estInd){
        transacaoAtualizacao(estInd);
    }
    
    public static void executaAtualizacao(MetanaliseEstudoIndividual metEstInd){
        transacaoAtualizacao(metEstInd);
    }
    
    public static void executaAtualizacao(EstudoGlobal estGlob){
        transacaoAtualizacao(estGlob);
    }
    
    public static void executaExclusao(EstudoGlobal estGlob){
        transacaoExclusao(estGlob);
    }
    
    public static void executaExclusao(EstudoIndividual estInd){
        transacaoExclusao(estInd);
    }
    
    public static void executaExclusao(MetanaliseEstudoIndividual metEstInd){
        transacaoExclusao(metEstInd);
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
    
    private static ArrayList transacaoConsulta(int estGlobID){
        ArrayList queryResult = null;
        try{
            session.beginTransaction();
            
            Query q = session.createQuery(QUERY_CONSULTA__TODOS_ESTUDOS_INDIVIDUAIS_POR_ESTUDO_GLOBAL + estGlobID);
            queryResult = (ArrayList) q.list();
            
            session.getTransaction().commit();
            
        } catch(HibernateException he){
            he.printStackTrace();
        }
        return queryResult;
    }
    
    private static void transacaoCadastro(EstudoIndividual estInd){
        try{
           session.beginTransaction();
           session.save(estInd);
           session.getTransaction().commit();
            
        }catch(HibernateException he){
            he.printStackTrace();
        }
    }
    
    private static void transacaoCadastro(MetanaliseEstudoIndividual metanalise_estInd){
        try{
           session.beginTransaction();
           session.save(metanalise_estInd);
           session.getTransaction().commit();
            
        }catch(HibernateException he){
            he.printStackTrace();
        }
    }
    
    private static void transacaoCadastro(EstudoGlobal estGlob){
        try{
           session.beginTransaction();
           session.save(estGlob);
           session.getTransaction().commit();
            
        }catch(HibernateException he){
            he.printStackTrace();
        }
    }
    
    private static void transacaoAtualizacao(EstudoIndividual estInd){
        try{
           session.beginTransaction();
           session.update(estInd);
           session.getTransaction().commit();
            
        }catch(HibernateException he){
            he.printStackTrace();
        }
    }
    
    private static void transacaoAtualizacao(MetanaliseEstudoIndividual metEstInd){
        try{
           session.beginTransaction();
           session.update(metEstInd);
           session.getTransaction().commit();
            
        }catch(HibernateException he){
            he.printStackTrace();
        }
    }
    
    private static void transacaoAtualizacao(EstudoGlobal estGlob){
        try{
           session.beginTransaction();
           session.update(estGlob);
           session.getTransaction().commit();
            
        }catch(HibernateException he){
            he.printStackTrace();
        }
    }
    
    private static void transacaoExclusao(EstudoGlobal estGlob){
         try{
           session.beginTransaction();
           session.delete(estGlob);
           session.getTransaction().commit();
            
        }catch(HibernateException he){
            he.printStackTrace();
        }
    }
    
    private static void transacaoExclusao(EstudoIndividual estInd){
        try{
           session.beginTransaction();
           session.delete(estInd);
           session.getTransaction().commit();
            
        }catch(HibernateException he){
            he.printStackTrace();
        }
    }
    
    private static void transacaoExclusao(MetanaliseEstudoIndividual metEstInd){
        try{
           session.beginTransaction();
           session.delete(metEstInd);
           session.getTransaction().commit();
            
        }catch(HibernateException he){
            he.printStackTrace();
        }
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
}
