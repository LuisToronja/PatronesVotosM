/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import dominio.observer.Observadores;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author luise
 */
public class GraficaPastel implements Observadores{
    ChartFrame f;
    Votaciones votaciones;
    
    public GraficaPastel(Votaciones votaciones){
        this.votaciones = votaciones;
    }
    public void update() {
        try{
            f.dispose();
        }catch(Exception e){}
        DefaultPieDataset dataset = new DefaultPieDataset( );
        dataset.setValue( "Candidato 1" , votaciones.candidato1 );  
        dataset.setValue( "Candidato 2" , votaciones.candidato2);   
        dataset.setValue( "Candidato 3" , votaciones.candidato3);

        JFreeChart chart = ChartFactory.createPieChart("Votaciones", dataset, true, true, false);
        f = new ChartFrame("Votaciones", chart);
        f.setLocationRelativeTo(null);
        f.setBounds(200, 200, 500, 300);
        f.setVisible(true);
    }
    
}
