import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FromArrivalDropDown {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Dynamic Dropdown
//		Going to departure option selection
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		
		Thread.sleep(Duration.ofSeconds(7));
		//Option 1- hardcoded the index
		//driver.findElement(By.xpath("(//a[@value='PNQ'])[2]")).click();
		//Option 2- parent child mechnism- parent child relation ship
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='PNQ']")).click();
		Thread.sleep(2000);
		//System.out.println("Selected Departure : "+driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).getText());
		//System.out.println("Selected Departure : "+driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).getText());
		
		//System.out.println("Selected Arrival : "+driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='PNQ']")).getText());
		
		System.out.println("Selecting Depart date from caleder for One way");
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();//css selector for two class names
		System.out.println("selected date is : "+ driver.findElement(By.xpath("//div[@class='picker-first2']")).getText());
		
		
		System.out.println("Count of radia buttion"+ driver.findElements(By.cssSelector("input[id*='ctl00_mainContent_rbtnl_Trip']")).size());
		System.out.println("Round trip status: yet not enable"+driver.findElement(By.id("view_fulldate_id_2")).isEnabled()+" Atributes are:"+driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		;
		if(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected())
		{
			System.out.println("Round Trip selected");
			if((driver.findElement(By.id("view_fulldate_id_2")).isEnabled()) || (driver.findElement(By.id("view_fulldate_id_2")).getAttribute("style").contains("1")))//both condition checking same 
			{
				System.out.println("Round trip status: after enable"+driver.findElement(By.id("view_fulldate_id_2")).isEnabled()+" Atributes are:"+driver.findElement(By.id("Div1")).getAttribute("style"));
				
				System.out.println("return Date is enabled..please select date");
			}
		}
		driver.close();

	}

}
