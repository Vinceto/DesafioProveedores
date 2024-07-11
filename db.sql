CREATE TABLE proveedores (
    id SERIAL PRIMARY KEY,
    nombre varchar NOT NULL,
    rut varchar NOT null,
    direccion varchar NOT null,
    correo varchar NOT null,
    telefono varchar NOT null,
    contacto varchar NOT null,
    telefono_contacto varchar NOT null
);