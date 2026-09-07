# CRUD - Prueba Técnica

Backend desarrollado como parte de una prueba técnica.

## Tecnologías

* Java 21
* Spring Boot 4
* Spring Data JPA
* MySQL
* Maven

## Base de datos

El proyecto utiliza **MySQL** como sistema de gestión de base de datos.

### Base de datos

```sql
customer_db
```

### Tabla

```sql
customers
```

La tabla contiene información de clientes proveniente de un archivo CSV de prueba.

### Estructura de `customers`


| Campo               | Tipo         | Descripción                        |
| ------------------- | ------------ | ---------------------------------- |
| `id`                | BIGINT       | Identificador interno autogenerado |
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

### Registros

La base de datos contiene **1000 registros de clientes** para realizar el crud.

## Estructura de la base de datos

```text
customer_db
└── customers
    ├── id
    ├── customer_id
    ├── first_name
    ├── last_name
    ├── company
    ├── city
    ├── country
    ├── phone_1
    ├── phone_2
    ├── email
    ├── subscription_date
    └── website
```

## CRUD

El backend implementará las siguientes operaciones:

