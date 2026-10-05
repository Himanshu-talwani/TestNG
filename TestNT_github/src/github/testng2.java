package github;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class testng2 {
	
	public WebDriver driver;
	
	 @BeforeTest
	  public void beforeTest() {
			driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.get("https://www.saucedemo.com/");
	     }

	
	
	@Test (priority=0)
	
  public void  bothareblank() throws InterruptedException {
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		
		String actual_message = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
		String Expected_message = "Epic sadface: Username is required";
		Assert.assertEquals(actual_message, Expected_message);	
	    }
		
		@Test (priority=1)
		
		  public void  UsernameBlank() throws InterruptedException {
	    driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	    driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();	
		Thread.sleep(3000);
				
		String actual_message = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
		String Expected_message = "Epic sadface: Username is required";
		Assert.assertEquals(actual_message, Expected_message);	
        }
 
		@Test (priority=2)

		 public void Passwordblank() throws InterruptedException {
			
	   // driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
		driver.navigate().refresh();

        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

		Thread.sleep(3000);
		String actual_message=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
		String Expected_message= "Epic sadface: Password is required";
		Assert.assertEquals(actual_message, Expected_message);	

		}
		
		@Test (priority=3)

		 public void Junkcharacter() throws InterruptedException {

		
	    driver.navigate().refresh();
        Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("@#$%");
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("@#$%");
        
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

		Thread.sleep(3000);
		String actual_message=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
		String Expected_message= "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(actual_message, Expected_message);

		}
		
		@Test (priority=4)

		 public void trim() throws InterruptedException {

		
		driver.navigate().refresh();
   

		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("  standard_user");
       driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("secret_sauce");
       
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

		Thread.sleep(3000);
		String actual_message=driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3")).getText();
		String Expected_message= "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(actual_message, Expected_message);

		}

		@Test (priority=5)

		 public void Usernameinuppercase() throws InterruptedException {

			driver.navigate().refresh();

      Thread.sleep(3000);
      

		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("STANDARD_USER");
      driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("secret_sauce");
      
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

		Thread.sleep(3000);
		String actual_message=driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3")).getText();
		String Expected_message= "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(actual_message, Expected_message);

		}
		
		@Test (priority=6)

		 public void Passwordinuppercase() throws InterruptedException {

			driver.navigate().refresh();

     Thread.sleep(3000);
     

		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("standard_user");
     driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("SECRET_SAUCE");
     
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

		Thread.sleep(3000);
		String actual_message=driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3")).getText();
		String Expected_message= "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(actual_message, Expected_message);

		}
		@Test (priority=6)

		 public void Vaild() throws InterruptedException {

	    driver.navigate().refresh();

        Thread.sleep(3000);
    

		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("standard_user");
	    driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("secret_sauce");

	    driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
	    Thread.sleep(3000);

	    driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
		}
  @AfterTest
  public void afterTest() {
  }

}
