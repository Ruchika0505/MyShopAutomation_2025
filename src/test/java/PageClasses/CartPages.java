package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPages {
    
	WebDriver driver;

    By checkoutButton = By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a");
    By Confirmation_Text=By.xpath("//*[@id=\"cart_title\"]");
    
    public CartPages(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {
    	
        driver.findElement(checkoutButton).click();
       
        
    }
    
    public  String Text()
    {
    	return ( driver.findElement(Confirmation_Text).getText());
    }
}


