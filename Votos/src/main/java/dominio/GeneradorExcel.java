/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;


import dominio.observer.Observadores;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author luise
 */
public class GeneradorExcel implements Observadores{
    Votaciones votaciones;
    
    public GeneradorExcel(Votaciones votaciones){
        this.votaciones = votaciones;
    }
  
    public void update() {
        File file = new File("D:\\docs\\Observer.csv");
        try{
        file.createNewFile();
        }catch(Exception e){}
        try{
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] header = {"Candidato", "Votos"};
            writer.writeNext(header);
            String[] data1 = {"Candidato 1", Integer.toString(votaciones.candidato1)}; 
            writer.writeNext(data1); 
            String[] data2 = {"Candidato 2", Integer.toString(votaciones.candidato2)}; 
            writer.writeNext(data2); 
            String[] data3 = {"Candidato 3", Integer.toString(votaciones.candidato3)};
            writer.writeNext(data3); 
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        } 
    }

    public void leerDatos(String file){
  
    try {
        ArrayList<Integer> list = new ArrayList<Integer>();
  
        // Create an object of filereader
        // class with CSV file as a parameter.
        FileReader filereader = new FileReader(file);
  
        // create csvReader object passing
        // file reader as a parameter
        CSVReader csvReader = new CSVReader(filereader);
        String[] nextRecord;
  
        // we are going to read data line by line
        while ((nextRecord = csvReader.readNext()) != null) {
            for (String cell : nextRecord) {
                try{
                    list.add(Integer.parseInt(cell));
                }catch(Exception e){}
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
        votaciones.candidato1 = list.get(0);
        votaciones.candidato2 = list.get(1);
        votaciones.candidato3 = list.get(2);
        
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    
} 
}
