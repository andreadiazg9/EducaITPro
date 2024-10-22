package EducaITPro;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Laboratorio3b {
	
    WebDriver driver;
    String URL = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
    String PATH = "..\\EducaITPro\\Drivers\\chromedriver.exe";

    // Se ejecuta una sola vez antes de toda la suite de pruebas
    @BeforeSuite
    public void configurarDriver() {
        System.setProperty("webdriver.chrome.driver", PATH);
    }

    // Se ejecuta una vez antes de cada <test> en el archivo testng.xml
    @BeforeTest
    public void abrirNavegadorIrURL() {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    // Se ejecuta una vez antes de cada clase de test en la suite
    @BeforeClass
    public void maximizarVentana() {
        driver.manage().window().maximize();
    }

    // Primer test: Registrar un usuario nuevo
    @Test(priority=2)
    public void registrarUsuario() throws InterruptedException {
        WebElement txt_Email = driver.findElement(By.id("email_create"));
        txt_Email.sendKeys("micorreo" + Math.random() + "@correo.com");

        WebElement btn_Crear = driver.findElement(By.id("SubmitCreate"));
        btn_Crear.click();

        WebDriverWait espera = new WebDriverWait(driver, 10);
        WebElement rb_genero = espera.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
        rb_genero.click();

        WebElement txt_Nombre = driver.findElement(By.name("customer_firstname"));
        txt_Nombre.sendKeys("Juan Perez");

        WebElement txt_Contrasena = driver.findElement(By.name("passwd"));
        txt_Contrasena.sendKeys("123456");

        Select meses = new Select(driver.findElement(By.id("months")));
        meses.selectByValue("4");

        WebElement btn_Registrar = driver.findElement(By.xpath("//*[text()='Register']"));
        btn_Registrar.click();
        Assert.assertEquals("http://www.automationpractice.pl/index.php?controller=authentication",driver.getCurrentUrl());
		
    }

    // Segundo test: Iniciar sesión con un usuario existente
    @Test(priority=1)
    public void iniciarSesion() throws InterruptedException {
        WebElement txt_Email = driver.findElement(By.id("email"));
        txt_Email.sendKeys("usuarioexistente@correo.com");

        WebElement txt_Contrasena = driver.findElement(By.id("passwd"));
        txt_Contrasena.sendKeys("123456");

        WebElement btn_Login = driver.findElement(By.id("SubmitLogin"));
        btn_Login.click();
        Assert.assertEquals("http://www.automationpractice.pl/index.php?controller=authentication",driver.getCurrentUrl());
		
      
    }

    // Captura pantalla después de cada test
    @AfterMethod
    public void capturaPantalla() throws IOException {
        File pantalla = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(pantalla, new File("..\\EducaITPro\\Evidencias\\pantalla_" + System.currentTimeMillis() + ".png"));
    }

    // Después de la clase, imprimir mensaje de fin
    @AfterClass
    public void finDePrueba() {
        System.out.println("Fin de la ejecución de la clase");
    }

    // Cerrar navegador después de la ejecución de todos los tests en <test>
    @AfterTest
    public void cerrarNavegador() {
        driver.quit();
    }

    // Fin de la suite de pruebas
    @AfterSuite
    public void finDeSuite() {
        System.out.print("Fin de la suite de pruebas");
    }

}