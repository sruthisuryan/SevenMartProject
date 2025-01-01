package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class logout extends BaseSeleniumURL {
  @Test
  public void logoutScreen() {
	  
	  driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/home");
	  driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(20));
	  WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
	  username.sendKeys("admin");
	  WebElement password =driver.findElement(By.xpath("//input[@name='password']"));
	  password.sendKeys("admin");
	  WebElement signin = driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']"));
	  signin.click();
	  
	  WebElement admin = driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
	  admin.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(20));
	  WebElement logot = driver.findElement(By.xpath("//a[@class='dropdown-item'][2]"));
	  logot.click();
  }
  
public static void main(String args[])
{
	logout lg = new logout();
	lg.beforeMethod();
	lg.logoutScreen();
}
 
}
