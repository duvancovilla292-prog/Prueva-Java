public class Lab03DatosConSentido {
    public static void main(String[] args) {
        // TODO 1: Elegir y justificar los tipos de datos:
        // - nombre: String (almacena cadenas de texto o cadenas de caracteres).
        // - edad: int (almacena nmeros enteros).
        // - temperatura: double (almacena numeros con decimalesdando precision).
        // - inicial: char (almacena un caracter '').
        // - activo: boolean (almacena exclusivamente  true o false).

        // TODO 2: Declarar e inicializar las cinco variables con nombres claros.
        String nombre = "Ciel Covilla";
        int edad = 18;
        double temperatura = 28.5;
        char inicial = 'C';
        boolean activo = true;

        // TODO 3: Mostrar cada dato en su propia línea, con una etiqueta.
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Temperatura: " + temperatura + "°C");
        System.out.println("Inicial: " + inicial);
        System.out.println("Activo: " + activo);

        // TODO 4: Probar el caso A del README

        // TODO 5: Explicar por qué String no es un tipo primitivo.
        /*
           Los tipos primitivos en Java (int, double, char, boolean, etc.) son bloques de construcción
           básicos que almacenan su valor bruto directamente en memoria.
           Por el contrario, "String" es una clase (un tipo de referencia u objeto).
           Una variable de tipo String no guarda el texto literal en sí, sino una referencia
           (dirección de memoria) que apunta al objeto real ubicado en el "heap".
           Además, al ser una clase, provee métodos avanzados para manipular el texto (como .length(),
           .toUpperCase(), etc.), cosa que los primitivos no poseen.
        */
    }
}