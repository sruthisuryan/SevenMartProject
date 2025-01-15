package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchListProductSearch {
public WebDriver driver;
	
	

	public SearchListProductSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchClick;
	@FindBy(xpath="(//input[@class='form-control'])[1]")
	WebElement titlevaluepass;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement searchbutton;
	@FindBy(xpath="//button[@class='btn btn-default btn-fix']")
	WebElement reset;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/home'])[3]")
	WebElement homelinkclick;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement Dashboard;
	public SearchListProductSearch searchbuttonclick()
	{
		searchClick.click();
		return this;
		
	}
	public SearchListProductSearch searchByValue(String values)
	
	{
		titlevaluepass.sendKeys(values);
		return this;
	}
	public SearchListProductSearch clicksearchbutton()
	{
		searchbutton.click();
		return this;
		
	}
	public SearchListProductSearch restValue()
	{
		reset.click();
		return this;
	}
	public SearchListProductSearch homeLink()
	{
		homelinkclick.click();
		return this;
	}
	public boolean isDashboardLoaded() {
		return Dashboard.isDisplayed();

	}
}
