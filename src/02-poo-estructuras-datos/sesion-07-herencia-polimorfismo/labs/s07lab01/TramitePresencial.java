package s07lab01;

public class TramitePresencial extends Tramite {
    public TramitePresencial(String codigo) {
        super(codigo);
    }

    @Override
    public String descripcion() {
        return "Tramite presencial: " + getCodigo();
    }
}
