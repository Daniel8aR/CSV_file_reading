package org.smartkode;

import com.opencsv.CSVReader;
import org.smartkode.csv_normal.ReadFiles;
import org.smartkode.csv_odq.Info_ODQ;
import org.smartkode.csv_odq.Oficinas;
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
//            InputStream inputStream = Main_odq.class.getResourceAsStream("/csv_files/19301-ODQ-202508.csv");
//            InputStream inputStream = Main_odq.class.getResourceAsStream("/csv_files/20015-ODQ-202508.csv");
            InputStream inputStream = Main_odq.class.getResourceAsStream("/csv_files/29548-ODQ-202508.csv");
            CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
            data = rf.readCSV(data, csvReader);

            csvReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        boolean inf = false;
        Info_ODQ info = new Info_ODQ();
        Oficinas reporte = new Oficinas();
        String seccion = "";

        for(String[] row: data) {
            String col = (!inf) ? rf.normanalizeString(row, 0) : rf.normanalizeString(row, 1);
            if (!inf) {
                if (col.equals("director")) info.setDirector(row[1].stripLeading());
                else if (col.equals("tipodeoficina")) info.setTipoOficina(row[1].stripLeading());
                else if (col.equals("periodocierre")) info.setPeriodoCierre(row[1].stripLeading());
                else if (col.equals("tipodecambio")) info.setTipoCambio(Double.parseDouble(row[1].stripLeading()));
                else if (col.equals("cveofi")) inf = true;
                continue;
            }

            if (rf.isEmptyString(col)){
                col = rf.normanalizeString(row, 4);

                if (!col.equals("totalodqs")) reporte.setOficinas(row, ".");
                else reporte.setTotales(row);
            } else reporte.setOficinas(row, row[1].stripLeading().stripTrailing());
        }

        System.out.println(info.toString());
        reporte.printData();
//        rf.printData(data);
    }
}
