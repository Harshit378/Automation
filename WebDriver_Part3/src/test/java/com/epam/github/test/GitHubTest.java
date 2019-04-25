package com.epam.github.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.epam.github.pages.LoginPage;
import com.epam.github.pages.UserProfilePage;

public class GitHubTest extends ConfigurationTest {
	@Test(description = "This test method checks whether the application is successfully launched")
	public void launchGitHUbTest() {
		objLogin = new LoginPage(driver);
		objLogin.launchApplication();
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Sign in to GitHub · GitHub");
		System.out.println("GitHub launched successfully");

	}

	@Parameters({ "username", "password" })
	@Test(description = "This test method checks whether the user is successfully logged in")
	public void LoginTest(String username, String password) {
		objLogin = new LoginPage(driver);
		objLogin.launchApplication();
		objLogin.login(username, password);
		String loggedInUser = objLogin.isUserNameVisible();
		Assert.assertEquals(loggedInUser, "shubhamsharma99");
		System.out.println("User logged in successfully");

	}

	@Parameters({ "username", "password" })
	@Test(description = "This test method checks whether the user profile is successfully updated")
	public void UpdateProfileTest(String username, String password) {
		objLogin = new LoginPage(driver);
		objUser = new UserProfilePage(driver);
		objLogin.launchApplication();
		objLogin.login(username, password).editProfile();
		Assert.assertTrue(objUser.isProfileUpadated());
		objUser.dragAndDropProfilePic();
		System.out.println("User has updated his profile");
	}

	@Parameters({ "username", "password" })
	@Test
	public void javaScriptExecuterTest(String username, String password) {
		objLogin = new LoginPage(driver);
		objUser = new UserProfilePage(driver);
		objLogin.launchApplication();
		objLogin.login(username, password).javaScriptExecutor();
		Assert.assertTrue(objUser.isProfileUpadated());
		System.out.println("User has updated his profile");
	}
	@Parameters({ "username", "password" })
	@Test
	public void logOutTest(String username, String password) {
		objLogin = new LoginPage(driver);
		objUser = new UserProfilePage(driver);
		objLogin.launchApplication();
		objLogin.login(username, password).userSignOut();
		Assert.assertTrue(objUser.isUserLoggedOut());
		System.out.println("User logged out");
	}

}
