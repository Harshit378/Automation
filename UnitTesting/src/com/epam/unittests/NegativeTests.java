package com.epam.unittests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeTests extends ConfigurationTest {

	@Test
	public void divisionTest() {
		long result = objCal.div(6, 2);
		Assert.assertEquals(result, 4, "The actual result and expected value does not match,");
	}

	@Test
	public void multiplicationTest() {
		double result = objCal.mult(7.5, 3.27);
		Assert.assertEquals(result, 9, "The actual result and expected value does not match,");
	}

	@Test(groups = "numberSign")
	public void positiveValueTest() {
		boolean result = objCal.isPositive(7);
		Assert.assertEquals(result, false, "The actual result and expected value does not match,");
	}

	@Test(groups = "numberSign")
	public void negativeValueTest() {
		boolean result = objCal.isNegative(-6);
		Assert.assertEquals(result, false, "The actual result and expected value does not match,");
	}

	@Test(dataProvider = "sqrtDataProvider")
	public void squareRootTest(double num, double expected) {
		double result = objCal.sqrt(num);
		Assert.assertEquals(result, expected, "The actual result and expected value does not match,");
	}

	@DataProvider(name = "sqrtDataProvider")
	public Object[][] valuesForSQRT() {
		return new Object[][] { { 81, 88 }, { 25, 7 }, { 100, -1 } };

	}

}
