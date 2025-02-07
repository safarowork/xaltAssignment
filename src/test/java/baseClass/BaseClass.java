package baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public Properties prop;
	
	@BeforeClass()
	public void setUp() throws IOException{
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
		prop.load(fis);
		
		switch(prop.getProperty("browser")) {
		case "chrome": WebDriverManager.chromedriver().setup();
						driver = new ChromeDriver(); break;
		case "edge" : WebDriverManager.edgedriver().setup();
						driver = new EdgeDriver(); break;
		case "firefox" : WebDriverManager.firefoxdriver().setup();
						driver = new FirefoxDriver();
		default : System.out.println("Invalid browser"); return;
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
