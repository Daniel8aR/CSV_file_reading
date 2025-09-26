package org.smartkode.csv_tipos.csv_odq;

import org.smartkode.csv_comun.ReadFiles;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class Oficinas {
    private long cve_ofi;
    private long id_odq;
    private String nombre_oficina;
    private String siniestralidad;

    private BigDecimal oficina_prima_neta_m_n;
    private BigDecimal oficina_prima_neta_dll;
    private BigDecimal oficina_total_honorarios;
    private BigDecimal oficina_nuevos_agentes;
    private BigDecimal oficina_subtotal;
    private BigDecimal oficina_iva;
    private BigDecimal oficina_total;
    private List<Agentes> agentesList = new ArrayList<Agentes>();
    ReadFiles rf = new ReadFiles();

    public void setCve_ofi(long cve_ofi) {
        this.cve_ofi = cve_ofi;
    }

    public long getCve_ofi() {
        return cve_ofi;
    }

    public void setId_odq(long id_odq) {
        this.id_odq = id_odq;
    }

    public void setNombre_oficina(String nombre_oficina) {
        this.nombre_oficina = nombre_oficina;
    }

    public void setSiniestralidad(String siniestralidad) {
        this.siniestralidad = siniestralidad;
    }

    public void setOficina_prima_neta_m_n(BigDecimal oficina_prima_neta_m_n) {
        this.oficina_prima_neta_m_n = oficina_prima_neta_m_n;
    }

    public void setOficina_prima_neta_dll(BigDecimal oficina_prima_neta_dll) {
        this.oficina_prima_neta_dll = oficina_prima_neta_dll;
    }

    public void setOficina_total_honorarios(BigDecimal oficina_total_honorarios) {
        this.oficina_total_honorarios = oficina_total_honorarios;
    }

    public void setOficina_nuevos_agentes(BigDecimal oficina_nuevos_agentes) {
        this.oficina_nuevos_agentes = oficina_nuevos_agentes;
    }

    public void setOficina_subtotal(BigDecimal oficina_subtotal) {
        this.oficina_subtotal = oficina_subtotal;
    }

    public void setOficina_iva(BigDecimal oficina_iva) {
        this.oficina_iva = oficina_iva;
    }

    public void setOficina_total(BigDecimal oficina_total) {
        this.oficina_total = oficina_total;
    }

    public void setAgentes(String [] row, Agentes agente) {
        agentesList.add(agente);
    }

    public void setAgentesHonorarios(String [] row, Agentes agente) {
        String[] check = row[4].split(" ");
        if (check[0].equals("TOTAL")) {
            agente.agenteTotales(row);
        } else {
            agente.addAgenteHonorario(row);
        }
    }

    public void setOficinaTotales (String[] row){
        BigDecimal bg;
        setCve_ofi(Long.parseLong(row[0]));

        for (Agentes agentes : agentesList) {
            if (agentes.getCve_ofi() == 0)
                agentes.setCve_ofi(getCve_ofi());
        }

        setNombre_oficina(row[1]);

        setSiniestralidad(row[2]);

        bg = new BigDecimal(row[5]);
        setOficina_prima_neta_m_n(bg);

        bg = new BigDecimal(row[6]);
        setOficina_prima_neta_dll(bg);

        bg = new BigDecimal(row[8]);
        setOficina_total_honorarios(bg);

        bg = new BigDecimal(row[9]);
        setOficina_nuevos_agentes(bg);

        bg = new BigDecimal(row[10]);
        setOficina_subtotal(bg);
        bg = new BigDecimal(row[11]);
        setOficina_iva(bg);
        bg = new BigDecimal(row[12]);
        setOficina_total(bg);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Agentes agentes : agentesList)
            sb.append(agentes.toString());

        sb.append(cve_ofi + "\t");
        sb.append(nombre_oficina + "\t");
        sb.append(siniestralidad + "\t\tTotal Oficina\t\t\t");
        sb.append(oficina_prima_neta_m_n + "\t\t");
        sb.append(oficina_prima_neta_dll + "\t\t\t\t\t");
        sb.append(oficina_total_honorarios + "\t\t");
        sb.append(oficina_nuevos_agentes + "\t\t");
        sb.append(oficina_subtotal + "\t\t");
        sb.append(oficina_iva + "\t\t");
        sb.append(oficina_total + "\n");

        return sb.toString();
    }
}
