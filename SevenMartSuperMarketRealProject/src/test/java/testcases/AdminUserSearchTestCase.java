package testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.AdminUserClick;
import Pages.AdminUserSearch;
import Pages.HomePage;
import Pages.LoginPage;
import utilities.ExcelUtilities;

public class AdminUserSearchTestCase extends BaseSeleniumURL {

	public HomePage homepage;
	public AdminUserClick adminuser;
	public AdminUserSearch adminusersearch;

	@Test
	@Parameters({ "username", "password","adminname","adminID" })
	public void verifyUserIsableToSearchUsernameandType(String username, String password,String adminname,String adminID) throws IOException {
		
	

		LoginPage login = new LoginPage(driver);
		
		
		/*
		 * String usernamefield = ExcelUtilities.getStringData(1, 0, "LoginPage");
		 * String passwordfield = ExcelUtilities.getStringData(1, 1, "LoginPage");
		 */

		login.enterUserNameAndenterPassword(username, password);
		homepage = login.clickOnSignInButton();
		adminuser = homepage.adminUserClick();
		/*String adminname = ExcelUtilities.getStringData(1, 0, "AdminUserSearch");
		String adminid = ExcelUtilities.getIntegerData(1, 1, "AdminUserSearch");*/
		adminusersearch = adminuser.searchuserButtonClick();
		adminusersearch.searchbuttonClickToVerify();
		
		adminusersearch.addUsernameAndUsertype(adminname);

		adminusersearch.userTypeSelect(adminID);
		
		adminusersearch.searchbuttonClickToVerify();

	}
}
