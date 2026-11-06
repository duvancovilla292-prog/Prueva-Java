package s16lab02;

import java.util.concurrent.atomic.AtomicInteger;

public class S16Lab02MensajesMain {
    // Crea los agentes con el mismo contador, los ejecuta y devuelve el total cuando todos terminan
    public static int procesar(int agentes, int mensajesPorAgente) throws InterruptedException {
        if (agentes < 1 || agentes > 16) {
            throw new IllegalArgumentException("Agentes entre 1 y 16");
        }
        AtomicInteger contador = new AtomicInteger();
        Runnable[] tareas = new Runnable[agentes];
        for (int indice = 0; indice < agentes; indice++) {
            tareas[indice] = new AgenteMensajes(contador, mensajesPorAgente);
        }
        EjecutorPrueba.ejecutar(tareas);
        return contador.get();
    }

    // Compara esperado vs procesado y muestra el ejemplo secuencial de AtomicInteger
    public static void main(String[] args) throws InterruptedException {
//        int agentes = 4;
        int agentes = 6; // Paso 4: 6 x 250 = 1500
        int mensajesPorAgente = 250;
        int esperado = agentes * mensajesPorAgente;
        int observado = procesar(agentes, mensajesPorAgente);
        System.out.println("Esperado: " + esperado);
        System.out.println("Procesados: " + observado);
        System.out.println("Correcto: " + (esperado == observado));
        if (esperado != observado) {
            throw new IllegalStateException("Se perdieron mensajes");
        }
        AtomicInteger secuencial = new AtomicInteger(0);
        System.out.println("incrementAndGet retorna: " + secuencial.incrementAndGet());
//        System.out.println("getAndIncrement retorna: " + secuencial.getAndIncrement());
        // Paso 6: incrementAndGet suma y DEVUELVE el nuevo valor (2); getAndIncrement devolvia el viejo (1)
        System.out.println("incrementAndGet (2da) retorna: " + secuencial.incrementAndGet());
        System.out.println("Valor final del ejemplo secuencial: " + secuencial.get());
    }
}
