package com.epam.publicmailtests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.epam.publicmail.Gmail;

public class GmailTest extends ConfigurationTest {

	@Test(description = "This test methods checks whether the application is successfully launched", priority = 0)
	public void launchAppTest() {
		objGmail.launchGmail(Gmail.GMAIL_URL);
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Gmail");
	}

	@Parameters({ "username", "password" })
	@Test(dependsOnMethods = "launchAppTest", priority = 1)
	public void loginTest(String username, String password) {
		objGmail.login(username, password);
		Assert.assertTrue(objGmail.isUserLoggedIn(), "User failed to login");
	}

	@Test(dependsOnMethods = "loginTest", priority = 2)
	public void composeDraftTest() throws InterruptedException {
		objGmail.composeNewMail();
		objGmail.closeNewMail();
		Assert.assertTrue(objGmail.isDraftMessagePresent(), "Draft message is not present in Drafts");
	}

	@Test(dependsOnMethods = "composeDraftTest", priority = 3)
	public void draftContentTest() throws InterruptedException {
		objGmail.verifyDraftContent();
		Assert.assertEquals(objGmail.checkMailAddressee(), Gmail.MAIL_ADDRESSEE);
		Assert.assertEquals(objGmail.checkMailSubject(), Gmail.MAIL_SUBJECT);
		Assert.assertEquals(objGmail.checkMailBody(), Gmail.MAIL_BODY);
	}

	@Test(dependsOnMethods = "draftContentTest", priority = 4)
	public void sendMailTest() throws InterruptedException {
		objGmail.sendMail();
		Assert.assertTrue(objGmail.isDraftEmpty());
		Assert.assertTrue(objGmail.isMailPresentInSent());
	}

	@Test(dependsOnMethods = "sendMailTest", priority = 5)
	public void logOutTest() {
		objGmail.logOut();
		Assert.assertTrue(objGmail.isUserLoggedOut());
	}
}
