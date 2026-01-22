import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdwon {

	public static void main(String[] args)  throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		System.out.println(options);
		
		//Thread.sleep(5000);
		for (WebElement webElement:options) {
			
			System.out.println(webElement.getText());
			if(webElement.getText().equalsIgnoreCase("India"))
			{
				webElement.click();
				System.out.println("Item selected");
				//Thread.sleep(5000);
//				break;
			}
		}
		driver.close();
	}

}
