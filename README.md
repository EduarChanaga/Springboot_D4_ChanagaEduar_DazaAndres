# Documentación de la API de Gestión de Inventario

## Descripción General

La API de Gestión de Inventario es una aplicación que permite gestionar productos en un sistema de inventario. Se compone de un backend desarrollado con Spring Boot y un frontend creado con HTML, CSS y JavaScript. Esta aplicación permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre los productos.

## Tecnologías Utilizadas

### Backend

- **Java**: Lenguaje de programación principal para desarrollar la API.
- **Spring Boot**: Framework que simplifica la creación de aplicaciones Java, proporcionando configuraciones automáticas y funcionalidades integradas.
- **Spring Data JPA**: Facilita la interacción con bases de datos a través de JPA (Java Persistence API).
- **Hibernate**: Implementación de JPA que gestiona la persistencia de datos en la base de datos.
- **MySQL**: Sistema de gestión de bases de datos relacional que almacena la información de los productos.

### Frontend

- **HTML**: Lenguaje de marcado utilizado para estructurar el contenido de la interfaz de usuario.
- **CSS**: Hojas de estilo que se utilizan para dar formato y mejorar la presentación visual de la aplicación.
- **JavaScript**: Lenguaje de programación que permite interactuar con la API y manejar eventos del usuario, proporcionando una experiencia dinámica.

## Estructura del Proyecto

### Backend

El backend incluye controladores, servicios y repositorios para gestionar la lógica de negocio y la persistencia de datos:

- **Controlador (`ProductoApiController`)**: Maneja las solicitudes HTTP y define los endpoints de la API.
- **Servicio (`ProductoServicio`)**: Contiene la lógica para la manipulación de productos.
- **Repositorio (`ProductoRepositorio`)**: Interactúa con la base de datos para realizar operaciones CRUD.

### Frontend

El frontend proporciona una interfaz de usuario interactiva donde los usuarios pueden:

- Ver todos los productos.
- Agregar nuevos productos.
- Modificar productos existentes.
- Eliminar productos.

La comunicación entre el frontend y el backend se realiza mediante llamadas a la API REST.

## Documentación de la API

Para una descripción detallada de los endpoints y sus especificaciones, visita la documentación en SwaggerHub:

[Documentación de la API en SwaggerHub](https://app.swaggerhub.com/apis-docs/chanaga250/sistema_inventario/1.0.0#/)

### Endpoints Principales

#### Productos

1. **Obtener todos los productos**
   - **Método**: `GET /api/productos`
   - **Descripción**: Retorna una lista de todos los productos.

2. **Obtener un producto por ID**
   - **Método**: `GET /api/productos/{id}`
   - **Descripción**: Retorna el producto correspondiente al ID especificado.

3. **Crear un nuevo producto**
   - **Método**: `POST /api/productos`
   - **Descripción**: Crea un nuevo producto. Se requiere un cuerpo de solicitud en formato JSON con los detalles del producto.

4. **Modificar un producto existente**
   - **Método**: `PUT /api/productos/{id}`
   - **Descripción**: Actualiza un producto existente. Se requiere el ID del producto y un cuerpo de solicitud en formato JSON.

5. **Eliminar un producto**
   - **Método**: `DELETE /api/productos/{id}`
   - **Descripción**: Elimina el producto correspondiente al ID especificado.

## Propiedades de Configuración del Backend

Las siguientes propiedades están configuradas en la aplicación para establecer la conexión a la base de datos:

```properties
spring.application.name=sistema_de_inventario
spring.datasource.url=jdbc:mysql://172.16.101.109:3306/gestion_inventario
spring.datasource.username=root
spring.datasource.password=1095916023
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

- **spring.application.name**: Nombre de la aplicación.
- **spring.datasource.url**: URL de conexión a la base de datos.
- **spring.datasource.username**: Usuario de la base de datos.
- **spring.datasource.password**: Contraseña de la base de datos.
- **spring.jpa.hibernate.ddl-auto**: Estrategia de creación de esquema.
- **spring.jpa.show-sql**: Muestra las consultas SQL en la consola.
- **spring.jpa.properties.hibernate.dialect**: Dialecto de Hibernate para MySQL.

Para más información y detalles sobre los endpoints, consulta la [documentación de la API en SwaggerHub](https://app.swaggerhub.com/apis-docs/chanaga250/sistema_inventario/1.0.0#/).


## Diagramas para la base de datos

 ![image](https://github.com/user-attachments/assets/daf31ab9-f25e-4612-b28d-d24a749cb0f9)

 ![image](https://github.com/user-attachments/assets/e5325019-3a17-4817-a5f0-aa1a285395d3)

![image](https://github.com/user-attachments/assets/b9f688b1-8f9b-4c54-b135-c42d296909f9)

