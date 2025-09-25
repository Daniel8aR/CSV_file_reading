package org.smartkode.csv_normal;

public class Informacion {
    private int director_clave;
    private String director_nom;
    private String oficina_dir;
    private String oficina_tipo;
    private String estructura;
    private String periodo_cierre;
    private String siniestralidad;
    private String tabla_para_sin;
    private String tabla_honorario;
    private String porc_honorario;
    private double tipo_cambio;

    public int getDirector_clave() {
        return director_clave;
    }

    public String getOficina_tipo() {
        return oficina_tipo;
    }

    public void setOficina_tipo(String oficina_tipo) {
        this.oficina_tipo = oficina_tipo;
    }

    public void setDirector_clave(int director_clave) {
        this.director_clave = director_clave;
    }

    public String getDirector_nom() {
        return director_nom;
    }

    public void setDirector_nom(String director_nom) {
        this.director_nom = director_nom;
    }

    public String getOficina_dir() {
        return oficina_dir;
    }

    public void setOficina_dir(String oficina_dir) {
        this.oficina_dir = oficina_dir;
    }

    public String getEstructura() {
        return estructura;
    }

    public void setEstructura(String estructura) {
        this.estructura = estructura;
    }

    public String getPeriodo_cierre() {
        return periodo_cierre;
    }

    public void setPeriodo_cierre(String periodo_cierre) {
        this.periodo_cierre = periodo_cierre;
    }

    public String getSiniestralidad() {
        return siniestralidad;
    }

    public void setSiniestralidad(String siniestralidad) {
        this.siniestralidad = siniestralidad;
    }

    public String getTabla_para_sin() {
        return tabla_para_sin;
    }

    public void setTabla_para_sin(String tabla_para_sin) {
        this.tabla_para_sin = tabla_para_sin;
    }

    public String getTabla_honorario() {
        return tabla_honorario;
    }

    public void setTabla_honorario(String tabla_honorario) {
        this.tabla_honorario = tabla_honorario;
    }

    public String getPorc_honorario() {
        return porc_honorario;
    }

    public void setPorc_honorario(String porc_honorario) {
        this.porc_honorario = porc_honorario;
    }

    public double getTipo_cambio() {
        return tipo_cambio;
    }

    public void setTipo_cambio(double tipo_cambio) {
        this.tipo_cambio = tipo_cambio;
    }

    public void setHonorarios(String[] row, String col) {
        if (col.equals("director")) {
            String[] directors = row[1].split(" ", 2);

            this.setDirector_clave(Integer.parseInt(directors[0]));
            this.setDirector_nom(directors[1]);
        }
        if (col.equals("oficina")) this.setOficina_dir(row[1]);
        if (col.equals("tipodeoficina")) this.setOficina_tipo(row[1]);
        if (col.equals("estructura")) this.setEstructura(row[1]);
        if (col.equals("periodocierre")) this.setPeriodo_cierre(row[1]);
        if (col.equals("siniestralidad")) this.setSiniestralidad(row[1]);
        if (col.equals("tablaparasin")) this.setTabla_para_sin(row[1]);
        if (col.equals("tablahonorario")) this.setTabla_honorario(row[1]);
        if (col.equals("porchonorario")) this.setPorc_honorario(row[1]);
        if (col.equals("tipodecambio")) this.setTipo_cambio(Double.parseDouble(row[1]));
    }

    @Override
    public String toString() {
        return "Informacion{" +
                "\ndirector_clave=" + director_clave +
                ",\ndirector_nom='" + director_nom + '\'' +
                ",\noficina_dir='" + oficina_dir + '\'' +
                ",\noficina_tipo='" + oficina_tipo + '\'' +
                ",\nestructura='" + estructura + '\'' +
                ",\nperiodo_cierre='" + periodo_cierre + '\'' +
                ",\nsiniestralidad='" + siniestralidad + '\'' +
                ",\ntabla_para_sin='" + tabla_para_sin + '\'' +
                ",\ntabla_honorario='" + tabla_honorario + '\'' +
                ",\nporc_honorario='" + porc_honorario + '\'' +
                ",\ntipo_cambio='" + tipo_cambio + '\'' +
                '}';
    }
}
