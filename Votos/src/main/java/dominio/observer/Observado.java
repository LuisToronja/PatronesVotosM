/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.observer;

import java.util.ArrayList;

/**
 *
 * @author luise
 */
public class Observado {
    private ArrayList<Observadores> observadores = new ArrayList<Observadores>();
    
    public void adicionarObservador(Observadores observador){
        this.observadores.add(observador);
    }
    
    public void eliminarObservador(){
        
    }
    
    public void notificarTodos(){
        for(Observadores x : observadores ){
            x.update();
        }
    }
}
