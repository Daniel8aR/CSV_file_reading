package org.smartkode;

import com.opencsv.CSVReader;
import org.smartkode.csv_especial.NegociosEspeciales;
import org.smartkode.csv_normal.*;
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
            InputStream inputStream = Main_especial.class.getResourceAsStream("/csv_files/29548-307-202508.csv");
//            InputStream inputStream = Main.class.getResourceAsStream("/csv_files/03628-576-202505.csv");
            CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
            data = rf.readCSV(data, csvReader);

            csvReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        boolean inf=false, negEsp=false, descuentos=false, importFacturar=false, descuentosF=false, conceps=false;
        Informacion info = new Informacion();
        NegociosEspeciales negociosEsp = new NegociosEspeciales();
        Descuentos des = new Descuentos();
        ImporteAFacturar imp = new ImporteAFacturar();
        DescuentosFac df = new DescuentosFac();
        Conceptos conceptos = new Conceptos();
        String seccion = "";

        for(String[] row: data) {
            String col = rf.normanalizeString(row, 0);
//            System.out.println("Col: " + col);
            if (!inf) {
                if (col.equals("negociosespeciales")) {
                    inf = true;
                    continue;
                }
                info.setHonorarios(row, col);
                continue;
            }
            if (!negEsp) {
                negociosEsp.setName(row[0]);
                negociosEsp.setPrima_devengada(Double.parseDouble(row[1]));
                negociosEsp.setSiniestralidad(row[2]);
                negociosEsp.setPor_honorario(row[3]);
                negociosEsp.setSubtotal(Double.parseDouble(row[4]));

                negEsp = true;
                continue;
            }
            if (!descuentos) {
                if (row.length > 1) {
                    col = rf.normanalizeString(row, 1);
                    if(!rf.isEmptyString(col)){
                        if (col.equals("subtotal")) des.setSubtotal(Double.parseDouble(row[2]));
                        else des.setDescuentos(row);
                    } else {
                        col = rf.normanalizeString(row, 3);
                        if ((col.equals("totaldescuentos"))) {
                            des.setTotal(Double.parseDouble(row[4].stripLeading()));
                            descuentos = true;
                        }
                    }
                }
                continue;
            }

            if (!importFacturar) {
                if (row.length > 2) {
                    col = rf.normanalizeString(row, 3);
                    if (col.equals("subtotal")) imp.setSubtotal(Double.parseDouble(row[4]));
                    if (col.equals("iva")) imp.setIva(Double.parseDouble(row[4]));
                    if (col.equals("total")) {
                        importFacturar = true;
                        imp.setTotal(Double.parseDouble(row[4]));
                    }
                }
                continue;
            }

            if (!descuentosF) {
                if (row.length > 1) {
                    col = rf.normanalizeString(row, 3);
                    if (col.equals("total"))
                        df.setTotal(Double.parseDouble(row[4]));
                    else if (col.equals("importeapagar")) {
                        df.setImportePagar(Double.parseDouble(row[4]));
                        descuentosF = true;
                    } else {
                        col = rf.normanalizeString(row, 1);
                        if (!col.equals("concepto")){
                            col = rf.normanalizeString(row, 3);
                            if (!rf.isEmptyString(col)) df.setHonorarios(row);
                            else {
                                System.out.println("Muy corto 1");
                                descuentosF = true;
                            }
                        }
                    }
                } else {
                    System.out.println("Muy corto 2");
                    descuentosF = true;
                }
                continue;
            }

            if (!conceps){
                String colVer = rf.normanalizeString(row, 1);
                if (!rf.isEmptyString(col)) conceptos.setConceptos(row, seccion);
                else seccion = colVer;
            }
        }

        System.out.println(info.toString() + "\n\n");
        System.out.println(negociosEsp.toString() + "\n\n");
        System.out.println();
        des.getDescuentos();
        System.out.println("\n" + imp.toString() + "\n");
        conceptos.printConceptos();

//        rf.printData(data);
    }
}
