# Lab 01 · MVC + DAO · Inventario · Clase: 30 minutos

**Problema:** una tienda necesita registrar productos y modificar su stock. Los mensajes, las validaciones y las consultas SQL deben tener responsabilidades claras.

**Esta carpeta contiene solo el planteamiento.** Crea tu aplicación en un proyecto Maven personal; no hay clases ni POM de arranque. Usa demo01 como referencia de organización, con este dominio distinto.

## Preparación SQL

Abre [preparar.sql](preparar.sql) en MySQL Workbench y ejecútalo una sola vez. Crea la base `campus_java_s18` (si no existe), la tabla y un registro de ejemplo.

## Qué debes hacer

1. **Diseño y proyecto · 5 min.** Crea un proyecto Maven, configura Connector/J y las variables de conexión de Run. Antes de programar, identifica estas responsabilidades:
   - Producto: id, nombre y stock; valida nombre obligatorio de hasta 100 caracteres y stock no negativo.
   - VistaInventario: menú, entrada y salida de consola.
   - ProductoController: coordina las acciones y pide a la vista mostrar resultados o errores.
   - ProductoDAO: SQL y transformación de filas en productos.
   - ConexionFactory: entrega conexiones nuevas, sin guardar una Connection global.
   - Main: crea los componentes y arranca el controlador.
2. **Modelo y listado · 8 min.** Implementa esas clases con métodos pequeños. Crea la opción listar: DAO consulta id, nombre y stock ordenados por id y devuelve una List<Producto>; el controlador entrega esa lista a la vista. Muestra `id | nombre | stock`, o `Sin productos.`. Si cargaste la semilla verás Marcador con 15.
3. **Registro · 7 min.** Añade la opción registrar. La vista pide nombre y stock; el controlador crea un Producto válido y llama al DAO. El DAO usa INSERT parametrizado y devuelve filas afectadas. Registra **Cuaderno con stock 10 desde Java**; lista y anota el id que recibió.
4. **Actualización · 6 min.** Añade cambiar stock por id. Rechaza id no positivo y stock negativo antes de persistir. El DAO ejecuta UPDATE con parámetros para stock e id. Si afecta cero filas, informa `Sin coincidencias para ese id.`; si afecta una, informa `Filas afectadas: 1`. No actualices por nombre: puede haber productos con el mismo nombre.
5. **Verificación · 4 min.** Cambia el Cuaderno de 10 a 7; lista. Intenta -1: informa `El stock no puede ser negativo.` y conserva 7. Prueba un id positivo inexistente. Reinicia y confirma que el Cuaderno permanece con 7.

```sql
SELECT id, nombre, stock FROM productos ORDER BY id;
SELECT id, nombre, stock FROM productos WHERE nombre = 'Cuaderno' ORDER BY id;
```

El menú solo necesita registrar, listar, actualizar stock y salir; **no se exige eliminar, controlar ventas ni usar transacciones múltiples**. Cada operación del DAO abre/cierra su Connection, PreparedStatement y ResultSet con try-with-resources. SQL solo en DAO, consola solo en vista y credenciales fuera del código. Una SQLException debe propagarse hasta el controlador para comunicar un fallo real; no devolver lista vacía o cero como sustituto del error.

## Criterios de comprobación

- El modelo rechaza stock negativo y nombre vacío.
- La vista no importa java.sql y el DAO no usa Scanner ni println.
- La actualización utiliza el id real y no modifica otros productos.
- El stock sigue en 7 después del intento negativo y del reinicio.
- Cambiar el separador del listado de ` | ` a ` - ` solo requiere modificar la vista.

Entrega las clases en tu repositorio y una evidencia de registro, actualización válida, rechazo de -1 y persistencia. Explica el recorrido vista → controlador → DAO → MySQL y el regreso de los datos.

**Pistas:** abre una conexión nueva por operación del DAO; usa setInt para stock e id; cero filas y SQLException son resultados distintos. Puedes adaptar la estructura del demo01, pero debes implementar las consultas y reglas del inventario. Completa en casa lo pendiente.

[Volver a la sesión](../../README.md)
