package testcase;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MainCategory;
import constants.Constant;
import utilities.ExcelUtilities;

public class MainCatogoryTestcase extends BaseSeleniumURL {
	public HomePage home;
	public MainCategory main;
	
	public void verifytheuserIsabletoAddCategoryDetails() throws IOException, AWTException
	{
		 LoginPage login = new LoginPage(driver);
		  String username =ExcelUtilities.getStringData(1, 0, "LoginPage"); //read from excel
		  String password = ExcelUtilities.getStringData(1, 1, "LoginPage");
		  login.enterUserNameAndenterPassword(username,password);
		  home = login.clickOnSignInButton();
		  main = home.mainCatogoryClickFromDashboard();
		  main.newButtonClickfromProductList();
		  main.enterCategorytoPassValue("userproduct");
		  main.fileUploadforProduct();
		  main.valuesSelectionAndSave();
		  boolean isHomepageloaded = login.isDashboardLoaded();
		  assertTrue(isHomepageloaded,Constant.ERRORMESSAGE);
	}

}
