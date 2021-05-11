package testcases;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtentReports {

	public static void main(String[] args) throws IOException {
	
		
	ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/reports.html");
	
	reporter.setAppendExisting(true);
	
	ExtentReports extent = new ExtentReports();
	
	extent.attachReporter(reporter);
	
	ExtentTest test = extent.createTest("LoginValidData", "Login with positive data");
	
	test.assignCategory("Functional");
	test.assignAuthor("Swatish");
	
	test.pass("enter username",MediaEntityBuilder.createScreenCaptureFromPath("./snaps/leaftaps.png").build());
	test.pass("enter password");
	test.pass("click login button");
	
	extent.flush();
	}

}
