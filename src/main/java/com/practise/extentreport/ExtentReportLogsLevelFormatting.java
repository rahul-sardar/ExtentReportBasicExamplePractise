package com.practise.extentreport;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportLogsLevelFormatting {
	
	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("\\Reports\\reportLogs.html");
		extentReports.attachReporter(sparkReporter);
		
		extentReports
		 .createTest("Test 1 - Text Based Data")
		 .log(Status.INFO, "Info1")
		 .log(Status.INFO, "<b>Info2</b>")
		 .log(Status.INFO, "<i>Info3</i>")
		 .log(Status.WARNING, "Warning 1")
		 .log(Status.WARNING, "Warning 2")
		 .log(Status.SKIP, "Skip 1")
		 .log(Status.SKIP, "Skip 2")
		 .log(Status.SKIP, "Skip 3")
		 .log(Status.FAIL, "Fail 1")
		 .log(Status.FAIL, "Fail 2");
		
		extentReports
		 .createTest("Test 2")
		 .log(Status.INFO, "Info1")
		 .log(Status.INFO, "Info2")
		 .log(Status.INFO, "Info3")
		 .log(Status.WARNING, "Warning 1")
		 .log(Status.WARNING, "Warning 2")
		 .log(Status.SKIP, "Skip 1")
		 .log(Status.SKIP, "Skip 2")
		 .log(Status.SKIP, "Skip 3")
		 .log(Status.PASS, "PASS 1");
		
		extentReports
		 .createTest("Test 3")
		 .log(Status.INFO, "Info1")
		 .log(Status.INFO, "Info2")
		 .log(Status.INFO, "Info3")
		 .log(Status.WARNING, "Warning 1")
		 .log(Status.WARNING, "Warning 2")
		 .log(Status.PASS, "PASS 1");
		
		extentReports
		 .createTest("Test 4")
		 .log(Status.INFO, "Info1")
		 .log(Status.INFO, "Info2")
		 .log(Status.INFO, "Info3")
		 .log(Status.PASS, "PASS 1");
		
		
		
		/*
		 * What will be the final status of Test 1, It depends on below order: 
		 * Fail 
		 * Skip
		 * Warning 
		 * Pass 
		 * Info
		 * Refer the notes
		 */
		 
		 
		
		
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File("\\Reports\\reportlogs.html").toURI());
	}

}
