package s07lab00;

public class Lavadora extends Electrodomestico {
    private int capacidadKg;

    public Lavadora(String marca, int capacidadKg) {
        super(marca);
        this.capacidadKg = capacidadKg;
    }

    public String ficha() {
        return "Lavadora " + describirMarca() + " - capacidad: " + capacidadKg + " kg";
    }
}
