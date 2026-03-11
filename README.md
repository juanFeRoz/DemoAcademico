# Lab 03 — Sistema Académico

## ¿Cómo ejecutar?

1. Clonar el repositorio y abrir el proyecto en IntelliJ IDEA (o tu IDE favorito).
2. Asegurarse de tener **Java 17+** y **Maven** instalados.
3. Ejecutar la clase principal:

```
DemoAcademicoApplication.java
```

La aplicación arranca en: `http://localhost:8080`

---

## URLs importantes

| Herramienta | URL |
|-------------|-----|
| Swagger UI  | http://localhost:8080/swagger-ui.html |
| H2 Console  | http://localhost:8080/h2-console |

**Credenciales H2:**
- JDBC URL: `jdbc:h2:mem:testdb`
- Usuario: `sa`
- Contraseña: *(vacía)*

---

## Ports creados (Parte 2)

### `EstudianteQueryPort`
**Paquete:** `co.edu.demoacademico.estudiantes.port`

Punto de acceso público que expone la consulta de un estudiante por ID desde el módulo `estudiantes`.

```java
public interface EstudianteQueryPort {
    Estudiante obtenerPorId(Long id);
}
```

Implementado por: `EstudianteServiceImpl`

---

### `GrupoQueryPort`
**Paquete:** `co.edu.demoacademico.grupos.port`

Punto de acceso público que expone la consulta de un grupo por ID desde el módulo `grupos`.

```java
public interface GrupoQueryPort {
    Grupo obtenerPorId(Long id);
}
```

Implementado por: `GrupoServiceImpl`

---