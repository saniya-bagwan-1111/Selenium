package com.seleniumlearning.selenium_e2e_project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	
	public static void main(String[] args) throws InterruptedException 
	{
//		WebDriverManager.chromedriver().setup();
		String productName="ADIDAS ORIGINAL";
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		
		driver.findElement(By.id("userEmail")).sendKeys("SB@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("saB#0808%TM");
		
		driver.findElement(By.id("login")).click();

		WebDriverWait expWait=new WebDriverWait(driver, Duration.ofSeconds(10));

		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));//wait until all elements are loaded on page 
		
		List<WebElement> productList=driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod=productList.stream().filter(ele -> ele.findElement(By.cssSelector("b"))
				.getText().equals(productName)).findFirst().orElse(null);
//		Thread.sleep(5000);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		impWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));//product added message displayed, option 1-wait until message is invisible
		expWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));//option 2 - improves performance
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
		List<WebElement> cartElement =driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
		System.out.println(cartElement);
		boolean flag=cartElement.stream().anyMatch(cele -> cele.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(flag);
		
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow .btn")));
		driver.findElement(By.cssSelector(".totalRow .btn")).click();
		
		Actions ac=new Actions(driver);
		ac.sendKeys(driver.findElement(By.cssSelector(".form-group .text-validated")), "india").build().perform();
		
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
		String conformMes=driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(conformMes);
		Assert.assertTrue(conformMes.equalsIgnoreCase("Thankyou for the order."));
		
		driver.close();
		
	}
    
}
