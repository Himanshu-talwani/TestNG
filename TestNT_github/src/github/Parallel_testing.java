package github;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Parallel_testing {
	public WebDriver driver;

  
  @BeforeTest
  public void beforeTest() {
  }

  @Test (priority=0)
  public void chrome() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.saucedemo.com/");
	//Bothvalueblank
	  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	  Thread.sleep(5000);

	   String actual_message=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
	   String expect_message="Epic sadface: Username is required";
	   Assert.assertEquals(actual_message, expect_message);

	  //PasswordisBlank
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	  String actual_message1=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
	  String expect_message1="Epic sadface: Password is required";
	  Assert.assertEquals(actual_message1, expect_message1);

	  }
  @Test (priority=1)
  public void firefox() throws InterruptedException {
  WebDriver driver;


  driver = new FirefoxDriver();
  driver.manage().window().maximize();
  driver.get("https://www.saucedemo.com/");

  //Bothvalueblank
  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
  Thread.sleep(5000);

   String actual_message=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
   String expect_message="Epic sadface: Username is required";
   Assert.assertEquals(actual_message, expect_message);

  //PasswordisBlank
  Thread.sleep(3000);
  driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
  String actual_message1=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
  String expect_message1="Epic sadface: Password is required";
  Assert.assertEquals(actual_message1, expect_message1);


  }

  @AfterTest
  public void afterTest() {
  }

}
