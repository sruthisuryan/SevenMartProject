package testcase;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ListProducts;
import Pages.LoginPage;
import Pages.SearchListProductSearch;
import constants.Constant;
import utilities.ExcelUtilities;

public class SearchProductTestcase extends BaseSeleniumURL{
	
	public HomePage home;
	
	public SearchListProductSearch search;
  @Test
  public void verifyUserisableToSearchProduct() throws IOException {
	  LoginPage login = new LoginPage(driver);
	  String username =ExcelUtilities.getStringData(1, 0, "LoginPage"); //read from excel
	  String password = ExcelUtilities.getStringData(1, 1, "LoginPage");
	  login.enterUserNameAndenterPassword(username,password);
	  home = login.clickOnSignInButton();
	  search = home.searchProduct();
	  search.searchbuttonclick();
	  search.searchByValue("PONDS SANDAL TALC - 100g");
	  search.clicksearchbutton();
	  search.restValue();
	  search.homeLink();
	  boolean isHomepageloaded = login.isDashboardLoaded();
	  assertTrue(isHomepageloaded,Constant.ERRORMESSAGE);
	  
  }
}
