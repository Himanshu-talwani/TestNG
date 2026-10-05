package github;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TitletestNG {
 
	public WebDriver driver;

  @BeforeClass
  public void beforeClass() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demo.guru99.com/test/newtours/");
		


  }

  @Test(priority=1)
  public void Title() {
	  
	  
	  String actual_message= driver.getTitle();   //Welcome: Mercury Tours
		String Expected_message= "Welcome: Mercury Tours";
		
		Assert.assertEquals(actual_message, Expected_message);

  }


  @AfterClass
  public void afterClass() {
  }

}
