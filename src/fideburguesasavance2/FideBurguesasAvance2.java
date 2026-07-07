package fideburguesasavance2;

import javax.swing.JOptionPane;

public class FideBurguesasAvance2 {

    public static void main(String[] args) {

        DatosSistema.cargarDatosIniciales();

        VentanaInicioSesion ventana =
                new VentanaInicioSesion();

        ventana.setVisible(true);
    }
}