package com.wikipedia.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.wikipedia.drivercreator.ChromeDriverCreator;
import com.wikipedia.pages.ResultPage;
import com.wikipedia.pages.WikiHomePage;

public class ConfigurationTest {
	WebDriver driver = null;
	WikiHomePage homePage = null;
	ResultPage resultPage = null;

	public WebDriver getDriverInstance() {
		if (driver == null) {
			driver = new ChromeDriverCreator().factoryMethodDriverLauncher();
		}
		return driver;
	}

	@BeforeMethod
	public void setup() {

		driver = getDriverInstance();
		homePage = new WikiHomePage(driver);
		resultPage = new ResultPage(driver);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
		driver = null;
		homePage = null;
		resultPage = null;
	}

}
