package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxAssignment {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chorme.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Thread.sleep(3000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@value='option1']")).isSelected(), false);
		driver.findElement(By.id("checkBoxOption1")).click();//used id method
		Assert.assertEquals(driver.findElement(By.xpath("//input[@value='option1']")).isSelected(), true);
		driver.findElement(By.cssSelector("#checkBoxOption2")).click();//used id in css selector
		Thread.sleep(3000);
		System.out.println("Count of checkbox"+driver.findElements(By.cssSelector("input[name*='checkBoxOption']")).size());
		driver.close();

	}

}
