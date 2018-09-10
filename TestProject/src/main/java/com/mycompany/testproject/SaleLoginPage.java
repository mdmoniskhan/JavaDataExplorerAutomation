package com.mycompany.testproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SaleLoginPage {

	WebDriver driver;
	
	@FindBy(id = "login_button")
	WebElement loginButton;

	@FindBy(xpath = "//div[@id='logInForm_container']/button")
	WebElement production;
	
	@FindBy(how=How.ID, using= "username")
	WebElement userName;

	@FindBy(id = "password")
	WebElement passWord;

	@FindBy(id = "Login")
	WebElement salesloginButton;
	


	public SaleLoginPage(WebDriver driver) {
		
        this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void loginMethod(String email, String pass) {

			loginButton.click();
			
			production.click();
			
			userName.sendKeys(email);
			
			passWord.sendKeys(pass);
			
			salesloginButton.click();
			
			
	}
}
