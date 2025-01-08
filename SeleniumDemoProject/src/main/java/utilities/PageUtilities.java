package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
	public void selectByVisibleText(WebElement dropdown,String visibleText)
	{
		Select drop = new Select(dropdown);
		drop.selectByVisibleText(visibleText);
}

}
