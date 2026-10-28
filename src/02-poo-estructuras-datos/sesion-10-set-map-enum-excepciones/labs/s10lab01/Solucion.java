package s10lab01;

public class Solucion {
    public static void main(String[] args) {
        RecuentoVotos recuento = new RecuentoVotos();

        System.out.println("Reporte inicial vacio: " + recuento.reporte());
        System.out.println("Total inicial: " + recuento.total());

        System.out.println("Votar ' a ': " + recuento.votar(" a "));
        System.out.println("Votar null: " + recuento.votar(null));
        System.out.println("Votar X: " + recuento.votar("X"));

        System.out.println("Recuento final: " + recuento.reporte());
        System.out.println("Total conservado: " + recuento.total());
    }
}