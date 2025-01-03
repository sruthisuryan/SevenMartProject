package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//@FindBy(xpath="//a[@class='nav-link']/parent::li[@class='nav-item dropdown show']")
    @FindBy(xpath="//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")
	WebElement admin;	
	@FindBy(xpath="//a[@class='dropdown-item'][2]")
	WebElement logout;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement homewindow;
	@FindBy(xpath="//a[@class='small-box-footer']")
	WebElement adminuser;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'])[2]")
	WebElement sublistcategory;
	@FindBy(xpath="(//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-news\"])[2]")
	WebElement managenews;
	public ManageNews manageNewsClick()
	{
		managenews.click();
		return new ManageNews(driver);
	}
	
	public SubListCategories listcategoriesClick()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		sublistcategory.click();
		return new SubListCategories(driver);
	}
	
	public AdminUserClick adminUserClick()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		adminuser.click();
		return new AdminUserClick(driver);
	}
	
	public HomePage logoutHomepage()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		admin.click();
		logout.click();
		return this;
	}
	
	//yr

	public boolean isMatchTitle() {
		
		return homewindow.isDisplayed();
	}
}
