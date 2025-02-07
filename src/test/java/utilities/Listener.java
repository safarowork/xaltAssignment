package utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{
	
//	public void onTestStart(ITestResult result) {
//	  }

//	  public void onTestSuccess(ITestResult result) {
//	  }

	  public void onTestFailure(ITestResult result) {
		  try {
			Helpers.takeScreenShotOnFailure(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }

//	  public void onTestSkipped(ITestResult result) {
//	  }

//	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//	  }
//
//	  public void onTestFailedWithTimeout(ITestResult result) {
//	    onTestFailure(result);
//	  }

	  public void onStart(ITestContext context) {
		  System.out.println("**********Test execution started********");
	  }

	  public void onFinish(ITestContext context) {
		  System.out.println("**********Test Execution Finished*********");
	  }
	

}
