package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass5NestedFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
		WebElement middleFrame=driver.findElement(By.cssSelector("frame[name='frame-middle']"));
		
		driver.switchTo().frame(middleFrame);
		System.out.println(driver.findElement(By.cssSelector("div[id='content']")).getText());
		
		driver.switchTo().defaultContent();
		
		driver.close();
		
		
	}

}
