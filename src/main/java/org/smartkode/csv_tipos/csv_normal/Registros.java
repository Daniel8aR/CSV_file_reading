package org.smartkode.csv_tipos.csv_normal;

import org.smartkode.csv_comun.ReadFiles;
import java.math.BigDecimal;

public class Registros {
    private long clave;
    private long id_seccion;
    private String nombre;
    private BigDecimal prima_neta_mn;
    private BigDecimal prima_neta_dlss;
    ReadFiles rf = new ReadFiles();

    public Registros(long clave, long id_seccion, String nombre, String prima_neta_mn, String prima_neta_dlss) {
        this.clave = clave;
        this.id_seccion = id_seccion;
        this.nombre = nombre;
        if (!rf.isEmptyString(prima_neta_mn)) this.prima_neta_mn = new BigDecimal(prima_neta_mn);
        else this.prima_neta_mn = null;
        if (!rf.isEmptyString(prima_neta_dlss)) this.prima_neta_dlss = new BigDecimal(prima_neta_dlss);
        else this.prima_neta_dlss = null;
    }

    public double getClave() {
        return clave;
    }

    public double getId_seccion() {
        return id_seccion;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrima_neta_mn() {
        return prima_neta_mn;
    }

    public BigDecimal getPrima_neta_dlss() {
        return prima_neta_dlss;
    }

    @Override
    public String toString() {
        String str = clave + "   "
                + nombre + "   ";
        str += (prima_neta_mn == null) ? "\t" : prima_neta_mn;
        str += (prima_neta_dlss == null) ? "" : prima_neta_dlss;

        return str + "\n";
    }
}
