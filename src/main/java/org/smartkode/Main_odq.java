package org.smartkode;

import com.opencsv.CSVReader;
import org.smartkode.csv_comun.Informacion;
import org.smartkode.csv_comun.ReadFiles;
import org.smartkode.csv_tipos.Tipos_CSV;
import org.smartkode.csv_tipos.csv_odq.Info_ODQ;
import org.smartkode.csv_tipos.csv_odq.Oficinas;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_odq {
    public static void main(String[] args){
        // Lista para guardar todas las filas del CSV
        List<String[]> data = new ArrayList<>();
        ReadFiles rf = new ReadFiles();

        try {
            InputStream inputStream = Main_odq.class.getResourceAsStream("/csv_files/19301-ODQ-202508.csv");
//            InputStream inputStream = Main_odq.class.getResourceAsStream("/csv_files/20015-ODQ-202508.csv");
//            InputStream inputStream = Main_odq.class.getResourceAsStream("/csv_files/29548-ODQ-202508.csv");
            CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
            data = rf.readCSV(data, csvReader);

            csvReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        Informacion info = new Informacion();
        String col;
        int id_estructura = 0;

        for(String[] row: data) {
            col = rf.normanalizeString(row, 0);
            if (col.equals("CVEOFI")) break;
            info.setInformacion(row, col);
        }

        Tipos_CSV tipo = new Tipos_CSV();
        for(String[] row: data) {
            if (row.length > 2 ) {
                col = rf.normanalizeString(row, 1);
                if (col.equals("honorarios")) {
                    tipo.setTipo_categoria(3);
                    break;
                }
            }
        }

        tipo.setTipo(3, id_estructura, data);

        System.out.println(info.toString() + "\n");
        System.out.println(tipo.getTipo_categoria());
        System.out.println(tipo.toString());
    }
}
