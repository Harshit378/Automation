package com.epam.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.utilities.HighlighterAndWait;





public class LoginPage extends AbstractPage {

	@FindBy(id = "login_field")
	private static WebElement userName;

	@FindBy(name = "password")
	private static WebElement passWord;

	@FindBy(xpath = "//input[@value='Sign in']")
	public static WebElement signIn;

	@FindBy(xpath = "//img[@class='avatar']")
	private static WebElement avatarImg;

	@FindBy(xpath = "//strong[contains(text(),'shubhamsharma99')]")
	private static WebElement checkName;

	@FindBy(linkText = "Sign in")
	private static WebElement signInLink;

	public final String URL = "https://github.com/settings/profile";

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void launchApplication() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public UserProfilePage login(String username, String password) {;
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String bgColorUserName = userName.getCssValue("backgroundColor");
		String bgColorPassWord = userName.getCssValue("backgroundColor");

		// invoking highlighter method to highlight username field
		HighlighterAndWait.javaScriptHighlighter(userName, "yellow", bgColorUserName);

		userName.sendKeys(username);
		// invoking highlighter method to highlight password field
		HighlighterAndWait.javaScriptHighlighter(passWord, "green", bgColorPassWord);

		passWord.sendKeys(password);

		signIn.click();
		return new UserProfilePage(driver);

	}

	public String getLoggedInUsername() {
		avatarImg.click();
		return checkName.getText();
		 

	}
}
