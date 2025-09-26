package org.smartkode.csv_tipos;

import org.smartkode.csv_comun.ReadFiles;
import org.smartkode.csv_tipos.csv_especial.NegociosEspeciales;
import org.smartkode.csv_tipos.csv_normal.Honorarios;
import org.smartkode.csv_tipos.csv_odq.Info_ODQ;

import java.util.ArrayList;
import java.util.List;

public class Tipos_CSV {
    private long id_tipo;
    private long id_estructura;
    private int tipo_categoria;
    private Honorarios honor = new Honorarios();
    private NegociosEspeciales ne = new NegociosEspeciales();
    private Info_ODQ info = new Info_ODQ();
    private List<String[]> data = new ArrayList<>();
    ReadFiles rf = new ReadFiles();

    public void setTipo (long id_tipo, long id_estructura, List<String[]> data) {
        setId_tipo(id_tipo);
        setId_estructura(id_estructura);

        if (getTipo_categoria() == 1){
            honor.setId_honorario(0);
            honor.setId_tipo(id_tipo);
            honor.setHonorario(data);
        } else if (getTipo_categoria() == 2) ne.setNegociosEsp(1, id_tipo, data);
        else info.setTablaOdq(2, id_tipo, data);
    }

    public void setId_tipo(long id_tipo) {
        this.id_tipo = id_tipo;
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

    public void setTipo(long tipo) {
        this.id_tipo = tipo;
    }

    @Override
    public String toString(){
        if (getTipo_categoria() == 1)
            return honor.toString();
        else if (getTipo_categoria() == 2)
            return ne.toString();
        else
            return info.toString();
    }
}
