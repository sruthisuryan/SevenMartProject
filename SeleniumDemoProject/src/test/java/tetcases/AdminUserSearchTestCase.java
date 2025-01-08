package tetcases;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AdminUserClick;
import pages.AdminUserSearch;
import pages.HomePage;
import pages.LoginPage;

public class AdminUserSearchTestCase extends BaseSeleniumURL {

	public HomePage homepage;
	public AdminUserClick adminuser;
	public AdminUserSearch adminusersearch;

	@Test
	@Parameters({ "username", "password","adminname","adminID" })
	public void verifyUserIsableToSearchUsernameandType(String username, String password,String adminname,String adminID){
		
	//yu

		LoginPage login = new LoginPage(driver);
		
		login.enterUserNameAndenterPassword(username, password);
		homepage = login.clickOnSignInButton();
		adminuser = homepage.adminUserClick();
		adminusersearch = adminuser.searchuserButtonClick();
		adminusersearch.searchbuttonClickToVerify();
		
		adminusersearch.addUsernameAndUsertype(adminname);

		adminusersearch.userTypeSelect(adminID);
		
		adminusersearch.searchbuttonClickToVerify();

	}
}