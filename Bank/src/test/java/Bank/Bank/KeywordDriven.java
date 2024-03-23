package Bank.Bank;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeywordDriven {
	public static WebDriver driver;
	  
	 public static void openBrowser()
	 { 
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		 driver = new ChromeDriver();
	 }
	  
	 public static void navigate()
	 { 
	  driver.get("http://newtours.demoaut.com");
	 }
	  
	 public static void input_Username()
	 {
	 driver.findElement(By.name("userName")).sendKeys("mercury"); 
	 }
	  
	 public static void input_Password()
	 {
	 driver.findElement(By.name("password")).sendKeys("mercury");
	 }
	  
	 public static void click_Login()
	 {
	 driver.findElement(By.name("login")).click();
	 }
	 
	@Test
	 public static void verify_login()
	 {
	 String pageTitle = driver.getTitle();
	 Assert.assertEquals(pageTitle, "Find a Flight: Mercury Tours:");
	 }
	 
	 public static void closeBrowser()
	 {
	 driver.quit();
	 }
}
