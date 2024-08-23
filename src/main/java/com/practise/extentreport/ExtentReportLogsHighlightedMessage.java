package com.practise.extentreport;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportLogsHighlightedMessage {
	
	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("\\Reports\\reportLogs.html");
		extentReports.attachReporter(sparkReporter);
		
		extentReports
		 .createTest("Test 1 - Highlighted Message")
		 .log(Status.INFO, "This is not a highlighted Message")
		 .log(Status.INFO, MarkupHelper.createLabel("This is highlighted message", ExtentColor.RED))
		 .info(MarkupHelper.createLabel("This is too highlighted message", ExtentColor.RED));

		
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File("\\Reports\\reportlogs.html").toURI());
	}


}
