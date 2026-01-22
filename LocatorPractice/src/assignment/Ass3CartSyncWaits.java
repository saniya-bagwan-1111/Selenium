package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ass3CartSyncWaits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		
		WebDriverWait webwait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		loginPage(driver,webwait);
		shopCart(driver);
		
		
		driver.close();
		
	}
	
	private static void shopCart(WebDriver driver) {
		// TODO Auto-generated method stub
		List<WebElement> cartElement=driver.findElements(By.xpath("//app-card-list[@class='row']//app-card"));
		for(int i=0;i< cartElement.size();i++)
		{
			System.out.println(driver.findElements(By.xpath("//app-card-list[@class='row']//h4[@class='card-title']")).get(i).getText());
			driver.findElements(By.xpath("//app-card-list[@class='row']//button")).get(i).click();
		}
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
		
	}

	public static void loginPage(WebDriver driver,WebDriverWait webwait)
	{
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(driver.findElement(By.xpath("//p[@class='text-center text-white']//b[1]")).getText());
		driver.findElement(By.id("password")).sendKeys(driver.findElement(By.xpath("//p[@class='text-center text-white']//b[2]")).getText());
		driver.findElement(By.xpath("//label[@class='customradio']//input[@value='user']")).click();
		
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']//p")));
		driver.findElement(By.cssSelector("#okayBtn")).click();
		driver.findElement(By.xpath("//select[@class='form-control']//option[@value='teach']")).click();
		driver.findElement(By.cssSelector("#terms")).click();
		driver.findElement(By.cssSelector("input[class='btn btn-info btn-md']")).click();
		
		webwait.until(ExpectedConditions.titleIs("ProtoCommerce"));
	}

}
