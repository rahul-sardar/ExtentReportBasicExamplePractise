package com.practise.extentreport;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportLogsException {

	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("\\Reports\\reportLogs.html");
		extentReports.attachReporter(sparkReporter);

		try {
			int i = 5 / 0;
		} catch (Exception e) {
           extentReports
            .createTest("Test 1 - Logging Exception")
            .info(e);
		}
		
		Throwable t = new RuntimeException("This is a custom exception");
		extentReports
        .createTest("Test 2 - Logging Exception")
        .info(t);

		extentReports.flush();

		Desktop.getDesktop().browse(new File("\\Reports\\reportlogs.html").toURI());
	}

}
