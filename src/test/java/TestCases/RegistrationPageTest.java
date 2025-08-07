package TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import PageClasses.RegistrationPage;
import TestBase.BaseTest;

public class RegistrationPageTest extends BaseTest {
  
	
	public void verifyUserRegistration() {
	   
	    logger.info("Starting test: verifyUserRegistration");

	    RegistrationPage registration = new RegistrationPage(driver);
	    logger.debug("Created RegistrationPage object");

	    String email = randomeString() + "@gmail.com";
	    logger.info("Generated random email: " + email);

	    registration.startAccountCreation(email);
	    logger.info("Started account creation with email: " + email);

	    String fname = randomeString();
	    String lname = randomeString();
	    String password = randomeString();

	    logger.debug("Generated first name: " + fname);
	    logger.debug("Generated last name: " + lname);
	    logger.debug("Generated password: " + password);

	    registration.fillRegistrationForm(fname, lname, password);
	    logger.info("Filled registration form with generated data");

	    registration.submitRegistration();
	    logger.info("Submitted registration form");

	    logger.info("Ending test: verifyUserRegistration");
	}

 }
