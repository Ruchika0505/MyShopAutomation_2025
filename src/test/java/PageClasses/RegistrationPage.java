package PageClasses;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;

  
    By emailCreateField = By.xpath("//*[@id=\"email_create\" and @name =\"email_create\"]");
 	By createAccountButton = By.xpath("//*[@id=\"SubmitCreate\" and @name=\"SubmitCreate\"]");

    	By firstName = By.xpath("//*[@id=\"customer_firstname\"]");
    	By lastName = By.id("customer_lastname");
    	By password = By.id("passwd");
    	By address = By.id("address1");
    	By city = By.id("city");
    	By state = By.id("id_state");
    	By postcode = By.id("postcode");
    	By mobilePhone = By.id("phone_mobile");
    	By registerButton = By.id("submitAccount");
    	By SignInButton=By.xpath("//a[@title='Log in to your customer account']");
        By SignOutButton=By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");
   
        
        // Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void startAccountCreation(String email) {
    	driver.findElement(SignInButton).click();
        driver.findElement(emailCreateField).sendKeys(email);
        driver.findElement(createAccountButton).click();
    }

   
    public void fillRegistrationForm(String fName, String lName, String pass)
           {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(password).sendKeys(pass);
        
    }

    public void submitRegistration() {
        driver.findElement(registerButton).click();
    }
    
    public void clickSignOut() {
        driver.findElement(SignOutButton).click();
    }
    
}

