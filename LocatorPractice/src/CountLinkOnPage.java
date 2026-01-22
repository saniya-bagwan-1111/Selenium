import java.security.Key;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountLinkOnPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println("Count of Links on Page: "+driver.findElements(By.tagName("a")).size());
		
		System.out.println("Count links only on footer Section");
		WebElement footerDriver=driver.findElement(By.cssSelector("[id='gf-BIG']"));
		
		System.out.println("Count is : "+footerDriver.findElements(By.tagName("a")).size());
		
		WebElement footerFirstCol=footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("Count of Footer First column links:"+ footerFirstCol.findElements(By.tagName("a")).size());
		
		for(int i=1;i<footerFirstCol.findElements(By.tagName("a")).size();i++)
		{
			String clickonLinktab=Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinktab);
//			driver.navigate().back(); this is not working because every page load takes time
			Thread.sleep(Duration.ofSeconds(15));
		}
		
		Set<String> windows=driver.getWindowHandles();
		Iterator< String> it=windows.iterator();
		while(it.hasNext())
		{
			System.out.println("Window Title : " +driver.switchTo().window(it.next()).getTitle());
		}
		driver.close();

	}

}
