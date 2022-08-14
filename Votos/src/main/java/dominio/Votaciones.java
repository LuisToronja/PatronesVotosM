/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.command.Command;
import java.awt.event.ActionEvent;

/**
 *
 * @author luise
 */
public class Votaciones {
    private Command Voto1;
    private Command Voto2;
    private Command Voto3;
    private Command Regresar;
    
    public int candidato1;
    public int candidato2;
    public int candidato3;
    
    public Votaciones(){
        candidato1 = 0;
        candidato2 = 0;
        candidato3 = 0;
    }
    
    public void votar1(){
        candidato1++;
    }
    public void votar2(){
        candidato2++;
    }
    public void votar3(){
        candidato3++;
    }
    
    public void setVoto1(Command v){
        this.Voto1 = v;
    }
        
    public void setVoto2(Command v){
        this.Voto2 = v;
    }
        
    public void setVoto3(Command v){
        this.Voto3 = v;
    }
    
    public void setRegresar(Command v){
        this.Regresar = v;
    }
    
    public void procesaEntrada(ActionEvent e, UIVotos uiv){
        if(e.getSource()== uiv.btnCan1)Voto1.execute(this);
        if(e.getSource() == uiv.btnCan2)Voto2.execute(this);
        if(e.getSource() == uiv.btnCan3)Voto3.execute(this);
        if(e.getSource() == uiv.btnRegresar)Regresar.execute(this);
    }
    
}
