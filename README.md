# InternetCheckpoint Back

API REST del proyecto InternetCheckpoint, desarrollada con Spring Boot, que da servicio a la web front.

InternetCheckpoint es una red social donde los usuarios pueden compartir sus vivencias mediante publicaciones, decorándolas con diferentes temas, y comentar sobre las publicaciones de otros usuarios.

## Requisitos

### Entornos recomendados

* [MySQL Workbench](https://www.mysql.com/products/workbench) (para base de datos local)
* [Spring Tool Suite 4](https://spring.io/tools)

### Recursos del proyecto

* [Maven 3.9.6](https://maven.apache.org)
* [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

## Arranque

### Desde línea de comandos

Desde la raíz del repositorio, ejecutar:

```
mvn spring-boot:run
```

### Desde Spring Tool Suite

1. Abrir el repositorio `internetcheckpoint-back`.
2. En el Boot Dashboard, seleccionar `internetCheckpoint-back` y arrancar.

## Empaquetado para despliegue

```
mvn clean package
```

## Direcciones del API

* [http://localhost:8080/api/v1/usuarios](http://localhost:8080/api/v1/usuarios)
* [http://localhost:8080/api/v1/publicaciones](http://localhost:8080/api/v1/publicaciones)
* [http://localhost:8080/api/v1/comentarios](http://localhost:8080/api/v1/comentarios)
* [http://localhost:8080/api/v1/tags](http://localhost:8080/api/v1/tags)

## Documentación Swagger UI

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Base de datos SQL

### Conexión remota

Por defecto, la base de datos está configurada de forma remota. La configuración de conexión se encuentra en:

`src/main/resources/application.properties`

### Conexión local

Para utilizar la base de datos de forma local es necesario montarla en MySQL Workbench:

1. Crear la base de datos con nombre `internetcheckpointdb`.
2. Ejecutar los scripts SQL de esquema (schema) en orden.
3. Ejecutar los scripts SQL de datos en orden.

#### Scripts de esquema

Ejecutar los scripts SQL de la carpeta `sql/schema` en el siguiente orden:

1. `01_internetcheckpointdb_usuario`
2. `02_internetcheckpointdb_tag`
3. `03_internetcheckpointdb_publicacion`
4. `04_internetcheckpointdb_comentario`

#### Scripts de datos

Ejecutar los scripts SQL de la carpeta `sql/datos`.
