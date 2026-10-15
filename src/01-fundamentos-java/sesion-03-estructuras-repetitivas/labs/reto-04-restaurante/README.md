# Reto 4 · Sistema de pedidos para un restaurante

**Sector:** gastronomía. **Nivel:** intermedio. Integra menú, selección, repetición, contadores, acumuladores y reglas comerciales.

El cliente puede agregar productos hasta finalizar su pedido. Diseña la interacción y justifica tus decisiones; no existe una única organización válida del código. El docente asignará el reto y lo pendiente se completa para la siguiente clase.

## Antes de programar

1. ¿Qué ciclo mantiene abierto el menú y cómo termina?
2. ¿Cómo identificarás el precio del producto elegido?
3. ¿Cómo impedirás que opción=7 o cantidad=−2 cambien el pedido?
4. ¿Por qué debes comprobar primero el descuento mayor?
5. ¿Sobre qué importe calcularás el domicilio y qué efecto tiene esa elección?

## Lo que debes construir

1. Crea `S03Reto04Restaurante` con main y Scanner. Muestra este menú en cada vuelta: 1=Hamburguesa, 18000 pesos; 2=Pizza, 25000; 3=Ensalada, 15000; 4=Bebida, 6000; 5=Finalizar pedido.
2. Si la opción no pertenece al menú, muestra el error y vuelve a pedirla. Si es 5, finaliza sin pedir cantidad.
3. Para productos 1–4 solicita cantidad entera mayor que cero. Corrige cantidades inválidas sin registrar el producto.
4. Calcula precio×cantidad, muestra el importe agregado y actualiza subtotal y productos solicitados. **Productos solicitados cuenta unidades**, no veces que se eligió una opción. Usa long para dinero y acumulaciones.
5. Al finalizar el pedido, elige una sola tasa: **15 % si subtotal>150000**; en caso contrario, **10 % si subtotal>100000**; en los demás casos, 0 %. No sumes ambas tasas. Los límites son estrictos: exactamente 100000 no tiene descuento y exactamente 150000 tiene 10 %.
6. Calcula descuento y neto=subtotal−descuento. Los precios son múltiplos de 100: estas tasas producen pesos enteros.
7. Decide si el domicilio de 5000 se agrega cuando **subtotal<30000** o cuando **neto<30000**. Ambas interpretaciones se admiten si documentas cuál elegiste y la aplicas coherentemente. El neto es el importe después del descuento y antes del domicilio; no pruebes un total que ya contenga ese cargo.
8. Calcula total=neto+domicilio y muestra unidades solicitadas, subtotal, descuento, domicilio y total. Si se finaliza sin productos, todos los valores deben ser cero: no cobres domicilio por un pedido vacío.

Para estas tarifas y umbrales de descuento, ambas interpretaciones de domicilio producen el mismo resultado en los pedidos base. Explica la elección igualmente; si agregas reglas nuevas, diseña un caso que permita distinguirlas.

## Pruebas mínimas

| Productos seleccionados | Unidades | Subtotal | Descuento | Domicilio | Total |
| --- | --- | --- | --- | --- | --- |
| Bebida × 1 | 1 | 6000 | 0 | 5000 | 11000 |
| Ensalada × 2 | 2 | 30000 | 0 | 0 | 30000 |
| Pizza × 4 | 4 | 100000 | 0 | 0 | 100000 |
| Pizza × 6 | 6 | 150000 | 15000 | 0 | 135000 |
| Pizza × 7 | 7 | 175000 | 26250 | 0 | 148750 |
| Hamburguesa × 4 y Pizza × 2 | 6 | 122000 | 12200 | 0 | 109800 |

Cada fila es un pedido nuevo. Prueba también 5 al comenzar: resumen en cero; opción=7: no cambia acumuladores; cantidad=−2: vuelve a pedirla. No tienes que registrar varios clientes para completar el reto base.

## Extensión opcional

Después del resumen pregunta si desea registrar otro cliente. Reinicia subtotal y unidades para cada pedido y agrega un ciclo para la jornada. No copies manualmente todo el programa para cada cliente.

## Entrega

Entrega la clase y un README con decisiones, regla de domicilio y resultados de las pruebas en tu repositorio personal; comparte el enlace por Campus. Las distintas formas de ciclos y selección son válidas si respetan las reglas. Manejar entradas no numéricas es opcional.
