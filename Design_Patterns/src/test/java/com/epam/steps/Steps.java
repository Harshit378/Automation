package com.epam.steps;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.epam.businessobjects.User;
import com.epam.pages.LoginPage;
import com.epam.pages.UserProfilePage;
import com.epam.singletonpattern.WebDriverManager;

public class Steps implements Comparable<Object>{
	private WebDriver driver;
	private static Logger logger = Logger.getLogger(Steps.class);

	public void initBrowser() {
		driver = WebDriverManager.getWebDriverInstance("CHROME");
	}

	public void loginGithub(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.launchApplication();
		loginPage.login(username, password);
		logger.info("User logging in on GitHub");

	}

	public User createUser(String username, String password) {
		
		Comparator<User> AgeComparator = new Comparator<User>() {

	        public int compare(User e1, User e2) {
	            return e1.getUserName().compareTo(e2.getPassword());
	        }
	    };
	    
	    List<User> users = Arrays.asList(new User("Alan", "123"), new User("Bob", "!@#"),
	    		new User("Charlie", "7$5"));
	    
	    Collections.sort(users);
	    
	    System.out.println("***************");
	    System.out.println(users);
	    
	    Comparator.comparing(User::getUserName);
	    
	    Comparator<User> compareByFirstName = Comparator.comparing(e -> e.getUserName());
	   
		
		return new User(username, password);
	}

	public void loginGithub(User user) {
		this.loginGithub(user.getUserName(), user.getPassword());
	}

	public boolean isLoggedIn(String username) {
		LoginPage loginPage = new LoginPage(driver);
		return (loginPage.getLoggedInUsername().trim().toLowerCase().equals(username));
	}

	public void githubEditProfile() {
		UserProfilePage profilePage = new UserProfilePage(driver);
		profilePage.editProfile();
		profilePage.javaScriptExecutor();
		logger.info("User is editing profile");
	}

	public boolean isProfileUpdated() {
		UserProfilePage profilePage = new UserProfilePage(driver);
		return profilePage.profileUpadatedMessage();
	}

	public boolean isUserLoggedOut() {
		UserProfilePage profilePage = new UserProfilePage(driver);
		profilePage.userSignOut();
		return profilePage.isSignInPageVisible();
	}

	public void closeDriver() {
		WebDriverManager.destroyTheDriver();
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
