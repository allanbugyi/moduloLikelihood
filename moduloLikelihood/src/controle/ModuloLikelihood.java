/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author allan
 */
public  class ModuloLikelihood {

    private static Integer idContador;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new gui.TelaHome().setVisible(true);
    }
    
    public Integer getIdContador() {
        return idContador;
    }
    
}
