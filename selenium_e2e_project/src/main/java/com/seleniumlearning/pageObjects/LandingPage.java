package com.seleniumlearning.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumlearning.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//driver.findElement(By.id("userEmail")).sendKeys("SB@gmail.com");
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement pass;
	
	@FindBy(id="login")
	WebElement submit;
	
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorIncrrectEmail;
	
	public ProductCatalogue loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		pass.sendKeys(password);
		submit.click();
		return  new ProductCatalogue(driver);

	}
	
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorIncrrectEmail);
		return errorIncrrectEmail.getText();
	}
	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client/");
	}

}
