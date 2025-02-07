package testCases;

import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import baseClass.BaseClass;
import pageObject.DashboardPage;
import pageObject.HomePage;
import pageObject.SignUpPage;

public class TC_SU_001 extends BaseClass{

	HomePage homepage;
	SignUpPage signupPage;
	DashboardPage dashboardpage;
	Faker faker;
	
	@Test()
	void testSignupValidInfo() throws IOException, InterruptedException {
		homepage = new HomePage(driver);
		signupPage = new SignUpPage(driver);
		dashboardpage = new DashboardPage(driver);
		faker = new Faker();
		
		homepage.clickGetStarted();
		
		boolean signUpPageValdation = signupPage.verifySignUpPage();
		Assert.assertTrue(signUpPageValdation);
		
		String email = faker.internet().emailAddress();
		String password = faker.internet().password(8, 9)+"!2A";
		
		signupPage.enterSignupEmail(email);
		signupPage.enterSignupPassword(password);
		signupPage.enterSignupConfirmPassword(password);
		signupPage.clickSignUp();
		
		boolean signUpValdation = dashboardpage.verifyDashboardPage();
		Assert.assertTrue(signUpValdation);
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/config.properties");
		prop.put("validemail", email);
		prop.put("validpassword", password);
		prop.store(fos, "");
				
	}
	
}
