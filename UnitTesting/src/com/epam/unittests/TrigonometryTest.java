package com.epam.unittests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TrigonometryTest extends ConfigurationTest {

	@Test(dataProvider = "sineDataProvider")
	public void sineValueTest(double num, double expected) {
		ConfigurationTest.checkTime();
		double result = objCal.sin(num);
		Assert.assertEquals(result, expected, "result and expected values are not equal");
	}

	@Test(dataProvider = "cosDataProvider")
	public void cosValueTest(double num, double expected) {
		ConfigurationTest.checkTime();
		double result = objCal.cos(num);
		Assert.assertEquals(result, expected, "result and expected values are not equal");
	}

	@DataProvider(name = "sineDataProvider")
	public Object[][] valuesForSine() {
		return new Object[][] { { 0, 0.0 }, { 45, 0.8509035245341184 }, { -90, -0.8939966636005579 } };

	}

	@DataProvider(name = "cosDataProvider")
	public Object[][] valuesForCos() {
		return new Object[][] { { 0, 1.0 }, { 45, 0.70710678 }, { 270, 0.0 } };

	}

}
