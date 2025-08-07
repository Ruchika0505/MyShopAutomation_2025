package TestCases;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageClasses.RegistrationPage;
import TestBase.BaseTest;
import Utilities.ExcelUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;



public class RegistrationDDTTest extends BaseTest {

   
    String path = System.getProperty("user.dir") + "\\Test Data\\Registration.xlsx";

    @Test
    public void registrationDDTTest() throws Exception {
    	  logger.info("Starting Data-Driven Registration Test");
    	  logger.debug("Excel file path: " + path);

        int rowCount = ExcelUtils.getRowCount(path, "Sheet1");
        logger.info("Total rows in Excel: " + rowCount);

        for (int i = 1; i <= rowCount; i++) {
            String email = randomeString() + "@gmail.com";
            String fname = ExcelUtils.getCellData(path, "Sheet1", i, 1);
            String lname = ExcelUtils.getCellData(path, "Sheet1", i, 2);
            String password = ExcelUtils.getCellData(path, "Sheet1", i, 3);

            logger.info("Executing registration for: " + email);
            logger.debug("First Name: " + fname + ", Last Name: " + lname + ", Password: " + password);

            RegistrationPage registration = new RegistrationPage(driver);
            registration.startAccountCreation(email);
            logger.info("Started account creation with email: " + email);

            Thread.sleep(3000); // Replace with WebDriverWait for better reliability
            registration.fillRegistrationForm(fname, lname, password);
            logger.info("Filled registration form for: " + fname + " " + lname);

            registration.submitRegistration();
            logger.info("Submitted registration form");

            registration.clickSignOut();
            logger.info("Signed out after registration");
        }

        logger.info("Data-Driven Registration Test Completed");
    }
}


  


