package testcase;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SearchAdminUserAndDelete;
import constants.Constant;
import utilities.ExcelUtilities;

public class SearchUserDeleteTestcase extends BaseSeleniumURL{
	public HomePage home;
	public SearchAdminUserAndDelete searchdelete;
	
	
  @Test
  public void verifyUserIsableToDeleteSearchedUser() throws IOException {
	  
	  LoginPage login = new LoginPage(driver);
	  String username =ExcelUtilities.getStringData(1, 0, "LoginPage"); //read from excel
	  String password = ExcelUtilities.getStringData(1, 1, "LoginPage");
	  login.enterUserNameAndenterPassword(username,password);
	  home = login.clickOnSignInButton();
	 searchdelete = home.searchUserDelete();
	searchdelete.clickOnSearch();
	searchdelete.addUsernameAndUsertype("Aarav");
	//searchdelete.userTypeSelect("admin");
	searchdelete.searchbuttonClickToVerify();
	searchdelete.deleteUser();
	//searchdelete.resetButtonClickToVerify();
	searchdelete.homeLinkClick();
	 boolean isHomepageloaded = login.isDashboardLoaded();
	  assertTrue(isHomepageloaded,Constant.ERRORMESSAGE);
	
	 
  }
}
