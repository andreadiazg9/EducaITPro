package pruebas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio5 {
	
	WebDriver driver;

	
	
	String URL="https://demoqa.com/alerts";
	String PATH="..\\EducaITPro\\Drivers\\chromedriver.exe";

	
	@BeforeSuite
	public void setUp() {
		
		    System.setProperty("webdriver.chrome.driver", PATH);
		    driver=new ChromeDriver();
		    driver.get(URL);
		    driver.manage().window().maximize();
	}
	
	
	@AfterSuite
	public void cierreNavegador() {
		
		driver.close();
		
	}

   @Test
   public void popUp() throws InterruptedException {
	   
	     // Crear un WebDriverWait para manejar tiempos de espera
       WebDriverWait wait = new WebDriverWait(driver, 10);

       // Esperar hasta que el botón de la alerta esté disponible y hacer clic
       WebElement btnAlert = wait.until(ExpectedConditions.elementToBeClickable(By.id("alertButton")));
       btnAlert.click();

       // Esperar hasta que el pop-up de alerta esté presente
       wait.until(ExpectedConditions.alertIsPresent());

       // Cambiar al pop-up y aceptarlo
       Alert popUp = driver.switchTo().alert();
       popUp.accept();
	 
	   
   }


}
