

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserPermission {

	//SSLChecks
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1 Giving permission inside browser
		/*ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");//unsafe site we have take permission
		System.out.println(driver.getTitle());
		driver.close();
		*/
		
		//2.PRoxy permission required for some of site
		ChromeOptions options=new ChromeOptions();
		Proxy proxy=new Proxy();
		proxy.setHttpProxy("IPaddress:portno");
		
		//3. adding extensions on browser
		options.addExtensions(new File("path of extension file"));
		ChromeDriver chdriver=new ChromeDriver(options);
		
		//4. block unnecessary popups
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		
		//change Download directory
		Map<String,Object> pref= new HashMap<String, Object>();
		pref.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("pref", pref);
		options.setCapability("proxy", proxy);
		
		
	}

}
