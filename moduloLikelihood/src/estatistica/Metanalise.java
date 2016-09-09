/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estatistica;

import moduloLikelihoodException.ModuloLikelihoodException;

/**
 *
 * @author allan
 */
public class Metanalise {
    
    private static double   verdadeiroPositivo, verdadeiroNegativo, falsoPositivo, falsoNegativo,
                            sensibilidade, especificidade, likelihoodPositiva, likelihoodNegativa,
                            erroPadrao_lkPositiva, erroPadrao_lkNegativa, percentualIntervaloConfianca, z,
                            intervaloConfianca_LKPositiva_zPositivo, intervaloConfianca_LKPositiva_zNegativo,
                            intervaloConfianca_LKNegativa_zPositivo, intervaloConfianca_LKNegativa_zNegativo,
                            peso_MH_LKPositiva, peso_MH_LKNegativa;

    public Metanalise(){
      
    }
    
    public static void calcula(int verdadeiroPositivo, int falsoPositivo, int verdadeiroNegativo, int falsoNegativo, double percentualIntervaloConfianca) throws ModuloLikelihoodException {
        Metanalise.verdadeiroPositivo           = verdadeiroPositivo;
        Metanalise.verdadeiroNegativo           = verdadeiroNegativo;
        Metanalise.falsoPositivo                = falsoPositivo;
        Metanalise.falsoNegativo                = falsoNegativo;
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
    
    public static void resetaValores(){
        Metanalise.verdadeiroPositivo           = 0;
        Metanalise.verdadeiroNegativo           = 0;
        Metanalise.falsoPositivo                = 0;
        Metanalise.falsoNegativo                = 0;
        Metanalise.sensibilidade                = 0;
        Metanalise.especificidade               = 0;
        Metanalise.likelihoodPositiva         = 0;
        Metanalise.likelihoodNegativa           = 0;
        Metanalise.erroPadrao_lkPositiva        = 0;
        Metanalise.erroPadrao_lkNegativa        = 0;
        Metanalise.percentualIntervaloConfianca = 0;
        Metanalise.z                            = 0;
        Metanalise.intervaloConfianca_LKPositiva_zPositivo = 0;
        Metanalise.intervaloConfianca_LKPositiva_zNegativo = 0;
        Metanalise.intervaloConfianca_LKNegativa_zPositivo = 0;
        Metanalise.intervaloConfianca_LKNegativa_zNegativo = 0;
        Metanalise.peso_MH_LKPositiva           = 0;
        Metanalise.peso_MH_LKNegativa           = 0;
    }
    
    private static void calculaPeso_MH_LKPositiva() throws moduloLikelihoodException.ModuloLikelihoodException {
        if((verdadeiroPositivo+falsoPositivo+verdadeiroNegativo+falsoNegativo)!=0){
             peso_MH_LKPositiva = (falsoPositivo*(verdadeiroPositivo+falsoNegativo))/(verdadeiroPositivo+falsoPositivo+verdadeiroNegativo+falsoNegativo);
        }else{
            throw new moduloLikelihoodException.ModuloLikelihoodException("Não foi possível realizar a metanálise, reveja os valores fornecidos na tabela 2x2. Divisão por zero impossível.");
        }
    }
    
    private static void calculaPeso_MH_LKNegativa() throws moduloLikelihoodException.ModuloLikelihoodException {
        if((verdadeiroPositivo+falsoPositivo+verdadeiroNegativo+falsoNegativo)!=0){
            peso_MH_LKNegativa = (verdadeiroNegativo*(verdadeiroPositivo+falsoNegativo))/(verdadeiroPositivo+falsoPositivo+verdadeiroNegativo+falsoNegativo);
        }else{
            throw new moduloLikelihoodException.ModuloLikelihoodException("Não foi possível realizar a metanálise, reveja os valores fornecidos na tabela 2x2. Divisão por zero impossível.");
        }
    }
    
    private static void calculaSensibilidade() throws moduloLikelihoodException.ModuloLikelihoodException {
        if((verdadeiroPositivo+falsoNegativo)!=0){
            sensibilidade = verdadeiroPositivo/(verdadeiroPositivo+falsoNegativo);
        }else{
            throw new moduloLikelihoodException.ModuloLikelihoodException("Não foi possível realizar a metanálise, reveja os valores fornecidos na tabela 2x2. Divisão por zero impossível.");
        }
    }
    
    private static void calculaEspecificidade() throws moduloLikelihoodException.ModuloLikelihoodException {
        if((falsoPositivo+verdadeiroNegativo)!=0){
            especificidade = verdadeiroNegativo/(falsoPositivo+verdadeiroNegativo);
        }else{
            throw new moduloLikelihoodException.ModuloLikelihoodException("Não foi possível realizar a metanálise, reveja os valores fornecidos na tabela 2x2. Divisão por zero impossível.");
        }
    }
    
    private static void calculaLikelihood() throws moduloLikelihoodException.ModuloLikelihoodException {
        if((1-especificidade)!=0 && especificidade !=0){
            likelihoodPositiva = sensibilidade/(1-especificidade);
             likelihoodNegativa   = (1-sensibilidade)/especificidade;
        }else{
            throw new moduloLikelihoodException.ModuloLikelihoodException("Não foi possível realizar a metanálise, reveja os valores fornecidos na tabela 2x2. Divisão por zero impossível.");
        }
    }
    
    private static void calculaErroPadrao() throws moduloLikelihoodException.ModuloLikelihoodException {
        if(verdadeiroPositivo != 0 || falsoPositivo != 0 || (verdadeiroPositivo+falsoNegativo) != 0 || (falsoPositivo+verdadeiroNegativo) != 0){
            erroPadrao_lkPositiva = Math.sqrt((1/verdadeiroPositivo) + (1/falsoPositivo) - (1/(verdadeiroPositivo+falsoNegativo))-(1/(falsoPositivo+verdadeiroNegativo)));
            erroPadrao_lkNegativa = Math.sqrt((1/falsoNegativo) + (1/verdadeiroNegativo) - (1/(verdadeiroPositivo+falsoNegativo)) - (1/(falsoPositivo + verdadeiroNegativo)));
        }else{
            throw new moduloLikelihoodException.ModuloLikelihoodException("Não foi possível realizar a metanálise, reveja os valores fornecidos na tabela 2x2. Divisão por zero impossível.");
        }
    }
    
    private static void calculaZ() {
        try{
            z = Math.abs(StatUtil.getInvCDF(((1 - percentualIntervaloConfianca/100)/2), true));
        }catch(Exception ex){
            
        }
    }
    
    private static void calculaIntervalosConfianca(){
        intervaloConfianca_LKPositiva_zNegativo = likelihoodPositiva * (Math.pow(Math.E, (- z * erroPadrao_lkPositiva)));
        intervaloConfianca_LKPositiva_zPositivo = likelihoodPositiva * (Math.pow(Math.E, (z * erroPadrao_lkPositiva)));
        
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
        System.out.println("Likelihood Positiva: " + likelihoodPositiva);
        System.out.println("Likelihood Negativa: " + likelihoodNegativa);
        System.out.println("Erro padrao Likelihood Positiva: " + erroPadrao_lkPositiva);
        System.out.println("Erro padrao Likelihood Negativa: " + erroPadrao_lkNegativa);
        System.out.println("Z: " + z);
        System.out.println("Intervalo de conf LK+ Z-: " + intervaloConfianca_LKPositiva_zNegativo);
        System.out.println("Intervalo de conf LK+ Z+: " + intervaloConfianca_LKPositiva_zPositivo);
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

    public static double getSensibilidade() {
        return sensibilidade;
    }

    public static double getEspecificidade() {
        return especificidade;
    }

    public static double getLikelihoodPositiva() {
        return likelihoodPositiva;
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

    public static double getIntervaloConfianca_LKPositiva_zPositivo() {
        return intervaloConfianca_LKPositiva_zPositivo;
    }

    public static double getIntervaloConfianca_LKPositiva_zNegativo() {
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
    
     public static void setVerdadeiroPositivo(int verdadeiroPositivo) {
        Metanalise.verdadeiroPositivo = verdadeiroPositivo;
    }

    public static void setVerdadeiroNegativo(int verdadeiroNegativo) {
        Metanalise.verdadeiroNegativo = verdadeiroNegativo;
    }

    public static void setFalsoPositivo(int falsoPositivo) {
        Metanalise.falsoPositivo = falsoPositivo;
    }

    public static void setFalsoNegativo(int falsoNegativo) {
        Metanalise.falsoNegativo = falsoNegativo;
    }

    public static void setSensitividade(double sensitividade) {
        Metanalise.sensibilidade = sensitividade;
    }

    public static void setEspecificidade(double especificidade) {
        Metanalise.especificidade = especificidade;
    }

    public static void setLikelihoodPositiva(double likelihoodPositiviva) {
        Metanalise.likelihoodPositiva = likelihoodPositiviva;
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
        Metanalise.intervaloConfianca_LKPositiva_zPositivo = intervaloConfianca_LKPositivo_zPositivo;
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
