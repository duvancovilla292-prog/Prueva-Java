package s19lab05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Lab05: ordenar nombres. List.sort recibe un Comparator<String>
// Se ejecuta con compare(primero, segundo) (sort lo llama por dentro)
public class S19Lab05ParticipantesMain {
    public static void main(String[] args) {
        // Regla de orden: alfabético ascendente comparando el contenido con compareTo
        Comparator<String> alfabetico = (primero, segundo) -> primero.compareTo(segundo);

        // Listas modificables (ArrayList), porque List.of no se puede ordenar
        List<String> lista1 = new ArrayList<>(List.of("Sofia", "Luis", "Ana"));
        List<String> lista2 = new ArrayList<>(List.of("Luis", "Ana", "Ana"));
        List<String> lista3 = new ArrayList<>();

        // Se ordena cada lista con la misma regla
        lista1.sort(alfabetico);
        lista2.sort(alfabetico);
        lista3.sort(alfabetico); // lista vacía: no da error

        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);
        System.out.println("Lista 3: " + lista3);

        // compare devuelve: negativo = primero va antes, cero = empatan, positivo = primero va después
        System.out.println("Comparar Ana con Luis: " + alfabetico.compare("Ana", "Luis"));
        System.out.println("Comparar Ana con Ana: " + alfabetico.compare("Ana", "Ana"));
        System.out.println("Comparar Sofia con Ana: " + alfabetico.compare("Sofia", "Ana"));

        // Los dos "Ana" se conservan: cero significa empate en el orden,
        // no que se borre uno. sort solo reordena, no elimina elementos.
    }
}
