package org.smartkode.csv_tipos.csv_odq;

import org.smartkode.csv_comun.ReadFiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Info_ODQ {
    private long id_odq;
    private long id_tipo;

    private BigDecimal total_prima_neta_m_n;
    private BigDecimal total_prima_neta_dll;
    private BigDecimal total_total_honorarios;
    private BigDecimal total_nuevos_agentes;
    private BigDecimal total_subtotal;
    private BigDecimal total_iva;
    private BigDecimal total_total;
    private List<Oficinas> oficinas = new ArrayList<Oficinas>();
    ReadFiles rf = new ReadFiles();

    public long getId_odq() {
        return id_odq;
    }

    public void setId_odq(long id_odq) {
        this.id_odq = id_odq;
    }

    public long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public BigDecimal getTotal_prima_neta_m_n() {
        return total_prima_neta_m_n;
    }

    public void setTotal_prima_neta_m_n(BigDecimal total_prima_neta_m_n) {
        this.total_prima_neta_m_n = total_prima_neta_m_n;
    }

    public BigDecimal getTotal_prima_neta_dll() {
        return total_prima_neta_dll;
    }

    public void setTotal_prima_neta_dll(BigDecimal total_prima_neta_dll) {
        this.total_prima_neta_dll = total_prima_neta_dll;
    }

    public BigDecimal getTotal_total_honorarios() {
        return total_total_honorarios;
    }

    public void setTotal_total_honorarios(BigDecimal total_total_honorarios) {
        this.total_total_honorarios = total_total_honorarios;
    }

    public BigDecimal getTotal_nuevos_agentes() {
        return total_nuevos_agentes;
    }

    public void setTotal_nuevos_agentes(BigDecimal total_nuevos_agentes) {
        this.total_nuevos_agentes = total_nuevos_agentes;
    }

    public BigDecimal getTotal_subtotal() {
        return total_subtotal;
    }

    public void setTotal_subtotal(BigDecimal total_subtotal) {
        this.total_subtotal = total_subtotal;
    }

    public BigDecimal getTotal_iva() {
        return total_iva;
    }

    public void setTotal_iva(BigDecimal total_iva) {
        this.total_iva = total_iva;
    }

    public BigDecimal getTotal_total() {
        return total_total;
    }

    public void setTotal_total(BigDecimal total_total) {
        this.total_total = total_total;
    }

    public void setTablaOdq (long id_odq, long id_tipo, List<String[]> data) {
        setId_odq(id_odq);
        setId_tipo(id_tipo);
        boolean ver = false;
        long i=0, j=0;

        Oficinas of = new Oficinas();;
        Agentes agente = null;
        for(String[] row: data){
            String col = rf.normanalizeString(row, 0);
            if (col.equals("cveofi")) {
                ver = true;
                continue;
            }
            if (ver) {
                col = rf.normanalizeString(row, 4);

                if (col.equals("totaloficina")) {
                    oficinas.add(of);
                    of.setOficinaTotales(row);
                } else if (col.equals("totalodqs")) {
                    setTotalesOdq(row);
                } else if (rf.isEmptyString(row[3])) {
                    System.out.println("Nuevo Agente");
                    System.out.println("col: " + col);
                    agente = new Agentes(j++, col);
                } else if (!rf.isEmptyString(row[3])) {
                    System.out.println("Nuevo Agente Honorario");
                    System.out.println("Row[3]: " + row[3]);
                    of.setAgentesHonorarios(row, agente);
                } else of = new Oficinas();

            }
        }
    }

    public void setTotalesOdq (String[] row){
        BigDecimal bg;
        bg = new BigDecimal(row[5]);
        setTotal_prima_neta_m_n(bg);

        bg = new BigDecimal(row[6]);
        setTotal_prima_neta_dll(bg);

        bg = new BigDecimal(row[8]);
        setTotal_total_honorarios(bg);

        bg = new BigDecimal(row[9]);
        setTotal_nuevos_agentes(bg);

        bg = new BigDecimal(row[10]);
        setTotal_subtotal(bg);

        bg = new BigDecimal(row[11]);
        setTotal_iva(bg);

        bg = new BigDecimal(row[12]);
        setTotal_total(bg);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        System.out.println("CVE.OFI\tOFICINA\tSINIESTRALIDAD\tCLAVE\tAGENTE\tPRIMA NETA M.N.\tPRIMA NETA DLLS\t% HONORARIOS\tTOTAL HONORARIOS\t2% NUEVOS AGENTES\tSUBTOTAL\tIVA\tTOTAL");

        for (Oficinas oficinas : oficinas)
            sb.append(oficinas.toString()).append("\n");

        sb.append(id_odq + " ");
        sb.append(id_tipo + "");
        sb.append("\t\t\t\t\t\t\t\t\t\tTOTAL ODQ'S" + "\t\t\t\t");
        sb.append(total_prima_neta_m_n + "\t\t");
        sb.append(total_prima_neta_dll + "\t\t\t\t\t");
        sb.append(total_total_honorarios + "\t\t");
        sb.append(total_nuevos_agentes + "\t\t");
        sb.append(total_subtotal + "\t\t");
        sb.append(total_iva + "\t\t");
        sb.append(total_total + "\t\t");

        return sb.toString();
    }
}
