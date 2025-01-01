package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // PageFactory.initElements method initializes all @FindBy annotated
												// elements in the class.
	}

	@FindBy(xpath = "//a[@class='dropdown-toggle']") // @FindBy annotation is used to specify the locator for the web
														// element
	WebElement profile;
	@FindBy(xpath = "//a[@class='logout-btn']")
	WebElement logout;
	@FindBy(xpath = "//h1[text()='Login']")
	WebElement login;
	@FindBy(xpath = "//a[text()='Clients']")
	WebElement client;

	public ClientClick clientClick() {
		client.click();
		return new ClientClick(driver);
	}

	public HomePage logoutUserProfile() {
		profile.click();
		logout.click();
		return this;
	}

	public boolean isMatchTitle() {
		return login.isDisplayed();

	}
}
