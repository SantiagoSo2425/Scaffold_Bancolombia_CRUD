@echo off
REM Script para ejecutar análisis de SonarQube

echo Verificando si SonarQube está disponible localmente...
powershell -Command "try { $response = Invoke-WebRequest -Uri http://localhost:9000 -UseBasicParsing -TimeoutSec 5; if ($response.StatusCode -eq 200) { Write-Host 'SonarQube está disponible localmente' } } catch { Write-Host 'Error: SonarQube no está disponible en http://localhost:9000' -ForegroundColor Red; Write-Host 'Por favor, asegúrate de tener SonarQube en ejecución con el comando:'; Write-Host 'docker run -d --name sonarqube -p 9000:9000 sonarqube:latest'; exit 1 }"

echo Ejecutando tests y generando reportes de cobertura...
call ./gradlew clean test jacocoMergedReport

echo Para generar un token de acceso, sigue estos pasos:
echo 1. Abre http://localhost:9000 en tu navegador
echo 2. Inicia sesión con tu usuario y contraseña (admin/Viva.elsople123)
echo 3. Ve a Mi cuenta ^> Seguridad
echo 4. Genera un nuevo token (por ejemplo: "scaffold-bancolombia-token")
echo 5. Copia el token generado y reemplaza "tu-token-aqui" en la siguiente línea:

set /p SONAR_TOKEN="Ingresa el token de SonarQube: "

echo Ejecutando análisis de SonarQube con el token proporcionado...
call ./gradlew sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.token=%SONAR_TOKEN%

echo Análisis de SonarQube completado. Revisa los resultados en http://localhost:9000
