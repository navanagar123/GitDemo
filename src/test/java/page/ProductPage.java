package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	@FindBy(css=".mb-3")
	private List<WebElement> products;
	
	public ProductPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public List<WebElement> getProduts() {
		return products;
	}
	
	
	public void addproduct(String nameofProduct) {
		for(WebElement product: getProduts()) {
			String prodname=product.findElement(By.cssSelector("b")).getText();
			System.out.println(prodname);
			if(prodname.equalsIgnoreCase(nameofProduct)) {
				
				product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
				break;
			}
		
		}
	}
	
	
	
}

