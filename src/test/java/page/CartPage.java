package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
@FindBy(css="button[routerlink*='/cart']")
private WebElement cartbtn;

@FindBy(css=".cartSection h3")
private List<WebElement> cartProductsrt;

@FindBy(css=".totalRow button")
private WebElement btnclick;


public CartPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

public void clickOnCart() {
	cartbtn.click();
}

public void getCartprod(String nameofProduct) {
	for(WebElement cartprod:cartProductsrt) {
		String cartprodname=cartprod.getText();
		Assert.assertEquals(cartprodname, nameofProduct,"products are matched");
		break;
	}
	

	
}
public void getbtnclick() {
	btnclick.click();
}

}
