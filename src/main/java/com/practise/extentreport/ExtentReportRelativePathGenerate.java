package com.practise.extentreport;

import java.awt.Desktop;
import java.io.File;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportRelativePathGenerate {
	
	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(".\\Reports\\reportNew.html");
		extentReports.attachReporter(sparkReporter);
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File("\\Reports\\reportNew.html").toURI());
		
		
	}

}

