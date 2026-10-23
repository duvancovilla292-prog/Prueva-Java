package s07lab03;

public class PlanCardio extends PlanEntrenamiento {
    public PlanCardio() {
        super("Cardio");
    }

    @Override
    public int duracionMinutos() {
        return 2 * 15;
    }
}
