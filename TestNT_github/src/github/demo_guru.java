package github;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class demo_guru {
 
	
	public WebDriver driver;

  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demo.guru99.com/test/newtours/");
		

  }

  @Test(priority=1)
  public void clickonregister() throws InterruptedException {
	  Thread.sleep(5000);
  driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]")).click();
 driver.findElement(By.id("email")).sendKeys("user1@test.com");
 driver.findElement(By.name("password")).sendKeys("user1");
 driver.findElement(By.name("confirmPassword")).sendKeys("user1");

 Thread.sleep(2000);
 
 driver.findElement(By.name("submit")).click();
  }
  

  @Test(priority=2)
  public void Verifyregistion() {
	  
	  
	  String actual_message=driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]")).getText();
		String Expected_message= "Thank you for registering. You may now sign-in using the user name and password you've just entered.";
		Assert.assertEquals(actual_message, Expected_message);

  }

  @Test(priority=3)
  public void clickonsign() throws InterruptedException {
	  Thread.sleep(4000); 
 driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a")).click();
  }
  
  @Test(priority=4)
  public void fillsignin() throws InterruptedException {
	  Thread.sleep(4000); 
 driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td[2]/input")).sendKeys("user1@test.com");

 driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")).sendKeys("user1");
 driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/input")).click();
  }
  @Test(priority=5)
  public void Verifysign() {
	  
	  
	  String actual_message=driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3")).getText();
		String Expected_message= "Login Successfully";
		Assert.assertEquals(actual_message, Expected_message);

  }

  
  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]")).click();
  }

}
