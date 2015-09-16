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
public class LikelihoodIndividual {
    private Integer id;

    //Tabela 2x2
    private double VP, FP, VN, FN,          // VP = Verdadeiro Positivo, FP = Falso Positivo, VN = Verdadeiro Negativo, FN = Falso Negativo
                   LRpostivo, LRnegativo;   // LRpositivo = Likelihood positivo, LRnegativo = Likelihood negativo

    
    public LikelihoodIndividual(double VP, double FP, double VN, double FN, Integer id){
        this.VP = VP;
        this.FP = FP;
        this.VN = VN;
        this.FN = FN;
        this.id = id;
    }
    
    //calcula Likelihood Positivo
    public void calculaLRpositivo(){
        this.LRpostivo = ((this.VP/(this.VP+this.FN))/(this.FP/(this.FP+this.VN)));
    }
    
    //calcula Likelihood Negativo
    public void calculaLRnegativo(){
        this.LRnegativo = ((this.FN/(this.VP+this.FN))/(this.VN/(this.FP+this.VN)));
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setVP(double VP) {
        this.VP = VP;
    }

    public void setFP(double FP) {
        this.FP = FP;
    }

    public void setVN(double VN) {
        this.VN = VN;
    }

    public void setFN(double FN) {
        this.FN = FN;
    }

    public void setLRpostivo(double LRpostivo) {
        this.LRpostivo = LRpostivo;
    }

    public void setLRnegativo(double LRnegativo) {
        this.LRnegativo = LRnegativo;
    }
    
    public Integer getId() {
        return id;
    }


    public double getVP() {
        return VP;
    }

    public double getFP() {
        return FP;
    }

    public double getVN() {
        return VN;
    }

    public double getFN() {
        return FN;
    }

    public double getLRpostivo() {
        return LRpostivo;
    }

    public double getLRnegativo() {
        return LRnegativo;
    }
}
