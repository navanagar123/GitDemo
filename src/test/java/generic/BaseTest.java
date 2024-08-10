package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	public void preCondition() throws FileNotFoundException, IOException {
		
		Properties prop=new Properties();
		prop.load(new FileInputStream("./src/test/resources/resources/data.properties"));
		String browsername = prop.getProperty("browser");
		String url=prop.getProperty("url");
		if(browsername.equals("chrome")) {
			 driver=new ChromeDriver();
		}
		else {
		 driver=new FirefoxDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void postCondition() {
		driver.close();
	}
}
