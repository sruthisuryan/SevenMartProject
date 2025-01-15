package testcase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.AdminUserClick;
import Pages.AdminUserSearch;
import Pages.HomePage;
import Pages.LoginPage;
import constants.Constant;
import utilities.ExcelUtilities;

public class AdminUserSearchTestCase extends BaseSeleniumURL {

	public HomePage homepage;
	public AdminUserClick adminuser;
	public AdminUserSearch adminusersearch;

	@Test
	@Parameters({ "username", "password","adminname","adminID" })
	public void verifyUserIsableToSearchUsernameandType(String username, String password,String adminname,String adminID){
		

		LoginPage login = new LoginPage(driver);
		
		login.enterUserNameAndenterPassword(username, password);
		homepage = login.clickOnSignInButton();
		adminuser = homepage.adminUserClick();
		adminusersearch = adminuser.searchuserButtonClick();
		adminusersearch.searchbuttonClickToVerify();
		
		adminusersearch.addUsernameAndUsertype(adminname);

		adminusersearch.userTypeSelect(adminID);
		
		adminusersearch.searchbuttonClickToVerify();
		boolean isDashboardtext = adminusersearch.isAlertMessageMatch();
		String actualText = "Admin Users | 7rmart supermarket";
		assertEquals(driver.getTitle(), actualText, Constant.ERRORMESSAGE);

	}
}