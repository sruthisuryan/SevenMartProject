package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class HomePageTestcase extends BaseSeleniumURL {
	public HomePage homepage;
  @Test
  public void verifyUserisabletoLogoutSuccessfully() {
	  //tr
	  LoginPage login = new LoginPage(driver);
	  login.enterUserNameAndenterPassword("admin", "admin");
	  
	  homepage=login.clickOnSignInButton();
	  homepage.logoutHomepage();
	  boolean homepageloaded= homepage.isMatchTitle();
	  
	  String expectedTitle="Login | 7rmart supermarket";
	  assertEquals(driver.getTitle(), expectedTitle, "The page title is not correct after logout.");
  }
}
