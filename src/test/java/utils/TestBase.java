package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.LandingPage;

public class TestBase {


public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {
		
//		FileInputStream fis = new FileInputStream(System.getProperty("D://Java-practice//CucumberFrameworkTestNG//src//test//resources//global.properties"));
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		if(driver==null) {
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
//			if(prop.getProperty("browser") == "chrome") {
				driver =new ChromeDriver();
			}
			if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				driver= new FirefoxDriver();
			}
		
	    driver.get(url);
		}
	    return driver;
		
	}
	
	
	
}

