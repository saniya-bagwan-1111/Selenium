package ActionsDemo;

import java.awt.RenderingHints.Key;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://amazon.com");
		Actions a=new Actions(driver);
		
		//Write in serach box in  capital letters
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		Thread.sleep(Duration.ofSeconds(5));
		//write in text box and doble click on text
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.UP).sendKeys("hello").doubleClick().build().perform();
		
		WebElement ele=driver.findElement(By.cssSelector("div[id='nav-link-accountList'] a[class='nav-a nav-a-2   nav-progressive-attribute']"));
		//move to specific element
		a.moveToElement(ele).build().perform();
		
		//right click and open option
		a.moveToElement(ele).contextClick().build().perform();
		
		driver.close();
		
	}

}
