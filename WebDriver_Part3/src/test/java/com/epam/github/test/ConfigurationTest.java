package com.epam.github.test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.epam.github.pages.LoginPage;
import com.epam.github.pages.UserProfilePage;

public class ConfigurationTest {

	WebDriver driver = null;
	LoginPage objLogin = null;
	UserProfilePage objUser = null;
	public String PROJECT_ROOT_PATH = System.getProperty("user.dir");

	@BeforeMethod
	public void setup() {

		System.out.println("In Setup,setting up objects");
		new DesiredCapabilities();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		capabilities.setBrowserName("chrome");
		capabilities.setPlatform(Platform.WIN10);
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), capabilities);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

	}

	@AfterMethod
	public void teardown() {
		System.out.println("In Teardown,destroying the objects");
		objLogin = null;
		objUser = null;
		driver.quit();
	}
}
