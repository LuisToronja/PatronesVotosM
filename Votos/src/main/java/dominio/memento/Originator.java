/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.memento;

import dominio.Votaciones;
import dominio.memento.Memento;

/**
 *
 * @author luise
 */
public class Originator {
    private Votaciones estado;
    
    public Votaciones getEstado(){
        return estado;
    }
    
    public void setEstado(Votaciones estado){
        this.estado = estado;
    }
    
    public Memento guardar(){
        return new Memento(estado);
    }
    
    public void restaurar(Memento m){
        this.estado = m.getEstado();
    }
}
