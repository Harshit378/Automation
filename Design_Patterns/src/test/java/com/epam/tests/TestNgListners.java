package com.epam.tests;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.epam.utilities.Screenshot;


public class TestNgListners implements ITestListener {
	private static Logger logger = Logger.getLogger(TestNgListners.class);
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult Result) {
		new Screenshot().captureScreenshot(Result);
		logger.info("Captured screenshot for failed test: "+Result.getName());
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult Result) {
		new Screenshot().captureScreenshot(Result);
		logger.info("Captured screenshot for passed test: "+Result.getName());
		
		
	}

}
