package com.seleniumlearning.e2eTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumlearning.pageObjects.CartPage;
import com.seleniumlearning.pageObjects.ProductCatalogue;
import com.seleniumlearning.testComponents.BaseTest;
import com.seleniumlearning.testComponents.Retry;

public class ErrorValidationTest extends BaseTest {

	@Test(groups = { "ErrorHandling"},retryAnalyzer = Retry.class)
	public  void incorrectEmailSubmit() throws IOException, InterruptedException
	{
		landingPage.loginApplication("SB@gmail.com", "BsaB#0808%TM");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
	}
	
	@Test(groups = { "ErrorHandling"})
	public void buyDifferentProduct()
	
	{
		String productName="ADIDAS ORIGINAL";
		ProductCatalogue prodCatalogue=landingPage.loginApplication("SB@gmail.com", "saB#0808%TM");
		List<WebElement> productList=prodCatalogue.getProductList();
		prodCatalogue.addProductToCart(productName);
		CartPage cartPage=prodCatalogue.goToCartPage();
		List<WebElement> cartElement =cartPage.getCartElementList();
		Assert.assertTrue(cartPage.verifyProductDisplay(productName));
	}
	@Test (groups = {"Error"})
	public void buyProduct()
	{
		System.out.println("Another group");
	}
	
}
