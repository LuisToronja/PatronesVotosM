/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.command;

import dominio.Control;
import dominio.memento.Originator;
import dominio.Votaciones;
import dominio.memento.Caretaker;

/**
 *
 * @author luise
 */
public class CommandRegresar implements Command{
    Originator orig;
    Caretaker crt;
    Votaciones votaciones;
    
    public CommandRegresar(Votaciones v, Caretaker crt, Originator orig){
        this.orig = orig;
        this.crt = crt;
        this.votaciones = v;
    }

    public void execute(Votaciones v){
        orig.restaurar(crt.getMemento(Caretaker.cont-1));
        v = orig.getEstado();
        Control.votos.candidato1 = v.candidato1;
        Control.votos.candidato2 = v.candidato2;
        Control.votos.candidato3 = v.candidato3;
        Caretaker.mementos.remove(Caretaker.cont-1);
        Caretaker.cont--;
    }
    
}
