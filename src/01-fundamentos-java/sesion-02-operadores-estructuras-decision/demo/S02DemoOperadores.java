public class S02DemoOperadores {
    public static void main(String[] args) {
        int unidades = 7;
        int capacidad = 2;
        System.out.println("Suma: " + (unidades + capacidad));
        System.out.println("Resta: " + (unidades - capacidad));
        System.out.println("Producto: " + (unidades * capacidad));
        System.out.println("Division entera: " + (unidades / capacidad));
        System.out.println("Division decimal: " + (7.0 / capacidad));
        System.out.println("Resto: " + (unidades % capacidad));
        System.out.println("Sin parentesis: " + (2 + 3 * 4));
        System.out.println("Con parentesis: " + ((2 + 3) * 4));

        int contador = 3;
        contador++;
        System.out.println("Despues de incrementar: " + contador);
        contador--;
        System.out.println("Despues de decrementar: " + contador);

        // Contrasta el valor producido por la expresión con el estado posterior.
        int valorConSufijo = contador++;
        System.out.println("Valor con sufijo: " + valorConSufijo);
        System.out.println("Contador tras sufijo: " + contador);
        int valorConPrefijo = ++contador;
        System.out.println("Valor con prefijo: " + valorConPrefijo);
        System.out.println("Contador tras prefijo: " + contador);
    }
}
