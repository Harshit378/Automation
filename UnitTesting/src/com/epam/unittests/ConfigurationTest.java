package com.epam.unittests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.epam.tat.module4.Calculator;

public class ConfigurationTest {

	Calculator objCal = null;

	@BeforeClass(description = "Method will be invoked before executing tests")
	public void setUp() {
		System.out.println("In Setup,setting up objects");
		objCal = new Calculator();
	}

	public static void checkTime() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));
	}

	@AfterClass(description = "Method will be invoked after executing tests")
	public void tearDown() {
		System.out.println("In Teardown,destroying objects");
		objCal = null;
	}
}
