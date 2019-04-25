package com.epam.factorypattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeDriverCreator extends WebDriverCreator {

	private String PROJECT_ROOT_PATH = System.getProperty("user.dir");

	@Override
	public WebDriver factoryMethodDriverLauncher() {
		System.setProperty("webdriver.chrome.driver",
				PROJECT_ROOT_PATH + "/src/main/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
		
		

	}

}
