-- Lab01 · Inventario
-- Ejecuta este script una sola vez en MySQL Workbench.

CREATE DATABASE IF NOT EXISTS campus_java_s18;
USE campus_java_s18;

CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    stock INT NOT NULL,
    CHECK (stock >= 0)
);

-- Producto de ejemplo (opcional)
INSERT INTO productos (nombre, stock) VALUES ('Marcador', 15);

SELECT * FROM productos;
