package org.smartkode.descuentos_impuestos;

import java.math.BigDecimal;

public class DescuentosI {
    private long id_descuentoI;
    private long id_descuentoImp;
    private String concepto;
    private BigDecimal descuento;

    public DescuentosI(long id_descuentoI, long id_descuentoImp, String concepto, BigDecimal descuento) {
        this.id_descuentoI = id_descuentoI;
        this.id_descuentoImp = id_descuentoImp;
        this.concepto = concepto;
        this.descuento = descuento;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return concepto + "\t\t\t" + descuento + "\n";
    }
}
