package com.wikipedia.drivercreator;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;


public class FirefoxDriverCreator extends WebDriverCreator {

	private String PROJECT_ROOT_PATH = System.getProperty("user.dir");

	@Override
	public WebDriver factoryMethodDriverLauncher() {
		System.setProperty("webdriver.gecko.driver", PROJECT_ROOT_PATH + "/src/main/resources/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;
	}


}
