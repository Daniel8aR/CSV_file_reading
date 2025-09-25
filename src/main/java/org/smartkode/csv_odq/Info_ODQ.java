package org.smartkode.csv_odq;

public class Info_ODQ {
    private String director;
    private String tipoOficina;
    private String periodoCierre;
    private double tipoCambio;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director.stripLeading();
    }

    public String getTipoOficina() {
        return tipoOficina;
    }

    public void setTipoOficina(String tipoOficina) {
        this.tipoOficina = tipoOficina.stripLeading();
    }

    public String getPeriodoCierre() {
        return periodoCierre;
    }

    public void setPeriodoCierre(String periodoCierre) {
        this.periodoCierre = periodoCierre.stripLeading();
    }

    public double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    @Override
    public String toString() {
        return "Info_ODQ{" +
                "\n\tdirector='" + director + '\'' +
                ",\n\ttipoOficina='" + tipoOficina + '\'' +
                ",\n\tperiodoCierre='" + periodoCierre + '\'' +
                ",\n\ttipoCambio=" + tipoCambio +
                "\n}\n";
    }
}
