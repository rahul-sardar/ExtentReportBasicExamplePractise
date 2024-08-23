package com.practise.extentreport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportExample1 {
public static void main(String[] args) {
	ExtentReports extentReport = new ExtentReports();
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter("D:\\eclipse-practiseworkspace1\\ExtentReportPractiseMaven\\report.html");
	
	//Attaches the ExtentSparkReporter to the ExtentReports instance. This makes the ExtentSparkReporter an observer that listens to 
	//test results and generates the HTML report.
	extentReport.attachReporter(sparkReporter);
	System.out.println("Done");
	// Finalizes the report by writing all collected test data to the HTML file. This should be called at the end to ensure all data 
	//is written to the report.
	extentReport.flush();
}
}
