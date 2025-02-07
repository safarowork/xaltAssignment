package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import pageObject.BasePage;

public class Helpers extends BasePage{
	
	JavascriptExecutor js;
	WebDriverWait wait;
	
	public Helpers(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
	}

	public Alert switchToAlert() {
		return driver.switchTo().alert();
	}
	
	public void javaScriptClick(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}
	
	public void javaScriptSendKeys(WebElement element, String attribute, String value) {
		js.executeScript("arguments[0].setAttribute('"+attribute+"', '"+value+"')", element);
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element, int duration) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public Alert waitForAlert() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void takeScreenShotOnFailure(ITestResult result) throws IOException {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date()); //TimeStamp
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./screenshots/"+result.getName()+"_"+timestamp+".png"));
	}
	
	
	
	
	 
	
	

}
