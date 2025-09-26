package org.smartkode.descuentos_factura;

import org.smartkode.csv_comun.ReadFiles;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DescuentosFac {
    private long id_descuentoF;
    private long id_estructura;
    private BigDecimal total;
    private BigDecimal importePagar;
    private List<DescuentosF> listaDescuentos = new ArrayList<>();
    ReadFiles rf = new ReadFiles();

    public void setId_descuentoF(long id_descuentoF) {
        this.id_descuentoF = id_descuentoF;
    }

    public long getId_descuentoF() {
        return id_descuentoF;
    }

    public void setId_estructura(long id_estructura) {
        this.id_estructura = id_estructura;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getImportePagar() {
        return importePagar;
    }

    public void setImportePagar(BigDecimal importePagar) {
        this.importePagar = importePagar;
    }

    public void reviewData (long id_descuentoF, long id_estructura, List<String[]> data) {
        long i=0;
        boolean ver = false;
        setId_descuentoF(id_descuentoF);
        setId_estructura(id_estructura);
        BigDecimal bg;
        String before = "";

        for (String[] row : data) {
            if (row.length > 4){
                String col = rf.normanalizeString(row, 3);
                if (col.equals("total") && !before.equals("iva")) {
                    bg = new BigDecimal(row[4]);
                    setTotal(bg);
                    continue;
                } else if (col.equals("importeapagar")) {
                    bg = new BigDecimal(row[4]);
                    setImportePagar(bg);
                    break;
                }

                before = col;
                col = rf.normanalizeString(row, 1);
                if (col.equals("concepto")){
                    ver = true;
                    continue;
                }

                setDescuento(row, i, ver);
                i++;
            }
        }
    }

    public void setDescuento (String[] row, long i, boolean ver){
        BigDecimal bg1, bg2;
        if (row.length > 3){
            String col = rf.normanalizeString(row, 3);

            if (ver) {
                if (rf.isEmptyString(col)) {
                    bg1 = new BigDecimal(row[4]);
                    setTotal(bg1);
                } else {
                    bg1 = new BigDecimal(row[2]);
                    bg2 = new BigDecimal(row[4]);
                    listaDescuentos.add(new DescuentosF(i, getId_descuentoF(), row[1], bg1, row[3], bg2));
                }
            }
        }
    }

    public String toString(){
        System.out.println("\n--- DESCUENTOS QUE SE HACEN SOBRE LA FACTURA DE HONORARIOS ---");
        StringBuilder sb = new StringBuilder();

        sb.append("CONCEPTO\t\t\t\t\t\t\t\t\t\t\tREMESA\t\tCUENTA\tIMPORTE\n");
        for (DescuentosF descuento : listaDescuentos) {
            sb.append(descuento.toString());
        }

        sb.append("\tTotal: " + total);

        sb.append("\nImporte A Pagar: " + importePagar);
        return sb.toString();
    }
}
