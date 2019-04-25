package com.wikipedia.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {

	private WebDriver driver;

	@FindBy(linkText = "Object-oriented programming")
	private static WebElement OOPSlnk;

	@FindBy(id = "collapseButton1")
	private static WebElement showLink;
	
	@FindBy(linkText = "Grady Booch")
	private static WebElement softwareEnggBooch;

	public ResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOOPlink() {
		OOPSlnk.click();
	}

	public String isUserLandedOnOOPPage() {
		return driver.getCurrentUrl();
	}

	public void showSoftwareEnggDetails() {

		// scrolling down page
		((JavascriptExecutor) driver).executeScript("scroll(0,10000)");
		showLink.click();
		softwareEnggBooch.click();
	}
	
	public String isGradyBoochClicked(){
		return driver.getCurrentUrl();
	}
}
