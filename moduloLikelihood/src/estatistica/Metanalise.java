/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estatistica;

/**
 *
 * @author allan
 */
public class Metanalise {
    
    private double verdadeiroPositivo, verdadeiroNegativo, falsoPositivo, falsoNegativo, sensitividade, especificidade,
                   likelihoodPositiviva, likelihoodNegativa, erroPadrao_lkPositiva, erroPadrao_lkNegativa,
                   percentualIntervaloConfianca, z,
                   intervaloConfianca_LKPositivo_zPositivo, intervaloConfianca_LKPositivo_zNegativo,
                   intervaloConfianca_LKNegativa_zPositivo, intervaloConfianca_LKNegativa_zNegativo;
    
    public Metanalise(/*double verdadeiroPositivo, double verdadeiroNegativo, double falsoPositivo, double falsoNegativo, double percentualIntervaloConfianca*/){
        this.verdadeiroPositivo           = 22; //verdadeiroPositivo;
        this.verdadeiroNegativo           = 21; //verdadeiroNegativo;
        this.falsoPositivo                = 1; //falsoPositivo;
        this.falsoNegativo                = 6; //falsoNegativo;
        this.percentualIntervaloConfianca = 95;//percentualIntervaloConfianca;
        this.calculaSensitividade();
        this.calculaEspecificidade();
        this.calculaLikelihood();
        this.calculaErroPadrao();
        this.calculaZ();
        this.calculaIntervalosConfianca();
    }
    
    private void calculaSensitividade(){
        this.sensitividade = this.verdadeiroPositivo/(this.verdadeiroPositivo+this.falsoNegativo);
    }
    private void calculaEspecificidade(){
        this.especificidade = this.verdadeiroNegativo/(this.falsoPositivo+this.verdadeiroNegativo);
    }
    
    private void calculaLikelihood(){
        this.likelihoodPositiviva = this.sensitividade/(1-this.especificidade);
        this.likelihoodNegativa   = (1-this.sensitividade)/this.especificidade;
    }
    
    private void calculaErroPadrao(){
        this.erroPadrao_lkPositiva = Math.sqrt((1/this.verdadeiroPositivo) + (1/this.falsoPositivo) - (1/(this.verdadeiroPositivo+this.falsoNegativo))-(1/(this.falsoPositivo+this.verdadeiroNegativo)));
        this.erroPadrao_lkNegativa = Math.sqrt((1/this.falsoNegativo) + (1/this.verdadeiroNegativo) - (1/(this.verdadeiroPositivo+this.falsoNegativo)) - (1/(this.falsoPositivo + this.verdadeiroNegativo)));
    }
    
    private void calculaZ(){
        this.z = Math.abs(StatUtil.getInvCDF(((1 - this.percentualIntervaloConfianca/100)/2), true));
    }
    
    private void calculaIntervalosConfianca(){
        this.intervaloConfianca_LKPositivo_zNegativo = this.likelihoodPositiviva * (Math.pow(Math.E, (- this.z * this.erroPadrao_lkPositiva)));
        this.intervaloConfianca_LKPositivo_zPositivo = this.likelihoodPositiviva * (Math.pow(Math.E, (this.z * this.erroPadrao_lkPositiva)));
        
        this.intervaloConfianca_LKNegativa_zNegativo = this.likelihoodNegativa * (Math.pow(Math.E, (- this.z * this.erroPadrao_lkNegativa)));
        this.intervaloConfianca_LKNegativa_zPositivo = this.likelihoodNegativa * (Math.pow(Math.E, (this.z * this.erroPadrao_lkNegativa)));
    }
    
    public void printa(){
        System.out.println("Verdadeiro positivo: " + this.verdadeiroPositivo);
        System.out.println("Verdadeiro negativo: " + this.verdadeiroNegativo);
        System.out.println("Falso Positivo: "      + this.falsoPositivo);
        System.out.println("Falso Negativo: "      + this.falsoNegativo);
        System.out.println("Percentual Intervalo Conf: " + this.percentualIntervaloConfianca);
        System.out.println("Sensitividade: " + this.sensitividade);
        System.out.println("Especificidade: " + this.especificidade);
        System.out.println("Likelihood Positiva: " + this.likelihoodPositiviva);
        System.out.println("Likelihood Negativa: " + this.likelihoodNegativa);
        System.out.println("Erro padrao Likelihood Positiva: " + this.erroPadrao_lkPositiva);
        System.out.println("Erro padrao Likelihood Negativa: " + this.erroPadrao_lkNegativa);
        System.out.println("Z: " + this.z);
        System.out.println("Intervalo de conf LK+ Z-: " + this.intervaloConfianca_LKPositivo_zNegativo);
        System.out.println("Intervalo de conf LK+ Z+: " + this.intervaloConfianca_LKPositivo_zPositivo);
        System.out.println("Intervalo de conf LK- Z-: " + this.intervaloConfianca_LKNegativa_zNegativo);
        System.out.println("Intervalo de conf LK- Z+: " + this.intervaloConfianca_LKNegativa_zPositivo);
        
    }
}
