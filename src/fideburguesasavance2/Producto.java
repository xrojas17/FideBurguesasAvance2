package fideburguesasavance2;

import java.io.Serializable;

public class Producto implements Vendible, Serializable {

    private String nombre;
    private String categoria;
    private double precio;
    private boolean disponible;

    public Producto(String nombre, String categoria,
            double precio, boolean disponible) {

        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.disponible = disponible;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String mostrarDetalle() {
        return nombre + " - " + categoria + " - ₡" + precio;
    }

    @Override
    public String toString() {
        return mostrarDetalle();
    }
}