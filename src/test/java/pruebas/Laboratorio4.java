package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.paginaLogin;

public class Laboratorio4 {
	
	WebDriver driver; 
	paginaLogin login;
	
	String URL="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
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
	public void irRegistroLogin() {
		
		login = new paginaLogin(driver);
		login.ingresarDatos("test1@gmail.com", "1234");

		Assert.assertEquals(login.getTextTitleForm(), "AUTHENTICATION");
		
	}

}
