package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;

public class AdminUserSearch {

	public WebDriver driver;

	public AdminUserSearch(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchclick;

	@FindBy(xpath = "//input[@name='un']")
	WebElement usernamefield;

	@FindBy(xpath = "//select[@name='ut']")
	WebElement usertypeDropdown;

	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	WebElement searchusername;

	@FindBy(xpath = "//a[text()='Reset']")
	WebElement resetfield;

	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement Dashboard;
	public AdminUserSearch clickOnSearch() {
		searchclick.click();
		return this;
	}
public AdminUserSearch addUsernameAndUsertype(String username )
	{
		usernamefield.sendKeys(username);
		return this;
		
	}
	public AdminUserSearch userTypeSelect(String usertype)//method pageutilities
	{
		PageUtilities page = new PageUtilities();
		page.selectByVisibleText(usertypeDropdown, usertype);
		return this;

	}
	//ttt
	public AdminUserSearch searchbuttonClickToVerify()
	{
		searchusername.click();
		return this;
		
	}
	public AdminUserSearch resetButtonClickToVerify()
	{
		resetfield.click();
		return this;
		
	}
	
	public boolean isAlertMessageMatch() {
		return Dashboard.isDisplayed();
	
	}

}