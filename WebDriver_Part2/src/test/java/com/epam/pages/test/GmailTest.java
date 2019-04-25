package com.epam.pages.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.epam.app.pages.LandingPage;
import com.epam.app.pages.LoginPage;

public class GmailTest extends ConfigurationTest {

	@Test(description = "This test methods checks whether the application is successfully launched", priority = 0)
	public void launchAppTest() {
		objLogin.launchGmail(LoginPage.GMAIL_URL);
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Gmail");
		System.out.println("Application has launched successfully");
	}

	@Parameters({ "username", "password" })
	@Test(priority = 1)
	public void loginTest(String username, String password) throws IOException, InterruptedException {
		objLogin.login(username, password);
		Assert.assertTrue(objLand.isUserLoggedIn());
		System.out.println("User has signed In");
	}

	@Test(priority = 2)
	public void composeAndDraftMailTest() {

		objLand.composeAndCloseNewMail();
		objDrafts.clickDrafts();
		Assert.assertTrue(objDrafts.isDraftMessagePresent());
		System.out.println("Draft message is present in the draft folder");
	}

	@Test(priority = 3)
	public void verifyDraftSubject() {
		objDrafts.verifyDraftContent();
		Assert.assertEquals(objDrafts.checkMailSubject(), LandingPage.MAIL_SUBJECT);
		System.out.println("Subject is same");
	}

	@Test(priority = 4)
	public void verifyDraftRecipient() {
		Assert.assertEquals(objDrafts.checkMailAddressee(), LandingPage.MAIL_ADDRESSEE);
		System.out.println("Recipient is same");
	}

	@Test(priority = 5)
	public void verifyDraftBody() {
		Assert.assertEquals(objDrafts.checkMailBody(), LandingPage.MAIL_BODY);
		System.out.println("Body message is same");
	}

	@Test(priority = 6)
	public void sendDraftTest() {
		objDrafts.sendMail();
		Assert.assertTrue(objDrafts.isDraftEmpty());
		System.out.println("Draft folder is empty now");
	}

	@Test(priority = 7)
	public void sentMailTest() {
		Assert.assertTrue(objSent.isMailPresentInSent());
		System.out.println("Mail is present in sent");
	}

	@Test(priority = 8)
	public void logOuttest() {
		objSent.logOut();
		Assert.assertTrue(objSent.isUserLoggedOut());
		System.out.println("User has logged out successfully");
	}

	// Sample test with page’s methods return new page objects

/*	@Test
	public void Test1() {
		objLogin.launchGmail(LoginPage.GMAIL_URL);
		objLogin.login("abcd", "xyza").composeAndCloseNewMail().clickDrafts();
	}

	@Test(dependsOnMethods = "Test2")
	public void Test2() {
		objDrafts.verifyDraftContent();
		objDrafts.sendMail().logOut();
	}*/

}
