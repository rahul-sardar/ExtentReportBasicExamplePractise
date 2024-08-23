package com.practise.extentreport;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentsReportsAssigningAttributesExample2 {
	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("\\Reports\\reportLogs.html");
		extentReports.attachReporter(sparkReporter);
		
		extentReports
		 .createTest("Test 1 - Adding Attribute With Tests")
		 .log(Status.INFO, "Checks the Tags in reports")
		 .assignAuthor("John QA")
		 .assignCategory("Sanity")
		 .assignDevice("Computer");
		
		extentReports
		 .createTest("Test 2 - Adding Attribute With Tests")
		 .log(Status.INFO, "Checks the Tags in reports")
		 .assignAuthor("John QA")
		 .assignCategory("Sanity")
		 .assignDevice("Computer");
		
		extentReports
		 .createTest("Test 3 - Adding Attribute With Tests")
		 .log(Status.INFO, "Checks the Tags in reports")
		 .assignAuthor("Peter QA")
		 .assignAuthor("John QA")
		 .assignAuthor("Parker QA")
		 .assignCategory("Regression")
		 .assignCategory("Smoke")
		 .assignDevice("Laptop")
		 .assignDevice("Tablets");
		
		extentReports
		 .createTest("Test 4 - Adding Attribute With Tests")
		 .log(Status.WARNING, "Checks the Tags in reports")
		 .assignAuthor("Peter QA")
		 .assignCategory("Regression")
		 .assignDevice("Laptop");
		
		extentReports
		 .createTest("Test 5 - Adding Mutiple Attribute With Tests")
		 .log(Status.PASS, "Checks the Tags in reports")
		 .assignAuthor("Peter QA" , "Rat QA", "Mouse QA", "Dog QA")
		 .assignCategory("Regression" , "Sanity", "Smoke", "Functional")
		 .assignDevice("Laptop" , "Mobile", "Tablet", "Computer");
		
		extentReports
		 .createTest("Test 5 - Adding Mutiple Attribute With Tests")
		 .log(Status.PASS, "Checks the Tags in reports")
		 .assignAuthor(new String[] {"Peter QA" , "Rat QA", "Mouse QA", "Dog QA"})
		 .assignCategory(new String[] {"Regression" , "Sanity", "Smoke", "Functional"})
		 .assignDevice(new String[] {"Laptop" , "Mobile", "Tablet", "Computer"});
		

		
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File("\\Reports\\reportlogs.html").toURI());
	}

}
