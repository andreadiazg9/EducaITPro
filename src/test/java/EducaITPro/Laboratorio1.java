package EducaITPro;

import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio1 {
	
	@Ignore
	public void lab1_test() {
		
		System.out.println("Hola Mundo de automatización");
		
	}
	
	@Ignore
	public void lab1_e1() {
		
		System.setProperty("webdriver.chrome.driver", "..//EducaITPro//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationpractice.pl/index.php");
		driver.close();
	
	}
	
	@Ignore
	public void lab1_e2() {
		
		System.setProperty("webdriver.gecko.driver", "..//EducaITPro//Drivers//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.automationpractice.pl/index.php");
		driver.close();
	
	}
	
	@Test
	public void lab1_e3() {
		
		System.setProperty("webdriver.chrome.driver", "..//EducaITPro//Drivers//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.automationpractice.pl/index.php");
		
		driver.manage().window().maximize();
		
		WebElement txt_Buscador = driver.findElement(By.id("search_query_top"));
		
		txt_Buscador.sendKeys("Blouse");
		
		txt_Buscador.sendKeys(Keys.ENTER);
		
		driver.close();
	
	}

}
