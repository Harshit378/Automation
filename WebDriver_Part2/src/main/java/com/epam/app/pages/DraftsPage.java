package com.epam.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.app.reusable.WebDriverManager;

public class DraftsPage  {
	WebDriver driver;
	
	public static final String DRAFTS = "//a[@href='https://mail.google.com/mail/u/0/#drafts']";
	public static final String DRAFT_MAIL ="//span[contains(text(),'Testing mail')]";

	@FindBy(xpath = "//a[@href='https://mail.google.com/mail/u/0/#drafts']")
	private static WebElement draftsLink;

	@FindBy(xpath = "//span[contains(text(),'Testing mail')]")
	private static WebElement testMailDraft;

	@FindBy(xpath ="//span[contains(text(),'Testing mail')]")
	private static WebElement draftMail;

	@FindBy(xpath = "//div[@class='oL aDm az9']/span")
	private static WebElement mailRecipient;

	@FindBy(className = "aYf")
	private static WebElement mailSubject;

	@FindBy(css = "div[aria-label='Message Body']")
	private static WebElement mailBody;

	@FindBy(xpath = "//div[contains(text(),'Send')]")
	private static WebElement sendBtn;

	@FindBy(xpath = "//td[contains(text(),'You don')]")
	private static WebElement emptyDraft;

	public DraftsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickDrafts() {
		driver.switchTo().parentFrame();
		draftsLink = WebDriverManager.explicitWait(5, DRAFTS);
		draftsLink.click();
	}

	public boolean isDraftMessagePresent() {

		testMailDraft = WebDriverManager.explicitWait(5, DRAFT_MAIL);
		return testMailDraft.isEnabled();
	}

	public void verifyDraftContent() {
		draftMail.click();
	}

	public String checkMailAddressee() {
		return mailRecipient.getText();
	}

	public String checkMailSubject() {
		return mailSubject.getText();
	}

	public String checkMailBody() {
		return mailBody.getText();
	}

	public SentMailPage sendMail() {
		sendBtn.click();
		driver.navigate().refresh();
		// sometimes alert is coming
		driver.switchTo().alert().accept();
		driver.navigate().refresh();
		return new SentMailPage(driver);
	}

	public boolean isDraftEmpty() {

		return emptyDraft.isDisplayed();
	}

}
