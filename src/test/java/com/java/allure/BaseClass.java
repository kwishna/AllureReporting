package com.java.allure;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");

		ChromeOptions co = new ChromeOptions();
		co.setAcceptInsecureCerts(true);
		co.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		co.addArguments("disable-infobars");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
		
		co.setExperimentalOption("prefs", chromePrefs);
		
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@BeforeTest
	public void bm() {
		driver.manage().deleteAllCookies();
		driver.get("https://demo.guru99.com/v4/");
	}
	
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
