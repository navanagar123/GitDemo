package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

@FindBy(id="userEmail")
private WebElement email;

@FindBy(id="userPassword")
private WebElement password;

@FindBy(id="login")
private WebElement logbtn;

@FindBy(css="[class*='flyInOut']")
private WebElement errormsg;

public LandingPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

public void sendemail(String emailid) {
	email.sendKeys(emailid);
}

public void sendpassword(String passwordid) {
	password.sendKeys(passwordid);
}

public void logging() {
	logbtn.click();
}

public String getErrormsg() {
	return errormsg.getText();
	
}

}
