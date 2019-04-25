package com.clicklabs.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.click.pages.LandingPage;

public class ConfigurationTest {

	LandingPage objLand = null;
	WebDriver driver = null;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"D:/Minsk_Training/Design_Patterns/src/main/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		objLand = new LandingPage(driver);
	}

	@AfterClass
	public void teardown() {
		objLand = null;
		driver.quit();
	}
}
