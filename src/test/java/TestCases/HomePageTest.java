package TestCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import PageClasses.HomePage;
import TestBase.BaseTest;




public class HomePageTest extends BaseTest{

    @Test
    public void verifyProductSearch() {
    	
        logger.info("Starting test: verifyProductSearch");

        HomePage home = new HomePage(driver);
        logger.debug("Created HomePage object");

        String text = home.searchProduct("dress");
        logger.info("Searched for product: 'dress'");
        logger.debug("Search result text: " + text);

        if (text.contains("DRESS")) {
        	  logger.info("Search results contain the word 'DRESS' - Test Passed");
            Assert.assertTrue(true);
        } else {
        	  logger.error("Search results do not contain 'DRESS' - Test Failed");
//        	  captureScreen(String )
            Assert.fail();
        }

        logger.info("Ending test: verifyProductSearch");
    }

}



