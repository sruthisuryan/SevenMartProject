package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class SearchAdminUserAndDelete {
public WebDriver driver;
	
	

	public SearchAdminUserAndDelete(WebDriver driver) {
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
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement delete;

	@FindBy(xpath = "//a[text()='Reset']")
	WebElement resetfield;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/home'])[3]")
	WebElement homelinkClick;

	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement Dashboard;



public SearchAdminUserAndDelete clickOnSearch() {
	searchclick.click();
	return this;
}
public SearchAdminUserAndDelete addUsernameAndUsertype(String username )
{
	usernamefield.sendKeys(username);
	return this;
	
}
public SearchAdminUserAndDelete userTypeSelect(String usertype)
{
	PageUtilities page = new PageUtilities();
	page.selectByVisibleText(usertypeDropdown, usertype);
	return this;

}
//ttt
public SearchAdminUserAndDelete searchbuttonClickToVerify()
{
	searchusername.click();
	return this;
	
}

public SearchAdminUserAndDelete deleteUser()
{
	delete.click();
	driver.switchTo().alert().accept();
	return this;
}
public SearchAdminUserAndDelete resetButtonClickToVerify()
{
	resetfield.click();
	return this;
	
}
public SearchAdminUserAndDelete homeLinkClick()
{
	homelinkClick.click();
	return this;
}

public boolean isAlertMessageMatch() {
	return Dashboard.isDisplayed();

}
}
