package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PageUtilities;

public class AdminUserClick {
	
	public WebDriver driver;
	
	public AdminUserClick(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
WebElement newbuttonclick;
@FindBy(xpath="//input[@name='username']")
WebElement username;
@FindBy(xpath="//input[@name='password']")
WebElement password;
@FindBy(xpath="//select[@name='user_type']")
WebElement usertype;
@FindBy(xpath="//button[@name='Create']")
WebElement save;
@FindBy(xpath="//h1[text()='Admin Users']")
WebElement dashboard;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
WebElement usersearch;




public AdminUserClick newButtonClick()
{
	newbuttonclick.click();
	return this;
}
public AdminUserClick adminUserInformation(String name,String id)
{
	username.sendKeys(name);
	password.sendKeys(id);
	return this;
}
public AdminUserClick userTypeDropdownSelection(String usertypeDropdown)//read from excel
{
	PageUtilities page = new PageUtilities( );
	page.selectByVisibleText(usertype,usertypeDropdown);
	return this;
}
public AdminUserClick saveUserDetails()
{
	save.click();//tt
	return this;
	
}

public AdminUserSearch searchuserButtonClick()

{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	usersearch.click();
	return new AdminUserSearch(driver);
}
public boolean isAlertMessageMatch()
{
	
	return dashboard.isDisplayed();
	
}
}
