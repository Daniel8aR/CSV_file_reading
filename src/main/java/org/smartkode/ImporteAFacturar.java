package org.smartkode;

public class ImporteAFacturar {
    private double subtotal;
    private double iva;
    private double total;

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
        return "ImporteAFacturar{" +
                "subtotal=" + subtotal +
                ", iva=" + iva +
                ", total=" + total +
                '}';
    }
}
