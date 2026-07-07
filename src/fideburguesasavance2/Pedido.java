package fideburguesasavance2;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {

    private int numeroPedido;
    private ArrayList<Vendible> items;
    private String estado;

    public Pedido() {
        this.numeroPedido = (int) (System.currentTimeMillis() % 100000);
        this.items = new ArrayList<>();
        this.estado = "Pendiente";
    }

    public void agregarItem(Vendible item) {
        items.add(item);
    }

    public double calcularTotal() {
        double total = 0;

        for (Vendible item : items) {
            total += item.getPrecio();
        }

        return total;
    }

    public String mostrarDetalle() {
        String detalle = "Pedido #" + numeroPedido + "\n";
        detalle += "Estado: " + estado + "\n\n";

        for (Vendible item : items) {
            detalle += item.mostrarDetalle() + "\n";
        }

        detalle += "\nTotal: ₡" + calcularTotal();

        return detalle;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public ArrayList<Vendible> getItems() {
        return items;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}