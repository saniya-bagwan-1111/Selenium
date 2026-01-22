import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("----------Parent to Child Traverse------");
		System.out.println(
				"Captuing 2nd button text : " + driver.findElement(By.xpath("//header/div/button[1]")).getText());
		System.out.println("cpatuing 2nd button 1st sibling button text : "
				+ driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());

		System.out.println("----------Child to Parent Traverse------");
		System.out.println(
				"parent of button: " + driver.findElement(By.xpath("//header/div/button[1]/parent::div")).getTagName());
		System.out.println("parent of div : "
				+ driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header")).getTagName());
		System.out.println("in header child a tag and their text : "
				+ driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a[2]")).getText());

		driver.close();

	}

}
