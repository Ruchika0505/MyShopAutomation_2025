package TestCases;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import PageClasses.CartPages;
import TestBase.BaseTest;

public class CartPageTest extends BaseTest {
//    WebDriver driver;

    
    @Test
    public void verifyProceedToCheckout() {
    	

		logger.info("***** Starting TC001_CartPageTest Started ****");
		logger.debug("This is a debug log message");

    	CartPages cart =new CartPages(driver);
    	
        cart.clickCheckout();
    	logger.info("***** Clicked on Add to Cart ****");
    	
        Assert.assertEquals(driver.getTitle(),"Order - My Shop");
        Assert.assertEquals(cart.Text(),"SHOPPING-CART SUMMARY");
       
        logger.info("***** Ended TC001_CartPageTest Started ****\"");
    }
          
}
