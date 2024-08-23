package com.practise.extentreport;

import java.awt.Desktop;
import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportAddEnvironmentSystemProperties {
	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		
		/**
		 * RemoteWebDriver is a class in Selenium that implements the WebDriver interface. 
		((RemoteWebDriver) driver).getCapabilities(); is a typecast that allows you to access the getCapabilities() 
		method of the RemoteWebDriver class, even when you're using a specific WebDriver instance like ChromeDriver.
		*/
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		
		String browserName = capabilities.getBrowserName();  // e.g., "chrome"
		String browserVersion = capabilities.getBrowserVersion();  // e.g., "92.0.4515.107"
		
		// Get OS name
        String osName = System.getProperty("os.name");
        System.out.println("Operating System Name: " + osName);
        
        // Get Java version
        String javaVersion = System.getProperty("java.version");
        System.out.println("Java Version: " + javaVersion);
        
        //To print all the Property
        System.getProperties().list(System.out);
		
		ExtentReports extentReports = new ExtentReports();
		extentReports.setSystemInfo("OS", osName);
		extentReports.setSystemInfo("Browser", browserName);
		extentReports.setSystemInfo("Browser Version", browserVersion);
		extentReports.setSystemInfo("Java Runtime Version", javaVersion);
		extentReports.setSystemInfo("App Url", "www.google.com");
		extentReports.setSystemInfo("UserName", "RahulAsh@yopmail.com");
		extentReports.setSystemInfo("Password", "Abcd");
		
		
		
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("\\Reports\\reportLogs.html");
		sparkReporter.config().setTheme(Theme.DARK);
				
		//Check the Title of the page
		sparkReporter.config().setDocumentTitle("Automation Reports -2024");
		
		sparkReporter.config().setReportName("Extent Reports -2024");
		sparkReporter.config().setTimeStampFormat("dd-mm-yyyy hh:mm:ss");
		sparkReporter.config().setCss(".badge-success {background-color:#0743e3}");
		sparkReporter.config().setJs("document.getElementsByClassName('logo')[0].style.display='none'");
		
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
		
		extentReports.flush();

		Desktop.getDesktop().browse(new File("\\Reports\\reportlogs.html").toURI());
	}

}
