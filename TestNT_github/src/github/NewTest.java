package github;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
 
	public WebDriver driver;

  @BeforeTest
  public void beforeTest() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	    driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");

	    driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
     }
  
  @Test(priority=0)
  public void ZtoA() throws InterruptedException {
	  
	  Thread.sleep(3000);
	  WebElement testDropDown = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
	  Select dropdown = new Select(testDropDown);
	  dropdown.selectByValue("za");
 Thread.sleep(3000);
 
	String actual_message=driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div")).getText();
	String Expected_message= "Test.allTheThings() T-Shirt (Red)";
	Assert.assertEquals(actual_message, Expected_message);

 
  }
  @Test(priority=1)
  public void Lowtohigh() throws InterruptedException {
	  
	  Thread.sleep(3000);
	  WebElement testDropDown = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
	  Select dropdown = new Select(testDropDown);
	  dropdown.selectByValue("lohi");
 Thread.sleep(3000);
 
	String actual_message=driver.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div")).getText();
	String Expected_message= "Sauce Labs Onesie";
	Assert.assertEquals(actual_message, Expected_message);

  }

  @Test(priority=2)
  public void Hightolow() throws InterruptedException {
	  
	  Thread.sleep(3000);
	  WebElement testDropDown = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
	  Select dropdown = new Select(testDropDown);
	  dropdown.selectByValue("hilo");
 Thread.sleep(3000);
 
	String actual_message=driver.findElement(By.xpath("//*[@id=\"item_5_title_link\"]/div")).getText();
	String Expected_message= "Sauce Labs Fleece Jacket";
	Assert.assertEquals(actual_message, Expected_message);

  }

  @Test(priority=3)
  public void AtoZ() throws InterruptedException {
	  
	  Thread.sleep(3000);
	  WebElement testDropDown = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
	  Select dropdown = new Select(testDropDown);
	  dropdown.selectByValue("az");
 Thread.sleep(3000);
 
	String actual_message=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
	String Expected_message= "Sauce Labs Backpack";
	Assert.assertEquals(actual_message, Expected_message);

  }
  @AfterTest
  public void afterTest() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
	  Thread.sleep(3000);
	  
	 driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
  }

}
