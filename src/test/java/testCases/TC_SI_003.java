package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import baseClass.BaseClass;
import pageObject.HomePage;
import pageObject.SignInPage;
import pageObject.SignUpPage;

public class TC_SI_003 extends BaseClass{
	
	HomePage homepage;
	SignUpPage signuppage;
	SignInPage signinpage;
	Faker faker;
	
	@Test()
	public void testSigninInvalidPassword() {
		
		homepage = new HomePage(driver);
		signuppage = new SignUpPage(driver);
		signinpage = new SignInPage(driver);
		faker = new Faker();
		
		homepage.clickSignin();
		signuppage.goToSignInPage();
				
		boolean verifySignInPage = signinpage.verifySignInPage();
		Assert.assertTrue(verifySignInPage);
		
		String password = faker.internet().password(8, 9)+"!2A";
		
		signinpage.enterSigninEmail(prop.getProperty("validemail"));
		signinpage.enterSigninPassword(password);
		signinpage.clickSignIn();
		
		String invalidPasswordText = signinpage.getSignInAlerttext();
		
		Assert.assertEquals(invalidPasswordText, "Incorrect E-Mail or Password");
		
		signinpage.acceptSignInAlert();
		
	}

}
