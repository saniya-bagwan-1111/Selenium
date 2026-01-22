import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Id_Name_Locator {
	
	public static void LoginPage() {
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Learning Started: Selenium ");
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Implicit wait- says that wait for 5 sec to display the message. It will take care of synchronization issues
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("saniya");
		driver.findElement(By.name("inputPassword")).sendKeys("saniya");
		driver.findElement(By.className("signInBtn")).click();
//		Thread.sleep(5000);
		
		System.out.println("Message if incorrect username and password added : "+driver.findElement(By.cssSelector("p.error")).getText());
				
		//Go to forgot password
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//Fill the form for forget password
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Saniya");
				
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("saniya");
		Thread.sleep(Duration.ofSeconds(2));
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		
		
		driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("1112");
		Thread.sleep(Duration.ofSeconds(2));
		//OR using css selector -clearing phone number
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).clear();
		Thread.sleep(Duration.ofSeconds(2));
		
		//traverse using parent to child tags
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("2345");
		//Thread.sleep(Duration.ofSeconds(2));
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		//Thread.sleep(Duration.ofSeconds(2));
		
		
		System.out.println("text with cssselector with parent and child tag : "+driver.findElement(By.cssSelector("form p")).getText());
		
		String pass=driver.findElement(By.cssSelector("form p")).getText().split("'")[1];
		System.out.println("Passowrd is : "+pass);
		
		//option 1-driver.findElement(By.className("go-to-login-btn")).click();
		//option 2 -customize tag name
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("saniya");
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(pass);
//		Thread.sleep(Duration.ofSeconds(2));
		
		driver.findElement(By.id("chkboxTwo")).click();
		
		
		//regular expression used type of button is submit , in below program is developer used only sub the also its gives correct selector
		//option 1-driver.findElement(By.cssSelector("button[type*='sub']")).click();
		//option 2- using regular expression on two classname
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		    
		
		
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://google.com");
		
		driver.close();
	}

}
