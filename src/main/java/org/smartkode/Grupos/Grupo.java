package org.smartkode.Grupos;

import org.smartkode.csv_comun.ReadFiles;
import org.smartkode.csv_tipos.csv_normal.Secciones;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private long id_grupo;
    private long id_estructura;
    private List<Conceptos> listaConceptos  = new ArrayList<Conceptos>();
    ReadFiles rf = new ReadFiles();

    public void setId_grupo(long id_grupo) {
        this.id_grupo = id_grupo;
    }

    public long getId_grupo() {
        return id_grupo;
    }

    public void setId_estructura(long id_estructura) {
        this.id_estructura = id_estructura;
    }

    public void setGrupo (long id_grupo, long id_estructura, List<String[]> data) {
        setId_grupo(id_grupo);
        setId_estructura(id_estructura);
        long i=0, j=0;
        boolean ver = false;
        Conceptos concep;

        for (String[] row : data) {
            if (row.length > 1){
                String col = rf.normanalizeString(row, 1);
                if (col.equals("ayudadesiniestros") || col.equals("grupo123")) {
                    ver = true;
                    concep = new Conceptos(i, getId_grupo(), row[1]);
                    listaConceptos.add(concep);
                    i++;
                    continue;
                }

                if (ver && !listaConceptos.isEmpty()) {
                    Conceptos concepActual = listaConceptos.get(listaConceptos.size() - 1);
                    concepActual.setConceptos(j, row);
                    j++;
                }
            }
        }

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (Conceptos conceptos : listaConceptos) {
            sb.append(conceptos.toString() + "\n");
        }

        return sb.toString();
    }
}
