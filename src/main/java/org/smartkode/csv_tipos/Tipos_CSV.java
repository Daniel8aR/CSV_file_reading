package org.smartkode.csv_tipos;

import org.smartkode.csv_tipos.base.TipoCSV;
import org.smartkode.csv_tipos.csv_especial.NegociosEspeciales;
import org.smartkode.csv_tipos.csv_normal.Honorarios;
import org.smartkode.csv_tipos.csv_odq.Info_ODQ;
import java.util.List;

public class Tipos_CSV {
    private long id_tipo;
    private long id_estructura;
    private int tipo_categoria;
    private TipoCSV tipo; // polimórfico

    public void setTipo (long id_tipo, long id_estructura, List<String[]> data) {
        setId_tipo(id_tipo);
        setId_estructura(id_estructura);

        tipo = (getTipo_categoria() == 1) ? new Honorarios() :
               (getTipo_categoria() == 2) ? new NegociosEspeciales() :
                   new Info_ODQ();

        tipo.cargarDatos(id_tipo, id_estructura, data);
    }

    public void setId_tipo(long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public long getId_tipo() {
        return id_tipo;
    }

    public void setTipo_categoria(int tipo_categoria) {
        this.tipo_categoria = tipo_categoria;
    }

    public int getTipo_categoria() {
        return tipo_categoria;
    }

    public void setId_estructura(long id_estructura) {
        this.id_estructura = id_estructura;
    }

    public long getId_estructura() {
        return id_estructura;
    }

    @Override
    public String toString(){
        return tipo != null ? tipo.toString() : "No se cargó ningún tipo.";
    }
}
