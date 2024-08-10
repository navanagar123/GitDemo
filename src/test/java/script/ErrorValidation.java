package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.LandingPage;

public class ErrorValidation extends BaseTest {
@Test(groups="errorvalidation")
public void validation() {
	LandingPage lp=new LandingPage(driver);
	lp.sendemail("9480@gmail.com");
	lp.sendpassword("Abc@234");
	lp.logging();
	
	Assert.assertEquals("Incorrect email or passwordd.",lp.getErrormsg(),"not matching");
}



}
