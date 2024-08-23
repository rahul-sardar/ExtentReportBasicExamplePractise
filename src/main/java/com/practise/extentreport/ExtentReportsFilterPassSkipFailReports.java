package com.practise.extentreport;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsFilterPassSkipFailReports {
	
	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter_All = new ExtentSparkReporter("\\Reports\\reportLogs_All.html");
		ExtentSparkReporter sparkReporter_Failed = new ExtentSparkReporter("\\Reports\\reportLogs_Failed.html");
		ExtentSparkReporter sparkReporter_SkipAndWarning = new ExtentSparkReporter("\\Reports\\reportLogs_SkipAndWarning.html");
		
		sparkReporter_Failed.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		sparkReporter_SkipAndWarning.filter().statusFilter().as(new Status[] {Status.SKIP, Status.WARNING}).apply();
		
		extentReports.attachReporter(sparkReporter_All,sparkReporter_Failed,sparkReporter_SkipAndWarning );
		
		extentReports
		 .createTest("Test 1 - Adding Attribute With Tests")
		 .log(Status.PASS, "Checks the Tags in reports")
		 .assignAuthor("John QA")
		 .assignCategory("Sanity")
		 .assignDevice("Computer");
		
		extentReports
		 .createTest("Test 2 - Adding Attribute With Tests")
		 .log(Status.FAIL, "Checks the Tags in reports")
		 .assignAuthor("John QA")
		 .assignCategory("Sanity")
		 .assignDevice("Computer");
		
		extentReports
		 .createTest("Test 3 - Adding Attribute With Tests")
		 .log(Status.FAIL, "Checks the Tags in reports")
		 .assignAuthor("Peter QA")
		 .assignCategory("Regression")
		 .assignDevice("Laptop");
		
		extentReports
		 .createTest("Test 4 - Adding Attribute With Tests")
		 .log(Status.PASS, "Checks the Tags in reports")
		 .assignAuthor("Peter QA")
		 .assignCategory("Regression")
		 .assignDevice("Laptop");
		
		extentReports
		 .createTest("Test 5 - Adding Attribute With Tests")
		 .log(Status.WARNING, "Checks the Tags in reports")
		 .assignAuthor("Peter QA", "GWEN QA", "Tony QA")
		 .assignCategory("Regression", "Functional Testing")
		 .assignDevice("Laptop");
		
		extentReports
		 .createTest("Test 6 - Adding Attribute With Tests")
		 .log(Status.SKIP, "Checks the Tags in reports")
		 .assignAuthor("Peter QA", "GWEN QA", "Tony QA")
		 .assignCategory("Regression", "Functional Testing")
		 .assignDevice("Laptop");
		

		
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File("\\Reports\\reportlogs_All.html").toURI());
		Desktop.getDesktop().browse(new File("\\Reports\\reportlogs_Failed.html").toURI());
		Desktop.getDesktop().browse(new File("\\Reports\\reportLogs_SkipAndWarning.html").toURI());
	}


}
