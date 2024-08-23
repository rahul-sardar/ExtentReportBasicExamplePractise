package com.practise.extentreport;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportConfiguration {

	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("\\Reports\\reportLogs.html");
		extentReports.attachReporter(sparkReporter);
		
		
		
		sparkReporter.config().setTheme(Theme.DARK);
		
		//Check the Title of the page
		sparkReporter.config().setDocumentTitle("Automation Reports -2024");
		
		sparkReporter.config().setReportName("Extent Reports -2024");
		sparkReporter.config().setTimeStampFormat("dd-mm-yyyy hh:mm:ss");
		sparkReporter.config().setCss(".badge-success {background-color:#0743e3}");
		sparkReporter.config().setJs("document.getElementsByClassName('logo')[0].style.display='none'");
		
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
