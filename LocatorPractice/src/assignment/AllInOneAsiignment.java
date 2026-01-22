package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AllInOneAsiignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys("abc");
		driver.findElement(By.name("email")).sendKeys("abc.gmail.com");
		
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("abc123");
		driver.findElement(By.cssSelector("#exampleCheck1")).click();
		
		WebElement element=driver.findElement(By.id("exampleFormControlSelect1"));
		Select options= new Select(element);
		options.selectByVisibleText("Female");
		
		
		driver.findElement(By.cssSelector("input[id='inlineRadio2']")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("01/08/1998");
		driver.findElement(By.cssSelector("input[class='btn btn-success']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		driver.close();
	}

}
