package com.seleniumlearning.AbstractComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumlearning.pageObjects.CartPage;
import com.seleniumlearning.pageObjects.CheckoutPage;

public class OrderPage extends AbstractComponent {
	
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;
	
	
	
	public boolean verifyOrderDisplay(String prodName)
	{
		System.out.println(prodName);
		return productNames.stream().anyMatch(cele -> cele.getText().equalsIgnoreCase(prodName));
	}
	
	

}
