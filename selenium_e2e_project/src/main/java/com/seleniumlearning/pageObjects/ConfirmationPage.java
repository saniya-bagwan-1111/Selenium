package com.seleniumlearning.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.seleniumlearning.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	By messgaeAppear=By.cssSelector(".hero-primary");
	
	@FindBy(css=".hero-primary")
	WebElement confmesg;
	
	public String verifyConfirmationMesg()
	{
		waitForElementToAppear(messgaeAppear);
		return confmesg.getText();	
	}
	

}
