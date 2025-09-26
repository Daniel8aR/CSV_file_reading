package org.smartkode.Grupos;

import org.smartkode.csv_comun.ReadFiles;
import java.util.ArrayList;
import java.util.List;

public class Conceptos {
    private long id_concepto;
    private long id_grupo;
    private String concepto_nombre;
    private List<Valores> listValores = new ArrayList<Valores>();
    ReadFiles rf = new ReadFiles();

    public Conceptos(long id_concepto, long id_grupo,  String concepto_nombre) {
        this.id_concepto = id_concepto;
        this.id_grupo = id_grupo;
        this.concepto_nombre = concepto_nombre;
    }

    public long getId_concepto() {
        return id_concepto;
    }

    public void setId_concepto(long id_concepto) {
        this.id_concepto = id_concepto;
    }

    public long getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(long id_grupo) {
        this.id_grupo = id_grupo;
    }

    public void setConceptos(long j, String[] row) {
        listValores.add(new  Valores(j, getId_concepto(), row));
    }

    public void setValor (String[] row, long i){

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\t\t\t" + concepto_nombre + "\n");
        for (Valores v : listValores)
            sb.append(v.toString() + "\n");

        return  sb.toString();
    }
}
