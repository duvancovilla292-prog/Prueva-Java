package s07lab03;

public abstract class PlanEntrenamiento {
    private final String nombre;

    public PlanEntrenamiento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract int duracionMinutos();
}
