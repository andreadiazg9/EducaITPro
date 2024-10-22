package pruebas;


import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CrossBrowserTest {
	
	WebDriver driver = null;
	String URL="http://www.automationpractice.pl/index.php";
	String PATH="..\\EducaITPro\\Drivers\\chromedriver.exe";
	String PATHF="..\\EducaITPro\\Drivers\\geckodriver.exe";
	
	@BeforeMethod
	@Parameters("navegador")
	public void setUp(String navegador) {
		
		if(navegador.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", PATH);
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.gecko.driver", PATHF);
			driver = new FirefoxDriver();
		}
		
		driver.get(URL);
		
	
	}
	@Test
	public void buscarPalabra() {
				
		WebElement txtBuscador=driver.findElement(By.cssSelector("input[placeholder='Search']"));

		txtBuscador.clear();

		txtBuscador.sendKeys("Blouse");

		txtBuscador.sendKeys(Keys.ENTER);
	
	}
	
	@AfterMethod
	public void cierreNavegador() {
		
		driver.close();
		
	}

}
