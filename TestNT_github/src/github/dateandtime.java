package github;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class dateandtime {
	public WebDriver driver;

  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(" https://demo.guru99.com/test/");
		
  }
  @Test(priority=1)
  public void date() throws InterruptedException {
      WebElement dateInput = driver.findElement(By.name("bdaytime"));
      dateInput.sendKeys("10/01/2026");
      dateInput.sendKeys(Keys.TAB);
      dateInput.sendKeys("03:30PM"); 

      Thread.sleep(2000);
      driver.findElement(By.xpath("/html/body/form/input[2]")).click();

  }

  @Test(priority=2)
  public void Verifydate() {
	  
	  
	  String actual_message=driver.findElement(By.xpath("/html/body/div[2]")).getText();
		String Expected_message= "Your Birth Date is 2026-01-10\n"
				+ "Your Birth Time is 03:30";
		Assert.assertEquals(actual_message, Expected_message);

  }
  @AfterTest
  public void afterTest() {
  }

}
