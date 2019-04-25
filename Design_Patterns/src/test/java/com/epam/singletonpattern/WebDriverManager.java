package com.epam.singletonpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import com.epam.factorypattern.ChromeDriverCreator;
import com.epam.factorypattern.FirefoxDriverCreator;

public class WebDriverManager {
	private static WebDriver driver = null;

	static WebDriverManager objDrivers = null;
	private static String browserName = "CHROME";
	//for maven test,vm arguments are throwing null
	//private static String browserName = System.getProperty("browser");

	private WebDriverManager() {
	}

	// singleTon pattern method
	public static WebDriver getWebDriverInstance() {
		if (driver == null) {
			driver = launchAndReturnDriver();
		}
		return driver;

	}

	public final static WebDriver launchAndReturnDriver() {

		if (browserName.equalsIgnoreCase(BrowserType.CHROME)) {
			driver = new ChromeDriverCreator().factoryMethodDriverLauncher();
			return driver;
		}

		else if (browserName.equalsIgnoreCase(BrowserType.FIREFOX)) {
			driver = new FirefoxDriverCreator().factoryMethodDriverLauncher();
			return driver;
		} else {

			System.out.println("No Driver Found");
		}
		return driver;

	}

	public static void destroyTheDriver() {

		driver.quit();
		driver = null;
	}
}
