package com.epam.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.singletonpattern.WebDriverManager;

public  class HighlighterAndWait  {
	
	
	public static void javaScriptHighlighter(WebElement element, String highlightColor, String defaultColor) {
		WebDriver driver =  WebDriverManager.getWebDriverInstance();
		JavascriptExecutor jsExec = ((JavascriptExecutor) driver);

		jsExec.executeScript("arguments[0].style.backgroundColor = '" + highlightColor + "'", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		jsExec.executeScript("arguments[0].style.backgroundColor = '" + defaultColor + "'", element);

	}
	public static WebElement explicitWait(int time, String locator) {
		WebDriver driver =  WebDriverManager.getWebDriverInstance();
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

}
