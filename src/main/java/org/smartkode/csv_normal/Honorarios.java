package org.smartkode.csv_normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Honorarios {
    private Map<String, List<String[]>> seccionesList = new HashMap<>();
    private static Map<String, List<Double>> totalPrimaNeta = new HashMap<>();
    private static Map<String, List<Double>> primaNetaDlsAMn = new HashMap<>();
    private static double total_honorarios;
    ReadFiles rd = new ReadFiles();

    public void setTotal_Honorarios(double total_honorarios) {
        Honorarios.total_honorarios = total_honorarios;
    }

    public double getTotal_Honorarios() {
        return total_honorarios;
    }

    public void setHonorarios(String[] row, String seccion) {
        if (rd.isEmptyString(row[3]))
            row = rd.removeElements(row, false, false,true);

        seccionesList.putIfAbsent(seccion, new ArrayList<>());
        seccionesList.get(seccion).add(row);
    }

    public void setTotales(String[] row, String col, String seccion) {
        if (col.equals("subtotal") || col.equals("dlsamn")) {
            row = rd.removeElements(row, true, false, false);
            seccionesList.get(seccion).add(row);
        }
        if (col.equals("honorarios")) {
            row = rd.removeElements(row, true, true, false);
            seccionesList.get(seccion).add(row);
        }

        if (col.equals("totalprimaneta")) {
            totalPrimaNeta.put(col, new ArrayList<>());
            if (rd.isEmptyString(row[2]))
                totalPrimaNeta.get(col).add(null);
            else
                totalPrimaNeta.get(col).add(Double.parseDouble(row[2]));

            if (rd.isEmptyString(row[3]))
                totalPrimaNeta.get(col).add(null);
            else
                totalPrimaNeta.get(col).add(Double.parseDouble(row[3]));
        }
        if (col.equals("primanetadlsamn")) {
            primaNetaDlsAMn.put(col, new ArrayList<>());
            if (rd.isEmptyString(row[2]))
                primaNetaDlsAMn.get(col).add(null);
            else
                primaNetaDlsAMn.get(col).add(Double.parseDouble(row[2]));

            if (rd.isEmptyString(row[3]))
                primaNetaDlsAMn.get(col).add(null);
            else
                primaNetaDlsAMn.get(col).add(Double.parseDouble(row[3]));
        }
    }

    public void printData() {
        for (Map.Entry<String, List<String[]>> entry : seccionesList.entrySet()) {
            String seccion = entry.getKey();
            List<String[]> filas = entry.getValue();

            System.out.println("=== Sección: " + seccion + " ===");
            for (String[] row : filas) {
                for (String col : row)
                    System.out.print(col + " ");
                System.out.println();
            }
            System.out.println();
        }
        for (Map.Entry<String, List<Double>> entry : totalPrimaNeta.entrySet()) {
            String seccion = entry.getKey();
            List<Double> filas = entry.getValue();
            System.out.println("=== Sección: " + seccion + " ===");
            for (Double col : filas)
                System.out.print(col + " ");
            System.out.println();
        }
        for (Map.Entry<String, List<Double>> entry : primaNetaDlsAMn.entrySet()) {
            String seccion = entry.getKey();
            List<Double> filas = entry.getValue();

            System.out.println("=== Sección: " + seccion + " ===");
            for (Double col : filas)
                System.out.print(col + " ");
            System.out.println();
        }

        System.out.println("Total de Honorarios: " + total_honorarios);
    }
}
