/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estatistica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import mapeamento.EstudoIndividual;

/**
 *
 * @author allan
 */
public class Agrupados {
    
    private static double LKPositiva;
    private static double LKNegativa;
    private static double erroPadrao;
    private static double intervaloConfSup;
    private static double intervaloConfInf;
    private static ArrayList<EstudoIndividual> estudosIndividuais;

    public Agrupados(){
    }
    
    public static void calculaLikelihoodGlobal(){
        double somatorioPesosLKPositiva = 0, somatorioPesosPositiva = 0, somatorioPesosLKNegativa = 0, somatorioPesosNegativa = 0;
        
        for(EstudoIndividual estInd : Agrupados.estudosIndividuais){
            somatorioPesosLKPositiva += ((estInd.getMetanaliseEstudoIndividual().getPesoMhLkpositiva()) * (estInd.getMetanaliseEstudoIndividual().getLikelihoodPositiviva()));
            somatorioPesosPositiva   += (estInd.getMetanaliseEstudoIndividual().getPesoMhLkpositiva());
            
            somatorioPesosLKNegativa   += ((estInd.getMetanaliseEstudoIndividual().getPesoMhLknegativa()) * (estInd.getMetanaliseEstudoIndividual().getLikelihoodNegativa()));
            somatorioPesosNegativa     += (estInd.getMetanaliseEstudoIndividual().getPesoMhLknegativa());
        }
        
        Agrupados.LKPositiva = somatorioPesosLKPositiva/somatorioPesosPositiva;
        Agrupados.LKNegativa = somatorioPesosLKNegativa/somatorioPesosNegativa;
    }
    
    public static void resetaValores(){
        Agrupados.LKNegativa = 0;
        Agrupados.LKPositiva = 0;
        Agrupados.erroPadrao = 0;
        Agrupados.intervaloConfSup = 0;
        Agrupados.intervaloConfInf = 0;
    }
    
    public static void printa(){
         System.out.println("Likelihood global positiva: " + Agrupados.LKPositiva);
         System.out.println("Likelihood global positiva: " + Agrupados.LKNegativa);
     }
     
    public static double getLKPositiva() {
        return LKPositiva;
    }

    public static void setLKPositiva(double LKPositiva) {
        Agrupados.LKPositiva = LKPositiva;
    }

    public static double getLKNegativa() {
        return LKNegativa;
    }

    public static void setLKNegativa(double LKNegativa) {
        Agrupados.LKNegativa = LKNegativa;
    }

    public static double getErroPadrao() {
        return erroPadrao;
    }

    public static void setErroPadrao(double erroPadrao) {
        Agrupados.erroPadrao = erroPadrao;
    }

    public static double getIntervaloConfSup() {
        return intervaloConfSup;
    }

    public static void setIntervaloConfSup(double intervaloConfSup) {
        Agrupados.intervaloConfSup = intervaloConfSup;
    }

    public static double getIntervaloConfInf() {
        return intervaloConfInf;
    }

    public static void setIntervaloConfInf(double intervaloConfInf) {
        Agrupados.intervaloConfInf = intervaloConfInf;
    }

    public static ArrayList<EstudoIndividual> getEstudosIndividuais() {
        return estudosIndividuais;
    }

    public static void setEstudosIndividuais(ArrayList<EstudoIndividual> estudosIndividuais) {
        Agrupados.estudosIndividuais = estudosIndividuais;
    }
    
}
