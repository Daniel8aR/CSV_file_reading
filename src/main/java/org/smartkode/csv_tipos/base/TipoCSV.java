package org.smartkode.csv_tipos.base;

import java.util.List;

public interface TipoCSV {
    void cargarDatos (long idRegistro, long idTipo, List<String[]> data);
}
