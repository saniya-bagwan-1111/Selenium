import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenNotWorkingLink {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//working link
//		String url=driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
//		HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
//		conn.setRequestMethod("HEAD");
//		conn.connect();
//		System.out.println("Response code of soapui url"+conn.getResponseCode());
//		conn.disconnect();
		
		Thread.sleep(Duration.ofSeconds(5));
		//not working link
		String brokenurl=driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		System.out.println(brokenurl);
		HttpURLConnection conn2=(HttpURLConnection) new URL(brokenurl).openConnection();
		conn2.setRequestMethod("GET");
		conn2.connect();
		System.out.println("Response code of broken link url"+conn2.getResponseCode());
//		conn2.disconnect();
		
		driver.close();
	}

}
