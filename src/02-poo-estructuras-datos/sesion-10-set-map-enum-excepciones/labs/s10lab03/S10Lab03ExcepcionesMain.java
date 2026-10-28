package s10lab03;

/**
 * Escenario del Lab 03: mezcla datos válidos, no convertibles, fuera de rango y vacíos.
 */
public class S10Lab03ExcepcionesMain {
    public static void main(String[] args) {
        RegistroTemperaturas registro = new RegistroTemperaturas();
        // Válidos: 20, 25, -10. Rechazados: abc (formato), 80 (rango), "" (obligatorio).
        String[] entradas = {"20", "abc", " 25 ", "80", "", "-10"};
        for (String entrada : entradas) {
            registro.registrar(entrada);
        }
        System.out.println("Lecturas: " + registro.lecturasComoTexto());
        System.out.println("Aceptadas: " + registro.aceptadas());
        System.out.println("Rechazadas: " + registro.rechazadas());
        System.out.println("Promedio: " + registro.promedioComoTexto());
    }
}
