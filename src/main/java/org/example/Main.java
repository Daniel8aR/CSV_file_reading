package org.example;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.example.readFiles.*;

public class Main {
    public static void main(String[] args){
        // Lista para guardar todas las filas del CSV
        List<String[]> data = new ArrayList<>();
            try {
                FileReader fl = new FileReader("C:\\Users\\danie\\OneDrive\\Escritorio\\proyectohonorariosdirectores\\03628-119-202505.csv");
                CSVReader csvReader = new CSVReader(fl);
                data = readFiles.readCSV(data, csvReader);

                csvReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        for(String[] row: data){
            for(String col: row)
                System.out.print(col);
            System.out.println();
        }
    }
}