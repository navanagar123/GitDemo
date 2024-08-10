package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmationmsg {
@FindBy(css=".hero-primary")
private WebElement confirmsg;

public Confirmationmsg(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

public String verifyconfirmmsg() {
	return confirmsg.getText();
}


}
