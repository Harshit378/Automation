package com.wikipedia.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHomePage {
	private WebDriver driver;

	@FindBy(id = "searchInput")
	private static WebElement searchField;

	@FindBy(className = "pure-button")
	private static WebElement searchBtn;
	
	@FindBy(linkText = "Object-oriented programming")
	private static WebElement OOPSlnk;

	public static String WIKIPEDIA_URL = "https://www.wikipedia.org/";

	public WikiHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void launchWikipedia() {
		driver.get(WIKIPEDIA_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public void searchOOP() {
		searchField.sendKeys("OOP");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		
	}
	
	public String isUserLandedOnOOPResultPage(){
		return driver.getCurrentUrl();
	}
	
	

}
