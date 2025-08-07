package PageClasses;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.testng.Assert;

	public class HomePage {
	    WebDriver driver;

	    By signInButton = By.className("login");
	    By searchBox = By.id("search_query_top");
	    By searchButton = By.name("submit_search");
	    By confirmation_Text=By.xpath("//*[@id=\"center_column\"]/h1/span[1]");
	   

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void clickSignIn() {
	        driver.findElement(signInButton).click();
	    }

	    public String searchProduct(String productName) {
	        driver.findElement(searchBox).sendKeys(productName);
	        driver.findElement(searchButton).click();
	       return( driver.findElement(confirmation_Text).getText()); 
	        
	    }
	}

