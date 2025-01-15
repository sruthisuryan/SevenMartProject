package Pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class ListProducts
 {
	public WebDriver driver;
	
	

	public ListProducts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newbuttonclick;
	@FindBy(xpath="//input[@class='form-control']")
	WebElement entercategory;
	@FindBy(xpath="//input[@name='main_img']")
	WebElement fileUpload;
	@FindBy(xpath="//input[@value='yes'][1]")
	WebElement valueYes;
	@FindBy(xpath="(//input[@value='yes'])[2]")
	WebElement valueleftmenu;
	@FindBy(xpath="//button[@name='create']")
	WebElement savebutton;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement Dashboard;
	public ListProducts newButtonClickfromProductList()
	{
		//wait.waitForClickingElement(driver, newbuttonclick);
		newbuttonclick.click();
		return this;
	}
	
	public ListProducts enterCategorytoPassValue(String category)
	{
		//wait.waitForClickingElement(driver, entercategory);
		entercategory.sendKeys(category);
		return this;
	}
	public ListProducts fileUploadforProduct() throws AWTException
	{
		//wait.waitForClickingElement(driver, entercategory);
		FileUploadUtility fileupload = new FileUploadUtility();
		String uploadfilepath= Constant.FILEPATH;
		fileupload.robotClass(fileUpload,uploadfilepath);
		return this;
	}
	
	public ListProducts valuesSelectionAndSave()
	
	{
		valueYes.click();
		valueleftmenu.click();
		savebutton.click();
		return this;
	}
	public boolean isDashboardLoaded() {
		return Dashboard.isDisplayed();

	}
	
 }
