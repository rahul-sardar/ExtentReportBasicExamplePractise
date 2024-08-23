package com.practise.extentreport;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportCreateTest {
	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		File file = new File("\\Reports\\reportTest.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		
		//By Default it will be passed, if we don't provide log
		ExtentTest test1 = extentReports.createTest("First Test");
		
		ExtentTest test2 = extentReports.createTest("Second Test", "This is second test description");
		test2.log(Status.FAIL, "Failed this test");
		
		ExtentTest test3 = extentReports.createTest("Third Test", "This is Third test description");
		test3.fail("Failed third test");
		
		ExtentTest test4 = extentReports.createTest("Fouth Test", "This is fourth test description");
		test4.skip("Skipped fourth test");
		
		
		
		extentReports.flush();
		Desktop.getDesktop().browse(file.toURI());
	}

}

/*
 * ExtentTest is an object that encapsulates a single test case in the
 * ExtentReports framework. It is used to log the details of the test steps,
 * such as what actions were taken, the results of those actions (pass, fail,
 * skip, etc.), and any additional information like screenshots, exceptions, or
 * warnings.
 */