package github;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class parallwl_testing_hard {
	public WebDriver driver;

	
  @BeforeTest
  public void beforeTest() {
  }

  @Test(priority = 0)
  public void testChrome() throws InterruptedException {
      driver = new ChromeDriver();
      runLoginValidation(); // Runs the actual testing logic
  }

  @Test(priority = 1)
  public void testFirefox() throws InterruptedException {
      driver = new FirefoxDriver();
      runLoginValidation(); // Runs the exact same logic here
  }

  // This single method handles all the steps using IF / ELSE
  public void runLoginValidation() throws InterruptedException {
      driver.manage().window().maximize();
      driver.get("https://saucedemo.com");

      // We run a loop twice: Round 1 for Username error, Round 2 for Password error
      for (int round = 1; round <= 2; round++) {
          
          // IF it is Round 1: Test blank username
          if (round == 1) {
              driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
              Thread.sleep(2000);

              String actual = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
              Assert.assertEquals(actual, "Epic sadface: Username is required");
          } 
          // ELSE (Round 2): Test blank password
          else if (round == 2) {
              driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
              driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
              Thread.sleep(2000);

              String actual = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
              Assert.assertEquals(actual, "Epic sadface: Password is required");
          }
      }

      driver.quit();
  }

  @AfterTest
  public void afterTest() {
  }

}
