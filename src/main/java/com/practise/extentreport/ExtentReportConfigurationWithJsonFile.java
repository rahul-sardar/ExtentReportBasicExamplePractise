package com.practise.extentreport;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportConfigurationWithJsonFile {
	
	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("\\Reports\\reportLogs.html");
		sparkReporter.loadJSONConfig(new File(".\\src\\main\\resources\\config\\spark-config.json"));
		extentReports.attachReporter(sparkReporter);
		
		
		extentReports
		 .createTest("Test 1 - Adding Attribute With Tests")
		 .log(Status.INFO, "Checks the Tags in reports")
		 .assignAuthor("John QA")
		 .assignCategory("Sanity")
		 .assignDevice("Computer");
		
		extentReports.flush();

		
		Desktop.getDesktop().browse(new File("\\Reports\\reportlogs.html").toURI());
	}

}
