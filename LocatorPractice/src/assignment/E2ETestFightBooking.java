package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2ETestFightBooking {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for (WebElement webElement : options) {

			System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase("India")) {
				webElement.click();
			}
		}

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();

		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		Thread.sleep(Duration.ofSeconds(7));
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='PNQ']")).click();

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(Duration.ofSeconds(3));
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Thread.sleep(Duration.ofSeconds(3));

		WebElement element = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropCurrency = new Select(element);

		dropCurrency.selectByValue("INR");
		Thread.sleep(Duration.ofSeconds(3));

		driver.findElement(By.cssSelector("input[value='Search']")).click();

	}

}
