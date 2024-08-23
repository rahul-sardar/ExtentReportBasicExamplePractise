package com.practise.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportAttachScreenshotAtTestAndLogLevel {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("\\Reports\\reportLogs.html");
		extentReports.attachReporter(sparkReporter);

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		extentReports.createTest("Test 1 -Screenshot", "This is for attaching the screenshot at the test level")
				.info("This is the info message")
				.addScreenCaptureFromBase64String(takescreenshotsAsBase64());
		
		extentReports.createTest("Test 2 -Screenshot", "This is for attaching the screenshot at the test level")
		.info("This is the info message")
		.addScreenCaptureFromBase64String(takescreenshotsAsBase64(), "Google Image as Base64");
		
		
		extentReports.createTest("Test 3 -Screenshot", "This is for attaching the screenshot at the test level")
		.info("This is the info message 2 ")
		.addScreenCaptureFromPath(takescreenshots("Google"));
		
		extentReports.createTest("Test 4 -Screenshot", "This is for attaching the screenshot at the test level")
		.info("This is the info message 2 ")
		.addScreenCaptureFromPath(takescreenshots("Google") , "Google Image");
		
		extentReports.createTest("Test 5 - Mutiple Screenshot", "This is for attaching the multiple screenshot at the test level")
		.info("This is the info message 5 ")
		.addScreenCaptureFromPath(takescreenshots("Google") , "Google Image 1")
		.addScreenCaptureFromPath(takescreenshots("Google") , "Google Image 2")
		.addScreenCaptureFromPath(takescreenshots("Google") , "Google Image 3")
		.addScreenCaptureFromPath(takescreenshots("Google") , "Google Image 4");
		
		
		extentReports.createTest("Test 6 - Adding Screenshot At Log Level", "This is for attaching the  screenshot at the log level")
		.info("This is the info message 6 ")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(takescreenshotsAsBase64()).build());
		
		extentReports.createTest("Test 7 - Adding Screenshot At Log Level", "This is for attaching the  screenshot at the log level")
		.info("This is the info message 7 ")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(takescreenshotsAsBase64(), "Google Dashboard").build());
		
		extentReports.createTest("Test 8 - Adding Screenshot At Log Level", "This is for attaching the  screenshot at the log level")
		.info("This is the info message 8 ")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(takescreenshots("Google Images")).build());
		
		extentReports.createTest("Test 9 - Adding Screenshot At Log Level", "This is for attaching the  screenshot at the log level")
		.info("This is the info message 9 ")
		.fail("Failed Test Case with screenshot", MediaEntityBuilder.createScreenCaptureFromPath(takescreenshots("Google Images"), "Google Dashboard").build());
		
		extentReports.createTest("Test 10 - Adding Screenshot At Multiple Log Level", "This is for attaching the  screenshot at the log level")
		.info("This is the info message 10 with screenshot" , MediaEntityBuilder.createScreenCaptureFromPath(takescreenshots("Google Images"), "Google Dashboard").build())
		.fail("Failed Test Case with screenshot", MediaEntityBuilder.createScreenCaptureFromPath(takescreenshots("Google Images"), "Google Dashboard").build());
		
		Throwable t = new Throwable("This is throwable exception");
		
		//We can add throwable object also with screenshot
		extentReports.createTest("Test 11 - Adding Screenshot At Log Level", "This is for attaching the  screenshot at the log level")
		.info("This is the info message 11 ")
		.fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String(takescreenshotsAsBase64(), "Google Dashboard").build());
		
		extentReports.createTest("Test 12 - Adding Screenshot At Log Level", "This is for attaching the  screenshot at the log level")
		.info("This is the info message 12 ")
		.fail(t, MediaEntityBuilder.createScreenCaptureFromPath(takescreenshots("Google Images")).build());
		
		extentReports.createTest("Test 13 - Adding Screenshot At Log Level", "This is for attaching the  screenshot at the log level")
		.info("This is the info message 13 ")
		.fail(t, MediaEntityBuilder.createScreenCaptureFromPath(takescreenshots("Google Images"), "Google Dashboard").build());
		
		extentReports.createTest("Test 14 - Adding Screenshot At Multiple Log Level", "This is for attaching the  screenshot at the log level")
		.info("This is the info message 14 with screenshot" , MediaEntityBuilder.createScreenCaptureFromPath(takescreenshots("Google Images"), "Google Dashboard").build())
		.fail(t, MediaEntityBuilder.createScreenCaptureFromPath(takescreenshots("Google Images"), "Google Dashboard").build());
		
		
		
		extentReports.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("\\Reports\\reportlogs.html").toURI());
	}

	public static String takescreenshots(String filename) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File screenshotfile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./target/ScreenShots/" + filename + ".png");

		try {
			FileUtils.copyFile(screenshotfile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		return destFile.getAbsolutePath();

	}

	public static String takescreenshotsAsBase64() {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		String screenshotBase64Code = takesScreenshot.getScreenshotAs(OutputType.BASE64);

		System.out.println("Screenshot saved successfully");
		return screenshotBase64Code;
	}
}
