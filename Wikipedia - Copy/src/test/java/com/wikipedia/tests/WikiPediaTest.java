package com.wikipedia.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WikiPediaTest extends ConfigurationTest {

	@Test(description = "This test searches OOP in search bar")
	public void enterOOPinSearchBar() {
		homePage.launchWikipedia();
		homePage.searchOOP();
		Assert.assertEquals("https://en.wikipedia.org/wiki/OOP", homePage.isUserLandedOnOOPResultPage());
	}

	@Test
	public void clickOOPlink() {
		homePage.launchWikipedia();
		homePage.searchOOP();
		resultPage.clickOOPlink();
		Assert.assertEquals("https://en.wikipedia.org/wiki/Object-oriented_programming",
				resultPage.isUserLandedOnOOPPage());
	}

	@Test
	public void selectSoftwareEnggBooch() {
		homePage.launchWikipedia();
		homePage.searchOOP();
		resultPage.clickOOPlink();
		resultPage.showSoftwareEnggDetails();
		Assert.assertEquals("https://en.wikipedia.org/wiki/Grady_Booch", resultPage.isGradyBoochClicked());
	}

}
