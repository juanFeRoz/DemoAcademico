# demoacademico Microservices

Este repositorio contiene una demo de microservicios con dos servicios Spring Boot:

- `auth-service` — Servicio de autenticación/validación en el puerto `8081`
- `consulta-service` — Servicio consumidor/consulta en el puerto `8082`

Ambos servicios están configurados para ejecutarse con Spring Boot y OpenFeign.

## Requisitos previos

- Java 21
- Maven
- Docker y Docker Compose 

### Compilar auth-service

```bash
cd /home/juanfelipe/IdeaProjects/demoacademico/microservicios-demoacademico/auth-service
./mvnw clean package -DskipTests
```

### Compilar consulta-service

```bash
cd /home/juanfelipe/IdeaProjects/demoacademico/microservicios-demoacademico/consulta-service
./mvnw clean package -DskipTests
```

El `consulta-service` depende de `auth-service` y utiliza la propiedad `services.auth.url` para conectarse a él.

## Ejecutar con Docker Compose

Desde `microservicios-demoacademico`:

```bash
cd /home/juanfelipe/IdeaProjects/demoacademico/microservicios-demoacademico
docker compose up --build
```

Esto construirá e iniciará ambos servicios:

- `auth-service` mapeado a `http://localhost:8081`
- `consulta-service` mapeado a `http://localhost:8082`

## Consumo paso a paso en Swagger

Sigue este orden obligatorio para la prueba:

1. Levantar `auth-service`.
2. Levantar `consulta-service`.
3. Probar `POST /auth/login` en Swagger de `auth-service`.
4. Copiar el token generado.
5. Usar el botón `Authorize` en Swagger de `consulta-service`.
6. Consumir el endpoint protegido `GET /api/estudiantes`.

### Abrir Swagger de auth-service

`http://localhost:8081/swagger-ui.html`

### Ejecutar el login

Ubique `POST /auth/login`, pulse `Try it out` y envíe:

```json
{
  "username": "admin",
  "password": "Admin2026*"
}
```

### Copiar el token

La respuesta será similar a:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiQURNSU4iLCJzdWIiOiJhZG1pbiIsImlhdCI6MT...",
  "type": "Bearer"
}
```

Copie únicamente el valor del campo `token`. No copie la palabra `token`, ni las llaves, ni el prefijo `Bearer`.

### Validar manualmente el token

En `GET /auth/validate` pegue solo el token como parámetro.

La respuesta esperada será similar a:

```json
{
  "valid": true,
  "username": "admin",
  "role": "ADMIN"
}
```

### Abrir Swagger de consulta-service

`http://localhost:8082/swagger-ui.html`

### Usar el botón Authorize

- Ubique el botón `Authorize` en la parte superior de Swagger.
- Haga clic allí.
- Pegue solo el token, sin la palabra `Bearer`.
- Haga clic en `Authorize`.
- Cierre la ventana emergente.

No debe escribirse esto:

```text
Bearer eyJhbGciOiJIUzI1NiJ9...
```

Debe pegarse así:

```text
eyJhbGciOiJIUzI1NiJ9...
```

### Consumir GET /api/estudiantes

- Despliegue el endpoint `GET /api/estudiantes`.
- Pulse `Try it out`.
- Complete, si lo desea, parámetros como `page` y `size`.
- Pulse `Execute`.

Swagger enviará automáticamente el encabezado:

`Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...`

La respuesta exitosa debería devolver una estructura similar a:

```json
{
  "success": true,
  "message": "OK",
  "data": {
    "content": [
      {
        "id": 1,
        "nombre": "Juan",
        "apellido": "Pérez",
        "email": "estudiante0@demoacademico.edu",
        "edad": 18
      }
    ]
  }
}
```

### Errores frecuentes

Si el token no se carga correctamente en `Authorize`, puede aparecer:

- `Token no enviado o formato inválido`

Si el token es incorrecto, incompleto o vencido, puede aparecer:

- `Token inválido o expirado`

## Consola H2

Para `consulta-service`, la consola H2 en memoria está disponible en:

- `http://localhost:8082/h2-console`

URL de la base de datos:

- `jdbc:h2:mem:demoacademico`
