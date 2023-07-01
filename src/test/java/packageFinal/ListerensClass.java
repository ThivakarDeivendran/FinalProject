package packageFinal;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListerensClass implements ITestListener {

	public ExtentSparkReporter htmlReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;

	public void onStart(ITestContext testContext) {
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/MyExtentReport/myreport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Testing");
		htmlReporter.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);
		extentReports.setSystemInfo("Host Name", "LocalHost");
		extentReports.setSystemInfo("Environment", "QATest");
		extentReports.setSystemInfo("User", "Thivakar Deivendran");
	}

	public void onTestSuccess(ITestResult testResult) {
		extentTest = extentReports.createTest(testResult.getName());
		extentTest.log(Status.PASS, "Test Case Passed : " + testResult.getName());
	}

	public void onTestFailure(ITestResult testResult) {
		extentTest = extentReports.createTest(testResult.getName());
		extentTest.log(Status.FAIL, "Test Case Fail : " + testResult.getName());
		extentTest.log(Status.FAIL, "Error for Fail case : " + testResult.getThrowable());
	}
	
	public void onTestSkipped(ITestResult testResult) {
		extentTest = extentReports.createTest(testResult.getName());
		extentTest.log(Status.SKIP, "Test case Skip :  "+ testResult.getName());
	}
	public void onFinish(ITestContext testContext) {
		extentReports.flush();
	}
}

 class ListenersClassRetryAnalysers implements IRetryAnalyzer {

	private static int maximumValue = 5;
	private int countValue = 0;

	@Override
	public boolean retry(ITestResult result) {
		if (maximumValue > countValue) {
			countValue++;
			return true;
		}
		return false;
	}
}