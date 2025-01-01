package testScript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Base {

  
  public WebDriver driver;
  
  @BeforeMethod
  
  public void beforeMethod()
  {
	  driver = new ChromeDriver();
	  driver.get("https://www.qabible.in/payrollapp/site/login\n"
	  		+ "");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(20));
	  
  }
  
  @AfterMethod
  public void afterMethod()
  {
	 // driver.quit();
  }
}
