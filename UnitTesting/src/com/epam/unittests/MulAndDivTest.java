package com.epam.unittests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MulAndDivTest extends ConfigurationTest {

	@Test(dataProvider = "divisionDataProvider")
	public void divisionTest(long num1, long num2, long expected) {
		ConfigurationTest.checkTime();
		long result = objCal.div(num1, num2);
		Assert.assertEquals(result, expected, "The actual result and expected value does not match,");
	}

	@Test(dataProvider = "multiplicationDataProvider")
	public void multiplicationTest(double num1, double num2, double expected) {
		ConfigurationTest.checkTime();
		double result = objCal.mult(num1, num2);
		Assert.assertEquals(result, expected, "The actual result and expected value does not match,");
	}

	@DataProvider(name = "multiplicationDataProvider")
	public Object[][] valuesForMultiplication() {
		return new Object[][] { { 0, 6, 0.0 }, { 10, 9, 90.0 }, { -4, 7.2, -29.0 } };
	}

	@DataProvider(name = "divisionDataProvider")
	public Object[][] valuesForDivision() {
		return new Object[][] { { 6, 2, 3 }, { 3, 3, 1 }, { 100, 25, 4 } };
	}

}
