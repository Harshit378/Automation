package com.click.pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends Constants {

	WebDriver driver;

	@FindBy(xpath = EMAIL)
	private static WebElement btnEMAIL;

	@FindBy(xpath = PASSWORD)
	private static WebElement btnPASSWORD;

	@FindBy(xpath = SUBMIT)
	private static WebElement btnSUBMIT;

	@FindBy(xpath = "//header[@id='js_navigation']/div/div[3]/button")
	private static WebElement loggedUser;
	
	@FindBy(xpath = "//span[contains(text(),'Search')]")
	private static WebElement searchBtn;
	
	@FindBy(xpath = ".//*[@id='js-fullscreen-hero']/div/form/div[2]/div/div[1]/button")
	private static  WebElement checkIn;

	public String baseUrl = " https://www.trivago.in/";

	public LandingPage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void launchApplication() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		// maximize the browser window
		driver.manage().window().maximize();

	}

	public String checkUsername() {
		return loggedUser.getText();
	}

	public void loginTrivago(String email, String password) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement profile = driver.findElement(By.xpath("//button[@data-log='100:2364:19']"));
		profile.click();
		// enter a valid username in the email textbox
		WebElement login = driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
		login.click();
		btnEMAIL.click();
		btnEMAIL.sendKeys(email);
		btnPASSWORD.click();
		btnPASSWORD.sendKeys(password);
		btnSUBMIT.click();
	}

	public void method3() throws InterruptedException {
		searchBtn.click();
        Thread.sleep(1000);
		checkIn.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'28')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'29')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Single Room')]")).click();
	}

	public void method4() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='mf-select-sortby']")).click();
		Random rnd = new Random();
		Thread.sleep(1000);
		List<WebElement> radios = driver.findElements(By.xpath("//*[@id='mf-select-sortby']/option[*]"));
		Thread.sleep(1000);
		radios.get(rnd.nextInt(radios.size())).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'View Deal')]")).click();
		driver.quit();
	}

}
