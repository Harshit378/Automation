package com.epam.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.app.reusable.WebDriverManager;

public class LandingPage {

	WebDriver driver;

	public static final String MAIL_ADDRESSEE = "royalsingh1494@yahoo.in";

	public static final String MAIL_SUBJECT = "Testing mail";

	public static final String MAIL_BODY = "This is message body";

	@FindBy(xpath = "//div[contains(text(),'COMPOSE')]")
	private static WebElement composeBtn;

	@FindBy(name = "to")
	private static WebElement mailRecipient;

	@FindBy(name = "subjectbox")
	private static WebElement subject;

	@FindBy(xpath = "//div[@aria-label='Message Body']")
	private static WebElement bodyMessage;

	@FindBy(css = "img[alt='Close']")
	private static WebElement closeBtn;

	@FindBy(css = "span[class='gb_9a gbii']")
	private static WebElement profileBtn;

	@FindBy(linkText = "Sign out")
	private static WebElement signOutBtn;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Initializing login page object elements");
	}

	// methods return new page objects
	public DraftsPage composeAndCloseNewMail() {
		driver.switchTo().defaultContent();
		composeBtn = WebDriverManager.explicitWait(5, "//div[contains(text(),'COMPOSE')]");
		composeBtn.click();
		mailRecipient.sendKeys(MAIL_ADDRESSEE);
		subject.sendKeys(MAIL_SUBJECT);
		bodyMessage.sendKeys(MAIL_BODY);
		closeBtn.click();
		return new DraftsPage(driver);
	}

	public boolean isUserLoggedIn() {

		profileBtn.click();
		signOutBtn = WebDriverManager.explicitWait(5, "//a[@id='gb_71']");
		return signOutBtn.isDisplayed();
	}
}
