package s18lab01;

// MAIN: solo crea los componentes, los conecta entre sí y arranca el controlador.
public class Main {
    public static void main(String[] args) {
        // new X() crea un objeto de la clase X.
        ConexionFactory fabrica = new ConexionFactory();
        ProductoDAO dao = new ProductoDAO(fabrica);
        VistaInventario vista = new VistaInventario();
        ProductoController controlador = new ProductoController(vista, dao);
        controlador.ejecutar();
    }
}
