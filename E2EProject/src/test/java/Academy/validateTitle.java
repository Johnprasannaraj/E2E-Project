package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.base;

public class validateTitle extends base {
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver=initializeDriver();
		 driver.get(prop.getProperty("url"));
		  driver.manage().window().maximize();
	}
	@Test
	public void basePageNavigation() throws IOException, InterruptedException
	{
	   
	 
	   LandingPage l =new LandingPage(driver);
	   Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
	
	   
	}
	@AfterTest
	public void teardown()
	{
		 driver.close();
		   
	}
	   
}
