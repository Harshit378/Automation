package com.epam.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.epam.steps.Steps;

public class ConfigurationTest {
	private static Logger logger = Logger.getLogger(ConfigurationTest.class);
	public Steps steps;

	@BeforeMethod
	public void setup() {
		steps = new Steps();
		logger.info("In Setup,setting up objects");
		steps.initBrowser();

	}

	@AfterMethod
	public void teardown() {
		steps = new Steps();
		logger.info("In Teardown,destroying the objects");
		steps.closeDriver();

	}
}
