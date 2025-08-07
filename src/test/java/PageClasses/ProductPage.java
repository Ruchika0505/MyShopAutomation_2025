
package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    By addToCartButton = By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a");
//    By proceedToCheckoutButton = By.xpath("//a[@title='Proceed to checkout']");
    By validationtext= By.xpath("//*[@id=\"center_column\"]/p");
    
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

//    public void proceedToCheckout() {
//        driver.findElement(proceedToCheckoutButton).click();
//    }
    
    public String text()
    {
    	return (driver.findElement(validationtext).getText());
    }
}


