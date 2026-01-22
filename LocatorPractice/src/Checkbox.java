import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkbox {

	public static void main(String[] args)  throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Thread.sleep(3000);
		//ctl00_mainContent_chk_friendsandfamily
		if(!driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()) {
			System.out.println("Selecting checkbox");
			driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
			System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		}
		Thread.sleep(4000);
		
		System.out.println("Countinh how many checkbox present on page");
		System.out.println(driver.findElements(By.cssSelector("input[id*='ctl00_mainContent_chk']")).size());
		Thread.sleep(4000);
		
		Assert.assertFalse(false);
		driver.close();
		
	}

}
