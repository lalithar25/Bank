package Bank.Bank;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	public class Dataprovider {
		WebDriver driver;
		@Test(enabled=false)
		public void validateLogin()
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\extractchromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		    driver.get("https://www.saucedemo.com/");
		    WebElement ur=driver.findElement(By.name("user-name"));
		    ur.sendKeys("standard_user1");
		    WebElement ps=driver.findElement(By.name("password"));
		    ps.sendKeys("secret_sauce2");
		    WebElement l=driver.findElement(By.name("login-button"));
		    l.click();
		    String expectedURL="https://www.saucedemo.com/inventory.html";
		    String actualURL=driver.getCurrentUrl();
		    System.out.println("Actual URL"+actualURL);
		    Assert.assertEquals(expectedURL,actualURL);
		}
		@Test(dataProvider="testdata")
		public void validateLoginTC(String s,String u,String p)
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		    driver = new ChromeDriver();// Replace with appropriate driver based on your browser
		    driver.get("https://www.saucedemo.com/"); // Access a website
		    WebElement user=driver.findElement(By.name("user-name"));
		    user.sendKeys(u);
		    WebElement pass=driver.findElement(By.name("password"));
		    pass.sendKeys(p);
		    WebElement login=driver.findElement(By.name("login-button"));
		    login.click();
		    String ExpectedURL="https://www.saucedemo.com/inventory.html";
		    String ActualURL=driver.getCurrentUrl();
		    System.out.println("ActualURL "+ ActualURL);
		    Assert.assertEquals(ExpectedURL, ActualURL);
		    
		    if (s.equals("BothCorrect")) {
		    	System.out.println("Both User name and Password Correct");
		    	System.out.println("User:"+u+" Password:"+p);
		    }
		    if (s.equals("User")) {
		    	System.out.println("Only User name is Coorect");
		    	System.out.println("User:"+u+" Password:"+p);
		    }
		    if (s.equals("Password")) {
		    	System.out.println("Only Password Correct");
		    	System.out.println("User:"+u+" Password:"+p);
		    }
		    if (s.equals("BothInCorrect")) {
		    	System.out.println("Both User name and Password InCorrect");
		    	System.out.println("User:"+u+" Password:"+p);
		    }
		}
		@DataProvider (name = "testdata")
		public Object[][] loginTC(){
			return new Object[][] {{"BothCorrect", "standard_user","secret_sauce"},
	                               {"User", "standard_user","Admin123"},
	                               {"Password", "tct","secret_sauce"},
	                               {"BothInCoorect", "admin","admin"}
	                                       };
								}
	}

		


