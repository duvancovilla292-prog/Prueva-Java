package s10lab00;

public class soluti {
    public static void main(String[] args) {
        MaterialesTaller taller = new MaterialesTaller();

        taller.requerir("CARTULINA");
        taller.requerir("PEGAMENTO");
        taller.requerir("TIJERAS");
        taller.disponer("cartulina");
        taller.disponer("REGLA");

        System.out.println("Faltantes: " + taller.faltantes());

        // Cubriendo los pasos del laboratorio
        taller.disponer("PEGAMENTO");
        System.out.println("Faltantes despues: " + taller.faltantes());

        taller.disponer("TIJERAS");
        System.out.println("Faltantes despues de completar: " + taller.faltantes()); // Debe ser []

        System.out.println("Disponer null: " + taller.disponer(null));
        System.out.println("Disponer blancos: " + taller.disponer("   "));
        System.out.println("Repetir cartulina: " + taller.disponer(" cartulina "));

        // Totales finales
        System.out.println("Requeridos: " + taller.cantidadRequeridos());
        System.out.println("Disponibles: " + taller.cantidadDisponibles());
    }
}