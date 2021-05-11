package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.messages.internal.com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class ProjectSpecifiMethods {

	public ChromeDriver driver;
	public String filename;
	public static Properties prop;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test,node;
	public String testName, testDescription,testCategory,testAuthor;
	
	@BeforeSuite
	public void startReport(){
	reporter = new ExtentHtmlReporter("./reports/reports.html");
	reporter.setAppendExisting(true);
	extent = new ExtentReports();
	extent.attachReporter(reporter);}
	
	@BeforeClass
	public void testDetails(){
	    test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);}
	
	public int takesnap() throws IOException {
		int rannum=(int)(Math.random()*99999);
		java.io.File source = driver.getScreenshotAs(OutputType.FILE);
		java.io.File target = new java.io.File("./snaps/img"+rannum+".png");
		FileUtils.copyFile(source, target);
		return rannum;
	}
	
	public void reportStep(String msg, String status) throws IOException{
	if(status.equalsIgnoreCase("pass")){
		node.pass(msg, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takesnap()+".png").build());
		test.pass(msg);}
	else if(status.equalsIgnoreCase("fail")) {
		test.fail(msg);
		throw new RuntimeException();}}
	
	@DataProvider(name="senddata")
	public String[][] senddata() throws IOException{
		return ReadExcel.ExcelRead(filename);
	}
	
	@BeforeMethod
	public void startapp() throws IOException
	{
		FileInputStream readfile = new FileInputStream("./src/main/resources/english.properties");
		prop = new Properties();
		prop.load(readfile);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closebrowser()
	{
		driver.close();
	}
}
