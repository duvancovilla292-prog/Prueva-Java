package s20lab03;

import java.util.List;

// Lab03: total de minutos -> mapToInt + sum
// Fuente: lista.stream() | Intermedia: mapToInt | Terminal: sum()
public class S20Lab03SoporteMain {
    public static void main(String[] args) {
        List<Integer> minutos1 = List.of(12, 8, 20);// el List.of() crea una lista inmutable con los elementos que se le pasan como argumentos
        List<Integer> minutos2 = List.of(8, 8);
        List<Integer> minutos3 = List.of();

        System.out.println("Caso 1: " + total(minutos1)); // 40
        System.out.println("Caso 2: " + total(minutos2)); // 16 
        System.out.println("Caso 3: " + total(minutos3)); // 0

       
    }

    // Suma todos los minutos
    public static int total(List<Integer> minutos) {
        return minutos.stream()//el .stream() crea un Stream<Integer> a partir de la lista
                .mapToInt(Integer::intValue) // convierte cada Integer en un int (un IntStream)
                .sum(); // el sum() suma todos los int del IntStream y devuelve el total                     
    }
}
