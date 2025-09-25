package org.smartkode.csv_normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DescuentosFac {
    private double total;
    private double importePagar;
    private List<String[]> descuentos = new ArrayList<>();
    ReadFiles rd = new ReadFiles();

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getImportePagar() {
        return importePagar;
    }

    public void setImportePagar(double importePagar) {
        this.importePagar = importePagar;
    }

    public void setHonorarios(String[] row) {
        row = rd.removeElements(row, true, false, false);

        descuentos.add(row);
    }

    public void printDescuentosFacturas(){
        System.out.println("\n--- DESCUENTOS QUE SE HACEN SOBRE LA FACTURA DE HONORARIOS ---");
        if (!descuentos.isEmpty()) {
            for(String[] row: descuentos){
                for (String col: row)
                    System.out.print(col + "  ");
                System.out.println();
            }
        }
        if (total>0) System.out.println("\nTotal: " + total);

        System.out.println("Importe: " + importePagar);
    }
}
