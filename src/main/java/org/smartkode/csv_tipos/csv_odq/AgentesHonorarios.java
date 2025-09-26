package org.smartkode.csv_tipos.csv_odq;

public class AgentesHonorarios {
    private long calve_agente;
    private long id_agente;

    private String nombre_agente;
    private double prima_neta_m_n;
    private double prima_neta_dll;
    private String por_honorarios;
    private double total_honorarios;
    private double nuevos_agentes;
    private double subtotal;
    private double iva;
    private double total;

    public AgentesHonorarios(long calve_agente, long id_agente, String nombre_agente, double prima_neta_m_n, double prima_neta_dll,
                             String por_honorarios, double total_honorarios, double nuevos_agentes, double subtotal,
                             double iva, double total) {
        this.calve_agente = calve_agente;
        this.id_agente = id_agente;
        this.nombre_agente = nombre_agente;

        this.prima_neta_m_n = prima_neta_m_n;
        this.prima_neta_dll = prima_neta_dll;
        this.por_honorarios = por_honorarios;
        this.total_honorarios = total_honorarios;
        this.nuevos_agentes = nuevos_agentes;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public long getCalve_agente() {
        return calve_agente;
    }

    public void setCalve_agente(long calve_agente) {
        this.calve_agente = calve_agente;
    }

    public long getId_agente() {
        return id_agente;
    }

    public void setId_agente(long id_agente) {
        this.id_agente = id_agente;
    }

    public double getPrima_neta_m_n() {
        return prima_neta_m_n;
    }

    public void setPrima_neta_m_n(double prima_neta_m_n) {
        this.prima_neta_m_n = prima_neta_m_n;
    }

    public double getPrima_neta_dll() {
        return prima_neta_dll;
    }

    public void setPrima_neta_dll(double prima_neta_dll) {
        this.prima_neta_dll = prima_neta_dll;
    }

    public String getPor_honorarios() {
        return por_honorarios;
    }

    public void setPor_honorarios(String por_honorarios) {
        this.por_honorarios = por_honorarios;
    }

    public double getTotal_honorarios() {
        return total_honorarios;
    }

    public void setTotal_honorarios(double total_honorarios) {
        this.total_honorarios = total_honorarios;
    }

    public double getNuevos_agentes() {
        return nuevos_agentes;
    }

    public void setNuevos_agentes(double nuevos_agentes) {
        this.nuevos_agentes = nuevos_agentes;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return " \t\t\t\t\t\t\t\t\t\t\t\t" + calve_agente +
                "\t\t" + nombre_agente +
                "\t\t" + prima_neta_m_n +
                "\t\t" + prima_neta_dll +
                "\t\t" + por_honorarios +
                "\t\t" + total_honorarios +
                "\t\t" + nuevos_agentes +
                "\t\t" + subtotal +
                "\t\t" + iva +
                "\t\t" + total +
                "\n";
    }
}
