

package com.geminid.project;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass 
{

	WebDriver driver;

	public WebDriver getWebDriver(String browser, String baseUrl)
	{
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Resource/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		else{
			System.out.println("No browser Specified");
		}				
		driver.get(baseUrl);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public Map<String, String> getDataFromCSV() 
	{
		Map<String, String> csvData=new HashMap<>();
		Reader reader = null;
		try {
			reader = Files.newBufferedReader(Paths.get("Resource/Data.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		CSVParser csvParser = null;
		try {
			csvParser = new CSVParser(reader, CSVFormat.DEFAULT
					  .withFirstRecordAsHeader()
			       .withIgnoreHeaderCase()
			       .withTrim());
		} catch (IOException e) {
			e.printStackTrace();
		}
		 for (CSVRecord csvRecord : csvParser) {
            // Accessing values by the names assigned to each column
			 
			 csvData.put("baseUrl", csvRecord.get("baseUrl"));
			 csvData.put("email", csvRecord.get("email"));
			 csvData.put("pass", csvRecord.get("pass"));
			 csvData.put("browser",csvRecord.get("browser"));
		 }		 
		 return csvData;		 
	}
}