import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chorme.driver","D:\\Selenium\\chormedriver.exe");

		WebDriver driver= new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("http://google.com");//full loading of website will be done- wait until all components are loaded
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");//opening and not waiting to full load
//		Thread.sleep(3000);
		driver.navigate().back();
		
//		Thread.sleep(3000);
		
		driver.navigate().forward();
//		Thread.sleep(3000);
		
		driver.close();
	}

}
