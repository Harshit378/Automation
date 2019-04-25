package com.epam.unittests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddAndSubTest extends ConfigurationTest {

	@Test(dataProvider = "additionDataProvider", groups = "addition")
	public void oneNumPlusAnother(long num1, long num2, long expected) {
		ConfigurationTest.checkTime();
		long result = objCal.sum(num1, num2);
		Assert.assertEquals(result, expected, "result and expected values are not equal");
	}

	@Test(dataProvider = "subtractionDataProvider")
	public void subtractionTest(long num1, long num2, long expected) {
		ConfigurationTest.checkTime();
		double result = objCal.sub(10, 3);
		Assert.assertEquals(result, 7.0, "result and expected values are not equal");

	}

	@Test(groups = "addition")
	public void tenPlusFiveEqualsFifteen() {
		ConfigurationTest.checkTime();
		double result = objCal.sum(10.0, 5.0);
		Assert.assertEquals(result, 15.0, "result and expected values are not equal");
	}

	@DataProvider(name = "additionDataProvider")
	public Object[][] valuesForAddition() {
		return new Object[][] { { 6, 6, 12 }, { 3, 2, 5 }, { 100, 47, 147 }, { 8, -9, -1 } };
	}

	@DataProvider(name = "subtractionDataProvider")
	public Object[][] valuesForSubtraction() {
		return new Object[][] { { 6, 6, 0 }, { 3, 2, 1 }, { 100, 47, 53 }, { 8, -9, 17 } };
	}
}
