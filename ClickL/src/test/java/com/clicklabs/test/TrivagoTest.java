package com.clicklabs.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TrivagoTest extends ConfigurationTest{
  @Test
  public void testMethod1(){
	  objLand.launchApplication();
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals("trivago.in: The world's top hotel search engine",actualTitle);
  }
  
  @Parameters({"email" , "password"})
  @Test
  public void testMethod2(String email,String password){
	  objLand.loginTrivago(email, password);
	  Assert.assertEquals("aish29sharma@gmail.com", objLand.checkUsername());
}
  
 @Test
 public void testMethod3() throws InterruptedException
 {
	 objLand.method3();
 }

}