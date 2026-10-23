package s07lab02;

public class S07Lab02PolimorfismoMain {
    public static void mostrarDuracion(ServicioTecnico servicio) {
        System.out.println("Duracion: " + servicio.duracionMinutos() + " min");
    }

    public static void main(String[] args) {
        ServicioTecnico revision = new RevisionEquipo();
        ServicioTecnico instalacion = new InstalacionPrograma();
        mostrarDuracion(revision);
        mostrarDuracion(instalacion);
    }
}
