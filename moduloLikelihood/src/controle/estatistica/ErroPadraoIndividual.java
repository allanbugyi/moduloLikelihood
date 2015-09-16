/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.estatistica;

/**
 *
 * @author allan
 */
public class ErroPadraoIndividual {
    //erro padrao
    private double SElnLRpositivo, SElnLRnegativo; //Erro padrao do logaritmo natural da Likelihood positivo e negativo
    private Integer idLikelihood;
    
    public ErroPadraoIndividual(Integer idLikelihoodIndividual){
        this.idLikelihood = idLikelihood;
    }
    
    public void calculaErroPadraoLRpositivo(){
        //necessario fazer consulta do LikelihoodIndividual respectivo pelo ID
        //this.SElnLRpositivo = Math.sqrt();
    }
    
    public void calculaErroPadraoLRnegativo(){
        
    }
    
}
