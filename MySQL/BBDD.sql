create database gestion_inventario;

use gestion_inventario;

CREATE TABLE producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    cantidad INT NOT NULL DEFAULT 0,
    precio DECIMAL(10, 2) NOT NULL,
    fecha_ingreso DATETIME DEFAULT CURRENT_TIMESTAMP,
    categoria VARCHAR(50)
);

insert producto(nombre, descripcion, cantidad, precio, fecha_ingreso, categoria) values
("pan","Rico pan",10,10000,"2024-05-15","Comestible");