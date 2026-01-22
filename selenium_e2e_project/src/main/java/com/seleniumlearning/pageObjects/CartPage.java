package com.seleniumlearning.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumlearning.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(css="div[class='cartSection'] h3")
	List<WebElement> cartElement;
	
	By CartList=By.cssSelector(".cartSection h3");
	
	public List<WebElement> getCartElementList()
	{
		waitForElementToAppear(CartList);
		return cartElement;
	}
	
	public boolean verifyProductDisplay(String productName)
	{
		return getCartElementList().stream().anyMatch(cele -> cele.getText().equalsIgnoreCase(productName));
	}
	
	@FindBy(css=".totalRow .btn")
	WebElement clickCheckout;
	
	By checkoutButton=By.cssSelector(".totalRow .btn");
	public CheckoutPage goToCheckout()
	{
		waitForElementToAppear(checkoutButton);
		clickCheckout.click();
		return new CheckoutPage(driver);
	}
	
}
