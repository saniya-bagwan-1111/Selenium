package com.seleniumlearning.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumlearning.pageObjects.CartPage;

public class AbstractComponent {
	
	//reusable code we can write in call and user same in child class
	
	WebDriver driver;
	
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait expWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		expWait.until(ExpectedConditions.visibilityOfElementLocated(findBy));//wait until all elements are loaded on page 
	}
	
	public void waitForElementToDisable(WebElement loadSpinner)
	{
		WebDriverWait expWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		expWait.until(ExpectedConditions.invisibilityOf(loadSpinner));
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
	
	public CartPage goToCartPage()
	{
		cartButton.click();
		return new CartPage(driver);
		
	}

}
