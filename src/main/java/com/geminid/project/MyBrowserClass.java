package com.geminid.project;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
