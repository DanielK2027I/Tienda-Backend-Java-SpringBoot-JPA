# Tienda Backend - Java Spring Boot & JPA

Este es un proyecto de backend robusto para una tienda, desarrollado con **Java 17** y **Spring Boot**. El enfoque principal del proyecto es la implementación de una arquitectura limpia por capas y un sistema de seguridad avanzado.

## 🚀 Tecnologías Utilizadas

* **Java 17 + **
* **Spring Boot 4.0.5**
* **Spring Data JPA**: Para la persistencia de datos.
* **MySQL**: Base de datos relacional.
* **Argon2**: Algoritmo de hashing de última generación para la protección de contraseñas.
* **Maven**: Gestión de dependencias.

## 🔑 Características Principales

* **Autenticación Segura**: Uso de `Argon2PasswordEncoder` para garantizar que las contraseñas nunca se almacenen en texto plano, siguiendo los estándares más altos de la industria.
* **Arquitectura por Capas**: Separación clara de responsabilidades en `Controller`, `Service`, `Repository` y `Entity`.
* **Gestión de Usuarios y Roles**: Implementación de relaciones JPA para manejar permisos y perfiles de usuario.
* **Configuración Desacoplada**: Uso de `@Bean` para la gestión de seguridad, facilitando el mantenimiento y la escalabilidad.

## 🛠️ Estructura del Proyecto

* `config`: Configuraciones de seguridad y beans del sistema.
* `controllers`: Endpoints de la API REST.
* `entities`: Modelos de datos y mapeo relacional.
* `repositories`: Interfaces para el acceso a la base de datos (Spring Data JPA).
* `services`: Lógica de negocio y procesamiento de datos.

## ⚙️ Instalación

1.  Clonar el repositorio:
    ```bash
    git clone https://github.com/DanielK2027I/Tienda-Backend-Java-SpringBoot-JPA.git
    ```
2.  Configurar la base de datos en `src/main/resources/application.properties`.
3.  Instalar dependencias y compilar:
    ```bash
    mvn clean install
    ```
4.  Ejecutar la aplicación:
    ```bash
    mvn spring-boot:run
    ```

---
Desarrollado por [Juan Daniel](https://github.com/DanielK2027I)
