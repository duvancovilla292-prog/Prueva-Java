public class S06Pedido {
    /*// TODO 1: Declarar estado como campo privado String.

    public S06Pedido() {
        // TODO 2: Inicializar el estado en PENDIENTE.
    }

    public String getEstado() {
        // TODO 3: Devolver el estado actual.
        return ""; // Retorno provisional: reemplazar.
    }

    public boolean enviar() {
        // TODO 4: Enviar solo un pedido PENDIENTE; cambiar a ENVIADO y devolver si acepta.
        return false; // Retorno provisional: reemplazar.
    }

    public boolean cancelar() {
        // TODO 5: Cancelar solo un pedido PENDIENTE; cambiar a CANCELADO y devolver si acepta.
        return false; // Retorno provisional: reemplazar.
    }*/
    private String estado;

    public S06Pedido() {
        estado = "PENDIENTE";
    }

    public String getEstado() {
        return estado;
    }

    public boolean enviar() {
        if (!estado.equals("PENDIENTE")) {
            return false;
        }
        estado = "ENVIADO";
        return true;
    }

    public boolean cancelar() {
        if (!estado.equals("PENDIENTE")) {
            return false;
        }
        estado = "CANCELADO";
        return true;
    }
}
