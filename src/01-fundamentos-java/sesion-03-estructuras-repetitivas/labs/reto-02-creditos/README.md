# Reto 2 · Simulador de aprobación de créditos

**Sector:** financiero. **Nivel:** intermedio. Integra condiciones compuestas, validación, clasificación, repetición y contadores.

Una cooperativa necesita una evaluación preliminar de solicitudes. Es un modelo didáctico sin intereses, seguros ni comisiones; no representa una política de crédito real. El docente asignará el reto; completa lo pendiente para la siguiente clase.

## Antes de programar

1. ¿Qué requisitos deben comprobarse antes de dividir?
2. ¿Qué ocurre si gastos son iguales o mayores que ingresos?
3. ¿Cómo separarás exactamente los límites del 35 % y 45 %?
4. ¿Qué contador debes incrementar para cada resultado?

## Lo que debes construir

1. Crea `S03Reto02Creditos` con main y Scanner. Muestra 1=Nueva solicitud y 0=Finalizar; cualquier otra opción se vuelve a pedir.
2. Solicita edad, ingresos mensuales, gastos mensuales, crédito solicitado y meses. Usa pesos enteros con long. Para este modelo: edad de 0 a 120; ingresos y gastos de 0 a 1000000000; crédito de 1 a 1000000000; meses de 1 a 360. Los datos fuera de esos rangos se corrigen antes de evaluar y no cuentan como solicitudes adicionales.
3. Si la edad no está entre 18 y 70 inclusive, o ingresos<=gastos, clasifica como RECHAZADA. No dividas por dinero disponible cero o negativo.
4. Para los demás solicitantes, calcula disponible=ingresos−gastos. La cuota estimada corresponde a crédito/meses, sin intereses. El endeudamiento es cuota/disponible.
5. Clasifica una sola vez: **APROBADA si endeudamiento<=35 %**; **REVISIÓN MANUAL si >35 % y <=45 %**; **RECHAZADA si >45 %**. Un crédito en revisión no es una aprobación automática.
6. Presenta los datos calculados y la clasificación. Para dinero evita perder una fracción de cuota antes de clasificar: puedes comparar `credito * 100` con `disponible * meses * 35` y con `disponible * meses * 45`. Así los límites se evalúan con enteros exactos dentro de los rangos indicados. No estás obligado a usar esa alternativa, pero debes justificar tu precisión.
7. Aumenta solicitudes evaluadas y el contador de su categoría. Vuelve al menú hasta seleccionar 0.
8. Al finalizar muestra evaluadas, aprobadas, revisión manual y rechazadas. Su suma debe coincidir con el total evaluado.

Si presentas una cuota en pesos enteros, indica que es aproximada; no uses su truncamiento para decidir la categoría. Un porcentaje puede representarse como double porque es una razón, no un importe monetario.

## Pruebas mínimas

| Edad | Ingresos | Gastos | Crédito | Meses | Resultado |
| --- | --- | --- | --- | --- | --- |
| 30 | 3000000 | 1800000 | 6000000 | 12 | REVISIÓN MANUAL: aproximadamente 41.67 % |
| 30 | 1000000 | 0 | 350000 | 1 | APROBADA: exactamente 35 % |
| 30 | 1000000 | 0 | 450000 | 1 | REVISIÓN MANUAL: exactamente 45 % |
| 30 | 1000000 | 0 | 450001 | 1 | RECHAZADA: supera 45 % |
| 17 | 1000000 | 0 | 100000 | 1 | RECHAZADA por edad |
| 30 | 1000000 | 1000000 | 100000 | 1 | RECHAZADA sin dividir |

Procesa las seis en una ejecución: resumen **6 evaluadas, 1 aprobada, 2 en revisión y 3 rechazadas**. Prueba meses=0: el dato debe corregirse antes de evaluar. Finalizar inmediatamente produce cuatro contadores en cero.

## Extensión opcional

Agrega un puntaje: +2 si ingresos>4000000; +1 si endeudamiento<25 %; +1 si edad entre 25 y 55; −2 si endeudamiento>40 %. Define y documenta cómo interviene en la decisión, sin saltarte los requisitos obligatorios. No hay un umbral final de puntaje impuesto: debes justificar tu regla.

## Entrega

Publica la clase y un README breve con reglas, pruebas y justificación de los límites en tu repositorio personal. Comparte el enlace por Campus. Se admiten distintas organizaciones de condiciones y ciclos si cumplen la especificación. Entradas no numéricas son una ampliación opcional.
