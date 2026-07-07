package fideburguesasavance2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DatosSistema {

    private static final String ARCHIVO_USUARIOS = "usuarios.dat";
    private static final String ARCHIVO_CAJEROS = "cajeros.dat";
    private static final String ARCHIVO_PRODUCTOS = "productos.dat";
    private static final String ARCHIVO_COMBOS = "combos.dat";
    private static final String ARCHIVO_PEDIDOS = "pedidos.dat";

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Cajero> cajeros = new ArrayList<>();
    public static ArrayList<Producto> productos = new ArrayList<>();
    public static ArrayList<Combo> combos = new ArrayList<>();
    public static ArrayList<Pedido> pedidos = new ArrayList<>();

    public static void cargarDatosIniciales() {

        usuarios = leerLista(ARCHIVO_USUARIOS);
        cajeros = leerLista(ARCHIVO_CAJEROS);
        productos = leerLista(ARCHIVO_PRODUCTOS);
        combos = leerLista(ARCHIVO_COMBOS);
        pedidos = leerLista(ARCHIVO_PEDIDOS);

        if (usuarios.isEmpty()) {

            Usuario admin = new Usuario(
                    "admin",
                    "1234",
                    "Administrador");

            usuarios.add(admin);
        }

        if (productos.isEmpty()) {

            productos.add(new Producto(
                    "Hamburguesa Clasica",
                    "Comida",
                    2500,
                    true));

            productos.add(new Producto(
                    "Papas Fritas",
                    "Acompanamiento",
                    1200,
                    true));

            productos.add(new Producto(
                    "Refresco",
                    "Bebida",
                    900,
                    true));
        }

        guardarDatos();
    }

    public static void guardarDatos() {

        guardarLista(usuarios, ARCHIVO_USUARIOS);
        guardarLista(cajeros, ARCHIVO_CAJEROS);
        guardarLista(productos, ARCHIVO_PRODUCTOS);
        guardarLista(combos, ARCHIVO_COMBOS);
        guardarLista(pedidos, ARCHIVO_PEDIDOS);
    }

    private static void guardarLista(Object lista, String archivo) {

        try {

            ObjectOutputStream salida =
                    new ObjectOutputStream(
                            new FileOutputStream(archivo));

            salida.writeObject(lista);

            salida.close();

        } catch (Exception e) {

            System.out.println("Error al guardar: " + archivo);
        }
    }

    private static <T> ArrayList<T> leerLista(String archivo) {

        try {

            ObjectInputStream entrada =
                    new ObjectInputStream(
                            new FileInputStream(archivo));

            ArrayList<T> lista =
                    (ArrayList<T>) entrada.readObject();

            entrada.close();

            return lista;

        } catch (Exception e) {

            return new ArrayList<>();
        }
    }

    public static Usuario validarUsuario(
            String nombreUsuario,
            String contrasena)
            throws UsuarioNoEncontradoException {

        for (Usuario usuario : usuarios) {

            if (usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario)
                    && usuario.getContrasena().equals(contrasena)) {

                return usuario;
            }
        }

        throw new UsuarioNoEncontradoException(
                "Usuario o contraseña incorrectos");
    }

    public static void agregarProducto(Producto producto) {

        productos.add(producto);
        guardarDatos();
    }

    public static void agregarPedido(Pedido pedido) {

        pedidos.add(pedido);
        guardarDatos();
    }

    public static void agregarCajero(Cajero cajero) {

        cajeros.add(cajero);
        guardarDatos();
    }
}