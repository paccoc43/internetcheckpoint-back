# InternetCheckpointBack

* [Rama main](https://github.com/paccoc43/internetcheckpoint-back)
* [Rama develop](https://github.com/paccoc43/internetcheckpoint-back/tree/develop)

## Requerimientos

Descomprimir dev.zip en C:\

Entornos necesarios


* [MySQL Workbench](https://www.mysql.com/products/workbench) (Local)
* [Spring Tool Suite 4](https://spring.io/tools) 

El proyecto utiliza los siguientes recursos

* [Maven 3.9.6](https://maven.apache.org) 
* [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) 

## Arranque desde cmd

Ejecutar el archivo env-1.cmd


    $ mvn spring-boot:run

## Arranque desde SpringToolSuite

* Abrir repositorio internetcheckpoint-back
* En Boot Dashboard seleccionar internetCheckpoint-back y arrancar 

## Direcciones del API

[http://localhost:8080/api/v1/usuarios](http://localhost:8080/api/v1/usuarios)

[http://localhost:8080/api/v1/publicaciones](http://localhost:8080/api/v1/publicaciones)

[http://localhost:8080/api/v1/comentarios](http://localhost:8080/api/v1/comentarios)

[http://localhost:8080/api/v1/tags](http://localhost:8080/api/v1/tags)

## Empaquetado para Despliegue

    $ mvn clean package

# Base de datos SQL

## Conexión remota

Por defecto se encuentra configurada de forma remota y la configuracion de conexion con la base de datos se encuentra aqui:

* C:\dev\repositorios\internetCheckpoint-back\src\main\resources\application.properties


## Conexión local

Para utilizar la base de datos de forma local necesitamos montarla en MySQL Workbench

    - Crear la base de datos nombre_bd: internetcheckpointdb
    - Ejecutar Scripts SQL de Schema en orden
    - Ejecutar Scripts SQL de datos en orden

## Schema

Ejecutar los scripts sql de la carpeta "C:\dev\instalacion\sql\schema" en el siguiente orden

* 01_internetcheckpointdb_usuario
* 02_internetcheckpointdb_tag
* 03_internetcheckpointdb_publicacion
* 04_internetcheckpointdb_comentario


## Datos

Ejecutar los scripts sql de la carpeta "C:\dev\instalacion\sql\datos"