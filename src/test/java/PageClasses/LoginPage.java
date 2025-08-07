package PageClasses;



		import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	public class LoginPage {
	    WebDriver driver;

	    By emailField = By.id("email");
	    By passwordField = By.id("passwd");
	    By signInButton = By.id("SubmitLogin");
	    By text=By.xpath("//*[@id=\"center_column\"]/div[1]/p");

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void login(String email, String password) {
	        driver.findElement(emailField).sendKeys(email);
	        driver.findElement(passwordField).sendKeys(password);
	        driver.findElement(signInButton).click();
	    }
	    
	    public String text()
	    {
	    	return (driver.findElement(text).getText());
	    }
	}

