-- Lab00 · Biblioteca
-- Ejecuta este script una sola vez en MySQL Workbench.

CREATE DATABASE IF NOT EXISTS campus_java_s18;
USE campus_java_s18;

CREATE TABLE IF NOT EXISTS libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    isbn VARCHAR(20) NOT NULL UNIQUE
);

-- Libro de ejemplo (opcional)
INSERT INTO libros (titulo, isbn) VALUES ('Don Quijote de la Mancha', '9788420412146');

SELECT * FROM libros;
