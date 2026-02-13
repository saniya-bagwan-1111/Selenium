package com.seleniumlearning.testComponents;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seleniumlearning.pageObjects.LandingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop=new Properties();
		//option 1-hardcoded whole path
		FileInputStream fileip=new FileInputStream("D:\\Selenium\\Examples\\selenium_e2e_project\\src\\main\\java\\com\\seleniumlearning\\resources\\GlobalData.properties");
		//
//		FileInputStream fileip=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\seleniumlearning\\resources\\GlobalData.properties");
		prop.load(fileip);
		//Option 1-
//		String browserName=prop.getProperty("browser");
		
		//OPtion 2- user value from cmd:  mvn test -Pregression -Dbrowser=chrome
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		if(browserName.contains("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless")) {
			options.addArguments("headless");
			}
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver(options);
			 driver.manage().window().setSize(new org.openqa.selenium.Dimension(1440, 900));//help to run in full screen
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{	
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if (browserName.equalsIgnoreCase("Edge"))
		{
//			System.setProperty("webdriver.edge.driver", "edge.exe");//manual path
			WebDriverManager.edgedriver().setup();
          driver = new EdgeDriver();
		}
		else {
          throw new RuntimeException("Browser not supported: " + browserName);
      }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		landingPage=new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
		
	}
	@AfterMethod
	public void closeDriver()
	{
		driver.close();
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	{
		//read json file
		String jsonContent=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
	
		ObjectMapper objmap=new ObjectMapper();
		List <HashMap<String,String>> data= objmap.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}
	
	public String takeScreenshot(String testcaseName,WebDriver driver) throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sourceSS=ts.getScreenshotAs(OutputType.FILE);
		File destSS=new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
		FileUtils.copyFile(sourceSS, destSS);
		System.out.println(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
		return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
	}
}
