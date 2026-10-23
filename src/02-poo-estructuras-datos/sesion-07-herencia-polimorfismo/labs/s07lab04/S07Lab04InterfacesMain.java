package s07lab04;

public class S07Lab04InterfacesMain {
    public static void mostrarExportacion(Exportable formato) {
        System.out.println(formato.exportar("Asistencia", 12));
    }

    public static void main(String[] args) {
        mostrarExportacion(new ResumenTexto());
        mostrarExportacion(new ResumenCsv());
    }
}
