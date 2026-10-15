# Laboratorios de la sesión 1

Trabaja primero los labs 1–3 durante los **40 minutos máximos de práctica en clase**. Completa lo pendiente y los labs 4–5 en casa para la siguiente clase.

## Antes de escribir código

- Usa tu proyecto personal en IntelliJ IDEA, con JDK 21 o 17. Conserva el archivo, la clase y su main.
- Escribe las instrucciones dentro de main, debajo del TODO correspondiente. Los comentarios con // no se ejecutan.
- Texto entre comillas; variables fuera de ellas. Ejemplo: `System.out.println("Cantidad: " + cantidad);`. Termina cada instrucción con `;`.
- Ejecuta la clase del lab actual. Compara solo sus mensajes, no los avisos del IDE. No pegues los bloques de salida como código Java.
- Cambia los datos iniciales para cada prueba. Guarda las comprobaciones y respuestas breves en el README de tu repositorio personal.

## Lab 1 · Mi primer saludo · Clase: 8 minutos

**Archivo:** [Lab01MiPrimerSaludo.java](Lab01MiPrimerSaludo.java).

### Pasos para completar la actividad

1. Abre `Lab01MiPrimerSaludo.java` en tu proyecto personal.
2. **TODO 1: Mostrar "Hola, Java!" en una línea.** Agrega un `System.out.println` que imprima `Hola, Java!`. Escribe el texto entre comillas dobles y termina con `;`.
3. **TODO 2: Mostrar tu nombre en una segunda línea, con la etiqueta "Nombre: ".** Agrega un segundo `System.out.println` con `Nombre: ` seguido de un nombre ficticio. Puedes escribir todo como texto, sin variables.
4. **TODO 3: Mostrar una meta de aprendizaje en una tercera línea, con "Meta: ".** Agrega un tercer `System.out.println` con `Meta: ` seguida de una frase sobre lo que quieres aprender.
5. **TODO 4: Escribir aquí qué esperas ver antes de ejecutar.** Antes de ejecutar, escribe un comentario `// Predicción:` con las tres líneas que esperas ver. No imprimas la predicción en consola.
6. **TODO 5: Ejecutar y explicar en un comentario dónde comienza el programa.** Ejecuta **Run → Lab01MiPrimerSaludo**. Comprueba las tres líneas y escribe un comentario indicando que la ejecución comienza en `main`. En tu README personal responde en una frase qué agrega `println` al final de cada mensaje.

**Salida de ejemplo:** puedes cambiar el nombre y la meta; conserva el saludo, las etiquetas y el orden.

```text
Hola, Java!
Nombre: Ana
Meta: Aprender a ejecutar y comprender un programa Java.
```

## Lab 2 · Ordena la salida · Clase: 10 minutos

**Archivo:** [Lab02OrdenaLaSalida.java](Lab02OrdenaLaSalida.java).

La clase ya contiene `print("A")`, `println("B")` y `println("C")`.

### Pasos para completar la actividad

1. Abre `Lab02OrdenaLaSalida.java` en tu proyecto personal.
2. **TODO 1: Predecir la salida de estas tres instrucciones en un comentario.** Sin modificar las instrucciones, escribe un comentario con la salida que esperas. Indica en qué línea aparecerá cada letra.
3. **TODO 2: Ejecutar y explicar cualquier diferencia con tu predicción.** Ejecuta la versión original. Guarda su salida y explica en una frase si coincidió con tu predicción.
4. **TODO 3: Modificar las instrucciones anteriores para obtener: A - B - C** Modifica esas mismas tres instrucciones: imprime `A - ` y `B - ` con `System.out.print`, y `C` con `System.out.println`. No conserves otro bloque que imprima la versión inicial.
5. **TODO 4: Agregar debajo una segunda línea que diga "Fin del laboratorio".** Después de las tres instrucciones agrega un `System.out.println` con el texto `Fin del laboratorio`.
6. **TODO 5: Explicar qué instrucción produce cada salto de línea.** Ejecuta otra vez y comprueba exactamente las dos líneas de abajo. En un comentario explica qué instrucción termina cada línea.

**Salida final esperada:**

```text
A - B - C
Fin del laboratorio
```

## Lab 3 · Datos con sentido · Clase: 17 minutos

**Archivo:** [Lab03DatosConSentido.java](Lab03DatosConSentido.java).

### Pasos para completar la actividad

1. Abre `Lab03DatosConSentido.java` en tu proyecto personal.
2. **TODO 1: Elegir y justificar los tipos para nombre, edad, temperatura, inicial y activo. Usa String, int, double, char y boolean.** Elige tipos explícitos para nombre, edad, temperatura, inicial y activo usando String, int, double, char y boolean. Justifica brevemente una elección.
3. **TODO 2: Declarar e inicializar las cinco variables con nombres claros.** Declara las cinco variables e inicialízalas con el caso A de la tabla. Usa comillas dobles para nombre, simples para inicial, punto decimal para temperatura y ningún tipo de comillas para edad y activo.
4. **TODO 3: Mostrar cada dato en su propia línea, con una etiqueta.** Agrega cinco `System.out.println` en el orden de la salida esperada. Une cada etiqueta y su variable con `+`; no escribas los resultados como textos fijos.
5. **TODO 4: Probar el caso A del README; el caso B es opcional.** Ejecuta con el caso A y compara las cinco líneas. El caso B es opcional: cambia solo los valores iniciales, sin modificar las impresiones.
6. **TODO 5: Explicar por qué String no es un tipo primitivo.** Explica en una frase que String representa texto y es una clase, no un tipo primitivo.

| Caso | nombre | edad | temperatura | inicial | activo |
| --- | --- | --- | --- | --- | --- |
| A · obligatorio | Ana | 20 | 23.5 | A | true |
| B · opcional | Luis | 25 | 18.0 | L | false |

**Salida del caso A:**

```text
Nombre: Ana
Edad: 20
Temperatura: 23.5
Inicial: A
Activo: true
```

## Lab 4 · Diagnostica y corrige · Casa

**Archivo:** [Lab04DiagnosticaYCorrige.java](Lab04DiagnosticaYCorrige.java).

Activa y corrige un caso por vez. Copia únicamente el fragmento Java del comentario a una línea nueva, sin las palabras `Caso 1:`, etc. Conserva una sola versión corregida de cada dato.

### Pasos para completar la actividad

1. Abre `Lab04DiagnosticaYCorrige.java` en tu proyecto personal.
2. **TODO 1: Corregir las comillas, mostrar el nombre y explicar la causa.** Prueba el fragmento `String nombre = 'Ana';`, lee el error y corrige las comillas conservando Ana como texto. Imprime la variable con la etiqueta `Nombre: `.
3. **TODO 2: Conservar el valor decimal usando un tipo adecuado y mostrarlo.** Prueba `int temperatura = 23.5;`, lee el error y cambia el tipo para conservar el decimal. Imprime la variable con `Temperatura: `; no sustituyas 23.5 por 23.
4. **TODO 3: Inicializar edad antes de mostrarla y explicar por qué es necesario.** Activa la declaración de edad y su impresión sin inicializar, observa el error y asigna 20 antes de leerla. Ajusta el println para mostrar `Edad: ` y la variable.
5. **TODO 4: Conservar CURSO como final y mostrar "Java", sin reasignarlo.** Activa la declaración de CURSO y su reasignación, observa el error y elimina la reasignación. Mantén `final` y agrega un println con `Curso: ` y CURSO.
6. **TODO 5: Registrar los cuatro mensajes del compilador en tu README personal, junto con la causa y la corrección aplicada a cada caso.** En tu README personal escribe cuatro filas: caso, mensaje observado, causa y corrección. Ejecuta la versión final: debe compilar e imprimir solo las cuatro líneas de abajo.

**Salida final esperada:**

```text
Nombre: Ana
Temperatura: 23.5
Edad: 20
Curso: Java
```

## Lab 5 · Perfil del estudiante · Casa

**Archivo:** [Lab05PerfilEstudiante.java](Lab05PerfilEstudiante.java).

### Pasos para completar la actividad

1. Abre `Lab05PerfilEstudiante.java` en tu proyecto personal.
2. **TODO 1: Identificar los tipos de nombre, edad, ciudad, promedio y activo.** Elige tipos explícitos para nombre, edad, ciudad, promedio y activo; usa la tabla de perfiles como datos.
3. **TODO 2: Declarar e inicializar esos datos con nombres claros.** Declara esas variables con los valores del perfil A.
4. **TODO 3: Declarar final String CURSO con el valor "Java".** Declara `final String CURSO` con el valor `"Java"` y no lo reasignes.
5. **TODO 4: Mostrar la ficha inicial con etiquetas legibles.** Imprime el encabezado y luego nombre, edad, ciudad, promedio, activo y curso con un println por línea. Concatena las etiquetas con las variables.
6. **TODO 5: Reasignar ciudad para representar un cambio de residencia y mostrar "Ciudad actualizada: " con el nuevo valor, conservando el mismo tipo.** Después de la ficha, reasigna ciudad a la ciudad nueva del perfil A sin volver a declarar String. Agrega un println con `Ciudad actualizada: ` y ciudad.
7. **TODO 6: Probar el perfil A del README; el perfil B es opcional.** Ejecuta el perfil A y compara sus ocho líneas. El perfil B es una prueba opcional.
8. **TODO 7: Colocar un breakpoint antes de la reasignación; observar ciudad, usar Step Over y registrar el valor anterior y el nuevo.** Pon un breakpoint en la reasignación de ciudad y ejecuta Debug. Anota el valor antes de ejecutar esa línea y después de Step Over.
9. **TODO 8: Explicar una elección de tipo y qué garantiza final en CURSO.** En tu README personal escribe una frase justificando un tipo y otra explicando qué impide final. Guarda la salida del perfil A y los dos valores de ciudad.

| Perfil | nombre | edad | ciudad | promedio | activo | Ciudad nueva |
| --- | --- | --- | --- | --- | --- | --- |
| A · obligatorio | Ana | 20 | Cucuta | 4.2 | true | Bogota |
| B · opcional | Luis | 25 | Medellin | 3.8 | false | Cali |

**Salida del perfil A:**

```text
=== Perfil del estudiante ===
Nombre: Ana
Edad: 20
Ciudad: Cucuta
Promedio: 4.2
Activo: true
Curso: Java
Ciudad actualizada: Bogota
```

## Entrega

Trae los cinco archivos Java completados para la siguiente clase y comparte el enlace de tu repositorio personal mediante Campus, según indique el docente. Incluye las pruebas mínimas y respuestas solicitadas; no se requieren capturas por prueba ni informes extensos. No subas archivos compilados ni configuración personal del IDE.
