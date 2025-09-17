package org.smartkode;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.smartkode.readFiles.*;

public class Main {
    public static void main(String[] args){
        // Lista para guardar todas las filas del CSV
        List<String[]> data = new ArrayList<>();
        readFiles rf = new readFiles();

        try {
            InputStream inputStream = Main.class.getResourceAsStream("/03628-119-202505.csv");
            CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));

            data = rf.readCSV(data, csvReader);

            csvReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        for(String[] row: data){
            for(String col: row)
                System.out.print(col);
            System.out.println();
        }

        for(String[] row: data){
            for(String col: row)
                System.out.print(col);
            System.out.println();
        }
    }
}