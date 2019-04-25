package com.epam.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.epam.businessobjects.User;
import com.epam.pages.LoginPage;
import com.epam.pages.UserProfilePage;
import com.epam.singletonpattern.WebDriverManager;

public class Steps {
	private WebDriver driver;
	private static Logger logger = Logger.getLogger(Steps.class);

	public void initBrowser() {
		driver = WebDriverManager.getWebDriverInstance();
	}

	public void loginGithub(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.launchApplication();
		loginPage.login(username, password);
		logger.info("User logging in on GitHub");

	}

	public User createUser(String username, String password) {
		return new User(username, password);
	}

	public void loginGithub(User user) {
		this.loginGithub(user.getUserName(), user.getPassword());
	}

	public boolean isLoggedIn(String username) {
		LoginPage loginPage = new LoginPage(driver);
		return (loginPage.getLoggedInUsername().trim().toLowerCase().equals(username));
	}

	public void githubEditProfile() {
		UserProfilePage profilePage = new UserProfilePage(driver);
		profilePage.editProfile();
		profilePage.javaScriptExecutor();
		logger.info("User is editing profile");
	}

	public boolean isProfileUpdated() {
		UserProfilePage profilePage = new UserProfilePage(driver);
		return profilePage.profileUpadatedMessage();
	}

	public boolean isUserLoggedOut() {
		UserProfilePage profilePage = new UserProfilePage(driver);
		profilePage.userSignOut();
		return profilePage.isSignInPageVisible();
	}

	public void closeDriver() {
		WebDriverManager.destroyTheDriver();
	}

}
