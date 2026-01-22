package functiontesting;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddItemInCart {

	public static void addItemCart(WebDriver driver, List<String> listItemsNeeded) {
		List<WebElement> productList = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < productList.size(); i++) {
//			 if(productList.get(i).getText().contains("Cucumber")) {
//				 System.out.println(productList.get(i).getText());
//				 driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
//				 break;
//			 }
			String name = productList.get(i).getText().split("-")[0].trim();
//			 System.out.println("Product List item names"+ name);
//			 Thread.sleep(Duration.ofSeconds(2));
			if (listItemsNeeded.contains(name)) {
//				 System.out.println("If condition"+listItemsNeeded+"-"+name);
//				 System.out.println(productList.get(i).getText());
				// not good approach- because Add To CART is changing to Added which will change
				// the index of further carts
				// driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			}
		}
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
	
		//Explicit Wait- code applied takes time to display more than 5 means requires more than time present in implicit wait time
		//where evenr required we can use or we can say targeted elements, no performance issues
		//Explicit wait has 2 types - 
		//1. webdriver wait: continuously monitors on page  to find the element
		//2. Fluent Wait: we are providing the 2nd parameter named as polling.polling -2sec then explicit wait checking web element on every 2 sec whether it is found or not
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.xpath("//div[@class='cart-preview active']//div[@class='action-block']//button")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		
		
		//locator-By.cssSelector("span.promoInfo")
		//webelement-driver.findElement(By.cssSelector("span.promoInfo"))
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		//Implicit wait- before running each statement it will wait for defined time and then execute the next line
		//its the global declration of waiting time, applicable before driver close
		//if dom element found on page with in 3 sec then also it will no wait for 2 sec , it goes on next code line
		//cons- if element found in 2 sec still page waiting for 15 sec to display item it will cause a performance issue..ideally don't go beyound 10 in implict wait declaration
		//no need to write implicit wait in this ex because wherever error occurred that is handled using explicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		String[] itemsNeeded = { "Brocolli", "Beetroot", "Beans" };
		List<String> listItemsNeeded = Arrays.asList(itemsNeeded);
		// System.out.println("User Requirement" + listItemsNeeded);
		addItemCart(driver, listItemsNeeded);
		
		//driver.close();
	}

}
