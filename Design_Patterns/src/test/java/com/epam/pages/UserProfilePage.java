package com.epam.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.utilities.HighlighterAndWait;





public class UserProfilePage extends AbstractPage {

	@FindBy(xpath = "//a[contains(text(),'Profile')]")
	private static WebElement profileBtn;

	@FindBy(id = "user_profile_name")
	private static WebElement profileName;

	@FindBy(id = "user_profile_bio")
	private static WebElement bioText;

	@FindBy(css = "input[id='user_profile_company']")
	private static WebElement userCompany;

	@FindBy(css = "input[id='user_profile_location']")
	private static WebElement userLocation;

	@FindBy(xpath = "//button[contains(text(),'Update profile')]")
	private static WebElement updateBtn;

	@FindBy(xpath = "//img[@class='avatar']")
	private static WebElement avatarImg;

	@FindBy(linkText = "view your profile.")
	private static WebElement viewProfileLink;

	@FindBy(name = "user[profile_email]")
	private static WebElement dropDown;

	@FindBy(xpath = "//option[contains(text(),'shubhamsharma99@gmail.com')]")
	private static WebElement selAccount;

	@FindBy(css = "img[class='avatar rounded-2']")
	private static WebElement draggableImageSource;

	@FindBy(id = "user_profile_blog")
	private static WebElement userURL;

	@FindBy(xpath = "//button[contains(text(),'Sign out')]")
	private static WebElement signOut;

	@FindBy(linkText = "Sign in")
	private static WebElement signInLink;

	public final String URL = "https://github.com/settings/profile";

	public UserProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void launchApplication() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public void editProfile() {

		Actions action = new Actions(driver);
		// explicitly waiting for the element to load
		profileName = HighlighterAndWait.explicitWait(5, "//input[@id='user_profile_name']");
		profileName.clear();
		profileName.sendKeys("Shubham Sharma");
		dropDown.click();

		// using keys action for dropdown
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.ARROW_DOWN);
		selAccount.click();
		bioText.clear();
		bioText.sendKeys("Hi I work in EPAM");
		userCompany.clear();
		userCompany.sendKeys("EPAM Systems");
		userLocation.clear();
		userLocation.sendKeys("Hyderabad");

	}

	public void javaScriptExecutor() {
		userURL.clear();
		// using javaScript executor,performing input action
		JavascriptExecutor jsExec = ((JavascriptExecutor) driver);
		jsExec.executeScript(
				"document.getElementById('user_profile_blog').setAttribute('value', 'https://www.epam.com/')");
		updateBtn.click();

	}

	public boolean profileUpadatedMessage() {
		return viewProfileLink.isDisplayed();
	}

	public void userSignOut() {
		avatarImg.click();
		signOut.submit();

	}

	public boolean isSignInPageVisible() {
		return signInLink.isDisplayed();
	}

}
