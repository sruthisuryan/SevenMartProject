package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
	
	public WebDriver driver;
	public void selectByVisibleText(WebElement dropdowntext,String visibleText)
	{
		Select drop = new Select(dropdowntext);
		drop.selectByVisibleText(visibleText);
}
	public void selectByValue(WebElement dropdownbyidex,String visibleValue)
	{
		Select drop = new Select(dropdownbyidex);
		drop.selectByValue(visibleValue);
	}
	
	public void selectByIndex(WebElement dropdownindex,int visibleIndex)
	{
		Select drop = new Select(dropdownindex);
		drop.selectByIndex(visibleIndex);
	}
	
	public void alertAccept()
	{
		driver.switchTo().alert().accept();
	}
	
	public void alertDismiss()
	{
		driver.switchTo().alert().dismiss();
	}
}