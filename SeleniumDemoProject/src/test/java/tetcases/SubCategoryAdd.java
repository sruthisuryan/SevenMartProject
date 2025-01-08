package tetcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SubListCategories;
import constants.Constant;
//import utilities.ExcelUtilities;
import utilities.FileUploadUtility;

public class SubCategoryAdd extends BaseSeleniumURL {
	public HomePage homepage;
	public SubListCategories sublist;
	@Test
	public void verifyUserisableToUploadFileForSubcatogories() throws IOException, AWTException {
		
		  LoginPage login = new LoginPage(driver);
		 // String username =ExcelUtilities.getStringData(1, 0, "LoginPage"); //read from excel
		 // String password = ExcelUtilities.getStringData(1, 1, "LoginPage");
		  login.enterUserNameAndenterPassword("admin","admin");
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
	}
}
