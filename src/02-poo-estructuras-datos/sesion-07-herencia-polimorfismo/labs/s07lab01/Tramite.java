package s07lab01;

public class Tramite {
    private final String codigo;

    public Tramite(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String descripcion() {
        return "Tramite: " + codigo;
    }

    public String verificar(Validador validador) {
        return validador.revisar();
    }
}
