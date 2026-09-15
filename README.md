# SpringEduManager

SpringEduManager es una aplicación web desarrollada con Spring Boot para la gestión de estudiantes y cursos.

El proyecto utiliza una arquitectura por capas, separando controladores, servicios, repositorios y modelos, con el objetivo de mantener una estructura organizada y facilitar el mantenimiento de la aplicación.

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

- Registrar estudiantes.
- Listar estudiantes.
- Consultar estudiantes mediante API REST.
- Actualizar estudiantes mediante API REST.
- Eliminar estudiantes mediante API REST.

### Gestión de cursos

La aplicación permite:

- Registrar cursos.
- Listar cursos.
- Consultar cursos mediante API REST.
- Actualizar cursos mediante API REST.
- Eliminar cursos mediante API REST.

## Arquitectura del proyecto

El proyecto está organizado en diferentes capas:

- `controller`: recibe y procesa las solicitudes HTTP.
- `service`: contiene la lógica de negocio de la aplicación.
- `repository`: gestiona el acceso a datos utilizando Spring Data JPA.
- `model`: contiene las entidades principales del sistema.
- `config`: contiene la configuración de seguridad de la aplicación.

Esta separación permite mantener responsabilidades claras dentro del proyecto.

## Seguridad

SpringEduManager utiliza Spring Security para controlar el acceso a diferentes funcionalidades.

Existen dos roles principales:

### ADMIN

El usuario ADMIN puede:

- Visualizar estudiantes.
- Registrar estudiantes.
- Visualizar cursos.
- Registrar nuevos cursos.
- Acceder a los endpoints REST.

### USER

El usuario USER puede:

- Visualizar estudiantes.
- Registrar estudiantes.
- Visualizar cursos.
- Acceder a los endpoints REST.

El formulario para registrar nuevos cursos solo se muestra a usuarios con rol ADMIN.

La aplicación cuenta además con un formulario personalizado de inicio de sesión y una opción para cerrar sesión.

## Base de datos

La aplicación utiliza MySQL.

La base de datos utilizada es:

`springedumanager`

El acceso a la base de datos se configura mediante variables de entorno para evitar almacenar credenciales directamente en el código fuente.

El archivo:

`application.properties.example`

incluye una configuración de referencia para ejecutar el proyecto localmente.

## Cómo ejecutar la aplicación

1. Clonar o descargar el repositorio.
2. Crear la base de datos `springedumanager` en MySQL.
3. Configurar las variables de entorno necesarias para la conexión a la base de datos y los usuarios de seguridad.
4. Abrir el proyecto en un entorno compatible con Maven.
5. Ejecutar la aplicación Spring Boot.
6. Acceder a la aplicación desde el navegador.

## Pruebas de API

Los endpoints REST fueron probados utilizando Postman para verificar las operaciones de consulta, creación, actualización y eliminación de registros.

## Aprendizajes del proyecto

Durante el desarrollo de SpringEduManager trabajé principalmente en:

- Creación de aplicaciones web con Spring Boot.
- Implementación del patrón MVC.
- Uso de arquitectura por capas.
- Persistencia de datos con Spring Data JPA.
- Integración con MySQL.
- Creación y prueba de endpoints REST.
- Implementación de autenticación y autorización con Spring Security.
- Uso de roles para controlar acceso a funcionalidades.
- Uso de Thymeleaf para generar vistas dinámicas.
- Gestión de dependencias y ejecución del proyecto con Maven.
