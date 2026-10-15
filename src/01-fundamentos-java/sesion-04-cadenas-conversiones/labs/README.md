# Laboratorios de la sesión 4

Prioriza los labs 1–3 en los **40 minutos máximos de práctica**. Completa lo pendiente y los labs 4–5 en casa para la siguiente clase.

## Antes de escribir código

- Usa tu proyecto personal con IntelliJ y JDK 21 o 17; conserva la clase y main. Escribe debajo del TODO correspondiente.
- Texto entre comillas, variables fuera de ellas: `System.out.println("Cantidad: " + cantidad);`. No pegues las salidas esperadas como código.
- Usa Run de la clase actual. Cambia solo los valores iniciales para cada prueba y guarda las comprobaciones y respuestas breves en tu README personal. No necesitas Scanner.

## Lab 1 · Limpia y compara · Clase: 10 minutos

**Archivo:** [S04Lab01LimpiaYCompara.java](S04Lab01LimpiaYCompara.java).

**Datos iniciales de la clase:**

```java
String nombreEntrada = "  Ana  ";
        String opcionEntrada = " si ";
```

### Pasos para completar la actividad

1. Abre `S04Lab01LimpiaYCompara.java` en tu proyecto personal.
2. **TODO 1: Guardar nombreEntrada.strip() en nombreLimpio conservando el original.** Declara String nombreLimpio y asígnale el resultado de strip. No basta con llamar strip sin guardar lo que devuelve.
3. **TODO 2: Mostrar Original, Limpio y Longitud limpia.** Agrega tres println: Original y Limpio entre corchetes, y Longitud limpia con nombreLimpio.length(). Respeta el orden del bloque esperado.
4. **TODO 3: Limpiar opcionEntrada y comparar con SI usando equalsIgnoreCase.** Guarda opcionEntrada.strip() en otra variable y construye un boolean confirmado con equalsIgnoreCase("SI").
5. **TODO 4: Mostrar Confirmado con el resultado booleano.** Agrega un println con `Confirmado: ` y confirmado. No uses == para comparar contenido.
6. **TODO 5: Probar los datos iniciales y explicar por qué el original no cambia.** Ejecuta la clase y guarda las cuatro líneas. Explica la inmutabilidad en una frase; probar opcionEntrada="NO" es opcional.

**Salida inicial esperada:**

```text
Original: [  Ana  ]
Limpio: [Ana]
Longitud limpia: 3
Confirmado: true
```

## Lab 2 · Extrae un identificador · Clase: 12 minutos

**Archivo:** [S04Lab02ExtraeIdentificador.java](S04Lab02ExtraeIdentificador.java).

**Datos iniciales de la clase:**

```java
String codigo = "USR-1048-CO";
```

### Pasos para completar la actividad

1. Abre `S04Lab02ExtraeIdentificador.java` en tu proyecto personal.
2. **TODO 1: Validar longitud 11 antes de acceder a posiciones.** Usa if/else para aceptar solo codigo.length()==11. Si falla, imprime `Codigo invalido` sin hacer charAt o substring.
3. **TODO 2: Comprobar prefijo USR- y separador en indice 8.** Dentro de la rama con longitud válida, comprueba substring(0,4) con equals("USR-") y charAt(8) con el carácter '-'. Si falla, imprime solo el error.
4. **TODO 3: Extraer tipo, numeroTexto, pais e inicial.** En formato aceptado usa substring(0,3), substring(4,8), substring(9,11) y charAt(0). Conserva numeroTexto como String.
5. **TODO 4: Mostrar los cuatro datos o solo Codigo invalido.** Agrega un println por dato: Tipo, Numero, Pais e Inicial, cada etiqueta con `: `. No imprimas esos datos para un código inválido.
6. **TODO 5: Probar el codigo inicial y USR; explicar el final exclusivo de substring.** Ejecuta con USR-1048-CO y luego con USR. La segunda prueba muestra solo `Codigo invalido`. Explica en una frase por qué substring(4,8) no incluye el índice 8.

**Salida inicial esperada:**

```text
Tipo: USR
Numero: 1048
Pais: CO
Inicial: U
```

Esta comprobación valida longitud y separadores, no que el campo numérico contenga únicamente dígitos.

## Lab 3 · Convierte texto en datos · Clase: 15 minutos

**Archivo:** [S04Lab03ConvierteDatos.java](S04Lab03ConvierteDatos.java).

**Datos iniciales de la clase:**

```java
String edadTexto = " 20 ";
        String estaturaTexto = "1.72";
        String estudianteTexto = "true";
```

### Pasos para completar la actividad

1. Abre `S04Lab03ConvierteDatos.java` en tu proyecto personal.
2. **TODO 1: Limpiar edadTexto antes de convertirlo.** Guarda edadTexto.strip() para quitar los espacios externos.
3. **TODO 2: Convertir edad a int y estatura a double.** Usa Integer.parseInt para edad y Double.parseDouble para estatura. No intentes convertir un String mediante cast.
4. **TODO 3: Convertir estudianteTexto a boolean.** Usa Boolean.parseBoolean. Las entradas de este lab son "true" o "false"; otros textos producen false, no un error de validación.
5. **TODO 4: Mostrar Edad, Edad siguiente, Estatura (m) y Estudiante.** Escribe cuatro println con las etiquetas del bloque. Para Edad siguiente calcula `(edad + 1)` antes de concatenar; no sumes 1 al texto.
6. **TODO 5: Probar el caso inicial y distinguir conversion de concatenacion.** Ejecuta una vez y guarda la salida. Explica en una frase por qué edad+1 calcula un número. El caso edadTexto=" 17 ", estaturaTexto="1.65", estudianteTexto="false" es opcional.

**Salida inicial esperada:**

```text
Edad: 20
Edad siguiente: 21
Estatura (m): 1.72
Estudiante: true
```

## Lab 4 · Casting y wrappers · Casa

**Archivo:** [S04Lab04CastingYWrappers.java](S04Lab04CastingYWrappers.java).

**Datos iniciales de la clase:**

```java
int cantidad = 10;
        double medicion = 7.9;
        String cantidadTexto = "42";
```

### Pasos para completar la actividad

1. Abre `S04Lab04CastingYWrappers.java` en tu proyecto personal.
2. **TODO 1: Ampliar cantidad a double sin cast y mostrarla.** Declara double cantidadAmpliada y asígnale cantidad. Imprime `Cantidad ampliada: ` con la variable.
3. **TODO 2: Truncar medicion a int y mostrarla.** Declara int medicionTruncada y aplica `(int) medicion`. Imprime `Medicion truncada: `.
4. **TODO 3: Truncar -7.9 a int y mostrarlo.** Declara int negativaTruncada con `(int) -7.9` e imprime `Negativa truncada: `. El cast trunca hacia cero, no redondea.
5. **TODO 4: Obtener un int con parseInt y un Integer con valueOf.** Convierte cantidadTexto a int cantidadPrimitiva con Integer.parseInt y a Integer cantidadObjeto con Integer.valueOf.
6. **TODO 5: Realizar unboxing y mostrar los tres valores.** Asigna cantidadObjeto a un int recuperada. Imprime Primitivo, Wrapper y Unboxing, cada etiqueta con `: `.
7. **TODO 6: Convertir el primitivo a String con String.valueOf y mostrarlo entre corchetes.** Guarda String.valueOf(cantidadPrimitiva) en texto e imprime `Texto: [` seguido del valor y `]`.
8. **TODO 7: Explicar casting frente a parsing y primitivo frente a wrapper.** Ejecuta con los valores iniciales y escribe dos frases: una sobre cast/parsing y otra sobre int/Integer. No necesitas nuevas clases ni colecciones.

**Salida inicial esperada:**

```text
Cantidad ampliada: 10.0
Medicion truncada: 7
Negativa truncada: -7
Primitivo: 42
Wrapper: 42
Unboxing: 42
Texto: [42]
```

## Lab 5 · Normaliza un registro · Casa

**Archivo:** [S04Lab05NormalizaRegistro.java](S04Lab05NormalizaRegistro.java).

**Datos iniciales de la clase:**

```java
String nombreEntrada = "  Laura Gomez  ";
        String documentoEntrada = " 1048 ";
        String edadTexto = " 24 ";
        String ciudadEntrada = "bucaramanga";
        String estaturaTexto = "1.68";
```

### Pasos para completar la actividad

1. Abre `S04Lab05NormalizaRegistro.java` en tu proyecto personal.
2. **TODO 1: Limpiar nombre y documento conservando los originales.** Declara nombre y documento como String con el resultado de strip. Documento sigue siendo texto: no lo conviertas a número ni elimines ceros iniciales.
3. **TODO 2: Rechazar nombre en blanco o documento con menos de 4 posiciones.** Usa if/else con nombre.isBlank() o documento.length()<4. La rama inválida imprime solo `Registro invalido`; escribe lo siguiente en su rama válida.
4. **TODO 3: Convertir edad a int y estatura a double despues de strip.** Usa Integer.parseInt(edadTexto.strip()) y Double.parseDouble(estaturaTexto.strip()). Las pruebas obligatorias tienen texto numérico válido.
5. **TODO 4: Validar edad de 0 a 120 y estatura positiva y finita.** Rechaza edad<0, edad>120, estatura<=0 o !Double.isFinite(estatura). Si falla imprime solo `Registro invalido`; el resto de la ficha queda en su else.
6. **TODO 5: Normalizar ciudad a mayusculas con Locale.ROOT.** Importa java.util.Locale y guarda ciudadEntrada.strip().toUpperCase(Locale.ROOT). Locale.ROOT hace el resultado independiente del idioma del equipo.
7. **TODO 6: Clasificar por mayoria de edad.** Usa edad>=18 para elegir MAYOR_DE_EDAD; en otro caso MENOR_DE_EDAD. Guarda el resultado en String categoria.
8. **TODO 7: Mostrar la ficha con las seis etiquetas indicadas.** Agrega seis println dentro de la rama válida: Nombre, Documento, Edad, Ciudad, Estatura (m) y Categoria, con `: ` y la variable correspondiente.
9. **TODO 8: Probar caso inicial, edad 17 y nombre en blanco.** Ejecuta tres veces: datos iniciales; solo edadTexto="17"; datos iniciales restaurados y solo nombreEntrada="   ". La tercera imprime solo `Registro invalido`. Registra las salidas.
10. **TODO 9: Observar opcionalmente el error de parsing con veinte y restaurar el dato valido.** **Opcional:** en tu copia, cambia edadTexto a "veinte", observa NumberFormatException y la línea del error. Restablece después el texto numérico; no debes escribir try/catch ni entregar ese dato inválido activo.

**Salida inicial esperada:**

```text
Nombre: Laura Gomez
Documento: 1048
Edad: 24
Ciudad: BUCARAMANGA
Estatura (m): 1.68
Categoria: MAYOR_DE_EDAD
```

Con edad 17 solo cambian Edad: 17 y Categoria: MENOR_DE_EDAD. Todas las entradas de este ejercicio son String no null. No es un validador completo de identidad ni un recuperador de parsing inválido.

## Entrega

Trae los cinco labs completados para la siguiente clase. Publica las clases y un README breve con las pruebas mínimas y respuestas solicitadas en tu repositorio personal; comparte el enlace por Campus. Las ampliaciones opcionales no son requisito. No publiques archivos compilados ni configuración del IDE.
