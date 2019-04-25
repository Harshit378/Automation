package com.epam.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHub {

	WebDriver driver;

	@FindBy(id = "login_field")
	private static WebElement userName;

	@FindBy(name = "password")
	private static WebElement password;

	@FindBy(xpath = "//input[@class='btn btn-primary btn-block']")
	private static WebElement signInBtn;

	@FindBy(xpath = "//img[@class='avatar']")
	private static WebElement avatarImg;

	@FindBy(xpath = "//strong[contains(text(),'shubhamsharma99')]")
	private static WebElement checkName;

	public static String URL = "https://github.com/settings/profile";

	public GitHub(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void launchApplication() {
		driver.get(URL);
		driver.manage().window().maximize();
	}

	public void LogIn() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		userName.sendKeys("shubhamsharma99");
		password.sendKeys("my_father123$");
		signInBtn.click();
	}

	public String getLoggedInUsername() {
		avatarImg.click();
		return checkName.getText();
	}
}
