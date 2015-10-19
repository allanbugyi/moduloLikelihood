/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeamento;

/**
 *
 * @author allan
 */
public  class ModuloLikelihood {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //persistencia.CRUD.criaSessaoHibernate();
        //new gui.TelaHome().setVisible(true);
        new estatistica.Metanalise().printa();
    }
    
    public static void fechaSessaoHibernate(){
        //persistencia.CRUD.fechaSessaoHibernate();
    }
}
