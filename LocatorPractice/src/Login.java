import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		String name="Saniya";
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[placeholder*='Pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		Thread.sleep(Duration.ofSeconds(3));
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		
		System.out.println("Logged in user name : "+driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText().split(" ")[1]);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),"Hello "+name+",");
		
		Thread.sleep(2000);
		//find element using the text only present in xpath,not in cssselector
		//Option 1-
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		//option 2- not matter which tag is used just text is checking
		//By.xpath("//*[text()='Log Out']
		
		driver.close();
	}

}
