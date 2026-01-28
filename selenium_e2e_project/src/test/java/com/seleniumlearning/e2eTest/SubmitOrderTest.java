package com.seleniumlearning.e2eTest;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumlearning.AbstractComponents.OrderPage;
import com.seleniumlearning.pageObjects.CartPage;
import com.seleniumlearning.pageObjects.CheckoutPage;
import com.seleniumlearning.pageObjects.ConfirmationPage;
import com.seleniumlearning.pageObjects.ProductCatalogue;
import com.seleniumlearning.testComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	public String productName="ADIDAS ORIGINAL"; 
	
	@Test(dataProvider = "getData", groups = "purchase")
	public  void SubmitOrder(HashMap<String, String> inmethod) throws IOException, InterruptedException
	{
		
		ProductCatalogue prodCatalogue=landingPage.loginApplication(inmethod.get("email"), inmethod.get("password"));
		List<WebElement> productList=prodCatalogue.getProductList();
		prodCatalogue.addProductToCart(inmethod.get("product"));
		CartPage cartPage=prodCatalogue.goToCartPage();
		List<WebElement> cartElement =cartPage.getCartElementList();
		Assert.assertTrue(cartPage.verifyProductDisplay(inmethod.get("product")));
		CheckoutPage checkout=cartPage.goToCheckout();
		checkout.selectSelectionBox();
		ConfirmationPage confpage=checkout.placeOrder();
		Assert.assertTrue(confpage.verifyConfirmationMesg().equalsIgnoreCase("Thankyou for the order."));
		
	}
    
	
	@Test(dependsOnMethods = {"SubmitOrder"})
	public void orderHistory()
	{
		ProductCatalogue prodCatalogue=landingPage.loginApplication("SB@gmail.com", "saB#0808%TM");
		OrderPage orderPage=prodCatalogue.goToOrdersPage();
		
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		//option 1-
//		return new Object[][] { {"SB@gmail.com","saB#0808%TM","ADIDAS ORIGINAL"},{"SB@gmail.com","saB#0808%TM","ADIDAS ORIGINAL"}};
		
		//option 2-
//		HashMap<String, String> map=new HashMap<String, String>();
//		map.put("email", "SB@gmail.com");
//		map.put("password", "saB#0808%TM");
//		map.put("product", "ADIDAS ORIGINAL");
//		
//		HashMap<String, String> map2=new HashMap<String, String>();
//		map2.put("email", "SB@gmail.com");
//		map2.put("password", "saB#0808%TM");
//		map2.put("product", "ADIDAS ORIGINAL");
//		
		//Option3, fetch data from json file
		List<HashMap<String, String>> datafromjson=getJsonDataToMap(System.getProperty("user.dir")+
				"\\src\\test\\java\\seleniumlearning\\data\\PurchaseOrder.json");
		
		return new Object [][] {{datafromjson.get(0)},{datafromjson.get(1)}};
	}
	
	
	
}
