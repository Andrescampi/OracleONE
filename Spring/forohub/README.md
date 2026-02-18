# 🗣️ Foro Hub - Challenge Backend Alura

API REST construida con **Spring Boot 3** y **Maven** que replica el funcionamiento del foro de Alura, permitiendo la gestión completa de tópicos con autenticación JWT.

---

## 🚀 Tecnologías

- Java 17
- Spring Boot 3.2
- Spring Security + JWT (Auth0)
- Spring Data JPA
- MySQL 8
- Flyway (migraciones de BD)
- Lombok
- SpringDoc / Swagger UI

---

## ⚙️ Configuración

### 1. Base de datos

Asegúrate de tener **MySQL** corriendo. Crea una base de datos (o deja que Flyway la cree automáticamente):

```sql
CREATE DATABASE forohub;
```

### 2. application.properties

Edita `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/forohub?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA

api.security.secret=tu-clave-secreta-segura
```

### 3. Ejecutar

```bash
./mvnw spring-boot:run
```

---

## 📋 Endpoints

### Autenticación
| Método | Ruta | Descripción |
|--------|------|-------------|
| POST | `/login` | Obtener token JWT |

**Body de login:**
```json
{
  "login": "admin@forohub.com",
  "password": "123456"
}
```

### Tópicos (requieren JWT en header `Authorization: Bearer <token>`)
| Método | Ruta | Descripción |
|--------|------|-------------|
| POST | `/topicos` | Crear tópico |
| GET | `/topicos` | Listar tópicos (paginado) |
| GET | `/topicos/{id}` | Detalle de tópico |
| PUT | `/topicos/{id}` | Actualizar tópico |
| DELETE | `/topicos/{id}` | Eliminar tópico (soft delete) |

---

## 📖 Documentación Swagger

Con la aplicación corriendo, visita:

```
http://localhost:8080/swagger-ui.html
```

---

## 🔑 Usuario de prueba (creado por Flyway)

- **Email:** `admin@forohub.com`
- **Password:** `123456`

---

## 📁 Estructura del proyecto

```
src/main/java/com/alura/forohub/
├── config/           # Seguridad y OpenAPI
├── controller/       # Controladores REST
├── dto/              # Objetos de transferencia
├── exception/        # Manejo de errores
├── model/            # Entidades JPA
├── repository/       # Repositorios Spring Data
├── security/         # Filtro JWT y TokenService
└── service/          # Lógica de negocio
```

---

## ✅ Funcionalidades implementadas

- ✅ CRUD completo de tópicos
- ✅ Autenticación JWT con Spring Security
- ✅ Validación de datos con Bean Validation
- ✅ Prevención de tópicos duplicados (mismo título o mensaje)
- ✅ Eliminación lógica (soft delete, campo `activo`)
- ✅ Paginación en listado de tópicos
- ✅ Migraciones de BD con Flyway
- ✅ Documentación Swagger UI
