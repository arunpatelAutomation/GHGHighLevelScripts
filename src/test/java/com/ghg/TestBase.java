package com.ghg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	public TestBase(){
		try {
			prop = new Properties();
			
			
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\resources\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static WebDriver initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			
			//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		}
		else if(browserName.equals("edge")){
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		tdriver.set(driver);
		return getDriver();
				
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}

}
