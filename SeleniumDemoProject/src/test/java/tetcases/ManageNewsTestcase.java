package tetcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageNews;
import constants.Constant;


public class ManageNewsTestcase extends BaseSeleniumURL {
	public HomePage homepage;
	public ManageNews news;
	  
	@DataProvider(name="Credentials")
	public Object[][] testData()
	{
		Object data[][]=  { {"admin","admin"} };
		return data;
		 
	//hfdsk	
	}
	 @Test(dataProvider = "Credentials")
  public void verifyUserisAbletoEnterManageNews(String username,String password) {
	  
	  LoginPage login = new LoginPage(driver);
	  login.enterUserNameAndenterPassword(username,password);
	  
	  homepage = login.clickOnSignInButton();
	  
	  news = homepage.manageNewsClick();
	  news.newButtonClick();
	  news.enterNewstoSend("Hello");
	  news.saveButtonClick();
	  String expectedTitle="Add News | 7rmart supermarket";
	 // assertEquals(driver.getTitle(), expectedTitle, Constant.ERRORMESSAGE);
  }
}
