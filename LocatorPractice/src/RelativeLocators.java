import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;

import org.openqa.selenium.By;

public class RelativeLocators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		System.out.println(		driver.findElement(with(By.tagName("label")).above(By.cssSelector("[name='name']"))).getText());
		
		
		WebElement dobele=driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		
		driver.findElement(with(By.tagName("input")).below(dobele)).click();
		
		WebElement checkboxlabel=driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkboxlabel)).click();
		
		WebElement studradio=driver.findElement(By.cssSelector("#inlineRadio1"));
		System.out.println(		driver.findElement(with(By.tagName("label")).toRightOf(studradio)).getText());

		Thread.sleep(Duration.ofSeconds(5));
		driver.close();
	}

}
