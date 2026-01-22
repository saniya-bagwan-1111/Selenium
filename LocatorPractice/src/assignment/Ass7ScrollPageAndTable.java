package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass7ScrollPageAndTable {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor jsexe=(JavascriptExecutor)driver;
		jsexe.executeScript("window.scrollBy(0,600)");
	
		System.out.println("Number of rows in table : "+driver.findElements(By.cssSelector(".table-display tr")).size());
		System.out.println("Number of columns in table : "+ driver.findElements(By.cssSelector(".table-display th")).size());
		
		System.out.println("Row text : "+ driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText());
		
		System.out.println("column wise text :");
		List<WebElement> rowText=driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td"));
		
		for(int i=0;i<rowText.size();i++)
		{
			System.out.println(" Column "+i+" text : "+rowText.get(i).getText());
		}
		driver.close();

	}

}
