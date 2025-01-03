package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.AdminUserClick;
import Pages.LoginPage;
import dev.failsafe.internal.util.Assert;
import utilities.ExcelUtilities;
import Pages.HomePage;

public class AdminUserSelectionTestcase extends BaseSeleniumURL {
	public HomePage homepage;
	public AdminUserClick adminuser;

	@Test
	@Parameters({"username","password"})
	public void verifytheUserisAbletoCreateNewUserDetails(String username,String password) throws IOException {

		LoginPage login = new LoginPage(driver);
		
		login.enterUserNameAndenterPassword(username,password);
		homepage = login.clickOnSignInButton();
		adminuser = homepage.adminUserClick();
		adminuser.newButtonClick();
		
		String adminname = ExcelUtilities.getStringData(1, 0, "AdminUserPageName");
		String adminid= ExcelUtilities.getIntegerData(1, 1, "AdminUserPageName");
		adminuser.adminUserInformation(adminname,adminid);
		adminuser.userTypeDropdownSelection("Staff");
		adminuser.saveUserDetails();
		homepage.logoutHomepage();
		boolean isDashboardtext = adminuser.isAlertMessageMatch();
		String actualText = "Admin Users | 7rmart supermarket";
		assertEquals(driver.getTitle(), actualText, "Popup message does not match!");
		
//yy
	}
}
