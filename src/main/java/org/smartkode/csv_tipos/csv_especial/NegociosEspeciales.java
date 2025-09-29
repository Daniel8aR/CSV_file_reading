package org.smartkode.csv_tipos.csv_especial;

import org.smartkode.csv_comun.ReadFiles;
import org.smartkode.csv_tipos.base.TipoCSV;
import java.util.List;

public class NegociosEspeciales implements TipoCSV {
    private long id_negociosE;
    private long id_tipo;

    private String name;
    private Double prima_devengada;
    private String siniestralidad;
    private String por_honorario;
    private Double subtotal;
    ReadFiles rf = new ReadFiles();

    public void setId_negociosE(long id_negociosE) {
        this.id_negociosE = id_negociosE;
    }

    public void setId_tipo(long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.stripLeading().stripLeading();
    }

    public Double getPrima_devengada() {
        return prima_devengada;
    }

    public void setPrima_devengada(Double prima_devengada) {
        this.prima_devengada = prima_devengada;
    }

    public String getSiniestralidad() {
        return siniestralidad;
    }

    public void setSiniestralidad(String siniestralidad) {
        this.siniestralidad = siniestralidad.stripLeading().stripLeading();
    }

    public String getPor_honorario() {
        return por_honorario;
    }

    public void setPor_honorario(String por_honorario) {
        this.por_honorario = por_honorario.stripLeading().stripLeading();
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public void cargarDatos (long id_negociosE, long id_tipo, List<String[]> data) {
        setId_negociosE(id_negociosE);
        setId_tipo(id_tipo);
        boolean ver = false;
        for(String[] row: data){
            String col = rf.normanalizeString(row, 0);
            if (col.equals("negociosespeciales")) {
                ver = true;
                continue;
            }
            if (ver) {
                setValores(row);
                break;
            }
        }
    }

    public void setValores (String[] row){
        setName(row[0]);
        setPrima_devengada(Double.parseDouble(row[1]));
        setSiniestralidad(row[2]);
        setPor_honorario(row[3]);
        setSubtotal(Double.parseDouble(row[4]));
    }

    @Override
    public String toString() {
        return "NegociosEspeciales{" +
                "name='" + name + '\'' +
                ", prima_devengada=" + prima_devengada +
                ", siniestralidad=" + siniestralidad +
                ", por_honorario='" + por_honorario + '\'' +
                ", subtotal=" + subtotal +
                '}';
    }
}
