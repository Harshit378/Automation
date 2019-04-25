package com.epam.pages.test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.epam.app.pages.DraftsPage;
import com.epam.app.pages.LandingPage;
import com.epam.app.pages.LoginPage;
import com.epam.app.pages.SentMailPage;
import com.epam.app.reusable.WebDriverManager;

public class ConfigurationTest {

	WebDriver driver = null;
	WebDriverManager objDrivers = null;
	LoginPage objLogin = null;
	LandingPage objLand = null;
	DraftsPage objDrafts = null;
	SentMailPage objSent = null;

	@BeforeClass
	public void setup() {

		System.out.println("In Setup,setting up objects");

		objDrivers = new WebDriverManager().getInstance();
		driver = objDrivers.launchAndReturnDriver("chrome");
		objLogin = new LoginPage(driver);
		objLand = new LandingPage(driver);
		objDrafts = new DraftsPage(driver);
		objSent = new SentMailPage(driver);

	}

	@AfterClass
	public void teardown() {
		System.out.println("In Teardown,destroying the objects");
		objLogin = null;
		objLand = null;
		objDrafts = null;
		objSent = null;
		objDrivers.destroyTheDriver();

	}
}
