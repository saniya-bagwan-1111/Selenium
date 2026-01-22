import java.util.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderDemo {

	public static void main(String[] args) throws InterruptedException {
		String year="2027";
		String month="8";
		String day="15";
		String stringdate[]= {month,day,year};
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
//		
//		driver.findElement(By.cssSelector(".cart-header-navlink[href='#/offers']")).click();
//		
//		Set<String> window=driver.getWindowHandles();
//		Iterator< String> it=window.iterator();
//		it.next();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup__year")).click();//clicing on default date
		
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();//clicking on month
		
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();//clicking on year
		
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
//		driver.findElement(By.xpath("//button[contains(@class,'month')]["+Integer.parseInt(month)+"]")).click();
		//OR
		driver.findElements(By.xpath("//button[contains(@class,'month')]")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//button[contains(@class,'day')]//abbr[text()="+day+"]")).click();
		
		System.out.println("Date aftre selection"+driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getText());
		System.out.println("Adding date into list");
		List<WebElement>dateList=driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i=0;i<dateList.size();i++)
		{
			System.out.println(dateList.get(i).getAttribute("value"));
			Assert.assertEquals(dateList.get(i).getAttribute("value"), stringdate[i]);
		}
		
//		driver.quit();
	}

}
