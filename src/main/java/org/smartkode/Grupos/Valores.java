package org.smartkode.Grupos;

import java.math.BigDecimal;

public class Valores {
    private long id_valor;
    private long id_Concepto;
    private String nombre;
    private BigDecimal value;

    public Valores(long id_valor, long id_Concepto, String[] row) {
        this.id_Concepto = id_Concepto;
        this.id_valor = id_valor;
        this.nombre = row[0];
        BigDecimal bg = new BigDecimal(row[1]);
        this.value = bg;
    }

    @Override
    public String toString() {
        return nombre + "\t\t" + value;
    }
}
