package com.seleniumlearning.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.seleniumlearning.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	//Search Country-By.cssSelector(".form-group .text-validated"))
	@FindBy(css=".form-group .text-validated")
	WebElement searchCountry;
	
	By selectionOption=By.cssSelector(".ta-results");
	
	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	WebElement selectOp2;
	
	@FindBy(css=".action__submit")
	WebElement placeOrderButton;
	
	
	public void selectSelectionBox()
	{
		Actions ac=new Actions(driver);
		ac.sendKeys(searchCountry, "india").build().perform();
		
		waitForElementToAppear(selectionOption);
		selectOp2.click();
	}
	
	public ConfirmationPage placeOrder()
	{
		placeOrderButton.click();
		return new ConfirmationPage(driver);
	}

}
