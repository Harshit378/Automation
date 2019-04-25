package com.epam.app.reusable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {
	static WebDriver driver = null;

	static WebDriverManager objDrivers = null;

	public WebDriverManager getInstance() {
		if (objDrivers == null) {
			objDrivers = new WebDriverManager();
		}
		return objDrivers;

	}

	public String PROJECT_ROOT_PATH = System.getProperty("user.dir");

	public final WebDriver launchAndReturnDriver(String browserName) {

		if (browserName.equalsIgnoreCase("CHROME")) {

			System.setProperty("webdriver.chrome.driver",
					PROJECT_ROOT_PATH + "/src/main/resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			return driver;
		}

		else if (browserName.equalsIgnoreCase("INTERNET EXPLORER")) {
			System.setProperty("webdriver.ie.driver",
					PROJECT_ROOT_PATH + "/src/main/resources/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			return driver;
		}

		else if (browserName.equalsIgnoreCase("FIREFOX")) {

			driver = new FirefoxDriver();
			return driver;
		} else {

			System.out.println("No Driver Found");
		}
		return driver;

	}

	public static WebElement explicitWait(int time, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public void destroyTheDriver() {

		driver.quit();
	}
}
