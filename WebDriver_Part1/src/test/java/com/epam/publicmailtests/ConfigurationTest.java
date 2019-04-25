package com.epam.publicmailtests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.epam.publicmail.WebDriverManager;
import com.epam.publicmail.Gmail;

public class ConfigurationTest {

	WebDriver driver = null;
	WebDriverManager objDrivers = null;
	Gmail objGmail = null;

	@BeforeClass
	public void setup() {

		System.out.println("In Setup,setting up objects");
		try {
			objDrivers = new WebDriverManager().getInstance();
			driver = objDrivers.launchAndReturnDriver("chrome");
			objGmail = new Gmail(driver);
		} catch (Exception e) {
			e.getMessage();
			Assert.fail();
		}

	}

	@AfterClass
	public void teardown() {
		System.out.println("In Teardown,destroying the objects");
		objGmail = null;
		try {
			objDrivers.destroyTheDriver();
		} catch (Exception e) {
			e.getMessage();
			Assert.fail();
		}
	}

}
