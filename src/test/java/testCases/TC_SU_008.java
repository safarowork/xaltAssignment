package testCases;

import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import baseClass.BaseClass;
import pageObject.HomePage;
import pageObject.SignUpPage;

public class TC_SU_008 extends BaseClass{

	HomePage homepage;
	SignUpPage signupPage;
	Faker faker;
	
	@Test()
	void testSignupExistingUser() throws IOException, InterruptedException {
		homepage = new HomePage(driver);
		signupPage = new SignUpPage(driver);
		faker = new Faker();
		
		homepage.clickGetStarted();
		
		boolean signUpPageValdation = signupPage.verifySignUpPage();
		Assert.assertTrue(signUpPageValdation);
		
		String email = prop.getProperty("validemail");
		String password = faker.internet().password(8,9)+"1@A";
		
		signupPage.enterSignupEmail(email);
		signupPage.enterSignupPassword(password);
		signupPage.enterSignupConfirmPassword(password);
		signupPage.clickSignUp();
				
		String message = signupPage.getSignUpAlerttext(); //alert with password already in use message
		System.out.println(message);
		Assert.assertEquals(message, "Provided E-Mail is already in use");
		
		signupPage.acceptSignUpAlert();
				
	}
	
}
