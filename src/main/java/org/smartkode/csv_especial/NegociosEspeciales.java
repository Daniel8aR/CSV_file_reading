package org.smartkode.csv_especial;

public class NegociosEspeciales {
    private String name;
    private Double prima_devengada;
    private String siniestralidad;
    private String por_honorario;
    private Double subtotal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.siniestralidad = siniestralidad;
    }

    public String getPor_honorario() {
        return por_honorario;
    }

    public void setPor_honorario(String por_honorario) {
        this.por_honorario = por_honorario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
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
