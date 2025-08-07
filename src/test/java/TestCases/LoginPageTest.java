package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import PageClasses.*;
import TestBase.BaseTest;

public class LoginPageTest extends BaseTest {
  
	    @Test
	    public void verifyUserLogin() throws InterruptedException {
	    	  logger.info("Starting test: verifyUserLogin");

	        Thread.sleep(3000); // Ideally, replace with WebDriverWait
	        logger.debug("Waiting for page to load");

	        HomePage home = new HomePage(driver);
	        LoginPage login = new LoginPage(driver);
	        logger.debug("Created HomePage and LoginPage objects");

	        home.clickSignIn();
	        logger.info("Clicked on Sign In link");

	        Thread.sleep(3000);
	        login.login("testuser@example.com", "testpassword");
	        logger.info("Entered login credentials: testuser@example.com / testpassword");

	        Thread.sleep(3000);
	        String actualError = login.text();
	        logger.debug("Captured login error text: " + actualError);

	        Assert.assertEquals(actualError, "There is 1 error");
	        logger.info("Verified login error message successfully");

	        logger.info("Ending test: verifyUserLogin");
	    }
   
}
