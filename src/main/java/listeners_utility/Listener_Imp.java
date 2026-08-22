package listeners_utility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener_Imp implements ISuiteListener, ITestListener{
	ExtentReports report; 
	ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		long time=System.currentTimeMillis();
	ExtentSparkReporter spark=new ExtentSparkReporter("./ad_reports/ExtentReport_"+time+".html");
	spark.config().setDocumentTitle("SauceDemo Report");
	spark.config().setReportName("Login Report");
	spark.config().setTheme(Theme.STANDARD);
	
	report = new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("Automation Test Engineer", "Deepak");
	report.setSystemInfo("Browser", "Chrome");
	report.setSystemInfo("Window", "11");
	report.setSystemInfo("FMT", "Maven");
	}
	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}
	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test=report.createTest(methodName);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS,methodName+"Passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.FAIL,methodName+ "Failed");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP,methodName+ "Skipped");
	}
	
}
