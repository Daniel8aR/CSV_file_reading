package org.smartkode.csv_comun;

import java.math.BigDecimal;
import java.util.List;

public class ImporteAFacturar {
    private long id_importeF;
    private long id_estructura;
    private BigDecimal subtotal;
    private BigDecimal iva;
    private BigDecimal total;
    ReadFiles rf = new ReadFiles();

    public void setId_importeF(long id_importeF) {
        this.id_importeF = id_importeF;
    }

    public void setId_estructura(long id_estructura) {
        this.id_estructura = id_estructura;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setFacturar (long id_importeF, long id_estructura, List<String[]> data){
        setId_importeF(id_importeF);
        setId_estructura(id_estructura);
        boolean ver = false;

        for (String[] row : data){
            if (getTotal() != null) break;

            if (row.length < 2) continue;

            String col = rf.normanalizeString(row, 1);
            if (col.equals("importeafacturarporhonorarios")) ver = true;
            setTotales(row, ver);
        }
    }

    public void setTotales (String[] row, boolean ver){
        if (ver){
            if (row.length > 3){
                String col = rf.normanalizeString(row, 3);
                if (!rf.isEmptyString(col)) {
                    BigDecimal bg = new BigDecimal(row[4]);

                    if (col.equals("subtotal")) setSubtotal(bg);
                    if (col.equals("iva")) setIva(bg);
                    if (col.equals("total")) setTotal(bg);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "ImporteAFacturar{" +
                "\nsubtotal=" + subtotal +
                ",\niva=" + iva +
                ",\ntotal=" + total +
                "\n}";
    }
}
