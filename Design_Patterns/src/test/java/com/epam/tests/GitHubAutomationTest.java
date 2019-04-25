package com.epam.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.epam.businessobjects.User;

public class GitHubAutomationTest extends ConfigurationTest {

	private final String USERNAME = "shubhamsharma99";
	private static Logger logger = Logger.getLogger(GitHubAutomationTest.class);

	@Parameters({ "username", "password" })
	@Test(description = "This test method checks whether the user is successfully logged in")
	public void loginTest(String username, String password) {
		User testUser = steps.createUser(username, password);
		steps.loginGithub(testUser);
		Assert.assertTrue(steps.isLoggedIn(USERNAME));
		logger.info("User logged in successfully");
	}

	@Parameters({ "username", "password" })
	@Test(description = "This test method checks whether the user profile is successfully updated")
	public void editProfileTest(String username, String password) {
		User testUser = steps.createUser(username, password);
		steps.loginGithub(testUser);
		steps.githubEditProfile();
		Assert.assertTrue(steps.isProfileUpdated());
		logger.info("profile is updated successfully");
	}

	@Parameters({ "username", "password" })
	@Test
	public void logoutTest(String username, String password) {
		User testUser = steps.createUser(username, password);
		steps.loginGithub(testUser);
		Assert.assertTrue(steps.isUserLoggedOut());
		logger.info("user logged out successfully");
	}
}
