package org.smartkode.csv_tipos.csv_normal;

import org.smartkode.csv_comun.ReadFiles;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class Honorarios {
    private long id_honorario;
    private long id_tipo;
    List<Secciones> secciones = new ArrayList<Secciones>();
    private BigDecimal total_prima_neta_mn;
    private BigDecimal total_prima_neta_dlss;
    private BigDecimal total_dls_amn;
    private BigDecimal total_honorarios;
    ReadFiles rf = new ReadFiles();

    public void setId_honorario(long id_honorario) {
        this.id_honorario = id_honorario;
    }

    public long getId_honorario() {
        return id_honorario;
    }

    public void setId_tipo(long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public void setTotal_prima_neta_mn(BigDecimal total_prima_neta_mn) {
        this.total_prima_neta_mn = total_prima_neta_mn;
    }

    public void setTotal_prima_neta_dlss(BigDecimal total_prima_neta_dlss) {
        this.total_prima_neta_dlss = total_prima_neta_dlss;
    }

    public void setTotal_dls_amn(BigDecimal total_dls_amn) {
        this.total_dls_amn = total_dls_amn;
    }

    public void setTotal_honorarios(BigDecimal total_honorarios) {
        this.total_honorarios = total_honorarios;
    }

    public void setHonorario(List<String[]> data) {
        boolean clave = false;
        Secciones seccion = null;

        long i = 0;
        for (String[] row : data) {
            String col = rf.normanalizeString(row, 0);
            if (col.equals("clave")) {
                clave = true;
                continue;
            }

            if (clave) {
                col = rf.normanalizeString(row, 2);
                if (col.equals("descuentosantesdeimpuestos")) break;

                if (rf.isEmptyString(row[0])) {
                    if (rf.isEmptyString(row[1])) {
                        seccion = new Secciones(i, getId_honorario(), row[2]);
                        secciones.add(seccion);
                        i++;
                    } else {
                        col = rf.normanalizeString(row, 1);
                        BigDecimal bg;
                        if (col.equals("totalprimaneta")) {
                            bg = new BigDecimal(row[2]);
                            setTotal_prima_neta_mn(bg);
                            bg = new  BigDecimal(row[3]);
                            setTotal_prima_neta_dlss(bg);
                        } else if (col.equals("primanetadlsamn")) {
                            bg = new  BigDecimal(row[3]);
                            setTotal_dls_amn(bg);
                        }else if (col.equals("totalhonorarios")) {
                            bg = new  BigDecimal(row[4]);
                            setTotal_honorarios(bg);
                        }else seccion.setSeccion(row);
                    }
                } else seccion.setSeccion(row);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("CLAVE\t\tNOMBRE\t\t\t\tPRIMA NETA M.N.\t\tPRIMA NETA DLLS\t\tHONORARIOS\n");
        for (Secciones seccion : secciones)
            sb.append(seccion.printSeccion()).append("\n");

        sb.append("\t\t\tTotal Prima Neta\t\t").append(total_prima_neta_mn).
                append("\t\t").append(total_prima_neta_dlss).append("\n");
        sb.append("\t\t\tPrima Neta DLS.A.M.N.\t").append(total_dls_amn).append("\n");
        sb.append("\t\t\tTotal Honorarios\t\t").append(total_honorarios).append("\n");

        return sb.toString();
    }
}
