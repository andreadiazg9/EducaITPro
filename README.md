# EducaITPro - Proyecto de Pruebas Automatizadas

Este proyecto contiene un conjunto de pruebas automatizadas para la validación de la funcionalidad de la aplicación **EducaITPro** usando **Java**, **Maven** y **TestNG**.

## Estructura del Proyecto

La estructura básica del proyecto es la siguiente:

```
/src
  /main
    /java    # Código fuente principal (si aplica)
  /test
    /java    # Pruebas automatizadas con TestNG
/pom.xml      # Archivo de configuración de Maven
```

### Pruebas Automatizadas
Las pruebas están escritas en **TestNG**, que permite la ejecución de casos de prueba de manera estructurada y eficiente. Los resultados de las pruebas se generan en formato HTML y pueden visualizarse en `target/surefire-reports`.

## Requisitos Previos

Antes de ejecutar las pruebas, asegúrate de que tienes lo siguiente instalado en tu entorno de desarrollo:

- **Java JDK 8 o superior**
- **Maven 3.6+**
- **TestNG**

### Instalación

1. Clona este repositorio en tu máquina local:

   ```bash
   git clone https://github.com/usuario/EducaITPro.git
   ```

2. Ve al directorio del proyecto:

   ```bash
   cd EducaITPro
   ```

3. Instala las dependencias del proyecto ejecutando Maven:

   ```bash
   mvn clean install
   ```

## Ejecución de Pruebas

Para ejecutar las pruebas, simplemente usa Maven con el siguiente comando:

```bash
mvn test
```

Esto ejecutará todas las pruebas definidas en los archivos de TestNG ubicados en el directorio `src/test/java`.

### Reportes de Pruebas

Los reportes de las pruebas se generan automáticamente en el directorio `target/surefire-reports`. Puedes abrir el archivo `index.html` dentro de esa carpeta para ver un resumen de las pruebas ejecutadas y sus resultados.

## Configuración de TestNG

El archivo `testng.xml` define la configuración de las pruebas, incluyendo los **test suites**, **clases** y **métodos** a ejecutar. Puedes personalizar este archivo según sea necesario para ejecutar casos de prueba específicos.

```xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Suite de Pruebas" parallel="false">
    <test name="Pruebas Funcionales">
        <classes>
            <class name="com.educaitpro.tests.PruebaLogin"/>
            <class name="com.educaitpro.tests.PruebaRegistro"/>
        </classes>
    </test>
</suite>
```

## Agregar Nuevas Pruebas

1. Crea una nueva clase de prueba en el directorio `src/test/java`.
2. Anota los métodos con `@Test` para definir los casos de prueba.
3. Añade tu clase de prueba al archivo `testng.xml` para incluirla en la suite de pruebas.

### Ejemplo de Caso de Prueba

```java
import org.testng.Assert;
import org.testng.annotations.Test;

public class PruebaLogin {

    @Test
    public void testLoginExitoso() {
        // Lógica de prueba para verificar el login
        String usuarioEsperado = "usuario1";
        String usuarioActual = "usuario1";
        Assert.assertEquals(usuarioActual, usuarioEsperado, "El usuario no coincide");
    }
}
```

## Recursos Adicionales

- [Documentación de Maven](https://maven.apache.org/)
- [Documentación de TestNG](https://testng.org/doc/)

## Contribuciones

Si deseas contribuir a este proyecto, crea un **pull request** o abre un **issue** para discutir los cambios que te gustaría hacer.

## Licencia

Este proyecto está bajo la licencia MIT. Ver el archivo `LICENSE` para más detalles.
