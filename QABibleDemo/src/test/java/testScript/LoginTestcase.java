package testScript;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTestcase extends Base {
  

@Test
  public void verifyuserisableToLoginValidCredentials() {
	  
	   
	  LoginPage login =  new LoginPage(driver);
	  login.enterUserNameAndenterPassword("carol", "1q2w3e4r");  
	  login.clickOnLoginButton();
	  boolean isHomepageisLoaded = login.isDashboardLoaded();
	  assertTrue(isHomepageisLoaded,"Dashboard not loaded");
	  
  }
  
}
