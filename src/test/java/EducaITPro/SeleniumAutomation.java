package EducaITPro;

import java.sql.SQLException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumAutomation {
	WebDriver driver;
	
    @Test
    public void TestSQL() {

        String urlBD = "jdbc:mysql://localhost:3306/db";
        String usuarioBD = "root";
        String contrasenaBD = "root";


        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver= new ChromeDriver();

        try {
    
            DatabaseManager databaseManager = new DatabaseManager(urlBD, usuarioBD, contrasenaBD);

            String[] datosUsuario = databaseManager.obtenerDatosUsuario(2); 

       
            databaseManager.cerrarConexion();


            driver.get("https://www.saucedemo.com/");

            WebElement nombreInput = driver.findElement(By.id("user-name"));
            WebElement contraseñaInput = driver.findElement(By.id("password"));
            
            
            System.out.println(datosUsuario[0]);
            System.out.println(datosUsuario[1]);
            nombreInput.sendKeys(datosUsuario[0]);
            contraseñaInput.sendKeys(datosUsuario[1]);

           

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
     
            driver.quit();
        }
    }
}
