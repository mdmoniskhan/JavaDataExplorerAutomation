package com.mycompany.testproject;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyBrowserClass extends BaseClass
{
	WebDriver driver;
	Map<String, String> csvData;
	@BeforeTest
	public void setup() 
	{
		csvData=getDataFromCSV();
		driver=getWebDriver(csvData.get("browser"),csvData.get("baseUrl"));		
	}
	
	@Test
	public void signUpFunction()
	{
				
		SaleLoginPage log= new SaleLoginPage(driver);
		log.loginMethod( csvData.get("email"),  csvData.get("pass"));
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		
	}
}
