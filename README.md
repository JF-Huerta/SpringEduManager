# SpringEduManager

SpringEduManager es una aplicación web desarrollada con Spring Boot para la gestión básica de estudiantes y cursos.

El proyecto fue desarrollado utilizando una arquitectura por capas, separando controladores, servicios, repositorios y modelos.

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- Thymeleaf
- MySQL
- Maven
- Postman

## Funcionalidades

### Gestión de estudiantes

La aplicación permite:

- Registrar estudiantes
- Listar estudiantes
- Consultar estudiantes mediante API REST
- Actualizar estudiantes mediante API REST
- Eliminar estudiantes mediante API REST

### Gestión de cursos

La aplicación permite:

- Registrar cursos
- Listar cursos
- Consultar cursos mediante API REST
- Actualizar cursos mediante API REST
- Eliminar cursos mediante API REST

## Seguridad

SpringEduManager utiliza Spring Security.

Existen dos roles:

### ADMIN

El usuario ADMIN puede:

- Visualizar estudiantes
- Registrar estudiantes
- Visualizar cursos
- Registrar nuevos cursos
- Acceder a los endpoints REST

### USER

El usuario USER puede:

- Visualizar estudiantes
- Registrar estudiantes
- Visualizar cursos
- Acceder a los endpoints REST

El formulario para registrar nuevos cursos solo se muestra a usuarios con rol ADMIN.

La aplicación cuenta además con un formulario personalizado de inicio de sesión y una opción para cerrar sesión.

## Base de datos

La aplicación utiliza MySQL.

La base de datos utilizada es:

```text
springedumanager