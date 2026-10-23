package s07lab04;

public class ResumenTexto implements Exportable {
    @Override
    public String exportar(String titulo, int cantidad) {
        return titulo + ": " + cantidad;
    }
}
