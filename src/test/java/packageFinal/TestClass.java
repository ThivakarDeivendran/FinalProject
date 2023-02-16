package packageFinal;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	public WebDriver finalProject;
	public Logger loggerFile;
	@BeforeSuite
	public void testloggerMethod() {
		loggerFile= Logger.getLogger("TestClass");
		PropertyConfigurator.configure("Log4j.properties");
		loggerFile.setLevel(Level.DEBUG);
	}
	
	@BeforeClass
	public void method1() {
		loggerFile.info("*****launch Chrome browser*****");
		WebDriverManager.chromedriver().setup();
		finalProject = new ChromeDriver();
		finalProject.manage().window().maximize();
		finalProject.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void mathod2() {
		loggerFile.info("*****launch application*****");
		finalProject.get("https://www.saucedemo.com/");
		finalProject.findElement(By.cssSelector("#user-name")).sendKeys("ThivakatTesting");	
	}
	
	@AfterClass
	public void method3() {
		loggerFile.info("*****launch  application 2*****");
		finalProject.navigate().to("https://demoqa.com/");
		finalProject.navi;
		try {
		Thread.sleep(7000);
		}catch(InterruptedException exceptionName ) {
			exceptionName.printStackTrace();
		}
		finalProject.close();
	}
	@AfterSuite
	public void shutDownMethod() {
		finalProject.manage().deleteAllCookies();
	}
	
}
