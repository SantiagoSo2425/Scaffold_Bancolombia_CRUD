FROM eclipse-temurin:21-jdk-alpine

LABEL maintainer="Bancolombia" \
      description="CRUD de Usuarios - Scaffold Clean Architecture Bancolombia" \
      version="1.0"

# Crear usuario no privilegiado para ejecutar la aplicación
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Establecer directorio de trabajo
WORKDIR /app

# Crear volumen para datos temporales
VOLUME /tmp

# Configuración de variables de entorno para la JVM
ENV JAVA_OPTS="-XX:+UseContainerSupport \
               -XX:MaxRAMPercentage=70 \
               -Djava.security.egd=file:/dev/./urandom"

# Exponer puertos de la aplicación y Actuator
EXPOSE 8080

# Copiar el jar construido
COPY *.jar /app/primerProyecto.jar
RUN chown -R appuser:appgroup /app

# Cambiar al usuario no privilegiado
USER appuser

# Establecer punto de verificación de salud para Docker
HEALTHCHECK --interval=30s --timeout=3s --retries=3 \
  CMD wget -q --spider http://localhost:8080/actuator/health || exit 1

# Comando para iniciar la aplicación
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar primerProyecto.jar"]
