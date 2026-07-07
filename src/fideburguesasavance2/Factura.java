package fideburguesasavance2;

import java.io.Serializable;

public class Factura implements Serializable {

    private int numeroFactura;
    private Pedido pedido;
    private double subtotal;
    private double impuesto;
    private double total;

    public Factura(Pedido pedido) {
        this.numeroFactura = (int) (System.currentTimeMillis() % 100000);
        this.pedido = pedido;
        calcularFactura();
    }

    private void calcularFactura() {
        subtotal = pedido.calcularTotal();
        impuesto = subtotal * 0.13;
        total = subtotal + impuesto;
    }

    public String generarTextoFactura() {

        String texto = "Factura #" + numeroFactura + "\n";
        texto += "Pedido #" + pedido.getNumeroPedido() + "\n";
        texto += "--------------------------\n";

        for (Vendible item : pedido.getItems()) {
            texto += item.mostrarDetalle() + "\n";
        }

        texto += "--------------------------\n";
        texto += "Subtotal: ₡" + subtotal + "\n";
        texto += "IVA 13%: ₡" + impuesto + "\n";
        texto += "Total: ₡" + total + "\n";

        return texto;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getTotal() {
        return total;
    }
}