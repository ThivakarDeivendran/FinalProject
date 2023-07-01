package finalMainProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Functions_Class {

	public static WebDriver functionClassDriver;

	public static WebDriver launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			functionClassDriver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			functionClassDriver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			functionClassDriver = new FirefoxDriver();
		}
		return functionClassDriver;
	}
	public static void getMaximizeWindow() {
		functionClassDriver.manage().window().maximize();
	}
	public static void deleteAllCookiesMethod() {
		try {
			functionClassDriver.manage().deleteAllCookies();
		}catch(Exception e) {}
	}
	public static void getImplicitlyWaitMethod(int timeUnits) {
		functionClassDriver.manage().timeouts().implicitlyWait(timeUnits,TimeUnit.SECONDS);
	}
	public static void getExplicitlyWaitMethod(Duration timeUnits) {
		WebDriverWait waitExplicit = new WebDriverWait(functionClassDriver,timeUnits);
	}
	public static void getPropertyFileValueMethod() {
		try {
			FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+ "\\Properties\\Adactinhotel.properties"));
			Properties propertiesFile = new Properties();
			
		} catch (FileNotFoundException e) {
		}
	}
}
