package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass6DynamicContent {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
		String text=driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText();
		System.out.println("Checkbox text: "+text);
		
		driver.findElement(By.xpath("//select[@id='dropdown-class-example']//option[text()='"+text+"']")).click();
		
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("#alertbtn")).click();

		String alertText=driver.switchTo().alert().getText();
		
		if(alertText.contains(text)) {
			System.out.println("Alert text found :"+ text);
		}
		driver.switchTo().alert().accept();
		driver.close();
	}

}
