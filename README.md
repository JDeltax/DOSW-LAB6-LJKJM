# DOSW-LAB6-LJKJM
Laboratorio 6 de DOSW

## Seccion 5 - Cobertura con JaCoCo

- Rama de trabajo: `feature/jacoco-dependency`
- Plugin agregado en `pom.xml`: `org.jacoco:jacoco-maven-plugin:0.8.14`
- Comando de validacion: `mvn clean verify`
- Reporte HTML: `target/site/jacoco/index.html`

### Cobertura

- Primera cobertura obtenida (antes de ampliar pruebas):
	- Line coverage: `70.53%`
	- Instruction coverage: `71.79%`
- Ultima cobertura obtenida (despues de ampliar pruebas):
	- Line coverage: `90.53%`
	- Instruction coverage: `89.94%`

Nota: si necesitan capturas para la entrega, se toman desde `target/site/jacoco/index.html`.

## Seccion 6 - Análisis de Calidad con SonarQube

- Rama de trabajo: `feature/sonarqube`
- Plugin agregado en `pom.xml`: `org.sonarsource.scanner.maven:sonar-maven-plugin:3.11.0.3922`

### Opción 1: SonarQube Local con Docker

Ejecuta SonarQube en tu máquina local usando Docker.

**Requisitos:**
- Docker Desktop instalado y ejecutándose

**Pasos:**

1. **Iniciar el servidor SonarQube:**
```bash
docker run -d --name sonarqube -p 9000:9000 sonarqube:lts-community
```

2. **Acceder a la interfaz web:**
- URL: http://localhost:9000
- Credenciales iniciales: `admin` / `admin` (te pedirá cambiarla)

3. **Configurar el proyecto:**
- Crear proyecto manualmente
- Generar un token de acceso
- Agregar el token en las propiedades del `pom.xml`:
```xml
<sonar.host.url>http://localhost:9000</sonar.host.url>
<sonar.projectKey>edu.eci.dosw:Library</sonar.projectKey>
<sonar.login>TU_TOKEN_AQUI</sonar.login>
```

4. **Ejecutar el análisis:**
```bash
mvn clean verify sonar:sonar
```

5. **Ver resultados:** http://localhost:9000/dashboard

**Comandos útiles de Docker:**
```bash
docker ps                  # Ver contenedores activos
docker stop sonarqube     # Detener SonarQube
docker start sonarqube    # Reiniciar SonarQube
docker rm -f sonarqube    # Eliminar contenedor
```

### Opción 2: SonarCloud (Nube) ✅ *Implementado*

Utiliza SonarCloud, la versión en la nube de SonarQube. **Gratis para proyectos públicos.**

**Ventajas:**
- No requiere Docker ni instalación local
- Accesible desde cualquier lugar
- Integración automática con GitHub
- No consume recursos locales

**Pasos:**

1. **Registrarse en SonarCloud:**
- Ir a https://sonarcloud.io
- Iniciar sesión con GitHub

2. **Crear organización y proyecto:**
- Crear una organización (o usar existente)
- Crear proyecto manualmente
- Copiar el `Organization Key` y generar un token

3. **Configurar propiedades en `pom.xml`:**
```xml
<sonar.host.url>https://sonarcloud.io</sonar.host.url>
<sonar.organization>kevincuitiva</sonar.organization>
<sonar.projectKey>DOSW-LAB6-LJKJM</sonar.projectKey>
<sonar.login>TU_TOKEN_AQUI</sonar.login>
```

4. **Ejecutar el análisis:**
```bash
mvn clean verify sonar:sonar
```

5. **Ver resultados:** https://sonarcloud.io/dashboard?id=DOSW-LAB6-LJKJM

### Integración con JaCoCo

Ambas opciones utilizan los reportes de cobertura de JaCoCo:

```xml
<sonar.java.coveragePlugin>jacoco</sonar.java.coveragePlugin>
<sonar.coverage.jacoco.xmlReportPaths>${project.build.directory}/site/jacoco/jacoco.xml</sonar.coverage.jacoco.xmlReportPaths>
```

### Métricas Analizadas

SonarQube/SonarCloud proporciona:
- **Bugs**: Errores de código que pueden causar fallos
- **Vulnerabilidades**: Problemas de seguridad
- **Code Smells**: Problemas de mantenibilidad
- **Coverage**: Cobertura de pruebas (desde JaCoCo)
- **Duplicación**: Código duplicado
- **Complejidad**: Complejidad ciclomática
