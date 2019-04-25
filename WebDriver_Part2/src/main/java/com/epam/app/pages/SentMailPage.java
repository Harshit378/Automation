package com.epam.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SentMailPage {

	WebDriver driver;

	@FindBy(linkText = "Sent Mail")
	private WebElement sentMailLink;

	@FindBy(xpath = "//span[contains(text(),'Testing mail')]")
	private WebElement sentMail;

	@FindBy(css = "span[class='gb_9a gbii']")
	private WebElement profileBtn;

	@FindBy(linkText = "Sign out")
	private WebElement signOutBtn;

	@FindBy(xpath = "//h2[contains(text(),'Sign in to continue to Gmail')]")
	private WebElement signInText;

	public SentMailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isMailPresentInSent() {

		sentMailLink.click();
		return sentMail.isEnabled();
	}

	public void logOut() {

		profileBtn.click();
		signOutBtn.click();
	}

	public boolean isUserLoggedOut() {

		return signInText.isDisplayed();
	}

}
