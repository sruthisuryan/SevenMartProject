package Pages;

import java.awt.AWTException;
import java.lang.invoke.ConstantBootstraps;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtilities;

public class SubListCategories {
	public WebDriver driver;
	


	public SubListCategories(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this); //test
	}
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
WebElement newlistcategories;
@FindBy(xpath="//select[@class='form-control selectpicker']")
WebElement entercategory;
@FindBy(xpath="//input[@class='form-control']")
WebElement subcategoryadd;
@FindBy(xpath="//input[@name='main_img']")
WebElement choosefile;
@FindBy(xpath="//button[@name='create']")
WebElement savebutton;

public SubListCategories newListButtonClick()
{
	newlistcategories.click();
	return this;
}
public SubListCategories selectCatogoryFromDropdown(String category)//method pageutilities
{
	PageUtilities page = new PageUtilities();
	page.selectByVisibleText(entercategory, category);
	return this;

}
public SubListCategories addSubCategories(String subcategory) {
	subcategoryadd.sendKeys(subcategory);
	return this;
}

public SubListCategories uploadimage() throws AWTException
{
	FileUploadUtility fileupload = new FileUploadUtility();
	String uploadfilepath= Constant.FILEPATH;
	fileupload.robotClass(choosefile,uploadfilepath);
	
	return this;
}
public SubListCategories saveClick()
{
	savebutton.click();
	return this;
}

}
