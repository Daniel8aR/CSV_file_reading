package org.smartkode.csv_tipos.base;

import java.util.List;

public abstract class Abstract_TipoCSV {
    protected long idRegistro;
    protected long idTipo;

    public final void cargar(long idRegistro, long idTipo, List<String[]> data) {
        this.idRegistro = idRegistro;
        this.idTipo = idTipo;
        cargarDatos(data);
    }

    protected abstract void cargarDatos(List<String[]> data);

    public long getIdRegistro() {
        return idRegistro;
    }

    public long getIdTipo() {
        return idTipo;
    }
}
