package s07lab03;

public class PlanFuerza extends PlanEntrenamiento {
    public PlanFuerza() {
        super("Fuerza");
    }

    @Override
    public int duracionMinutos() {
        return 3 * 8;
    }
}
