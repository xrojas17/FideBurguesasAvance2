package fideburguesasavance2;

import java.io.Serializable;

public interface Vendible extends Serializable {

    public String getNombre();

    public double getPrecio();

    public String mostrarDetalle();
}