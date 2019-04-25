package com.epam.unittests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowAndSqrtTest extends ConfigurationTest {
	@Test(description = "This test checks the power of the number")
	public void powerTest() {
		ConfigurationTest.checkTime();
		double result = objCal.pow(2, 3);
		Assert.assertEquals(result, 8.0, "result and expected values are not equal");
	}

	@Test(dataProvider = "sqrtDataProvider")
	public void squareRootTest(double num, double expected) {
		ConfigurationTest.checkTime();
		double result = objCal.sqrt(num);
		Assert.assertEquals(result, expected, "result and expected values are not equal");
	}

	@DataProvider(name = "sqrtDataProvider")
	public Object[][] valuesForSQRT() {
		return new Object[][] { { 81, 9.0 }, { 25, 5.0 }, { 0, 0.0 } };

	}
}
