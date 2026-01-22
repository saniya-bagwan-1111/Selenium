package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass8TextboxAutoComplete {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("us");
		Thread.sleep(Duration.ofSeconds(4));

		List<WebElement> listItems = driver.findElements(By.cssSelector("#ui-id-1 li"));
		String text = null;
		for (int i = 0; i < listItems.size(); i++) {
			text=listItems.get(i).getText();
			if (text.equalsIgnoreCase("Cyprus")) {
				listItems.get(i).click();
				break;
			}
		}
		Thread.sleep(Duration.ofSeconds(4));
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("document.querySelector('#autocomplete').value");
		
		
		driver.close();
		
	}

}
