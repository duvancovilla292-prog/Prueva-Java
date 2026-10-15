# Reto 1 · Sistema de tarifas de estacionamiento

**Sector:** movilidad. **Nivel:** básico–intermedio. Integra variables, cálculos, decisiones, repetición, contadores y acumuladores.

Un parqueadero necesita calcular el cobro de cada vehículo y resumir su jornada. Diseña tu programa de consola; no hay una plantilla que debas copiar. El docente asignará el reto en clase. Completa lo pendiente en casa para la siguiente clase.

## Antes de programar

En tu README personal responde brevemente:

1. ¿Qué datos cambian para cada vehículo?
2. ¿Qué contadores necesitas y qué acumula el dinero?
3. ¿Qué decisiones debes tomar para calcular la tarifa y el descuento?
4. ¿Qué ciclo mantendrá abierta la jornada y cómo terminará?

## Lo que debes construir

1. Crea una clase `S03Reto01Estacionamiento` con main en tu proyecto personal. Usa Scanner para leer enteros desde la consola.
2. Muestra un menú: 1=automóvil, 2=motocicleta, 0=terminar jornada. Permite finalizar sin registrar vehículos.
3. Al elegir un vehículo, solicita horas como entero mayor que cero. Si tipo u horas no son válidos, explica el error y vuelve a pedir el dato; no registres un vehículo incompleto.
4. Calcula el valor inicial: automóvil, 4000 pesos por hora; motocicleta, 2000 pesos por hora. Usa long para importes en pesos enteros.
5. Aplica un único descuento: automóvil con **más de 5 horas**, 10 %; motocicleta con **más de 8 horas**, 5 %. En el límite exacto no hay descuento.
6. Muestra para ese vehículo `Valor inicial`, `Descuento` y `Total a pagar`, con sus importes en pesos. La tarifa por hora se multiplica por horas; no escribas un if para cada duración.
7. Actualiza los contadores de automóviles, motocicletas y vehículos totales, y suma el total pagado al dinero recaudado. Hazlo una sola vez por vehículo válido.
8. Vuelve al menú. Cuando se seleccione 0, muestra el resumen de la jornada con los cuatro valores acumulados.

Las tarifas son múltiplos de 100: los descuentos indicados producen pesos enteros, sin necesitar double. No uses arrays, colecciones, clases auxiliares ni frameworks. El ciclo concreto puede variar si conserva el comportamiento.

## Pruebas mínimas

| Tipo | Horas | Valor inicial | Descuento | Total |
| --- | --- | --- | --- | --- |
| Automóvil | 5 | 20000 | 0 | 20000 |
| Automóvil | 6 | 24000 | 2400 | 21600 |
| Motocicleta | 8 | 16000 | 0 | 16000 |
| Motocicleta | 9 | 18000 | 900 | 17100 |

Registra esos cuatro vehículos en una jornada y finaliza. El resumen debe mostrar **4 vehículos, 2 automóviles, 2 motocicletas y 74700 pesos recaudados**. Prueba también horas=0 y tipo=7: se corrigen sin aumentar contadores. En otra ejecución elige 0 inmediatamente: los totales deben ser cero.

## Extensión opcional

Limita la tarifa diaria a 35000 pesos para automóvil y 20000 para motocicleta. Decide si el límite se aplica antes o después del descuento, documenta la regla y demuestra con un caso que tu programa la respeta. La extensión no es necesaria para la entrega base.

## Entrega

Entrega tu clase Java y un README con decisiones, entradas y resultados de las pruebas mínimas en tu repositorio personal; comparte el enlace por Campus. Puedes elegir otros nombres de variables y ciclos si explicas tu solución y respetas las reglas. La gestión de entradas no numéricas es opcional; no publiques archivos compilados ni configuración del IDE.
