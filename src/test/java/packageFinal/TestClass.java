package packageFinal;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import finalMainProject.Functions_Class;

@Listeners(packageFinal.ListerensClass.class)
public class TestClass extends Functions_Class {
	public WebDriver finalProject;
	public Logger loggerFile;

	@BeforeSuite
	public void testloggerMethod() {
		loggerFile = Logger.getLogger("TestClass");
		PropertyConfigurator.configure("Log4j.properties");
		loggerFile.setLevel(Level.DEBUG);
	}

	@BeforeClass
	public void method1() {
		loggerFile.info("*****launch chrome browser*****");
		finalProject=Functions_Class.launchBrowser("chrome");
		finalProject.manage().window().maximize();
		
	}

	@Test
	public void mathod2() {
		loggerFile.info("*****launch application*****");
		finalProject.get("https://www.saucedemo.com/");
		finalProject.findElement(By.cssSelector("#user-name")).sendKeys("Thivakar Testing");
		finalProject.findElement(By.xpath("//input[@id='password']")).sendKeys("jfkhewhkwjk");
	}

	@AfterClass
	public void method3() {
		loggerFile.info("*****launch  application 2*****");
		finalProject.navigate().to("https://demoqa.com/");
		finalProject.navigate().back();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException exceptionName) {
			exceptionName.printStackTrace();
		}
		System.out.println("Testing success");
		finalProject.close();
	}

	// @AfterSuite
	public void shutDownMethod() {
		finalProject.manage().deleteAllCookies();
	}

}
