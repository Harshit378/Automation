package com.wikipedia.drivercreator;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverCreator {
	protected static WebDriver driver;

	public abstract WebDriver factoryMethodDriverLauncher();
	
	
}
