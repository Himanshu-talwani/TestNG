package github;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class toosqabuttons {
 
	public WebDriver driver;

  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/buttons");
  }
  @Test(priority=0)
  public void doubleclick() throws InterruptedException {
	  Thread.sleep(2000);

	  Actions action = new Actions(driver);
	  WebElement element = driver.findElement(By.id("doubleClickBtn"));
	  action.doubleClick(element).perform();

	  
	  String actual_message=driver.findElement(By.id("doubleClickMessage")).getText();
		String Expected_message= "You have done a double click";
		Assert.assertEquals(actual_message, Expected_message);

  }

  @Test(priority=1)
  public void rightclick() throws InterruptedException {
	  Thread.sleep(2000);

	  Actions action = new Actions(driver);
	  WebElement element = driver.findElement(By.id("rightClickBtn"));
	  action.contextClick(element).perform();


	  
	  String actual_message=driver.findElement(By.id("rightClickMessage")).getText();
		String Expected_message= "You have done a right click";
		Assert.assertEquals(actual_message, Expected_message);

  }

  @Test(priority=2)
  public void click() throws InterruptedException {
	
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/div[3]/button")).click();

	  
	  String actual_message=driver.findElement(By.id("dynamicClickMessage")).getText();
		String Expected_message= "You have done a dynamic click";
		Assert.assertEquals(actual_message, Expected_message);

  }
  @AfterTest
  public void afterTest() {
  }

}
