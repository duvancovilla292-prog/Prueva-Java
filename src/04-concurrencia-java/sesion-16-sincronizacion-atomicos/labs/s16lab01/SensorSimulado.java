package s16lab01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class SensorSimulado implements Runnable {
    private static final int MAX_LOTES = 1_000_000;
    // volatile: el cambio que hace main se ve de inmediato en el hilo del sensor
    private volatile boolean activo = true;
    private final int tamanoLote;
    private final CountDownLatch primerLote = new CountDownLatch(1);
    private int lotes;
    private long muestras;
    private long comprobacion;
    private String resultado = "NO_INICIADO";

    // Constructor: valida y guarda el tamano de cada lote
    public SensorSimulado(int tamanoLote) {
        if (tamanoLote < 16 || tamanoLote > 4096) {
            throw new IllegalArgumentException("Tamano de lote entre 16 y 4096");
        }
        this.tamanoLote = tamanoLote;
    }

    // main espera (max 5 s) a que el sensor termine su primer lote
    public void esperarPrimerLote() throws InterruptedException {
        if (!primerLote.await(5, TimeUnit.SECONDS)) {
            throw new IllegalStateException("El trabajador no inicio");
        }
    }

    // Pide parar: baja la bandera, el sensor la revisa al inicio de cada lote
    public void solicitarDetencion() {
        activo = false;
    }

    // Trabajo del hilo: procesa lotes hasta ver la bandera en false, una interrupcion o el limite
    @Override
    public void run() {
        while (lotes < MAX_LOTES) {
            if (!activo) {
                resultado = "DETENIDO_POR_BANDERA";
                return;
            }
            if (Thread.currentThread().isInterrupted()) {
                resultado = "INTERRUMPIDO_EN_LIMPIEZA";
                return;
            }
            // Trabajo calculado: no es un bucle vacio esperando una bandera.
            for (int indice = 0; indice < tamanoLote; indice++) {
                comprobacion += (indice % 10);
            }
            muestras += tamanoLote;
            lotes++;
            if (lotes == 1) {
                primerLote.countDown();
            }
        }
        resultado = "LIMITE_DE_SEGURIDAD";
    }

    // El controlador consulta estos datos solamente despues de join.
    // Devuelve por que se detuvo el sensor
    public String consultarResultado() {
        return resultado;
    }

    // Cuantos lotes completo
    public int consultarLotes() {
        return lotes;
    }

    // Cuantas muestras genero en total
    public long consultarMuestras() {
        return muestras;
    }

    // Verifica que muestras = lotes x tamano y que la suma de control cuadre
    public boolean resumenCoherente() {
        long sumaPorLote = 0;
        for (int indice = 0; indice < tamanoLote; indice++) {
            sumaPorLote += indice % 10;
        }
        return muestras == (long) lotes * tamanoLote
                && comprobacion == sumaPorLote * lotes;
    }
}
