package ActionsDemo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenNewTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.className("blinkingText")).click();
		Set <String> windows=driver.getWindowHandles();
		Iterator< String> it=windows.iterator();
		String parnetWindow=it.next();
		String childWindow=it.next();
		driver.switchTo().window(childWindow);
		System.out.println("Test : "+driver.findElement(By.cssSelector(".im-para.red")).getText());
		System.out.println("Capturing mail id: ");
		String mail=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println("mail id is :"+mail);
		
		driver.switchTo().window(parnetWindow);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(mail);
		
		driver.close();
		
	}

}
