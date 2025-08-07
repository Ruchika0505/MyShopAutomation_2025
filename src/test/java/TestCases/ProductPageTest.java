package TestCases;




import org.testng.Assert;
import org.testng.annotations.Test;

import PageClasses.ProductPage;
import TestBase.BaseTest;


public class ProductPageTest extends BaseTest {

   

    @Test
    public void verifyAddToCartAndCheckout() throws InterruptedException {
    	  logger.info("Starting test: verifyAddToCartAndCheckout");

        ProductPage product = new ProductPage(driver);
        logger.debug("Created ProductPage object");

        Thread.sleep(3000); // Ideally replace with WebDriverWait
        logger.debug("Waiting for product page to load");

        product.addToCart();
        logger.info("Clicked 'Add to Cart' button");

        Thread.sleep(3000);
        String cartText = product.text();
        logger.debug("Retrieved cart message: " + cartText);

        Assert.assertEquals(cartText, "Your shopping cart is empty.");
        logger.info("Verified that cart is empty");

        logger.info("Ending test: verifyAddToCartAndCheckout");
    }
}

   

