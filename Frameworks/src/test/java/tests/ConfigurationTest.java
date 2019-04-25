package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import steps.Steps;

public class ConfigurationTest {

	protected Steps steps;

	@BeforeMethod
	public void setup() {
		steps = new Steps();
		System.out.println("In Setup,setting up objects");
		steps.initBrowser();

	}

	@AfterMethod
	public void teardown() {
		steps = new Steps();
		System.out.println("In Teardown,destroying the objects");
		steps.closeDriver();

	}
}
