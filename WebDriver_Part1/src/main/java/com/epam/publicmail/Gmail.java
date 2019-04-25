package com.epam.publicmail;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmail {

	WebDriver driver;

	public Gmail(WebDriver driver) {
		this.driver = driver;
	}

	public static final String MAIL_ADDRESSEE = "singhabc@yahoooo.in";
	public static final String MAIL_SUBJECT = "Testing mail";
	public static final String MAIL_BODY = "This is message body";
	public static final String GMAIL_URL = "https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier";

	public void launchGmail(String url) {
		driver.get(GMAIL_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void login(String username, String password) {
		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys(username);
		WebElement nextBtn = driver.findElement(By.id("next"));
		nextBtn.submit();
		WebElement userPassword = driver.findElement(By.xpath("//input[@name='Passwd']"));
		userPassword.sendKeys(password);
		WebElement signInBtn = driver.findElement(By.name("signIn"));
		signInBtn.submit();

	}

	public boolean isUserLoggedIn() {
		WebElement profileBtn = driver.findElement(By.cssSelector("span[class='gb_9a gbii']"));
		profileBtn.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement signOutBtn = driver.findElement(By.linkText("Sign out"));
		return signOutBtn.isDisplayed();
	}

	public void composeNewMail() throws InterruptedException {
		WebElement composeBtn = driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]"));
		composeBtn.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement mailRecipient = driver.findElement(By.name("to"));
		mailRecipient.sendKeys(MAIL_ADDRESSEE);
		WebElement subject = driver.findElement(By.name("subjectbox"));
		subject.sendKeys(MAIL_SUBJECT);
		WebElement bodyMessage = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
		bodyMessage.sendKeys(MAIL_BODY);
		WebElement closeBtn = driver.findElement(By.cssSelector("img[alt='Close']"));
		closeBtn.click();
	}

	public void closeNewMail() {
		driver.switchTo().parentFrame();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement draftsLink = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[@href='https://mail.google.com/mail/u/0/#drafts']")));
		draftsLink.click();
	}

	public boolean isDraftMessagePresent() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement testMailDraft = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Testing mail')]")));
		return testMailDraft.isEnabled();
	}

	public void verifyDraftContent() {
		WebElement draftMail = driver.findElement(By.xpath("//span[contains(text(),'Testing mail')]"));
		draftMail.click();
	}

	public String checkMailAddressee() {
		WebElement mailRecipient = driver.findElement(By.xpath("//div[@class='oL aDm az9']/span"));
		return mailRecipient.getText();
	}

	public String checkMailSubject() {
		WebElement mailSubject = driver.findElement(By.className("aYF"));
		return mailSubject.getText();
	}

	public String checkMailBody() {
		WebElement mailBody = driver.findElement(By.cssSelector("div[aria-label='Message Body']"));
		return mailBody.getText();
	}

	public void sendMail() {
		WebElement sendBtn = driver.findElement(By.xpath("//div[contains(text(),'Send')]"));
		sendBtn.click();
		driver.navigate().refresh();
		// sometimes alert is coming
		driver.switchTo().alert().accept();
		driver.navigate().refresh();
	}

	public boolean isDraftEmpty() {
		WebElement emptyDraft = driver.findElement(By.xpath("//td[contains(text(),'You don')]"));
		return emptyDraft.isDisplayed();
	}

	public boolean isMailPresentInSent() {
		WebElement sentMailLink = driver.findElement(By.linkText("Sent Mail"));
		sentMailLink.click();
		return driver.findElement(By.xpath("//span[contains(text(),'Testing mail')]")).isEnabled();
	}

	public void logOut() {
		WebElement profileBtn = driver.findElement(By.cssSelector("span[class='gb_9a gbii']"));
		profileBtn.click();
		WebElement signOutBtn = driver.findElement(By.linkText("Sign out"));
		signOutBtn.click();
	}

	public boolean isUserLoggedOut() {
		WebElement signInText = driver.findElement(By.xpath("//h2[contains(text(),'Sign in to continue to Gmail')]"));
		return signInText.isDisplayed();
	}
}
