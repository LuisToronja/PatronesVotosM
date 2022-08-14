/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.memento.Originator;
import dominio.command.CommandVotar1;
import dominio.command.CommandVotar2;
import dominio.command.CommandRegresar;
import dominio.command.CommandVotar3;
import dominio.memento.Caretaker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 *
 * @author luise
 */
public class Control implements ActionListener{
    public UIVotos uiv;
    public static Votaciones votos;
    public Originator orig;
    public Caretaker crt;
    public GraficaBarras grafBarr;
    public GraficaPastel grafPast;
    public GeneradorExcel genExc;
    
    public Control(){
        this.uiv = new UIVotos();
        this.votos = new Votaciones();
        this.orig = new Originator();
        this.crt = new Caretaker();
        
        this.votos.setVoto1(new CommandVotar1());
        this.votos.setVoto2(new CommandVotar2());
        this.votos.setVoto3(new CommandVotar3());
        this.votos.setRegresar(new CommandRegresar(votos, crt, orig));
        
        uiv.btnCan1.addActionListener(this);
        uiv.btnCan2.addActionListener(this);
        uiv.btnCan3.addActionListener(this);
        uiv.btnRegresar.addActionListener(this);
        
        this.grafBarr = new GraficaBarras(votos);
        this.grafPast = new GraficaPastel(votos);
        this.genExc = new GeneradorExcel(votos);
        
        this.uiv.observado.adicionarObservador(grafBarr);
        this.uiv.observado.adicionarObservador(grafPast);
        this.uiv.observado.adicionarObservador(genExc);
        
        File f = new File("D:\\docs\\Observer.csv");
        if(f.exists() && !f.isDirectory()) { 
            this.genExc.leerDatos("D:\\docs\\Observer.csv");
            uiv.observado.notificarTodos();
        }
        
        this.uiv.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()!=uiv.btnRegresar){
            orig.setEstado(votos);
            crt.addMemento(orig.guardar());
        }
        votos.procesaEntrada(e, uiv);
        uiv.observado.notificarTodos();
    }   
}
