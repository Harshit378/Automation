package steps;

import org.openqa.selenium.WebDriver;

import businessObjects.User;
import pages.LoginPage;
import pages.UserProfilePage;
import utils.WebDriverManager;

public class Steps {
	private WebDriver driver;

	public void initBrowser() {
		WebDriverManager objDrivers = WebDriverManager.getInstance();
		driver = objDrivers.launchAndReturnDriver("chrome");

	}

	public void loginGithub(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.launchApplication();
		loginPage.login(username, password);
		;
	}
	
	public User createUser(String username,String password)
	{
		return new User(username,password);
	}
	
	public void loginGithub(User user) {
		this.loginGithub(user.getUserName(),user.getPassword());
	}

	public boolean isLoggedIn(String username) {
		LoginPage loginPage = new LoginPage(driver);
		return (loginPage.getLoggedInUsername().trim().toLowerCase().equals(username));
	}

	public void githubEditProfile() {
		UserProfilePage profilePage = new UserProfilePage(driver);
		profilePage.editProfile();
		profilePage.javaScriptExecutor();
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
		WebDriverManager objDrivers = WebDriverManager.getInstance();
		objDrivers.destroyTheDriver();
	}

}
