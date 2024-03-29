package com.edu.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.edu.core.WebDriverEngine;
import com.edu.utils.Log;
import com.edu.utils.ReadProperties;

/**
 * author:lihuanzhen
 * ��ʼ�������
 */


public class BaseTest {

	public  WebDriverEngine webtest;
	private WebDriver driver;
	public String driverType;

	
	

	private WebDriver newWebDriver(String driverType) throws IOException {
		WebDriver driver = null;
	 if (driverType.equalsIgnoreCase("firefox")) {
		    String firefox_driver =com.edu.utils.ReadProperties.getPropertyValue("gecko_driver");
			String firefox_path = com.edu.utils.ReadProperties.getPropertyValue("firefox_path");
			System.setProperty("webdriver.gecko.driver", firefox_driver);
			System.setProperty("webdriver.firefox.bin", firefox_path);
			driver = new FirefoxDriver();
	
			com.edu.utils.Log.info("Using Firefox");
		}  else if (driverType.equalsIgnoreCase("chrome")) {
			String chrome_path = com.edu.utils.ReadProperties.getPropertyValue("chrome_path");
			System.setProperty("webdriver.chrome.driver",chrome_path);
			driver = new ChromeDriver();
			com.edu.utils.Log.info("Using Chrome");
			
		}else{
			return null;
		}

		
		return driver;

	
	}


	/**
	 * 
	 *��ʼ�������
	 * 
	 */


	@BeforeClass
	public void doBeforeClass() throws Exception {

		driverType=com.edu.utils.ReadProperties.getPropertyValue("driverType");
		driver = this.newWebDriver(driverType);
		driver.manage().window().maximize();
		com.edu.utils.Log.info(driverType);
		webtest = new WebDriverEngine(driver);
	
	
	
	}


//	@AfterSuite
//	public void doAfterMethod() {
//		if(this.driver != null){
//			this.driver.quit();
//			}
//		Log.info("Quitted Browser");
//	}
//	

	

	
	public WebDriver getDriver() {
        return driver;
    }
	
/*	public boolean ifContains(String content) {
		return driver.getPageSource().contains(content);
	}
*/

	

}
