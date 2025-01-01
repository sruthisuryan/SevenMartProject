package testScript;

import org.testng.annotations.Test;

import pages.ClientClick;
import pages.HomePage;
import pages.LoginPage;

public class ClientsPage extends Base{
	public HomePage homepage;
	public ClientClick client;
	
  @Test
  public void verifyUserIsableToSearchClientUserNameAndId() {
	  
	  LoginPage login = new LoginPage(driver);
		login.enterUserNameAndenterPassword("carol", "1q2w3e4r");
		homepage = login.clickOnLoginButton();
		client = homepage.clientClick();
		client.clientSearchAndClick("Sam", "3").clientSearchButton();
  }
}
