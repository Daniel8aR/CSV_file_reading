package org.smartkode.csv_normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Conceptos {
    private Map<String, List<String[]>> listaConceptos = new HashMap<String, List<String[]>>();
    ReadFiles rd = new ReadFiles();

    public void setConceptos(String[] row, String seccion) {
        listaConceptos.putIfAbsent(seccion, new ArrayList<>());
        listaConceptos.get(seccion).add(row);
    }

    public void printConceptos() {
        System.out.println("\n--- CONCEPTOS ---");
        for (Map.Entry<String, List<String[]>> entry : listaConceptos.entrySet()) {
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
    }
}
