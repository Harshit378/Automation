package com.epam.app.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.app.reusable.WebDriverManager;

public class LoginPage {
	WebDriver driver;

	public static final String GMAIL_URL = "https://accounts.google.com/";

	public static final String PASSWORD = "//input[@name='Passwd']";

	@FindBy(id = "Email")
	private static WebElement userName;

	@FindBy(id = "next")
	private static WebElement nextBtn;

	@FindBy(xpath = "//input[@name='Passwd']")
	private static WebElement passWord;

	@FindBy(name = "signIn")
	private static WebElement signInBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Initializing login page object elements");
	}

	public void launchGmail(String url) {
		driver.get(GMAIL_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// methods return new page objects
	public LandingPage login(String username, String password) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		userName.sendKeys(username);
		nextBtn.click();
		passWord = WebDriverManager.explicitWait(5, PASSWORD);
		passWord.sendKeys(password);
		signInBtn.submit();
		return new LandingPage(driver);

	}

}
