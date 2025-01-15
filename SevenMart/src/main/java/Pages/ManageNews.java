package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNews {
	
	public WebDriver driver;
	
	public ManageNews(WebDriver driver) {
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//a[@onclick='click_button(1)']")
WebElement newbutton;

@FindBy(xpath="//textarea[@id='news']")
WebElement enternews;
@FindBy(xpath="//button[@name='create']")
WebElement savebutton;
@FindBy(xpath="//nav[@class='main-header navbar navbar-expand navbar-dark navbar-dark']")
WebElement newswindow;
@FindBy(xpath = "//span[text()='7rmart supermarket']")
WebElement Dashboard;

public ManageNews newButtonClick()
{
	newbutton.click();
	return this;
}

public ManageNews enterNewstoSend(String textmessage)
{
	enternews.sendKeys(textmessage);
	return this;
}

public ManageNews saveButtonClick()
{
	savebutton.click();
	return this;
}

public boolean isMatchTitle() {
	//test
	return newswindow.isDisplayed();
}
public boolean isDashboardLoaded() {
	return Dashboard.isDisplayed();

}
}