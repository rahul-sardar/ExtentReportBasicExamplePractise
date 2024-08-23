package com.practise.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportReportStyling {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports = new ExtentReports();
		File file = new File("\\Reports\\reportLogsStyling.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);

		extentReports.createTest("Text Based Test").log(Status.INFO, "Info1").log(Status.INFO, "<b>info2</b>")
				.log(Status.INFO, "<i>info3</i>").log(Status.INFO, "<b><i>info3</i></b>");

		// XMLDATA in string format, Now we are going to directly log this xml data in
		// extent report
		String xmlData = "<root>\n" + "  <work toward=\"terrible\">\n" + "    <![CDATA[opinion basic memory]]>bag\n"
				+ "  </work>\n" + "  <sale>\n" + "    <possible>-766870879</possible>\n"
				+ "    <problem tone=\"main\">413852485.91068697</problem>\n"
				+ "    <appropriate tax=\"fast\">upper</appropriate>\n" + "  </sale>\n"
				+ "  <middle silver=\"began\">political</middle>\n" + "</root>";

		// JSONDATA in string format, Now we are going to directly log this xml data in
		// extent report
		String jsonData = "{\n" + "  \"root\": {\n" + "    \"work\": {\n" + "      \"@toward\": \"terrible\",\n"
				+ "      \"#text\": \"opinion basic memorybag\"\n" + "    },\n" + "    \"sale\": {\n"
				+ "      \"possible\": \"-766870879\",\n" + "      \"problem\": {\n" + "        \"@tone\": \"main\",\n"
				+ "        \"#text\": \"413852485.91068697\"\n" + "      },\n" + "      \"appropriate\": {\n"
				+ "        \"@tax\": \"fast\",\n" + "        \"#text\": \"upper\"\n" + "      }\n" + "    },\n"
				+ "    \"middle\": {\n" + "      \"@silver\": \"began\",\n" + "      \"#text\": \"political\"\n"
				+ "    }\n" + "  }\n" + "}";

		// We are logging the xml, json data directly as string
		extentReports.createTest("Printing directly XML DATA as text only").log(Status.INFO, xmlData);

		extentReports.createTest("Printing directly JSON DATA as text only").log(Status.INFO, jsonData);

		extentReports.createTest("XML based data").info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));
		extentReports.createTest("JSON based data").info(MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));

		// Lets highlight the logs in the report
		extentReports.createTest("Highlighted Test").info("This is not highlighted text")
				.info(MarkupHelper.createLabel("This is highlighted text", ExtentColor.RED));

		// Lets logs the expection in logs
		extentReports.createTest("Highlighted Test").info("This is not highlighted text")
				.info(MarkupHelper.createLabel("This is highlighted text", ExtentColor.RED));
		
		List listData = new ArrayList<>();
		

		try {
			int i = 5 / 0;
		} catch (ArithmeticException e) {
			extentReports.createTest("Exception Test 1").info(e);
		}

		Throwable t = new RuntimeException("This is a custom exception");
		extentReports.createTest("Exception test 2").info(t);

		extentReports.flush();
		Desktop.getDesktop().browse(file.toURI());

	}

}
