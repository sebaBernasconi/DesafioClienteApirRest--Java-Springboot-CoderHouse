# API REST de Clientes

Este proyecto Java se centra en la creación de una tabla de clientes con los siguientes atributos: nombre, apellido y fecha de nacimiento. Además, incluye un Rest Controller que proporciona endpoints para acceder y manipular los datos de los clientes en formato JSON.

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

- `src/main/java`: Contiene el código fuente Java.
  - `com.example.cliente`: Paquete principal del proyecto.
    - `Cliente`: Clase que representa un cliente con los atributos nombre, apellido y fecha de nacimiento.
    - `ClienteController`: Rest Controller que maneja las solicitudes relacionadas con los clientes y devuelve respuestas en formato JSON.
    - `ClienteRepository`: Permite las consultas a la base de datos a traves de la interfaz de JPA
    - `MainApplication`: Clase principal que inicia la aplicación Spring Boot.

## Configuración y Uso

1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu entorno de desarrollo Java preferido.
3. Asegúrate de tener instalado Java y Maven en tu sistema.
4. Configura la base de datos en el archivo `application.properties` según tu entorno.
5. Ejecuta la aplicación Spring Boot utilizando el comando `mvn spring-boot:run`.
6. Accede a los endpoints del Rest Controller para interactuar con los datos de los clientes.

## Endpoints

El Rest Controller `ClienteController` proporciona los siguientes endpoints:

- `GET /clientes`: Obtiene todos los clientes en formato JSON.
- `GET /clientes/{id}`: Obtiene un cliente específico por su ID en formato JSON.
- `POST /clientes`: Crea un nuevo cliente con los datos proporcionados en el cuerpo de la solicitud.
- `PUT /clientes/{id}`: Actualiza los datos de un cliente existente identificado por su ID.
- `DELETE /clientes/{id}`: Elimina un cliente existente por su ID.
