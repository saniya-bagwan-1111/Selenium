import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//dropdown with select tag
		WebElement element=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropCurrency=new Select(element);
		dropCurrency.selectByIndex(3);
		System.out.println("Index 3 option : "+dropCurrency.getFirstSelectedOption().getText());
		
		dropCurrency.selectByVisibleText("AED");
		System.out.println("Option selected by visible text : "+dropCurrency.getFirstSelectedOption().getText());
		
		dropCurrency.selectByValue("INR");
		System.out.println("Option selected by Attribute name-value : "+ dropCurrency.getFirstSelectedOption().getText());
	}

}
