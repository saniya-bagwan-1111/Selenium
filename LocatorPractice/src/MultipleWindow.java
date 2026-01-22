import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> windw=driver.getWindowHandles();
		Iterator<String> it=windw.iterator();
		String parentWindId=it.next();
		String childWindId=it.next();
		
		driver.switchTo().window(childWindId);
		driver.get("https://rahulshettyacademy.com/");
		String course1name=
		driver.findElement(By.xpath("//h3[text()='Selenium WebDriver with Java - Basics to Advanced']")).getText();
		
		driver.switchTo().window(parentWindId);
		WebElement name=driver.findElement(By.name("name"));
		name.sendKeys(course1name);
		//Taking screen shot only for name text box
		File namess=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(namess, new File("D:\\Selenium\\Screenshots\\nameSS.png"));
		
		
		System.out.println("Height "+name.getRect().height);
		System.out.println("Width "+name.getRect().width);
		driver.quit();
		

	}

}
