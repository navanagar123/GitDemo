package script;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.CartPage;
import page.Confirmationmsg;
import page.LandingPage;
import page.OrderPage;
import page.ProductPage;

public class StandaloneTest extends BaseTest{
	String nameofProduct="ADIDAS ORIGINAL";
@Test(dataProvider="getData")
public void submitOrder(HashMap<String,String> input) {
	
	
	LandingPage lp=new LandingPage(driver);
	lp.sendemail(input.get("email"));
	lp.sendpassword(input.get("password"));
	lp.logging();
	
	ProductPage pp=new ProductPage(driver);
	 pp.getProduts();
	
	pp.addproduct(nameofProduct);
	
	
//	for(WebElement product:products) {
//		String prodname=product.findElement(By.cssSelector("b")).getText();
//		System.out.println(prodname);
//		if(prodname.equalsIgnoreCase(nameofProduct)) {
//			
//			product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//			break;
//		}
//	}
	
	WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	
	
	//driver.findElement(By.cssSelector("button[routerlink*='/cart']")).click();
	
	//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3 "));
    
//	for(WebElement cartprod:cartProducts) {
//		String cartprodname=cartprod.getText();
//		Assert.assertEquals(cartprodname, nameofProduct,"products are matched");
//		break;
//	}
	
	CartPage cp=new CartPage(driver);
	cp.clickOnCart();
	cp.getCartprod(nameofProduct);
	cp.getbtnclick();
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	
	OrderPage op=new OrderPage(driver);
	op.selectCountries(driver);
	op.submitorder();
	
//	Actions a=new Actions(driver);
//	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
//	
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//	
//	driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
//	
//	driver.findElement(By.cssSelector(".action__submit")).click();
	
	Confirmationmsg cpv=new Confirmationmsg(driver) ;
	String confirmmsg = cpv.verifyconfirmmsg();
	
	Assert.assertEquals(confirmmsg,"THANKYOU FOR THE ORDER.");
	
}
@Test(dependsOnMethods={"submitOrder"},dataProvider="dataGet")
public void getOrderprod(String uname,String password) {
	LandingPage lp=new LandingPage(driver);
	lp.sendemail(uname);
	lp.sendpassword(password);
	lp.logging();
	OrderPage op=new OrderPage(driver);
	op.clickOnorder();
	op.getOrderProd("adidas original");
}

@DataProvider
public Object[][] getData() {
	HashMap<String,String> map=new HashMap<String,String>();
	map.put("email","9480@gmail.com");
	map.put("password","Abc@1234");
//	String[][] s1=new String[1][2];
//	s1[0][0]="9480@gmail.com";
//	s1[0][1]="Abc@1234";
	//{"9480@gmail.com","Abc@1234"};
	return  new Object[][]{{map}};
	
	
}
@DataProvider
public String[][] dataGet() {
	String[][] s=new String[1][2];
	s[0][0]="9480@gmail.com";
	s[0][1]="Abc@1234";
	return s;
}

public void getScreenShot(String testcaseName) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File srcFile = ts.getScreenshotAs(OutputType.FILE);
	File dstFile=new File("./resources/"+testcaseName+".png");
	FileUtils.copyFile(srcFile, dstFile);
}

}
