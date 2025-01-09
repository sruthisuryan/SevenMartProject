package testcase;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ListProducts;
import Pages.LoginPage;
import constants.Constant;
import utilities.ExcelUtilities;


public class ListProductTestcases extends BaseSeleniumURL {
	public HomePage home;
	public ListProducts list;
  @Test
  public void verifytheuserIsableAddProductDetails() throws IOException, AWTException {
	  
	  LoginPage login = new LoginPage(driver);
	  String username =ExcelUtilities.getStringData(1, 0, "LoginPage"); //read from excel
	  String password = ExcelUtilities.getStringData(1, 1, "LoginPage");
	  login.enterUserNameAndenterPassword(username,password);
	  home = login.clickOnSignInButton();
	  list = home.manageProductClick();
	  list.enterCategorytoPassValue("abc");
	  list.fileUploadforProduct();
	  list.valuesSelectionAndSave();
	  boolean isHomepageloaded = login.isDashboardLoaded();
	  assertTrue(isHomepageloaded,Constant.ERRORMESSAGE);
  }	  
  }
