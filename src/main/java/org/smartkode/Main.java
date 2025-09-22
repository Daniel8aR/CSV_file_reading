package org.smartkode;

import com.opencsv.CSVReader;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        // Lista para guardar todas las filas del CSV
        List<String[]> data = new ArrayList<>();
        ReadFiles rf = new ReadFiles();

        try {
            InputStream inputStream = Main.class.getResourceAsStream("/29568-060-202508.csv");
            CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
            data = rf.readCSV(data, csvReader);

            csvReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        boolean inf=false, honorarios=false, descuentos=false, importFacturar=false, descuentosF=false;
        Informacion info = new Informacion();
        Honorarios honor = new Honorarios();
        Descuentos des = new Descuentos();
        ImporteAFacturar imp = new ImporteAFacturar();
        Conceptos conceptos = new Conceptos();
        String seccion = "";

        for(String[] row: data){
            String col = rf.normanalizeString(row, 0);
            if (!inf) {
                if (col.equals("clave")) {
                    inf=true;
                    continue;
                }
                info.setHonorarios(row, col);
                continue;
            }

            if (!honorarios) {
                if (!rf.isEmptyString(col)) {
                    col = rf.normanalizeString(row, 1);
                    if (!rf.isEmptyString(col))
                        honor.setHonorarios(row, seccion);
                } else if (rf.isEmptyString(row[1])) {
                    col = rf.normanalizeString(row, 2);
                    seccion = col;
                } else {
                    col = rf.normanalizeString(row, 1);
                    if (col.equals("totalhonorarios")) {
                        honor.setTotal_Honorarios(Double.parseDouble(row[4]));
                        honorarios = true;
                    }
                    honor.setTotales(row, col, seccion);
                }
                continue;
            }

            if(!descuentos){
                col = rf.normanalizeString(row, 1);
                if(!rf.isEmptyString(col)){
                    if (col.equals("subtotal"))
                        des.setSubtotal(Double.parseDouble(row[2]));
                    else
                        des.setDescuentos(row);
                } else {
                    if (rf.isEmptyString(row[2])) {
                        des.setTotal(Double.parseDouble(row[4]));
                        descuentos = true;
                    }
                }
                continue;
            }

            if (!importFacturar){
                col = rf.normanalizeString(row, 1);
                if (col.equals("importeafacturarporhonorarios")){
                    imp.setSubtotal(Double.parseDouble(row[4]));
                    continue;
                }
                col = rf.normanalizeString(row, 3);
                if (col.equals("iva")) imp.setIva(Double.parseDouble(row[4]));
                if (col.equals("total")){
                    importFacturar = true;
                    imp.setTotal(Double.parseDouble(row[4]));
                }
                continue;
            }

            if (!descuentosF){
                if (row.length > 1){
                    String colVer = rf.normanalizeString(row, 1);

                    if(!colVer.equals("concepto")){
                        if (!rf.isEmptyString(col)){
                            conceptos.setConceptos(row, seccion);
                        } else
                            seccion = colVer;
                    }
                }
            }
        }

//        System.out.println(info.toString() + "\n\n");
//        honor.printData();
//        des.getDescuentos();
//        System.out.println("\n\n" + imp.toString());
        conceptos.printConceptos();
//        rf.printData(data);
    }

}