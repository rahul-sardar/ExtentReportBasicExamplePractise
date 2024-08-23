package com.practise.extentreport;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsLogXMlAndJsonData {
	

	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("\\Reports\\reportLogs.html");
		extentReports.attachReporter(sparkReporter);
		
		//This is some random xml data from net, we copy and directly pasted here.
		//In Java we don't have a direct datatype for storing xml or json data, just like we have it for int, character. so we
		//store it in string.
		
		String xmlData = "<!DOCTYPE glossary PUBLIC \"-//OASIS//DTD DocBook V3.1//EN\">\r\n"
				+ " <glossary><title>example glossary</title>\r\n"
				+ "  <GlossDiv><title>S</title>\r\n"
				+ "   <GlossList>\r\n"
				+ "    <GlossEntry ID=\"SGML\" SortAs=\"SGML\">\r\n"
				+ "     <GlossTerm>Standard Generalized Markup Language</GlossTerm>\r\n"
				+ "     <Acronym>SGML</Acronym>\r\n"
				+ "     <Abbrev>ISO 8879:1986</Abbrev>\r\n"
				+ "     <GlossDef>\r\n"
				+ "      <para>A meta-markup language, used to create markup\r\n"
				+ "languages such as DocBook.</para>\r\n"
				+ "      <GlossSeeAlso OtherTerm=\"GML\">\r\n"
				+ "      <GlossSeeAlso OtherTerm=\"XML\">\r\n"
				+ "     </GlossDef>\r\n"
				+ "     <GlossSee OtherTerm=\"markup\">\r\n"
				+ "    </GlossEntry>\r\n"
				+ "   </GlossList>\r\n"
				+ "  </GlossDiv>\r\n"
				+ " </glossary>";
		
		String jsonData = "{\r\n"
				+ "    \"glossary\": {\r\n"
				+ "        \"title\": \"example glossary\",\r\n"
				+ "		\"GlossDiv\": {\r\n"
				+ "            \"title\": \"S\",\r\n"
				+ "			\"GlossList\": {\r\n"
				+ "                \"GlossEntry\": {\r\n"
				+ "                    \"ID\": \"SGML\",\r\n"
				+ "					\"SortAs\": \"SGML\",\r\n"
				+ "					\"GlossTerm\": \"Standard Generalized Markup Language\",\r\n"
				+ "					\"Acronym\": \"SGML\",\r\n"
				+ "					\"Abbrev\": \"ISO 8879:1986\",\r\n"
				+ "					\"GlossDef\": {\r\n"
				+ "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\r\n"
				+ "						\"GlossSeeAlso\": [\"GML\", \"XML\"]\r\n"
				+ "                    },\r\n"
				+ "					\"GlossSee\": \"markup\"\r\n"
				+ "                }\r\n"
				+ "            }\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}";
		
		extentReports
		 .createTest("Test 1 - Directly logging XML data")
		 .log(Status.INFO, xmlData);
		
		extentReports
		 .createTest("Test 2 - Directly logging JSON data")
		 .log(Status.INFO, jsonData);
		
		extentReports
		 .createTest("Test 3 - logging XML data")
		 .info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));
		
		extentReports
		 .createTest("Test 4  -logging JSON data")
		 .info(MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));
		
		extentReports
		 .createTest("Test 5 - logging JSON data")
		 .log(Status.INFO,MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));
		 
		
		
		
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File("\\Reports\\reportlogs.html").toURI());
	}


}

/*
 * The method MarkupHelper.createCodeBlock(String data, CodeLanguage language)
 * is part of the ExtentReports library, specifically used to format and display
 * code-like text blocks in test reports. Here’s a detailed explanation:
 * 
 * Method Breakdown: MarkupHelper: This is a utility class in ExtentReports that
 * provides methods for generating HTML content within your test reports. It
 * helps in creating formatted text, code blocks, tables, and other elements
 * that enhance the readability and presentation of the reports.
 * 
 * createCodeBlock(String data, CodeLanguage language): This method formats a
 * given string of text as a code block, applying syntax highlighting based on
 * the specified programming or data language.
 */