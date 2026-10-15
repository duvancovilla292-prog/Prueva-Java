# Laboratorios de la sesión 2

Trabaja primero los labs 1–3 durante los **40 minutos máximos de práctica en clase**. Completa lo pendiente y los labs 4–5 en casa para la siguiente clase.

## Antes de escribir código

- Usa tu proyecto personal en IntelliJ IDEA, con JDK 21 o 17. Conserva el archivo, la clase y su main.
- Escribe las instrucciones dentro de main, debajo del TODO correspondiente. Los comentarios con // no se ejecutan.
- Texto entre comillas; variables fuera de ellas. Ejemplo: `System.out.println("Cantidad: " + cantidad);`. Termina cada instrucción con `;`.
- Ejecuta la clase del lab actual. Compara solo sus mensajes, no los avisos del IDE. No pegues los bloques de salida como código Java.
- Cambia los datos iniciales para cada prueba. Guarda las comprobaciones y respuestas breves en el README de tu repositorio personal.

## Lab 1 · Calcula y predice · Clase: 10 minutos

**Archivo:** [S02Lab01CalculaYPredice.java](S02Lab01CalculaYPredice.java).

La clase comienza con `int unidades = 7;`, `int capacidad = 2;` e `int contador = 3;`. Conserva esos datos para la prueba inicial.

### Pasos para completar la actividad

1. Abre `S02Lab01CalculaYPredice.java` en tu proyecto personal.
2. **TODO 1: Predecir los resultados en un comentario antes de ejecutar.** Antes de ejecutar, escribe un comentario con los resultados que esperas para las expresiones de la tabla.
3. **TODO 2: Calcular y mostrar suma, resta, producto, división entera y resto.** Calcula suma, resta, producto, división entera y resto con las expresiones de la tabla. Puedes guardarlos en variables int. Imprime cada resultado con `System.out.println`, su etiqueta y `+`. No escribas los resultados como mensajes fijos.
4. **TODO 3: Mostrar 7.0 / capacidad y explicar por qué conserva decimales.** Calcula `7.0 / capacidad` y guarda el resultado en un double. Imprímelo con `Division decimal: ` y explica brevemente por qué conserva decimales.
5. **TODO 4: Comparar 2 + 3 * 4 con (2 + 3) * 4.** Imprime los resultados de `2 + 3 * 4` y `(2 + 3) * 4` con las etiquetas indicadas. Si pones la expresión directamente en println, agrúpala: `"Etiqueta: " + (expresion)`.
6. **TODO 5: Incrementar contador en una sentencia, mostrarlo; decrementar y mostrarlo.** Escribe `contador++;` y después un println con `Contador incrementado: ` y contador. Luego escribe `contador--;` y otro println con `Contador decrementado: ` y contador.
7. **TODO 6 (opcional): Probar unidades = 8 y explicar qué cambia. Mantener capacidad = 2.** **Opcional:** cambia únicamente unidades a 8 y ejecuta. La expresión decimal sigue usando 7.0 como numerador; explica por qué su resultado no cambia.
8. **TODO 7: Registrar predicción, resultado y causa de cualquier diferencia.** Ejecuta el caso inicial y compara las diez líneas. Guarda una sola tabla de predicción y resultado observado en tu README personal; explica cualquier diferencia en una frase.

| Expresión | Etiqueta de salida |
| --- | --- |
| `unidades + capacidad` | `Suma: ` |
| `unidades - capacidad` | `Resta: ` |
| `unidades * capacidad` | `Producto: ` |
| `unidades / capacidad` | `Division entera: ` |
| `7.0 / capacidad` | `Division decimal: ` |
| `unidades % capacidad` | `Resto: ` |
| `2 + 3 * 4` | `Sin parentesis: ` |
| `(2 + 3) * 4` | `Con parentesis: ` |

**Salida inicial esperada, en este orden:**

```text
Suma: 9
Resta: 5
Producto: 14
Division entera: 3
Division decimal: 3.5
Resto: 1
Sin parentesis: 14
Con parentesis: 20
Contador incrementado: 4
Contador decrementado: 3
```

## Lab 2 · Reglas de acceso · Clase: 12 minutos

**Archivo:** [S02Lab02ReglasDeAcceso.java](S02Lab02ReglasDeAcceso.java).

Datos iniciales: edad=18, esMiembro=false, tieneInvitacion=true y bloqueado=false.

### Pasos para completar la actividad

1. Abre `S02Lab02ReglasDeAcceso.java` en tu proyecto personal.
2. **TODO 1: Escribir la regla de acceso en lenguaje natural.** Escribe un comentario con esta regla: ser mayor de edad, tener membresía o invitación y no estar bloqueado.
3. **TODO 2: Construir puedeEntrar combinando edad, membresía, invitación y bloqueo.** Declara boolean puedeEntrar y combina esos requisitos. Usa && para los requisitos simultáneos, || para las autorizaciones alternativas y ! para negar el bloqueo; agrupa las autorizaciones entre paréntesis.
4. **TODO 3: Mostrar "Acceso permitido" o "Acceso denegado" con if/else.** Usa if/else sobre puedeEntrar. Dentro de cada rama coloca un println: `Acceso permitido` en la verdadera y `Acceso denegado` en la falsa. Cada ejecución debe imprimir solo una línea.
5. **TODO 4: Probar los tres casos mínimos del README; las otras combinaciones son opcionales.** Ejecuta las tres filas de la tabla, modificando las cuatro variables según cada fila. Registra los resultados; no necesitas probar todas las combinaciones.
6. **TODO 5: Explicar por qué el bloqueo impide siempre el acceso.** Explica en una frase por qué el bloqueo niega el acceso aunque haya invitación.
7. **TODO 6 (opcional): Colocar un breakpoint en if y observar puedeEntrar antes de elegir la rama.** **Opcional:** coloca un breakpoint en if y observa puedeEntrar antes de ejecutar la rama.

**Tres pruebas obligatorias:**

| edad | esMiembro | tieneInvitacion | bloqueado | Única línea esperada |
| --- | --- | --- | --- | --- |
| 18 | false | true | false | Acceso permitido |
| 17 | false | true | false | Acceso denegado |
| 18 | false | true | true | Acceso denegado |

## Lab 3 · Clasifica resultados · Clase: 15 minutos

**Archivo:** [S02Lab03ClasificaResultados.java](S02Lab03ClasificaResultados.java).

La clase inicia con nota=85. Las notas válidas son enteros entre 0 y 100.

### Pasos para completar la actividad

1. Abre `S02Lab03ClasificaResultados.java` en tu proyecto personal.
2. **TODO 1: Rechazar notas fuera de 0 a 100 antes de clasificarlas.** En la primera condición detecta nota<0 o nota>100. Esa rama debe imprimir únicamente `Nota invalida`.
3. **TODO 2: Clasificar con if/else if/else: A desde 90, B desde 80, C desde 70, D desde 60 y E por debajo de 60.** Continúa la misma cadena con else if: A desde 90, B desde 80, C desde 70, D desde 60 y E en el else final. Evalúa primero el rango mayor; no escribas cinco if independientes.
4. **TODO 3: Mostrar "Categoria X" o "Nota invalida" según corresponda.** En cada rama válida usa un println con la categoría correspondiente: `Categoria A`, etc. No agregues encabezados ni imprimas otra categoría fuera de la cadena.
5. **TODO 4: Probar nota 85, 90 y 101; las demás entradas son opcionales.** Ejecuta con nota 85, después 90 y después 101. Compara con la tabla y guarda las tres salidas. Las demás fronteras son pruebas opcionales.
6. **TODO 5: Explicar con nota = 95 por qué el orden de las condiciones importa.** Explica con nota=95 qué ocurriría si evaluaras >=60 antes de >=90. Basta una frase; no debes entregar una versión incorrecta.

| nota | Única línea esperada |
| --- | --- |
| 85 | Categoria B |
| 90 | Categoria A |
| 101 | Nota invalida |

Los rangos completos son A: 90–100, B: 80–89, C: 70–79, D: 60–69 y E: 0–59. Son categorías del ejercicio, no una escala institucional.

## Lab 4 · Elige la entrega · Casa

**Archivo:** [S02Lab04EligeLaEntrega.java](S02Lab04EligeLaEntrega.java).

La clase comienza con tipoEntrega="EXPRESS". Usa los textos en mayúsculas de la tabla; no trabajamos con null.

### Pasos para completar la actividad

1. Abre `S02Lab04EligeLaEntrega.java` en tu proyecto personal.
2. **TODO 1: Resolver ESTANDAR=500, EXPRESS=1200 y RECOGIDA=0 centavos con switch.** Declara long costoCentavos y determina su valor con switch: ESTANDAR=500, EXPRESS=1200 y RECOGIDA=0. Usa una sola forma de switch; en la clásica agrega break, con flechas no lo necesitas.
3. **TODO 2: Manejar default como opción inválida; no mostrar un costo válido.** En default asigna -1 como señal interna de opción desconocida. Después del switch separa el caso inválido del válido con if/else.
4. **TODO 3: En opciones válidas mostrar "Costo (centavos): " con el valor.** En la rama válida imprime `Costo (centavos): ` y costoCentavos con println.
5. **TODO 4: Usar un ternario para elegir "Retiro en tienda" o "Entrega a domicilio".** En esa misma rama declara String etiqueta y asígnalo con un ternario: para RECOGIDA elegir `Retiro en tienda`; para las otras modalidades, `Entrega a domicilio`. Usa equals para comparar contenido.
6. **TODO 5: Mostrar la etiqueta con "Etiqueta: "; para invalidos mostrar solo "Tipo de entrega invalido".** Imprime `Etiqueta: ` y etiqueta en la rama válida. En la inválida imprime únicamente `Tipo de entrega invalido`; no muestres -1 como precio.
7. **TODO 6: Probar los tres tipos y DRON; opcionalmente comparar switch clásico y moderno en tu copia personal. Entregar una versión y explicar break y las flechas.** Prueba las cuatro filas. Entrega una sola versión y explica brevemente break y las flechas. Comparar dos implementaciones ejecutables es opcional.

| tipoEntrega | Costo | Etiqueta |
| --- | --- | --- |
| ESTANDAR | 500 | Entrega a domicilio |
| EXPRESS | 1200 | Entrega a domicilio |
| RECOGIDA | 0 | Retiro en tienda |
| DRON | No mostrar | No mostrar |

**Salida para EXPRESS:**

```text
Costo (centavos): 1200
Etiqueta: Entrega a domicilio
```

Para DRON debe aparecer solo `Tipo de entrega invalido`.

## Lab 5 · Motor de promociones · Casa

**Archivo:** [S02Lab05MotorPromociones.java](S02Lab05MotorPromociones.java).

Datos iniciales de la clase: subtotalCentavos=18500, cantidad=4, esMiembro=true y tipoEntrega="EXPRESS". Los importes se representan con long, en centavos; el subtotal ya incluye todos los productos.

### Pasos para completar la actividad

1. Abre `S02Lab05MotorPromociones.java` en tu proyecto personal.
2. **TODO 1: Predecir descuento, importe neto, envío y total antes de programar.** Calcula antes de programar el descuento, neto, envío y total inicial. Anota tu predicción en un comentario.
3. **TODO 2: Validar subtotal entre 0 y 1000000 inclusive y cantidad mayor que cero.** Crea boolean datosValidos: subtotal entre 0 y 1000000 inclusive y cantidad>0. Si no se cumple, imprime solo `Pedido invalido: subtotal o cantidad fuera de rango`. Continúa los otros TODO dentro del else de datos válidos.
4. **TODO 3: Rechazar entrega desconocida; no mostrar un desglose válido.** Usa switch para elegir long envioCentavos: ESTANDAR=500, EXPRESS=1200, RECOGIDA=0 y default=-1. Si el envío es negativo, imprime solo `Pedido invalido: tipo de entrega desconocido`; continúa los cálculos únicamente en su rama válida.
5. **TODO 4: Elegir 10%, 5% o 0% con if/else if/else según las reglas del README.** Declara int porcentajeDescuento. Asígnale 10 si es miembro y subtotal>=10000; 5 si no es miembro y subtotal>=20000; 0 en cualquier otro caso. Usa if/else if/else, sin sumar tasas.
6. **TODO 5: Calcular descuento y neto en centavos; truncar fracciones de centavo.** Calcula long descuentoCentavos con `subtotalCentavos * porcentajeDescuento / 100` y long netoCentavos con `subtotalCentavos - descuentoCentavos`. La división entera descarta fracciones de centavo; no uses tasas 0.10 o 0.05.
7. **TODO 6: Elegir costo de envío con switch y aplicar gratuidad solo al ESTANDAR cuando el neto alcanza 25000 centavos.** Si la entrega es ESTANDAR y netoCentavos>=25000, reasigna envioCentavos a 0. Compara el texto con equals. Después calcula long totalCentavos como `netoCentavos + envioCentavos`.
8. **TODO 7: Mostrar el desglose con las etiquetas indicadas en el README.** En la rama de pedido válido agrega seis println en el orden y con las etiquetas del bloque esperado. Concatena cada etiqueta con su variable; no escribas importes fijos en la salida.
9. **TODO 8: Probar los cinco casos mínimos del README; registrar resultados.** Ejecuta las cinco pruebas mínimas de abajo. En cada fila asigna todas las entradas indicadas y guarda el resultado; no cambies las fórmulas.
10. **TODO 9 (opcional): Inspeccionar con Debug descuentoCentavos, netoCentavos y envioCentavos.** **Opcional:** coloca un breakpoint en la condición del envío gratis y observa descuentoCentavos, netoCentavos y envioCentavos.
11. **TODO 10: Mejorar nombres y repetir las pruebas sin alterar las reglas.** Revisa los nombres y conserva las reglas. Si cambias código, repite al menos el caso inicial y uno de frontera. Explica en una frase por qué el envío gratis depende del neto.

**Salida inicial esperada:**

```text
Subtotal (centavos): 18500
Descuento (%): 10
Descuento (centavos): 1850
Neto (centavos): 16650
Envio (centavos): 1200
Total (centavos): 17850
```

**Tres pruebas válidas:** en cada una imprime las mismas seis etiquetas. La tasa es 10 % en la primera y 5 % en las otras.

| Subtotal | Cantidad | Miembro | Entrega | Descuento | Neto | Envío | Total |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 18500 | 4 | true | EXPRESS | 1850 | 16650 | 1200 | 17850 |
| 26314 | 1 | false | ESTANDAR | 1315 | 24999 | 500 | 25499 |
| 26315 | 1 | false | ESTANDAR | 1315 | 25000 | 0 | 25000 |

**Dos pruebas inválidas:** restaura primero las entradas iniciales y cambia solo lo indicado. No debe aparecer un desglose ni un total.

| Cambiar solo | Única línea esperada |
| --- | --- |
| cantidad=0 | Pedido invalido: subtotal o cantidad fuera de rango |
| tipoEntrega="DRON" | Pedido invalido: tipo de entrega desconocido |

## Entrega

Trae los cinco archivos Java completados para la siguiente clase y comparte el enlace de tu repositorio personal mediante Campus, según indique el docente. Incluye las pruebas mínimas y respuestas solicitadas; no se requieren capturas por prueba ni informes extensos. No subas archivos compilados ni configuración personal del IDE.
