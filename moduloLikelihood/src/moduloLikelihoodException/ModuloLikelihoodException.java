/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduloLikelihoodException;

/**
 *
 * @author allan
 */
public final class ModuloLikelihoodException extends Exception{
    
    private String erro = null;
    
    public ModuloLikelihoodException(String erro){
        this.erro = erro;
    }
    
    @Override
    public String getMessage(){
        return erro;
    }
}
