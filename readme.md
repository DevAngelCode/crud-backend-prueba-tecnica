# CRUD Backend - Prueba técnica

API REST del CRUD de clientes.

## Stack

- Java 21
- Spring Boot 4
- Spring Data JPA
- MySQL 8
- Maven

## Requisitos

- JDK 21
- Maven (o usar el wrapper `./mvnw`)
- MySQL 8 corriendo localmente

## Base de datos

El proyecto usa la base `customer_db` con la tabla `customers` (1000 registros de prueba).

### Crear la base de datos

Ejecuta el script `datos inciales.sql` (incluido en la raíz del proyecto) en tu MySQL:

```bash
mysql -u root -p < "datos inciales.sql"
```

### Estructura de `customers`

| Campo               | Tipo         | Descripción                        |
| ------------------- | ------------ | ---------------------------------- |
| `id`                | BIGINT       | Identificador autogenerado (PK)    |
| `customer_id`       | VARCHAR(50)  | Identificador del cliente          |
| `first_name`        | VARCHAR(100) | Nombre                             |
| `last_name`         | VARCHAR(100) | Apellido                           |
| `company`           | VARCHAR(150) | Empresa                            |
| `city`              | VARCHAR(100) | Ciudad                             |
| `country`           | VARCHAR(100) | País                               |
| `phone_1`           | VARCHAR(50)  | Teléfono principal                 |
| `phone_2`           | VARCHAR(50)  | Teléfono secundario                |
| `email`             | VARCHAR(150) | Correo electrónico                 |
| `subscription_date` | DATE         | Fecha de suscripción               |
| `website`           | VARCHAR(255) | Sitio web                          |

## Configuración

Los valores se configuran con variables de entorno (hay valores por defecto para desarrollo):

| Variable       | Valor por defecto                            |
| -------------- | -------------------------------------------- |
| `SERVER_PORT`  | `8080`                                       |
| `DB_URL`       | `jdbc:mysql://localhost:3306/customer_db`    |
| `DB_USERNAME`  | `root`                                       |
| `DB_PASSWORD`  | `1234`                                       |
| `JPA_SHOW_SQL` | `true`                                       |

## Ejecutar

```bash
./mvnw spring-boot:run
```

La API queda disponible en `http://localhost:8080`.

## API

Base: `/api/v1/customers`

| Método | Ruta         | Descripción                                         |
| ------ | ------------ | --------------------------------------------------- |
| GET    | `/`          | Lista paginada (parámetros `page` y `size`)         |
| GET    | `/{id}`      | Busca un cliente por id                             |
| POST   | `/`          | Crea un cliente                                     |
| PUT    | `/{id}`      | Actualiza un cliente                                |
| DELETE | `/{id}`      | Elimina un cliente                                  |

### Parámetros de listado

| Parámetro    | Tipo   | Default | Descripción                            |
| ------------ | ------ | ------- | -------------------------------------- |
| `page`       | int    | `0`     | Página (0-based)                       |
| `size`       | int    | `10`    | Registros por página (máx 100)         |
| `customerId` | string | -       | Busca por código de cliente (parcial)  |

### Respuesta de listado

```json
{
  "content": [ { "id": 1, "customerId": "dE014d010c7ab0c", "...": "..." } ],
  "page": 0,
  "size": 10,
  "totalElements": 1000,
  "totalPages": 100
}
```

## Ejemplos

### Crear cliente

```bash
curl -X POST http://localhost:8080/api/v1/customers \
  -H "Content-Type: application/json" \
  -d '{
    "customerId": "abc123",
    "firstName": "Juan",
    "lastName": "Perez",
    "email": "juan@correo.com",
    "subscriptionDate": "2024-01-15"
  }'
```

### Listar página 2

```bash
curl "http://localhost:8080/api/v1/customers?page=1&size=10"
```

### Buscar por código

```bash
curl "http://localhost:8080/api/v1/customers?customerId=abc"
```

## Tests

```bash
./mvnw test
```