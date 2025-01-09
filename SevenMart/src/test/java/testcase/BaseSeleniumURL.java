package testcase;

import org.testng.annotations.Test;

import constants.Constant;
import utilities.ScreenshotUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseSeleniumURL {
  
	public  WebDriver driver;
	Properties properties;
	
	
  @BeforeMethod
  @Parameters("Browser")
  public void beforeMethod(String browser) throws IOException {
	  try {
			properties = new Properties();
			
			FileInputStream	fis = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fis);

		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("invalid browser");
		}
	 // driver = new ChromeDriver();
	//  driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	//  driver.manage().window().maximize();
	  driver.get(properties.getProperty("URL"));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
 
  @AfterMethod
  public void afterMethod(ITestResult itResult) throws IOException {
	  
	  if (itResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility sc = new ScreenshotUtility();
			sc.captureFailureScreenShot(driver, itResult.getName());
		}
		if (driver != null) {
			driver.quit();
		}
  }

}