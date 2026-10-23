package s07lab04;

public class ResumenCsv implements Exportable {
    @Override
    public String exportar(String titulo, int cantidad) {
        return titulo + "," + cantidad;
    }
}
