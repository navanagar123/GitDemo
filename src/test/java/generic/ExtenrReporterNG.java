package generic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtenrReporterNG {
  public void getReporterObject() {
	  String path = System.getProperty("user.dir")+"//reports//index.html";
	  ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	  
	  ExtentReports extent=new ExtentReports();
	  extent.attachReporter(reporter);
	  
  }
	
	
}
