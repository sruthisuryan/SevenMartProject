package testcase;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;
import constants.Constant;
import utilities.ExcelUtilities;





public class LoginTestcase extends BaseSeleniumURL {
	
	@DataProvider(name="Credentials")
	public Object[][] testData()
	{
		Object data[][]= {{"admin","admin"},{"admin","123"}};
		return data;
		
	}

  @Test(dataProvider = "Credentials")
  public void verifyuserisableToLoginValidCredentials(String username,String password) {
	  
	  
	  LoginPage login = new LoginPage(driver);
	  login.enterUserNameAndenterPassword(username,password);
	  login.clickOnSignInButton();
	  boolean isHomepageloaded = login.isDashboardLoaded();
	  assertTrue(isHomepageloaded,Constant.ERRORMESSAGE);//hh
	  
  }
  @Test(groups = {"Regression"})
  public void verifyUserIsableToLoginwithValidUsernameandInvalidPassword() throws IOException
  {
	  LoginPage login = new LoginPage(driver);
	  String username =ExcelUtilities.getStringData(1, 0, "LoginPage"); //read from excel
	  String password = ExcelUtilities.getStringData(1, 1, "LoginPage");
	  login.enterUserNameAndenterPassword(username,password);
	  login.clickOnSignInButton();
	  boolean isHomepageloaded = login.isDashboardLoaded();
	  assertTrue(isHomepageloaded,Constant.ERRORMESSAGE);
  }
  @Test(groups = {"Regression"})
  public void verifyUserIsableToLoginwithInValidUsernameandInvalidPassword()
  {
	  LoginPage login = new LoginPage(driver);
	  login.enterUserNameAndenterPassword("admin", "admin");
	  login.clickOnSignInButton();
	  boolean isHomepageloaded = login.isDashboardLoaded();
	  assertTrue(isHomepageloaded,Constant.ERRORMESSAGE);
  }
  
  
}
