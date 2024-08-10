package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderPage {
@FindBy(css="[placeholder='Select Country']")
private WebElement selectCountry;

@FindBy(css=".ta-item:nth-of-type(2)")
private WebElement selectone;

@FindBy(css=".action__submit")
private WebElement submitbtn;

@FindBy(css="[routerlink*='myorders']")
private WebElement Orderbtn;


@FindBy(xpath="//tr//td[2]")
private List<WebElement> orderproducts ;

public OrderPage(WebDriver driver){
	PageFactory.initElements(driver,this);
}

public void selectCountries(WebDriver driver) {
	Actions a=new Actions(driver);
	a.sendKeys(selectCountry,"india").build().perform();
	selectone.click();
	
}

public void submitorder() {
	submitbtn.click();
}

public void clickOnorder() {
	Orderbtn.click();
}

public void getOrderProd(String nameofProduct) {
	for(WebElement orderprod:orderproducts) {
		String orderprodname=orderprod.getText();
		Assert.assertEquals(orderprodname, nameofProduct,"products are matched");
		break;
	}
	
}
}
