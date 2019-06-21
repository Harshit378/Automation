package com.epam.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.epam.singletonpattern.WebDriverManager;

public class Screenshot {

	private String PROJECT_ROOT_PATH = System.getProperty("user.dir");

	public final static String getDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}

	public final static String getDateTime() {
		DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss.SSS");
		return dtf.format(new Date());
	}

	public void captureScreenshot(ITestResult result) {
		String methodName = result.getName().toString().trim();
		String currentDir = PROJECT_ROOT_PATH + "/target/" + new File("Test Screenshots");

		String folderNameWithTimeStamp = getDate();

		String screenshotNameWithTimeStamp = getDateTime();

		String finalPath = currentDir + "\\" + folderNameWithTimeStamp;

		File f1 = new File(finalPath);
		f1.mkdir();
		WebDriver driver = WebDriverManager.getWebDriverInstance("CHROME");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = f1 + "\\" + screenshotNameWithTimeStamp + "_" + methodName + ".jpeg";
		try {
			FileUtils.copyFile(scrFile, new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
