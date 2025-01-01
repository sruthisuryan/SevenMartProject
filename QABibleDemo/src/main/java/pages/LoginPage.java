package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		// apply page factory(used to initialise each element using an anotation as
		// @findBy,mainly used to interact webElement")
		// usercan access this pagefactory in anywhere in the project
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='loginform-username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='loginform-password']")
	WebElement password;
	@FindBy(xpath = "//button[@name='login-button']")
	WebElement loginbutton;
	@FindBy(xpath = "//a[text()='Dashboard']")
	WebElement dashboard;

	public LoginPage enterUserNameAndenterPassword(String usernamefield, String passwordfield) {
		username.sendKeys(usernamefield);
		password.sendKeys(passwordfield);
		return this;
	}

	public HomePage clickOnLoginButton() {
		loginbutton.click();
		return new HomePage(driver);
	}

	public boolean isDashboardLoaded() {
		return dashboard.isDisplayed();
	}
}
