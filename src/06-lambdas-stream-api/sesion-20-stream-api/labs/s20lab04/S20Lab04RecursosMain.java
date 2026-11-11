package s20lab04;

import java.util.List;

// Lab04: catálogo único y ordenado desde una lista de listas -> flatMap + distinct + sorted
// Fuente: lista.stream() | Intermedias: flatMap, distinct, sorted | Terminal: toList()
public class S20Lab04RecursosMain {
    public static void main(String[] args) {
        // Lista de listas: cada lista interna son los recursos de un curso
        List<List<String>> cursos = List.of(
                List.of("Java", "SQL"),  // Programación
                List.of("SQL", "Git"),   // Bases de datos
                List.of());              // Curso nuevo

        List<List<String>> todosVacios = List.of(List.of(), List.of());
        List<List<String>> sinCursos = List.of();

        System.out.println("Catálogo: " + catalogo(cursos));              // [Git, Java, SQL]
        System.out.println("Todos vacíos: " + catalogo(todosVacios));     // []
        System.out.println("Sin cursos: " + catalogo(sinCursos));         // []

        System.out.println("Original: " + cursos);

        // Pasos: de cada curso saco su lista, la convierto en stream y flatMap
        // junta todo en un solo stream de textos. Así el catálogo tiene Strings
        // sueltos y distinct puede comparar texto con texto (SQL queda una vez).
        // Con map quedaría List<List<String>> y no se podrían quitar repetidos internos.
    }

    // Aplana, quita repetidos y ordena
    public static List<String> catalogo(List<List<String>> cursos) {
        return cursos.stream()
                .flatMap(recursos -> recursos.stream()) // lista de listas -> un solo stream de String
                .distinct()                              // SQL aparece una vez
                .sorted()                                // orden alfabético
                .toList();
    }
}
