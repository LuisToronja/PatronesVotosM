/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.memento;

import dominio.Votaciones;
import java.util.ArrayList;

/**
 *
 * @author luise
 */
public class Caretaker {
    public static ArrayList<Memento> mementos = new ArrayList<Memento>();
    public static int cont = 0;
    
    public void addMemento(Memento m){
        int cand1 = m.getEstado().candidato1;
        int cand2 = m.getEstado().candidato2;
        int cand3 = m.getEstado().candidato3;
        Votaciones v = new Votaciones();
        v.candidato1 = cand1;
        v.candidato2 = cand2;
        v.candidato3 = cand3;
        mementos.add(new Memento(v));
        cont++;
    }
    
    public Memento getMemento(int index){
        return mementos.get(index);
    }
}
