import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Sorting the element with clicking the arrow on table
		driver.findElement(By.xpath("//tr//th[1]")).click();
		
		//capturing all webelement from column 1 names of vegies
		List<WebElement> listNameCol1   =driver.findElements(By.xpath("//tr//td[1]"));
		//get all names from table and add it into list
		listNameCol1.stream().map(s->s.getText()).forEach(s -> System.out.println(s));//printing name of vegies
		
		List <String> nameVegies=listNameCol1.stream().map(s-> s.getText()).collect(Collectors.toList());
		List <String> sortednames=nameVegies.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(nameVegies, sortednames);
		Assert.assertTrue(nameVegies.equals(sortednames));
		
		//To check failure from AssertTrue method
//		nameVegies.add("Saniya");
//		Assert.assertTrue(nameVegies.equals(sortednames));
		
		Thread.sleep(Duration.ofSeconds(5));
		List<String> price;
		do {
		// capture the column names and print price of benas becuase bean is displayed on page
		//Way 1- if element found on first [age directory printing the value
//		listNameCol1.stream().filter(s -> s.getText().contains("Banana")).map(s -> getPrice(s)).forEach(s-> System.out.println(s));
		//Way 2- Storing price in to list 
//			on next page again capture the vegies names
			List<WebElement> listName   =driver.findElements(By.xpath("//tr//td[1]"));
		 price=listName.stream().filter(s -> s.getText().contains("Rice")).map(s->getPrice(s)).collect(Collectors.toList());
		price.forEach(p->System.out.println("Price of : "+ p));
			if(price.size()< 1) 
			{
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		}while(price.size()<1);
		driver.close();
		
	}

	public static String getPrice(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
