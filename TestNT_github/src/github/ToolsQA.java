package github;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ToolsQA {
 public WebDriver driver;

  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(" https://demoqa.com/text-box");
		driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("Himanshu");
		driver.findElement(By.id("userEmail")).sendKeys("Himanshutester08@gmail.com");
		driver.findElement(By.id("currentAddress")).sendKeys("Ahmedabad");
		driver.findElement(By.id("permanentAddress")).sendKeys("Ahmedabad");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0, 500)");

		driver.findElement(By.id("submit")).click();
  }
  @Test(priority=0)
  public void Name() {
	  String actual_message=driver.findElement(By.xpath("//*[@id=\"name\"]")).getText();
		String Expected_message= "Name:Himanshu";
		Assert.assertEquals(actual_message, Expected_message);

  }
  @Test(priority=1)

  public void Email() throws InterruptedException {
	  String actual_message=driver.findElement(By.xpath("//*[@id=\"email\"]")).getText();
		String Expected_message= "Email:Himanshutester08@gmail.com";
		Assert.assertEquals(actual_message, Expected_message);
		  Thread.sleep(2000);

  }
  @Test(priority=2)

  public void permananetaddress() {
	  String actual_message=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/form/div[6]/div/p[4]")).getText();
		String Expected_message= "Permananet Address :Ahmedabad";
		Assert.assertEquals(actual_message, Expected_message);

  }

  @Test(priority=3)
  public void Currentaddress() throws InterruptedException {
	  String actual_message=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/form/div[6]/div/p[3]")).getText();
		String Expected_message= "Current Address :Ahmedabad";
		Assert.assertEquals(actual_message, Expected_message);

  }
  @AfterTest
  public void afterTest() {
  }

}
