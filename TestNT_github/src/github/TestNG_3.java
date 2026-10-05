package github;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestNG_3 {
	public WebDriver driver;
	
	@BeforeTest
public void beforeTest() {

		ChromeOptions options = new ChromeOptions();
	    Map<String, Object> prefs = new HashMap<String, Object>();

	    prefs.put("credentials_enable_service", false);

	    prefs.put("profile.password_manager_enabled", false);

	    prefs.put("profile.password_manager_leak_detection", false);

	    options.setExperimentalOption("prefs", prefs);

	    driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	    driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");

	    driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	    
	    

	}
	  
  @Test(priority=0)
  public void firstproduct() throws InterruptedException {
	  
	  Thread.sleep(3000);
	  String actual_message=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
		String Expected_message= "Sauce Labs Backpack";
		Assert.assertEquals(actual_message, Expected_message);

  }
  
  @Test(priority=1)
  public void firstproductpage() {
	  
	  
	  String actual_message=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		String Expected_message= "Products";
		Assert.assertEquals(actual_message, Expected_message);

  }



  @Test(priority=2)
  public void addtocart() throws InterruptedException {
	  Thread.sleep(3000);

	driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click(); // click on product to add
	
	driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click(); // click on cart 
  }
  
  
  @Test(priority=3)
  public void verifycartpage() {
	  
	  
	  String actual_message=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		String Expected_message= "Your Cart";
		Assert.assertEquals(actual_message, Expected_message);

  }
  
  @Test(priority=4)
  public void verifyproduct() {
	  
	  
	  String actual_message=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
		String Expected_message= "Sauce Labs Backpack";
		Assert.assertEquals(actual_message, Expected_message);

  }  
  
  @Test(priority=5)
  public void checkout() throws InterruptedException {
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

  }  
  @Test(priority=6)
  public void Fill() throws InterruptedException {
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Himanshu");
	  driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Talwani");
	  driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("123456");

  }  
  
  @Test(priority=7)
  public void verifycheckout() {
	  
	  
	  String actual_message=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span ")).getText();
		String Expected_message= "Checkout: Your Information";
		Assert.assertEquals(actual_message, Expected_message);

  }  
  
  @Test(priority=8)
  public void contiunecheckout() throws InterruptedException {
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();

  }  
  @Test(priority=9)
  public void verifyoverview() {
	  
	  
	  String actual_message=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		String Expected_message= "Checkout: Overview";
		Assert.assertEquals(actual_message, Expected_message);

  }  

  @Test(priority=10)
  public void verifyproductatoverview() {
	  
	  
	  String actual_message=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
		String Expected_message= "Sauce Labs Backpack";
		Assert.assertEquals(actual_message, Expected_message);

  }
  @Test(priority=11)
  public void finish() throws InterruptedException {
	  
	  
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("scrollBy(0, 150)");

	  Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
  }  
  
  @Test(priority=12)
  public void Complete() {
	  
	  
	  String actual_message=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		String Expected_message= "Checkout: Complete!";
		Assert.assertEquals(actual_message, Expected_message);

  } 

  @Test(priority=13)
  public void Thankyou() throws InterruptedException {
	  
	  
	  String actual_message=driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
		String Expected_message= "Thank you for your order!";
		Assert.assertEquals(actual_message, Expected_message);

		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
  } 
  @Test(priority=14)
  public void againproduct() {
	  
	  
	  String actual_message=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		String Expected_message= "Products";
		Assert.assertEquals(actual_message, Expected_message);

  } 
  
  @Test(priority=15)
  public void Menu() throws InterruptedException {
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
  } 
  
  @Test(priority=16)
  public void logout() throws InterruptedException {
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
  } 
  
  @AfterTest
  public void afterTest() {
  }

}
