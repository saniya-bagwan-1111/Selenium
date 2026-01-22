import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutor_Scroll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js_exe=(JavascriptExecutor) driver;
		
		js_exe.executeScript("window.scrollBy(0,600)");//Scroll the page with x and y co-ordinator
		js_exe.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");//scroll table to downword
		
		
		//Sum of amount
		List<WebElement> amountColValues=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0;i<amountColValues.size();i++)
		{
			sum +=Integer.parseInt(amountColValues.get(i).getText());
		}
		
		System.out.println("Sum of amount is :"+ sum);
		String text=driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
		Assert.assertEquals(Integer.parseInt(text), sum);
		driver.close();

	}

}
