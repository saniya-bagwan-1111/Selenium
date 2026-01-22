import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown_Passenger {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(Duration.ofSeconds(3));
		
		System.out.println("Clicking for 5 Adults");
		for(int i=0;i<4;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			Thread.sleep(Duration.ofSeconds(1));
		}
		
		System.out.println("Clicking for 2 Child");
		for(int i=0;i<2;i++)
		{
			driver.findElement(By.id("hrefIncChd")).click();
		}
		
		System.out.println("Clicking for 1 Infant");
		for(int i=0;i<1;i++)
		{
			driver.findElement(By.id("hrefIncInf")).click();
		}
	
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		Thread.sleep(Duration.ofSeconds(5));
		
		System.out.println("Total no of Passensures : "+ driver.findElement(By.className("paxinfo")).getText());
		
		driver.close();

	}

}
