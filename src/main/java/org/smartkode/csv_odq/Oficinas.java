package org.smartkode.csv_odq;

import org.smartkode.csv_normal.ReadFiles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Oficinas {
    private Map<String, List<String[]>> oficinasList = new HashMap<String, List<String[]>>(); // cada fila es un mapa clave-valor
    private Map<String, Double> totales = new HashMap<>();
    ReadFiles rd = new ReadFiles();

    public void setOficinas(String[] row, String oficina) {
        if (!oficina.equals(".")) renameOficina(".", oficina);
        oficinasList.putIfAbsent(oficina, new ArrayList<>());
        oficinasList.get(oficina).add(row);
    }

    public void renameOficina(String oldName, String newName) {
        if (oficinasList.containsKey(oldName)) {
            // Mueve la lista completa a la nueva clave
            List<String[]> filas = oficinasList.remove(oldName);

            // Si ya existía la sección destino, las fusionamos
            oficinasList.putIfAbsent(newName, new ArrayList<>());
            oficinasList.get(newName).addAll(filas);
        }
    }

    public void setTotales(String[] row) {
        totales.put("prima_neta_mn", Double.parseDouble(row[5]));
        totales.put("prima_neta_dlls", Double.parseDouble(row[6]));

        if (rd.isEmptyString(row[7])) totales.put("por_honorarios", null);
        else totales.put("por_honorarios", Double.parseDouble(row[7]));

        totales.put("total_honorarios", Double.parseDouble(row[8]));
        totales.put("nuevos_agentes", Double.parseDouble(row[9]));
        totales.put("subtotal", Double.parseDouble(row[10]));
        totales.put("iva", Double.parseDouble(row[11]));
        totales.put("total", Double.parseDouble(row[12]));
    }

    public void printData() {
        for (Map.Entry<String, List<String[]>> entry : oficinasList.entrySet()) {
            String seccion = entry.getKey();
            List<String[]> filas = entry.getValue();

            System.out.println("\n====== OFICINA: " + seccion + " ======");
            for (String[] row : filas) {
                for (String col : row)
                    System.out.print(col + " ");
                System.out.println();
            }
        }
        System.out.println("\n====== TOTALES ======");
        System.out.println(totales);
    }
}
