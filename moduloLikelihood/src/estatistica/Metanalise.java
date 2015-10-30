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
    
    private double verdadeiroPositivo, verdadeiroNegativo, falsoPositivo, falsoNegativo, sensibilidade, especificidade,
                   likelihoodPositiviva, likelihoodNegativa, erroPadrao_lkPositiva, erroPadrao_lkNegativa,
                   percentualIntervaloConfianca, z,
                   intervaloConfianca_LKPositivo_zPositivo, intervaloConfianca_LKPositiva_zNegativo,
                   intervaloConfianca_LKNegativa_zPositivo, intervaloConfianca_LKNegativa_zNegativo,
                   peso_MH_LKPositiva, peso_MH_LKNegativa;

    

    public Metanalise(double verdadeiroPositivo, double verdadeiroNegativo, double falsoPositivo, double falsoNegativo, double percentualIntervaloConfianca){
        this.verdadeiroPositivo           = verdadeiroPositivo;
        this.verdadeiroNegativo           = verdadeiroNegativo;
        this.falsoPositivo                = falsoPositivo;
        this.falsoNegativo                = falsoNegativo;
        this.percentualIntervaloConfianca = percentualIntervaloConfianca;
        this.calculaSensibilidade();
        this.calculaEspecificidade();
        this.calculaLikelihood();
        this.calculaErroPadrao();
        this.calculaZ();
        this.calculaIntervalosConfianca();
        this.calculaPeso_MH_LKPositiva();
        this.calculaPeso_MH_LKNegativa();
        printa();
    }
    
    private void calculaPeso_MH_LKPositiva(){
        this.peso_MH_LKPositiva = (this.falsoPositivo*(this.verdadeiroPositivo+this.falsoNegativo))/(this.verdadeiroPositivo+this.falsoPositivo+this.verdadeiroNegativo+this.falsoNegativo);
    }
    
    private void calculaPeso_MH_LKNegativa(){
        this.peso_MH_LKNegativa = (this.verdadeiroNegativo*(this.verdadeiroPositivo+this.falsoNegativo))/(this.verdadeiroPositivo+this.falsoPositivo+this.verdadeiroNegativo+this.falsoNegativo);
    }
    
    private void calculaSensibilidade(){
        this.sensibilidade = this.verdadeiroPositivo/(this.verdadeiroPositivo+this.falsoNegativo);
    }
    private void calculaEspecificidade(){
        this.especificidade = this.verdadeiroNegativo/(this.falsoPositivo+this.verdadeiroNegativo);
    }
    
    private void calculaLikelihood(){
        this.likelihoodPositiviva = this.sensibilidade/(1-this.especificidade);
        this.likelihoodNegativa   = (1-this.sensibilidade)/this.especificidade;
    }
    
    private void calculaErroPadrao(){
        this.erroPadrao_lkPositiva = Math.sqrt((1/this.verdadeiroPositivo) + (1/this.falsoPositivo) - (1/(this.verdadeiroPositivo+this.falsoNegativo))-(1/(this.falsoPositivo+this.verdadeiroNegativo)));
        this.erroPadrao_lkNegativa = Math.sqrt((1/this.falsoNegativo) + (1/this.verdadeiroNegativo) - (1/(this.verdadeiroPositivo+this.falsoNegativo)) - (1/(this.falsoPositivo + this.verdadeiroNegativo)));
    }
    
    private void calculaZ(){
        this.z = Math.abs(StatUtil.getInvCDF(((1 - this.percentualIntervaloConfianca/100)/2), true));
    }
    
    private void calculaIntervalosConfianca(){
        this.intervaloConfianca_LKPositiva_zNegativo = this.likelihoodPositiviva * (Math.pow(Math.E, (- this.z * this.erroPadrao_lkPositiva)));
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
        System.out.println("Sensibilidade: " + this.sensibilidade);
        System.out.println("Especificidade: " + this.especificidade);
        System.out.println("Likelihood Positiva: " + this.likelihoodPositiviva);
        System.out.println("Likelihood Negativa: " + this.likelihoodNegativa);
        System.out.println("Erro padrao Likelihood Positiva: " + this.erroPadrao_lkPositiva);
        System.out.println("Erro padrao Likelihood Negativa: " + this.erroPadrao_lkNegativa);
        System.out.println("Z: " + this.z);
        System.out.println("Intervalo de conf LK+ Z-: " + this.intervaloConfianca_LKPositiva_zNegativo);
        System.out.println("Intervalo de conf LK+ Z+: " + this.intervaloConfianca_LKPositivo_zPositivo);
        System.out.println("Intervalo de conf LK- Z-: " + this.intervaloConfianca_LKNegativa_zNegativo);
        System.out.println("Intervalo de conf LK- Z+: " + this.intervaloConfianca_LKNegativa_zPositivo);
        System.out.println("Peso Mantel Hansel Likelihood Positiva: " + this.peso_MH_LKPositiva);
        System.out.println("Peso Mantel Hansel Likelihood Negativa: " + this.peso_MH_LKNegativa);
    }

    public double getPeso_MH_LKPositiva() {
        return peso_MH_LKPositiva;
    }

    public double getPeso_MH_LKNegativa() {
        return peso_MH_LKNegativa;
    }
    
      public double getVerdadeiroPositivo() {
        return verdadeiroPositivo;
    }

    public double getVerdadeiroNegativo() {
        return verdadeiroNegativo;
    }

    public double getFalsoPositivo() {
        return falsoPositivo;
    }

    public double getFalsoNegativo() {
        return falsoNegativo;
    }

    public double getSensitividade() {
        return sensibilidade;
    }

    public double getEspecificidade() {
        return especificidade;
    }

    public double getLikelihoodPositiviva() {
        return likelihoodPositiviva;
    }

    public double getLikelihoodNegativa() {
        return likelihoodNegativa;
    }

    public double getErroPadrao_lkPositiva() {
        return erroPadrao_lkPositiva;
    }

    public double getErroPadrao_lkNegativa() {
        return erroPadrao_lkNegativa;
    }

    public double getPercentualIntervaloConfianca() {
        return percentualIntervaloConfianca;
    }

    public double getZ() {
        return z;
    }

    public double getIntervaloConfianca_LKPositivo_zPositivo() {
        return intervaloConfianca_LKPositivo_zPositivo;
    }

    public double getIntervaloConfianca_LKPositivo_zNegativo() {
        return intervaloConfianca_LKPositiva_zNegativo;
    }

    public double getIntervaloConfianca_LKNegativa_zPositivo() {
        return intervaloConfianca_LKNegativa_zPositivo;
    }

    public double getIntervaloConfianca_LKNegativa_zNegativo() {
        return intervaloConfianca_LKNegativa_zNegativo;
    }
    
    public void setPeso_MH_LKPositiva(double peso_MH_LKPositiva) {
        this.peso_MH_LKPositiva = peso_MH_LKPositiva;
    }

    public void setPeso_MH_LKNegativa(double peso_MH_LKNegativa) {
        this.peso_MH_LKNegativa = peso_MH_LKNegativa;
    }
    
     public void setVerdadeiroPositivo(double verdadeiroPositivo) {
        this.verdadeiroPositivo = verdadeiroPositivo;
    }

    public void setVerdadeiroNegativo(double verdadeiroNegativo) {
        this.verdadeiroNegativo = verdadeiroNegativo;
    }

    public void setFalsoPositivo(double falsoPositivo) {
        this.falsoPositivo = falsoPositivo;
    }

    public void setFalsoNegativo(double falsoNegativo) {
        this.falsoNegativo = falsoNegativo;
    }

    public void setSensitividade(double sensitividade) {
        this.sensibilidade = sensitividade;
    }

    public void setEspecificidade(double especificidade) {
        this.especificidade = especificidade;
    }

    public void setLikelihoodPositiviva(double likelihoodPositiviva) {
        this.likelihoodPositiviva = likelihoodPositiviva;
    }

    public void setLikelihoodNegativa(double likelihoodNegativa) {
        this.likelihoodNegativa = likelihoodNegativa;
    }

    public void setErroPadrao_lkPositiva(double erroPadrao_lkPositiva) {
        this.erroPadrao_lkPositiva = erroPadrao_lkPositiva;
    }

    public void setErroPadrao_lkNegativa(double erroPadrao_lkNegativa) {
        this.erroPadrao_lkNegativa = erroPadrao_lkNegativa;
    }

    public void setPercentualIntervaloConfianca(double percentualIntervaloConfianca) {
        this.percentualIntervaloConfianca = percentualIntervaloConfianca;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setIntervaloConfianca_LKPositivo_zPositivo(double intervaloConfianca_LKPositivo_zPositivo) {
        this.intervaloConfianca_LKPositivo_zPositivo = intervaloConfianca_LKPositivo_zPositivo;
    }

    public void setIntervaloConfianca_LKPositivo_zNegativo(double intervaloConfianca_LKPositivo_zNegativo) {
        this.intervaloConfianca_LKPositiva_zNegativo = intervaloConfianca_LKPositivo_zNegativo;
    }

    public void setIntervaloConfianca_LKNegativa_zPositivo(double intervaloConfianca_LKNegativa_zPositivo) {
        this.intervaloConfianca_LKNegativa_zPositivo = intervaloConfianca_LKNegativa_zPositivo;
    }

    public void setIntervaloConfianca_LKNegativa_zNegativo(double intervaloConfianca_LKNegativa_zNegativo) {
        this.intervaloConfianca_LKNegativa_zNegativo = intervaloConfianca_LKNegativa_zNegativo;
    }
}
