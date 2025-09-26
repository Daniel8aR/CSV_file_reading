package org.smartkode.descuentos_factura;

import java.math.BigDecimal;

public class DescuentosF {
    private long id_descuentoF;
    private long id_descuentoFac;
    private String concepto;
    private BigDecimal remesa;
    private String cuenta;
    private BigDecimal importe;

    public DescuentosF(long id_descuentoF, long id_descuentoFac, String concepto,
                       BigDecimal remesa, String cuenta, BigDecimal importe) {
        this.id_descuentoF = id_descuentoF;
        this.id_descuentoFac = id_descuentoFac;
        this.concepto = concepto;
        this.remesa = remesa;
        this.cuenta = cuenta;
        this.importe = importe;
    }

    @Override
    public String toString() {
        return concepto + "\t" + remesa + "\t" + cuenta + "\t" + importe + "\n";
    }
}
