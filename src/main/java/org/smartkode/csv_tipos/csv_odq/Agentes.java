package org.smartkode.csv_tipos.csv_odq;

import org.smartkode.csv_comun.ReadFiles;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class Agentes {
    private long id_agente;
    private long cve_ofi;
    private String grupo_agente;

    private BigDecimal agente_prima_neta_m_n;
    private BigDecimal agente_prima_neta_dll;
    private String agente_por_honorarios;
    private BigDecimal agente_total_honorarios;
    private BigDecimal agente_nuevos_agentes;
    private BigDecimal agente_subtotal;
    private BigDecimal agente_iva;
    private BigDecimal agente_total;
    private List<AgentesHonorarios> listaAgentesHonor = new ArrayList<AgentesHonorarios>();
    ReadFiles rf = new ReadFiles();

    public Agentes(long id_agente, String grupo_agente) {
        this.id_agente = id_agente;
        this.grupo_agente = grupo_agente;
    }

    public long getId_agente() {
        return id_agente;
    }

    public void setCve_ofi(long cve_ofi) {
        this.cve_ofi = cve_ofi;
    }

    public long getCve_ofi() {
        return cve_ofi;
    }

    public void setGrupo_agente(String grupo_agente) {
        this.grupo_agente = grupo_agente;
    }

    public void setAgente_prima_neta_m_n(BigDecimal agente_prima_neta_m_n) {
        this.agente_prima_neta_m_n = agente_prima_neta_m_n;
    }

    public void setAgente_prima_neta_dll(BigDecimal agente_prima_neta_dll) {
        this.agente_prima_neta_dll = agente_prima_neta_dll;
    }

    public void setAgente_por_honorarios(String agente_por_honorarios) {
        this.agente_por_honorarios = agente_por_honorarios;
    }

    public void setAgente_total_honorarios(BigDecimal agente_total_honorarios) {
        this.agente_total_honorarios = agente_total_honorarios;
    }

    public void setAgente_nuevos_agentes(BigDecimal agente_nuevos_agentes) {
        this.agente_nuevos_agentes = agente_nuevos_agentes;
    }

    public void setAgente_subtotal(BigDecimal agente_subtotal) {
        this.agente_subtotal = agente_subtotal;
    }

    public void setAgente_iva(BigDecimal agente_iva) {
        this.agente_iva = agente_iva;
    }

    public void setAgente_total(BigDecimal agente_total) {
        this.agente_total = agente_total;
    }

    public void addAgenteHonorario (String[] row){
        long clave = Long.parseLong(row[3]);
        String nombre_agente = row[4];
        double prima_neta_m_n = (!rf.isEmptyString(row[5])) ? Double.parseDouble(row[5]) : 0;
        double prima_neta_dll = (!rf.isEmptyString(row[6])) ? Double.parseDouble(row[6]) : 0;
        String por_honorarios = row[7];
        double total_honorarios = (!rf.isEmptyString(row[8])) ? Double.parseDouble(row[8]) : 0;
        double nuevos_agentes = (!rf.isEmptyString(row[9])) ? Double.parseDouble(row[9]) : 0;
        double subtotal = (!rf.isEmptyString(row[10])) ? Double.parseDouble(row[10]) : 0;
        double iva = (!rf.isEmptyString(row[11])) ? Double.parseDouble(row[11]) : 0;
        double total = (!rf.isEmptyString(row[12])) ? Double.parseDouble(row[12]) : 0;

        listaAgentesHonor.add(new AgentesHonorarios(clave, getId_agente(), nombre_agente, prima_neta_m_n,
                prima_neta_dll, por_honorarios, total_honorarios, nuevos_agentes, subtotal, iva, total));
    }

    public void agenteTotales (String[] row){
        BigDecimal bg;
        bg = new BigDecimal(row[5]);
        setAgente_prima_neta_m_n(bg);

        bg = new BigDecimal(row[6]);
        setAgente_prima_neta_dll(bg);

        setAgente_por_honorarios(row[7]);

        bg = new BigDecimal(row[8]);
        setAgente_total_honorarios(bg);

        bg = new BigDecimal(row[9]);
        setAgente_nuevos_agentes(bg);

        bg = new BigDecimal(row[10]);
        setAgente_subtotal(bg);
        bg = new BigDecimal(row[11]);
        setAgente_iva(bg);
        bg = new BigDecimal(row[12]);
        setAgente_total(bg);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + grupo_agente + "\n");
        for (AgentesHonorarios agente : listaAgentesHonor)
            sb.append(agente.toString());

        sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTotal " + grupo_agente + "\t\t\t");
        sb.append(agente_prima_neta_m_n + "\t\t");
        sb.append(agente_prima_neta_dll + "\t\t");
        sb.append(agente_por_honorarios + "\t\t");
        sb.append(agente_total_honorarios + "\t\t");
        sb.append(agente_nuevos_agentes + "\t\t");
        sb.append(agente_subtotal + "\t\t");
        sb.append(agente_iva + "\t\t");
        sb.append(agente_total + "\n\n");

        return sb.toString();
    }
}
