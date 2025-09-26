package org.smartkode.descuentos_impuestos;

import org.smartkode.csv_comun.ReadFiles;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class Descuentos_Impuestos {
    private long id_descuentoImp;
    private long id_estructura;
    private List<DescuentosI> listaDescuentos = new ArrayList<DescuentosI>();
    private BigDecimal subtotal;
    private BigDecimal total;
    ReadFiles rf = new ReadFiles();

    public void setId_descuentoImp(long id_descuentoImp) {
        this.id_descuentoImp = id_descuentoImp;
    }

    public long getId_descuentoImp() {
        return id_descuentoImp;
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void reviewData (long id_descuentoImp, long id_estructura, int tipo, List<String[]> data){
        long i = 0;
        boolean ver = false;
        setId_descuentoImp(id_descuentoImp);
        setId_estructura(id_estructura);

        for (String[] row : data) {
            String col = (row.length > 1) ? rf.normanalizeString(row, 1) : "";
            if (col.equals("importeafacturarporhonorarios")) break;

            if (row.length < 3) continue;

            col = (tipo == 1) ? rf.normanalizeString(row, 2) : rf.normanalizeString(row, 0);
            if (col.equals("descuentosantesdeimpuestos")) {
                ver = true;
                continue;
            }
            setDescuentos(row, i, ver);
            i++;
        }
    }

    public void setDescuentos(String[] row, long i, boolean ver) {
        BigDecimal bg;
        String col = rf.normanalizeString(row, 1);

        if (ver) {
            System.out.println(col);
            if (rf.isEmptyString(col)) {
                bg = new BigDecimal(row[4]);
                setTotal(bg);
            } else if (col.equals("subtotal")) {
                bg = new BigDecimal(row[2]);
                setSubtotal(bg);
            } else {
                bg = new BigDecimal(row[2]);
                listaDescuentos.add(new DescuentosI(i, getId_descuentoImp(), row[1], bg));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\t\t\t\t\tDescuentos Antes De Impuestos\n");
        for (DescuentosI descuento : listaDescuentos)
            sb.append(descuento.toString());

        sb.append("Subtotal\t\t\t").append(subtotal).append("\n");
        sb.append("Total Descuento\t\t\t").append(total).append("\n");

        return sb.toString();
    }
}
