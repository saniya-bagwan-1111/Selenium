package assignment;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass4WindowHandling {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.cssSelector("div[class='example'] a")).click();
		Set <String> windows=driver.getWindowHandles();
		Iterator <String> it=windows.iterator();
		String parentWin=it.next();
		String childWind=it.next();
		
		driver.switchTo().window(childWind);
		System.out.println("Text  from child Window:"+driver.findElement(By.tagName("h3")).getText());
		
		driver.switchTo().window(parentWin);
		System.out.println("Parent Window Test : "+driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		
		driver.quit();

	}

}
