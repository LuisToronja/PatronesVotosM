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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author luise
 */
public class GraficaBarras implements Observadores{
    ChartFrame f;
    Votaciones votaciones;
    
    public GraficaBarras(Votaciones votaciones){
        this.votaciones = votaciones;
    }
    public void update(){
        try{
            f.dispose();
        }catch(Exception e){}
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        ds.addValue(votaciones.candidato1, "Candidato 1" ,"");
        ds.addValue(votaciones.candidato2, "Candidato 2" ,"");
        ds.addValue(votaciones.candidato3, "Candidato 3" ,"");
        JFreeChart jf = ChartFactory.createBarChart("Votaciones", "Candidato", 
                "Votos", ds, PlotOrientation.HORIZONTAL, true, true, true);
        f = new ChartFrame("Votaciones", jf);
        f.setBounds(200, 1200, 500, 300);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
}
