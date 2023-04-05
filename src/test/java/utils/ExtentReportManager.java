package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements  ITestListener{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	

	

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.FAIL, "Test failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.SKIP, "Test skipped");
		
	}

	

	@Override
	public void onStart(ITestContext context) {

	
		repName="Test_report"+".html";
		
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);
		sparkReporter.config().setDocumentTitle("RestAssuredAutomation Project");
		sparkReporter.config().setReportName("Pet store users API");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application", "Pet store user api");
		extent.setSystemInfo("Operating system", System.getProperty("os.name"));
		extent.setSystemInfo("Username", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Developer", "ANNABI");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
