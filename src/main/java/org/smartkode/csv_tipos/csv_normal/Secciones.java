package org.smartkode.csv_tipos.csv_normal;

import org.smartkode.csv_comun.ReadFiles;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class Secciones {
    private long id_seccion;
    private long id_honorario;

    private String nombre_seccion;
    private List<Registros> registros = new ArrayList<>();
    private BigDecimal subtotal_m_n;
    private BigDecimal subtotal_dlss;
    private BigDecimal dls_amn;
    private String porc_honorario;
    private BigDecimal total_honorario;
    ReadFiles rf = new ReadFiles();

    public Secciones(long id_seccion, long id_honorario, String nombre_seccion) {
        this.id_seccion = id_seccion;
        this.id_honorario = id_honorario;
        this.nombre_seccion = nombre_seccion;
    }

    public void setId_seccion(long id_seccion) {
        this.id_seccion = id_seccion;
    }

    public void setId_honorario(long id_honorario) {
        this.id_honorario = id_honorario;
    }

    public void setNombre_seccion(String nombre_seccion) {
        this.nombre_seccion = nombre_seccion;
    }

    public String getNombre_seccion() {
        return nombre_seccion;
    }

    public void setSubtotal_m_n(BigDecimal subtotal_m_n) {
        this.subtotal_m_n = subtotal_m_n;
    }

    public void setSubtotal_dlss(BigDecimal subtotal_dlss) {
        this.subtotal_dlss = subtotal_dlss;
    }

    public void setDls_amn(BigDecimal dls_amn) {
        this.dls_amn = dls_amn;
    }

    public void setPorc_honorario(String porc_honorario) {
        this.porc_honorario = porc_honorario;
    }

    public void setTotal_honorario(BigDecimal total_honorario) {
        this.total_honorario = total_honorario;
    }

    public void setSeccion(String[] row) {
        if (!rf.isEmptyString(row[0]))
            addingRegistro(row);
        else {
            String col = rf.normanalizeString(row, 1);
            BigDecimal bg;
            if (col.equals("dlsamn")) {
                bg = new  BigDecimal(row[3]);
                setDls_amn(bg);
            }else if (col.equals("subtotal")) {
                bg = new  BigDecimal(row[2]);
                setSubtotal_m_n(bg);
                bg = new  BigDecimal(row[3]);
                setSubtotal_dlss(bg);
            } else if (col.equals("honorarios")) {
                setPorc_honorario(row[3]);
                bg = new  BigDecimal(row[4]);
                setTotal_honorario(bg);
            }
        }
    }

    public void addingRegistro (String[] row){
        registros.add(new Registros(Long.parseLong(row[0]), id_seccion, row[1], row[2], row[3]));
    }

    public String printSeccion(){
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t").append(nombre_seccion).append("\n");

        for (Registros registro : registros)
            sb.append(registro.toString());

        sb.append("\t\t\tSubtotal\t").append(subtotal_m_n).append("  ").append(subtotal_dlss).append("\n");
        sb.append("\t\t\tDLS.A.M.N\t\t").append(dls_amn).append("\n");
        sb.append("\t\t\tHonorarios\t").append(nombre_seccion).append("\t")
                .append(porc_honorario).append("\t").append(total_honorario).append("\n");

        return sb.toString();
    }
}
