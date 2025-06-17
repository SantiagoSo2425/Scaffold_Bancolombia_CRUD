# CRUD de Usuarios – Scaffold Clean Architecture Bancolombia

[![Build Status](https://github.com/SantiagoSo2425/Scaffold_Bancolombia/actions/workflows/ci-cd.yml/badge.svg)](https://github.com/SantiagoSo2425/Scaffold_Bancolombia/actions/workflows/ci-cd.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=SantiagoSo2425_Scaffold_Bancolombia&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=SantiagoSo2425_Scaffold_Bancolombia)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=SantiagoSo2425_Scaffold_Bancolombia&metric=coverage)](https://sonarcloud.io/summary/new_code?id=SantiagoSo2425_Scaffold_Bancolombia)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://adoptium.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen.svg)](https://spring.io/projects/spring-boot)

## 🧾 Descripción del Proyecto
Este proyecto es un CRUD (Crear, Leer, Actualizar, Eliminar) de usuarios, desarrollado utilizando el **Scaffold Clean Architecture** de Bancolombia. El objetivo es demostrar cómo implementar un sistema básico de gestión de usuarios siguiendo las mejores prácticas de arquitectura limpia, ideal para entornos bancarios o empresariales.

## 🧱 Arquitectura
El proyecto sigue la arquitectura limpia propuesta por Bancolombia, que separa claramente las responsabilidades en diferentes capas:

- **Dominio**: Entidades del negocio y contratos de los casos de uso.
- **Aplicación**: Implementación de la lógica de negocio.
- **Infraestructura**: Adaptadores a tecnologías externas (bases de datos, APIs, etc.).
- **Entrada/Salida**: Controladores REST y configuración de entrada.


## 📜 Documentación de la API
La documentación de la API está disponible a través de Swagger. Una vez que la aplicación esté en ejecución, puedes acceder a la documentación en:
http://localhost:8080/swagger-ui/index.html

---

## 💛 Carta de Motivación

Quiero expresar mi profundo interés y compromiso por ser parte de Bancolombia. Elegí este proyecto y el uso del Scaffold Clean Architecture porque admiro la innovación, solidez y cultura de Bancolombia. Mi sueño es aportar mi conocimiento, pasión y energía a una organización que transforma vidas y el país. Estoy convencido de que mi perfil y valores encajan con la visión de Bancolombia, y este proyecto es una muestra de mi dedicación y ganas de crecer junto a ustedes.

---

## 🚀 Buenas Prácticas y Calidad
- **Pruebas Unitarias y de Integración**: El proyecto cuenta con pruebas para asegurar la calidad y el correcto funcionamiento de la lógica de negocio.
- **Swagger OpenAPI**: Documentación interactiva de la API disponible en `/swagger-ui.html`.
- **SonarQube**: Listo para integración con análisis de calidad de código. Ejecute `run-sonar-analysis.bat` para iniciar el análisis (requiere SonarQube Server en http://localhost:9000).
- **Actuator y Prometheus**: Métricas expuestas para monitoreo.
- **Docker**: Incluye Dockerfile para despliegue sencillo.
- **CI/CD**: Preparado para integración continua (ejemplo con GitHub Actions).

---

## 🏦 ¿Por qué Bancolombia?
- Es una empresa líder en innovación financiera en Latinoamérica.
- Su cultura de trabajo y enfoque en las personas me inspira.
- Quiero crecer profesionalmente en un entorno que fomente el aprendizaje y la excelencia.
- Me identifico con su propósito de transformar vidas y aportar al desarrollo del país.

---

## 📝 Personalización Bancolombia
- El proyecto utiliza el Scaffold oficial de Bancolombia.
- Se agregaron mensajes y documentación alineados con la cultura y valores de la organización.
- La API incluye endpoints documentados y listos para ser consumidos por equipos internos o externos.

---

## 🔍 Análisis de Calidad con SonarQube

### Requisitos previos
1. **SonarQube Server**: Asegúrese de tener un servidor SonarQube ejecutándose en http://localhost:9000
   - Para instalar SonarQube localmente puede usar Docker:
     ```
     docker run -d --name sonarqube -p 9000:9000 sonarqube:latest
     ```

2. **Configuración**: El proyecto ya viene configurado con todos los archivos necesarios:
   - `sonar-project.properties`: Contiene la configuración básica del proyecto
   - `build.gradle`: Incluye el plugin de SonarQube y sus configuraciones
   - `run-sonar-analysis.bat`: Script para ejecutar el análisis

### Ejecutar análisis
1. Ejecute el script desde la raíz del proyecto:
   ```
   ./run-sonar-analysis.bat
   ```

2. El script realizará los siguientes pasos:
   - Verificará que SonarQube esté disponible localmente
   - Ejecutará las pruebas del proyecto
   - Generará reportes de cobertura con JaCoCo
   - Solicitará un token de autenticación de SonarQube

3. Para generar el token de autenticación requerido:
   - Acceda a http://localhost:9000 en su navegador
   - Inicie sesión con sus credenciales (por defecto admin/admin en la primera instalación)
   - Vaya a su perfil (haga clic en su avatar en la esquina superior derecha) > Mi cuenta > Seguridad
   - Genere un nuevo token con un nombre descriptivo (por ejemplo "scaffold-bancolombia-token")
   - Copie el token generado y péguelo cuando el script lo solicite

4. Una vez completado el análisis, abra http://localhost:9000 en su navegador para ver los resultados:
   - Métricas de calidad de código
   - Cobertura de pruebas
   - Vulnerabilidades de seguridad
   - Deuda técnica
   - Código duplicado
   - Complejidad ciclomática

### Consejos para la resolución de problemas
- Si enfrenta problemas de autenticación, asegúrese de haber generado correctamente el token en SonarQube
- Para análisis recurrentes, considere almacenar el token en una variable de entorno para evitar ingresarlo cada vez
- Si hay problemas con archivos de reporte que no existen, verifique la configuración en `build.gradle` y comente las líneas problemáticas

### Personalización
Si necesita personalizar el análisis, puede modificar el archivo `sonar-project.properties` o la sección `sonar` en `build.gradle` para ajustar:
- Exclusiones de archivos o directorios
- Inclusiones específicas
- Reglas y umbrales de calidad
- Configuraciones de plugins

## 📊 Monitoreo con Actuator y Prometheus

El proyecto está configurado con Spring Boot Actuator y Prometheus para el monitoreo de la aplicación en tiempo real. Estas herramientas permiten supervisar el estado, el rendimiento y las métricas de la aplicación.

### Actuator

Spring Boot Actuator proporciona endpoints HTTP para monitorear y gestionar la aplicación:

1. **Endpoints disponibles**:
   - `/actuator/health`: Estado de salud de la aplicación
   - `/actuator/prometheus`: Métricas en formato Prometheus
   - `/actuator/info`: Información de la aplicación
   - `/actuator/metrics`: Métricas detalladas de la aplicación
   - `/actuator/env`: Variables de entorno y propiedades
   - `/actuator/loggers`: Configuración de loggers
   - `/actuator/mappings`: Mappings de endpoints de la aplicación
   - `/actuator/beans`: Beans de Spring disponibles

2. **Verificar el estado de la aplicación**:
   ```
   curl http://localhost:8080/actuator/health
   ```

3. **Ver métricas específicas**:
   ```
   curl http://localhost:8080/actuator/metrics/jvm.memory.used
   ```

### Prometheus

Prometheus es un sistema de monitoreo y alerta que recopila y almacena métricas como series temporales.

1. **Métricas personalizadas implementadas**:
   - `api.users.get.count`: Contador de solicitudes para obtener usuarios
   - `api.users.create.count`: Contador de solicitudes para crear usuarios
   - `api.users.update.count`: Contador de solicitudes para actualizar usuarios
   - `api.users.delete.count`: Contador de solicitudes para eliminar usuarios
   - `api.users.error.count`: Contador de errores en operaciones de usuarios
   - `api.users.get.time`: Tiempo de respuesta para obtener usuarios
   - `api.users.create.time`: Tiempo de respuesta para crear usuarios
   - `api.users.update.time`: Tiempo de respuesta para actualizar usuarios
   - `api.users.delete.time`: Tiempo de respuesta para eliminar usuarios

2. **Configurar Prometheus localmente**:
   - Descargue Prometheus desde [prometheus.io](https://prometheus.io/download/)
   - Cree un archivo `prometheus.yml` con el siguiente contenido:
     ```yaml
     global:
       scrape_interval: 15s
     
     scrape_configs:
       - job_name: 'spring-actuator'
         metrics_path: '/actuator/prometheus'
         static_configs:
           - targets: ['localhost:8080']
     ```
   - Inicie Prometheus:
     ```
     ./prometheus --config.file=prometheus.yml
     ```
   - Acceda a la interfaz web de Prometheus en http://localhost:9090

### Grafana (Opcional)

Para visualizaciones más avanzadas, puede utilizar Grafana con Prometheus:

1. **Instalar Grafana**:
   - Descargue Grafana desde [grafana.com](https://grafana.com/grafana/download)
   - O utilice Docker:
     ```
     docker run -d -p 3000:3000 grafana/grafana
     ```

2. **Configurar Grafana**:
   - Acceda a Grafana en http://localhost:3000 (usuario/contraseña: admin/admin)
   - Añada Prometheus como fuente de datos:
     - Vaya a Configuration > Data Sources > Add data source
     - Seleccione Prometheus
     - URL: http://localhost:9090
     - Haga clic en "Save & Test"

3. **Importar dashboard**:
   - Vaya a Create > Import
   - Importe dashboard para Spring Boot (ID: 11378 o 10280)

### Uso en producción

Para entornos de producción, considere:

1. **Seguridad**: Restringir el acceso a los endpoints de Actuator con Spring Security
2. **Persistencia**: Configurar Prometheus para almacenar datos a largo plazo
3. **Alertas**: Configurar alertas en Prometheus o Grafana basadas en umbrales
4. **Escalabilidad**: Considerar soluciones como Prometheus Operator en Kubernetes

## 🐳 Despliegue con Docker

El proyecto incluye un Dockerfile optimizado para facilitar el despliegue de la aplicación en entornos containerizados.

### Características del Dockerfile

- **Imagen Base**: Utiliza Eclipse Temurin JDK 21 con Alpine Linux para minimizar el tamaño
- **Seguridad**: Ejecuta la aplicación como usuario no privilegiado (appuser)
- **Optimización JVM**: Configuración de memoria optimizada para contenedores
- **Healthcheck**: Verificación de salud automática usando Spring Boot Actuator
- **Exposición de puertos**: Puerto 8080 expuesto para acceso a la API y endpoints de monitoreo

### Construir la imagen Docker

Para construir la imagen Docker, ejecute desde la raíz del proyecto:

```bash
# Primero, construir el JAR con Gradle
./gradlew clean bootJar

# Copiar el JAR al directorio deployment
cp applications/app-service/build/libs/*.jar deployment/

# Construir la imagen Docker
docker build -t bancolombia/scaffold-usuarios:1.0 deployment/
```

### Ejecutar el contenedor

```bash
# Ejecutar el contenedor mapeando el puerto 8080
docker run -p 8080:8080 --name scaffold-usuarios bancolombia/scaffold-usuarios:1.0
```

### Verificar el estado del contenedor

```bash
# Verificar el estado del contenedor
docker ps

# Ver logs de la aplicación
docker logs scaffold-usuarios

# Verificar el endpoint de salud directamente
curl http://localhost:8080/actuator/health
```

### Configuración con variables de entorno

La aplicación en el contenedor puede configurarse mediante variables de entorno:

```bash
# Ejemplo con configuración de base de datos
docker run -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/usuarios \
  -e SPRING_DATASOURCE_USERNAME=postgres \
  -e SPRING_DATASOURCE_PASSWORD=secreto \
  bancolombia/scaffold-usuarios:1.0
```

### Despliegue con Docker Compose (Opcional)

Para un entorno más completo con base de datos y herramientas de monitoreo, puede usar Docker Compose. Cree un archivo `docker-compose.yml` en la raíz del proyecto:

```yaml
version: '3.8'

services:
  app:
    image: bancolombia/scaffold-usuarios:1.0
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=prod
    depends_on:
      - db
    healthcheck:
      test: ["CMD", "wget", "-q", "--spider", "http://localhost:8080/actuator/health"]
      interval: 30s
      timeout: 3s
      retries: 3
      
  db:
    image: postgres:14-alpine
    environment:
      - POSTGRES_DB=usuarios
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=secreto
    volumes:
      - postgres_data:/var/lib/postgresql/data
    ports:
      - "5432:5432"
      
  prometheus:
    image: prom/prometheus:latest
    volumes:
      - ./prometheus.yml:/etc/prometheus/prometheus.yml
    ports:
      - "9090:9090"
      
  grafana:
    image: grafana/grafana:latest
    ports:
      - "3000:3000"
    depends_on:
      - prometheus
    environment:
      - GF_SECURITY_ADMIN_PASSWORD=admin
      - GF_USERS_ALLOW_SIGN_UP=false

volumes:
  postgres_data:
```

Y ejecutarlo con:

```bash
docker-compose up -d
```

## 🔄 Integración Continua y Despliegue Continuo (CI/CD)

El proyecto está preparado para integrarse con GitHub Actions, permitiendo la automatización del proceso de construcción, pruebas y despliegue.

### Configuración con GitHub Actions

Se ha incluido un archivo de configuración en `.github/workflows/ci-cd.yml` que establece un pipeline completo con las siguientes etapas:

#### 1. Construcción y Pruebas

```yaml
build-and-test:
  runs-on: ubuntu-latest
  steps:
    - name: Checkout repository
      uses: actions/checkout@v3

    - name: Set up JDK 21
      uses: actions/setup-java@v3
      with:
        java-version: '21'
        distribution: 'temurin'
        cache: gradle

    - name: Build with Gradle
      run: ./gradlew clean build

    - name: Run tests
      run: ./gradlew test

    - name: Run SonarQube analysis
      env:
        GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
        SONAR_TOKEN: ${{ secrets.SONAR_TOKEN }}
      run: ./gradlew sonarqube
```

#### 2. Construcción de la Imagen Docker

```yaml
docker-build:
  needs: build-and-test
  runs-on: ubuntu-latest
  if: github.event_name != 'pull_request'
  steps:
    - name: Checkout repository
      uses: actions/checkout@v3

    - name: Download build artifact
      uses: actions/download-artifact@v3
      with:
        name: app-service-jar
        path: deployment/

    - name: Build and push Docker image
      uses: docker/build-push-action@v4
      with:
        context: ./deployment
        push: true
        tags: |
          bancolombia/scaffold-usuarios:latest
          bancolombia/scaffold-usuarios:${{ github.sha }}
```

#### 3. Despliegue a Ambientes

```yaml
deploy-dev:
  needs: docker-build
  runs-on: ubuntu-latest
  if: github.ref == 'refs/heads/develop'
  steps:
    - name: Deploy to Development Environment
      run: echo "Deploying to development environment"
      # Comandos de despliegue personalizados

deploy-prod:
  needs: docker-build
  runs-on: ubuntu-latest
  if: github.ref == 'refs/heads/main' || github.ref == 'refs/heads/master'
  environment: production
  steps:
    - name: Deploy to Production Environment
      run: echo "Deploying to production environment"
      # Comandos de despliegue personalizados
```

### Configuración Requerida

Para habilitar completamente el pipeline de CI/CD, se deben configurar los siguientes secretos en el repositorio de GitHub:

1. **SONAR_TOKEN**: Token de autenticación para SonarCloud
2. **DOCKERHUB_USERNAME**: Nombre de usuario de DockerHub
3. **DOCKERHUB_TOKEN**: Token de acceso para DockerHub

### Beneficios de la Integración Continua

- **Automatización**: Eliminación de procesos manuales propensos a errores
- **Calidad**: Detección temprana de problemas mediante pruebas automáticas y análisis de código
- **Consistencia**: Garantía de que cada cambio pasa por el mismo proceso de validación
- **Velocidad**: Reducción significativa del tiempo entre desarrollo y despliegue
- **Confiabilidad**: Cada versión es construida, probada y desplegada de manera consistente

### Personalización del Pipeline

El pipeline puede adaptarse fácilmente a necesidades específicas:

1. **Notificaciones**: Añadir notificaciones por correo, Slack u otros canales
2. **Pruebas adicionales**: Incorporar pruebas de integración, rendimiento o seguridad
3. **Aprobación manual**: Agregar pasos de aprobación manual para ambientes críticos
4. **Integración con herramientas**: Añadir verificaciones de seguridad, calidad o licencias
5. **Infraestructura como código**: Integrar con Terraform, AWS CloudFormation u otras herramientas de IaC

El archivo de configuración está diseñado para ser extensible y adaptable a los flujos de trabajo específicos de cada equipo o proyecto.

## 📄 Licencia

MIT License

Copyright (c) 2025 Santiago Suarez Osorio
