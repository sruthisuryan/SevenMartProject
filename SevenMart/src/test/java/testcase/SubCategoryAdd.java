package testcase;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SubListCategories;
import constants.Constant;
import utilities.ExcelUtilities;
import utilities.FileUploadUtility;

public class SubCategoryAdd extends BaseSeleniumURL {
	public HomePage homepage;
	public SubListCategories sublist;
	@Test
	public void verifyUserisableToUploadFileForSubcatogories() throws IOException, AWTException {
		
		  LoginPage login = new LoginPage(driver);
		  String username =ExcelUtilities.getStringData(1, 0, "LoginPage"); //read from excel
		  String password = ExcelUtilities.getStringData(1, 1, "LoginPage");
		  login.enterUserNameAndenterPassword(username,password);
		  homepage = login.clickOnSignInButton();
		  sublist = homepage.listcategoriesClick(); 
		  sublist.newListButtonClick();
		  
		  //String addcat = ExcelUtilities.getStringData(1, 0, "AddCategory");
		  sublist.selectCatogoryFromDropdown("Toys");
		 // String subcat = ExcelUtilities.getStringData(1, 1, "AddCategory");
		  sublist.addSubCategories("test");
	
		  //etayhd
         sublist.uploadimage();
        sublist.saveClick();
        boolean isDashboardtext = sublist.isDashboardLoaded();
		String actualText = "Admin Users | 7rmart supermarket";
		assertEquals(driver.getTitle(), actualText, Constant.ERRORMESSAGE);
	}
}