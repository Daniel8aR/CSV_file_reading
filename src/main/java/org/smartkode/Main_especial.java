package org.smartkode;

import com.opencsv.CSVReader;
import org.smartkode.Grupos.Grupo;
import org.smartkode.csv_comun.ImporteAFacturar;
import org.smartkode.csv_comun.Informacion;
import org.smartkode.csv_comun.ReadFiles;
import org.smartkode.csv_tipos.Tipos_CSV;
import org.smartkode.descuentos_factura.DescuentosFac;
import org.smartkode.descuentos_impuestos.Descuentos_Impuestos;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_especial {
    public static void main(String[] args){
        // Lista para guardar todas las filas del CSV
        List<String[]> data = new ArrayList<>();
        ReadFiles rf = new ReadFiles();

        try {
//            InputStream inputStream = Main_especial.class.getResourceAsStream("/csv_files/29548-307-202508.csv");
            InputStream inputStream = Main_especial.class.getResourceAsStream("/csv_files/03628-576-202505.csv");
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
            if (col.equals("negociosespeciales")) break;
            info.setInformacion(row, col);
        }

        Tipos_CSV tipo = new Tipos_CSV();
        for(String[] row: data) {
            if (row.length > 2 ) {
                col = rf.normanalizeString(row, 1);
                if (col.equals("honorarios")) {
                    tipo.setTipo_categoria(2);
                    break;
                }
            }
        }
        tipo.setTipo(0,  id_estructura, data);


        Descuentos_Impuestos des = new Descuentos_Impuestos();
        des.reviewData(0, id_estructura, tipo.getTipo_categoria(), data);

        ImporteAFacturar imp = new ImporteAFacturar();
        imp.setFacturar(0, id_estructura, data);


        DescuentosFac df = new DescuentosFac();
        df.reviewData(0, id_estructura, data);

        Grupo gp = new Grupo();
        gp.setGrupo(0, id_estructura, data);


        System.out.println(info.toString() + "\n");
        System.out.println(tipo.toString());
        System.out.println("\n" + des.toString());
        System.out.println("\n" + imp.toString() + "\n");
        System.out.println(df.toString());
        System.out.println("\n\n" + gp.toString());


//        rf.printData(data);
    }
}
