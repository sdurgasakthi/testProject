package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	

	
	public TestBase(){
		
		 prop = new Properties();
		
		try {
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void initialization() {
		
	String browser=	prop.getProperty("browser");
	
	String path = System.getProperty("user.dir"); 
	
	String driverpath=path + "/src/main/resources/chromedriver.exe";
	
	if(browser.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", driverpath);
		
		 driver=new ChromeDriver();
		 
		 
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICITLY_WAIT_TIMEOUT));
	
	
	driver.get(prop.getProperty("url"));

	
		
	}

}
