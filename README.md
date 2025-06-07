# SauceDemoTest
Automatizacion procesos SauceDemo como requisito para el cargo de QA Automatizacion 


# Automatización SauceDemo  con Serenity BDD, Cucumber y Screenplay

Este proyecto de automatiza el flujo de login, agregar productos, checkout y completar orden.

## Requisitos previos
Antes de ejecutar las pruebas se debe tener instalado lo siguiente:
- Java JDK 11 o superior
- Apache Maven 3.6+
- Google Chrome
- IDE (IntelliJ IDEA, VS Code, Eclipse, etc.) el que sea de su preferencia

## Ejecución de Pruebas

### 1. Clonar el proyecto

Paso 1: Instalar git

        Windows: https://git-scm.com/download/win 
        MAC: https://git-scm.com/download/mac 
        General: https://git-scm.com/book/es/v2/Inicio---Sobre-el-Control-de-Versiones-Instalaci%C3%B3n-de-Git

Paso 2: Abrir git por terminal Windows: CMD MAC: Terminal
Paso 3: Ingresar a la carpeta donde se va a clonar el proyecto.

- ls
- cd Documents/

Paso 4: Para clonar el proyecto se debe ejecutar el siguiente comando git clone
- https://github.com/luisDevPKG/SauceDemoTest.git

# Ejecuta con Maven

Paso 1: Al interior de tu proyecto abrir la terminal y ejecutar el siguiente comando para compilar el proyecto:

- mvn compile

paso 2: Si la compilacion fue exitosa posteriormente ejecutar el siguiente comando para ejecutar los test:

- mvn clean verify

# Escenarios Automatizados

Login exitoso: Usuario accede con credenciales válidas
Login fallido: Usuario accede con credenciales inválidas
Agregar productos al carrito: Agrega productos al carrito de compras
Checkout completo:  Finaliza compra con datos válidos
Prueba de regresión completa: Flujo de compra desde login hasta confirmación

Después de ejecutar, encontrarás el reporte Serenity en:
target/site/serenity/index.html

Esto lo vas a poder abrir en tu navegador para visualizar resultados detallados.

Autor
Luis Mosquera – QA Engineer 