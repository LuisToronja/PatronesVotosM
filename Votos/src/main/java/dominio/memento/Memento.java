/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.memento;

import dominio.Votaciones;

/**
 *
 * @author luise
 */
public class Memento {
    private Votaciones estado;
    
    public Memento(){
        
    }
    
    public Memento(Votaciones v){
        this.estado = v;
    }
    
    public Votaciones getEstado(){
        return estado;
    }
    
    public void setEstado(Votaciones estado){
        this.estado = estado;
    }
}
