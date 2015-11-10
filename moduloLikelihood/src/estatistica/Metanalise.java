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
    
    private static double verdadeiroPositivo, verdadeiroNegativo, falsoPositivo, falsoNegativo, sensibilidade, especificidade,
                   likelihoodPositiviva, likelihoodNegativa, erroPadrao_lkPositiva, erroPadrao_lkNegativa,
                   percentualIntervaloConfianca, z,
                   intervaloConfianca_LKPositivo_zPositivo, intervaloConfianca_LKPositiva_zNegativo,
                   intervaloConfianca_LKNegativa_zPositivo, intervaloConfianca_LKNegativa_zNegativo,
                   peso_MH_LKPositiva, peso_MH_LKNegativa;

    

    public Metanalise(){
      
    }
    
    public static void calcula(String verdadeiroPositivo, String verdadeiroNegativo, String falsoPositivo, String falsoNegativo, double percentualIntervaloConfianca){
        Metanalise.verdadeiroPositivo           = Double.parseDouble(verdadeiroPositivo);
        Metanalise.verdadeiroNegativo           = Double.parseDouble(verdadeiroNegativo);
        Metanalise.falsoPositivo                = Double.parseDouble(falsoPositivo);
        Metanalise.falsoNegativo                = Double.parseDouble(falsoNegativo);
        Metanalise.percentualIntervaloConfianca = percentualIntervaloConfianca;
        Metanalise.calculaSensibilidade();
        Metanalise.calculaEspecificidade();
        Metanalise.calculaLikelihood();
        Metanalise.calculaErroPadrao();
        Metanalise.calculaZ();
        Metanalise.calculaIntervalosConfianca();
        Metanalise.calculaPeso_MH_LKPositiva();
        Metanalise.calculaPeso_MH_LKNegativa();
        //printa();
    }
    
    private static void calculaPeso_MH_LKPositiva(){
        peso_MH_LKPositiva = (falsoPositivo*(verdadeiroPositivo+falsoNegativo))/(verdadeiroPositivo+falsoPositivo+verdadeiroNegativo+falsoNegativo);
    }
    
    private static void calculaPeso_MH_LKNegativa(){
        peso_MH_LKNegativa = (verdadeiroNegativo*(verdadeiroPositivo+falsoNegativo))/(verdadeiroPositivo+falsoPositivo+verdadeiroNegativo+falsoNegativo);
    }
    
    private static void calculaSensibilidade(){
        sensibilidade = verdadeiroPositivo/(verdadeiroPositivo+falsoNegativo);
    }
    private static void calculaEspecificidade(){
        especificidade = verdadeiroNegativo/(falsoPositivo+verdadeiroNegativo);
    }
    
    private static void calculaLikelihood(){
        likelihoodPositiviva = sensibilidade/(1-especificidade);
        likelihoodNegativa   = (1-sensibilidade)/especificidade;
    }
    
    private static void calculaErroPadrao(){
        erroPadrao_lkPositiva = Math.sqrt((1/verdadeiroPositivo) + (1/falsoPositivo) - (1/(verdadeiroPositivo+falsoNegativo))-(1/(falsoPositivo+verdadeiroNegativo)));
        erroPadrao_lkNegativa = Math.sqrt((1/falsoNegativo) + (1/verdadeiroNegativo) - (1/(verdadeiroPositivo+falsoNegativo)) - (1/(falsoPositivo + verdadeiroNegativo)));
    }
    
    private static void calculaZ(){
        z = Math.abs(StatUtil.getInvCDF(((1 - percentualIntervaloConfianca/100)/2), true));
    }
    
    private static void calculaIntervalosConfianca(){
        intervaloConfianca_LKPositiva_zNegativo = likelihoodPositiviva * (Math.pow(Math.E, (- z * erroPadrao_lkPositiva)));
        intervaloConfianca_LKPositivo_zPositivo = likelihoodPositiviva * (Math.pow(Math.E, (z * erroPadrao_lkPositiva)));
        
        intervaloConfianca_LKNegativa_zNegativo = likelihoodNegativa * (Math.pow(Math.E, (- z * erroPadrao_lkNegativa)));
        intervaloConfianca_LKNegativa_zPositivo = likelihoodNegativa * (Math.pow(Math.E, (z * erroPadrao_lkNegativa)));
    }
    
    public static void printa(){
        System.out.println("Verdadeiro positivo: " + verdadeiroPositivo);
        System.out.println("Verdadeiro negativo: " + verdadeiroNegativo);
        System.out.println("Falso Positivo: "      + falsoPositivo);
        System.out.println("Falso Negativo: "      + falsoNegativo);
        System.out.println("Percentual Intervalo Conf: " + percentualIntervaloConfianca);
        System.out.println("Sensibilidade: " + sensibilidade);
        System.out.println("Especificidade: " + especificidade);
        System.out.println("Likelihood Positiva: " + likelihoodPositiviva);
        System.out.println("Likelihood Negativa: " + likelihoodNegativa);
        System.out.println("Erro padrao Likelihood Positiva: " + erroPadrao_lkPositiva);
        System.out.println("Erro padrao Likelihood Negativa: " + erroPadrao_lkNegativa);
        System.out.println("Z: " + z);
        System.out.println("Intervalo de conf LK+ Z-: " + intervaloConfianca_LKPositiva_zNegativo);
        System.out.println("Intervalo de conf LK+ Z+: " + intervaloConfianca_LKPositivo_zPositivo);
        System.out.println("Intervalo de conf LK- Z-: " + intervaloConfianca_LKNegativa_zNegativo);
        System.out.println("Intervalo de conf LK- Z+: " + intervaloConfianca_LKNegativa_zPositivo);
        System.out.println("Peso Mantel Hansel Likelihood Positiva: " + peso_MH_LKPositiva);
        System.out.println("Peso Mantel Hansel Likelihood Negativa: " + peso_MH_LKNegativa);
    }

    public static double getPeso_MH_LKPositiva() {
        return peso_MH_LKPositiva;
    }

    public static double getPeso_MH_LKNegativa() {
        return peso_MH_LKNegativa;
    }
    
      public double getVerdadeiroPositivo() {
        return verdadeiroPositivo;
    }

    public static double getVerdadeiroNegativo() {
        return verdadeiroNegativo;
    }

    public static double getFalsoPositivo() {
        return falsoPositivo;
    }

    public static double getFalsoNegativo() {
        return falsoNegativo;
    }

    public static double getSensitividade() {
        return sensibilidade;
    }

    public static double getEspecificidade() {
        return especificidade;
    }

    public static double getLikelihoodPositiviva() {
        return likelihoodPositiviva;
    }

    public static double getLikelihoodNegativa() {
        return likelihoodNegativa;
    }

    public static double getErroPadrao_lkPositiva() {
        return erroPadrao_lkPositiva;
    }

    public static double getErroPadrao_lkNegativa() {
        return erroPadrao_lkNegativa;
    }

    public static double getPercentualIntervaloConfianca() {
        return percentualIntervaloConfianca;
    }

    public static double getZ() {
        return z;
    }

    public static double getIntervaloConfianca_LKPositivo_zPositivo() {
        return intervaloConfianca_LKPositivo_zPositivo;
    }

    public static double getIntervaloConfianca_LKPositivo_zNegativo() {
        return intervaloConfianca_LKPositiva_zNegativo;
    }

    public static double getIntervaloConfianca_LKNegativa_zPositivo() {
        return intervaloConfianca_LKNegativa_zPositivo;
    }

    public static double getIntervaloConfianca_LKNegativa_zNegativo() {
        return intervaloConfianca_LKNegativa_zNegativo;
    }
    
    public static void setPeso_MH_LKPositiva(double peso_MH_LKPositiva) {
        Metanalise.peso_MH_LKPositiva = peso_MH_LKPositiva;
    }

    public static void setPeso_MH_LKNegativa(double peso_MH_LKNegativa) {
        Metanalise.peso_MH_LKNegativa = peso_MH_LKNegativa;
    }
    
     public static void setVerdadeiroPositivo(double verdadeiroPositivo) {
        Metanalise.verdadeiroPositivo = verdadeiroPositivo;
    }

    public static void setVerdadeiroNegativo(double verdadeiroNegativo) {
        Metanalise.verdadeiroNegativo = verdadeiroNegativo;
    }

    public static void setFalsoPositivo(double falsoPositivo) {
        Metanalise.falsoPositivo = falsoPositivo;
    }

    public static void setFalsoNegativo(double falsoNegativo) {
        Metanalise.falsoNegativo = falsoNegativo;
    }

    public static void setSensitividade(double sensitividade) {
        Metanalise.sensibilidade = sensitividade;
    }

    public static void setEspecificidade(double especificidade) {
        Metanalise.especificidade = especificidade;
    }

    public static void setLikelihoodPositiviva(double likelihoodPositiviva) {
        Metanalise.likelihoodPositiviva = likelihoodPositiviva;
    }

    public static void setLikelihoodNegativa(double likelihoodNegativa) {
        Metanalise.likelihoodNegativa = likelihoodNegativa;
    }

    public static void setErroPadrao_lkPositiva(double erroPadrao_lkPositiva) {
        Metanalise.erroPadrao_lkPositiva = erroPadrao_lkPositiva;
    }

    public static void setErroPadrao_lkNegativa(double erroPadrao_lkNegativa) {
        Metanalise.erroPadrao_lkNegativa = erroPadrao_lkNegativa;
    }

    public static void setPercentualIntervaloConfianca(double percentualIntervaloConfianca) {
        Metanalise.percentualIntervaloConfianca = percentualIntervaloConfianca;
    }

    public static void setZ(double z) {
        Metanalise.z = z;
    }

    public static void setIntervaloConfianca_LKPositivo_zPositivo(double intervaloConfianca_LKPositivo_zPositivo) {
        Metanalise.intervaloConfianca_LKPositivo_zPositivo = intervaloConfianca_LKPositivo_zPositivo;
    }

    public static void setIntervaloConfianca_LKPositivo_zNegativo(double intervaloConfianca_LKPositivo_zNegativo) {
        Metanalise.intervaloConfianca_LKPositiva_zNegativo = intervaloConfianca_LKPositivo_zNegativo;
    }

    public static void setIntervaloConfianca_LKNegativa_zPositivo(double intervaloConfianca_LKNegativa_zPositivo) {
        Metanalise.intervaloConfianca_LKNegativa_zPositivo = intervaloConfianca_LKNegativa_zPositivo;
    }

    public static void setIntervaloConfianca_LKNegativa_zNegativo(double intervaloConfianca_LKNegativa_zNegativo) {
        Metanalise.intervaloConfianca_LKNegativa_zNegativo = intervaloConfianca_LKNegativa_zNegativo;
    }
}
