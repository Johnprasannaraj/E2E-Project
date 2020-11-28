package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.base;

public class HomePage extends base {
	
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver=initializeDriver();
		
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password,String text) throws IOException, InterruptedException
	{
	   
	   driver.get(prop.getProperty("url"));
	   driver.manage().window().maximize();	  
	   LandingPage l =new LandingPage(driver);
	   l.getLogin().click(); 
	   Thread.sleep(2000);
	   LoginPage lp =new LoginPage(driver);
	   lp.getEmail().sendKeys(Username);
	   Thread.sleep(2000);
	   lp.getPassword().sendKeys(Password);
	   Thread.sleep(2000);
	   lp.getLogin().click();
	   Thread.sleep(3000);
	   System.out.println(text);
	  
	   
	}
	
	@AfterTest
	public void teardown()
	{
		 driver.close();
		   
	}
	   @DataProvider
	   public Object[][] getData()
	   {
		   Object[][] data =new Object[2][3];
		   data[0][0]="nonrestrciteduser@gmail.com";
		   data[0][1]="123444";
		   data[0][2]="Restricted User";
		   
		  data[1][0]="restrciteduser@gmail.com";
		   data[1][1]="98766";
		   data[1][2]="Non Restricted User";
		   
		   return data;
		   
 }

}
