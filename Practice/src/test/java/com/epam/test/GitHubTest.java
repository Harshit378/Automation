package com.epam.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.pages.GitHub;

public class GitHubTest {
	
	WebDriver driver=null;
	GitHub obj = null;
  
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","D:/Minsk_Training/Design_Patterns/src/main/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		obj = new GitHub(driver);
	}
	
	@Test
	public void loginTest()
	{
		obj.launchApplication();
		obj.LogIn();
		Assert.assertEquals("shubhamsharma99",obj.getLoggedInUsername());
	}
	
	@AfterTest
	public void Teardown()
	{
		obj = null;
		driver.quit();
	}
}
