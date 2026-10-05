package github;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class parallel_testing_hard_2 {
	public WebDriver driver;

	@Parameters("browser")


  @BeforeTest
  public void beforeTest(@Optional("firefox")String browser)throws Exception {

		  if(browser.equalsIgnoreCase("chrome"))

		  {
			  
				driver = new ChromeDriver();
			  driver.manage().window().maximize();  
		  }

		  else if(browser.equalsIgnoreCase("firefox"))

		  {
			  	driver = new FirefoxDriver();
			  driver.manage().window().maximize();
		  }
		  
		  else
		  {
			  throw new Exception("Browser is Not Correct");
		  }

	  }
	 @Test (priority=0)

	  public void bothvalueblank() throws InterruptedException {

		  driver.get("https://www.saucedemo.com/");

		  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

		  Thread.sleep(2000);

		  String actual_result = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();

		  String expect_result = "Epic sadface: Username is required";

		  Assert.assertEquals(actual_result, expect_result);

	  }
	 
	 @Test (priority=1)
	  public void Usernameblank() throws InterruptedException {

		  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Data");

		  Thread.sleep(2000);

	      String actual_result = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();

		  String expect_result = "Epic sadface: Username is required";

		  Assert.assertEquals(actual_result, expect_result);	  

	  }

	  @Test (priority=2)



	  public void Passwordblank() throws InterruptedException {

		  driver.navigate().refresh();

		  Thread.sleep(2000);

		  driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("data");

		  Thread.sleep(2000);

		  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

		  String actual_result = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();

		  String expect_result = "Epic sadface: Password is required";

		  Assert.assertEquals(actual_result, expect_result);	    

	  }

	  @Test (priority=3)

	  public void WrongBothvalue() throws InterruptedException {   

		  driver.navigate().refresh();

		  Thread.sleep(2000);

		  driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("Data");

		  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Data");

		  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

		  Thread.sleep(2000);

		  String actual_result = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();

		  String expect_result = "Epic sadface: Username and password do not match any user in this service";

		  Assert.assertEquals(actual_result, expect_result);

	  }


  @AfterTest
  public void afterTest() {
  }

}
