import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("[id='search-field']")).sendKeys("to");
		List<WebElement> listVegies=driver.findElements(By.xpath("//tr//td[1]"));
//		Way 1-
//		for (WebElement webElement : listVegies) {
//			System.out.println("Price of Element"+webElement.getText()+"is :"+webElement.findElement(By.xpath("following-sibling::td")).getText());
//		}
		
		List<WebElement>filteredlist=listVegies.stream().filter(s -> s.getText().contains("Tomato")).collect(Collectors.toList());
		Assert.assertEquals(listVegies.size(), filteredlist.size());//to gives 2 items and filter checking specifically tomato
		
		driver.close();
		
	}

}
