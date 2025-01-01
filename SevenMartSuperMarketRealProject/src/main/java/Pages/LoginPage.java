package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement Username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement Password;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement Signin;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement Dashboard;

	public LoginPage enterUserNameAndenterPassword(String usernamefield, String passwordfield) {
		Username.sendKeys(usernamefield);
		Password.sendKeys(passwordfield);
		return this;

	}

	public HomePage clickOnSignInButton() {
		Signin.click();
		return new HomePage(driver);

	}

	public boolean isDashboardLoaded() {
		return Dashboard.isDisplayed();

	}
}
