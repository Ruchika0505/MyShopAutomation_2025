package TestBase;


	import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import PageClasses.CartPages;
import TestCases.CartPageTest;

	public class BaseTest {
		
	    public WebDriver driver;
	    public Logger logger;
	    public Properties p;
	    
	    
		@BeforeClass
		@Parameters({"os", "browser"})
		public void setup(String os, String br) throws IOException
		
		{
			
			 FileInputStream file=new FileInputStream (".//src//test//resources//config.properties");
			 p=new Properties();
			 p.load(file);
			
			
			//loading log4j file
			logger=LogManager.getLogger(this.getClass());//Log4j
			
			//launching browser based on condition
			switch(br.toLowerCase())
			{
			case "chrome":
			ChromeOptions Coptions =new ChromeOptions();
	    	Coptions.addArguments("--headless=new");
			Coptions.addArguments("--window-size=1920,1080");
	        driver = new ChromeDriver(Coptions);
			 break;
			case "edge": 
				EdgeOptions Eoptions =new EdgeOptions();
		    	Eoptions.addArguments("--headless=new");
		        driver = new EdgeDriver(Eoptions);
				 break;
			default: System.out.println("No matching browser..");
						return;
			}
			
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get(p.getProperty("appURL"));
			driver.manage().window().maximize();
		}

//		public String captureScreen(String tname) throws IOException {
//
//			
//			System.out.println("hey I am capture screen method");
//			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//					
//			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//			
////			String targetFilePath=System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
//			
//			String targetFilePath="C:\\Users\\ruchika\\eclipse-workspace\\Ruchika\\MyShopAutomation\\screenshots\\" + tname + "_" + timeStamp + ".png";
//			System.out.println("File path ...."   + targetFilePath);
//			File targetFile=new File(targetFilePath);
//			
//			sourceFile.renameTo(targetFile);
//				System.out.println("Hello...");
//			return targetFilePath;
//
//		}
				

public String captureScreen(WebDriver driver,String tname) throws IOException {
    System.out.println("Capturing screenshot...");

    String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    String targetDir = System.getProperty("user.dir") + "/screenshots/";
    File dir = new File(targetDir);
    if (!dir.exists()) {
        dir.mkdirs();
    }

    String targetFilePath = targetDir + tname + "_" + timeStamp + ".png";
    File targetFile = new File(targetFilePath);

    FileUtils.copyFile(sourceFile, targetFile); 

    System.out.println("Screenshot saved at: " + targetFilePath);
    return targetFilePath;
}

	 
		public String randomeString()
		{
			String generatedString=RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}


	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}


