package generic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport {
	public static ExtentReports ExtentRep() {
	String path="./src/test/resources/resources/index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	ExtentReports extent=new ExtentReports();
	extent.attachReporter(reporter);
	return extent;
}
}
