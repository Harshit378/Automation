package com.epam.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.pages.GitHub;

public class GitHubTest {

	WebDriver driver = null;
	GitHub obj = null;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Projects\\TestNG_Practice\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		obj = new GitHub(driver);
	}

	@Test
	public void loginTest() {
		obj.launchApplication();
		obj.LogIn();
		Assert.assertEquals("shubhamsharma99", obj.getLoggedInUsername());
	}

	@AfterTest
	public void Teardown() {
		obj = null;
		driver.quit();
	}
}
