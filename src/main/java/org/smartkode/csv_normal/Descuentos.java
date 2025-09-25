package org.smartkode.csv_normal;

import java.util.ArrayList;
import java.util.List;

public class Descuentos {
    private List<String[]> listaDescuentos = new ArrayList<String[]>();
    private double subtotal;
    private double total;
    ReadFiles rf = new ReadFiles();

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDescuentos(String[] row) {
        row = rf.removeElements(row, true, false,false);
        listaDescuentos.add(row);
    }

    public void getDescuentos() {
        System.out.println("==== DESCUENTOS ANTES DE IMPUESTOS ====");
        for (String[] row: listaDescuentos){
            for (String col: row)
                System.out.print(col + " ");
            System.out.println();
        }

        System.out.println("\nSubtotal: " + getSubtotal());
        System.out.println("Total Descuentos: " + getTotal());
    }
}
