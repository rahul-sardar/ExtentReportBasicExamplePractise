package com.practise.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsLogsCollectionData {
	
	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("\\Reports\\reportLogs.html");
		extentReports.attachReporter(sparkReporter);
		
		List<String> cityData = new ArrayList<>();
		cityData.add("Badlapur");
		cityData.add("Ulhasnagar");
		cityData.add("Boisar");
		cityData.add("Dadar");
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Alex");
		map.put(2, "Israel");
		map.put(3, "Conor");
		
		Set<Integer> setData = map.keySet();
		
		
		extentReports
		 .createTest("Test 1 - Logging List Based Data")
		 .info(MarkupHelper.createOrderedList(cityData))
		 .info(MarkupHelper.createUnorderedList(cityData));
		
		extentReports
		 .createTest("Test 2 - Logging Maps Based Data")
		 .info(MarkupHelper.createOrderedList(map))
		 .info(MarkupHelper.createUnorderedList(map));
		
		//For Unordered list bullet points will be displayed and for ordered list numbering will come up.
		extentReports
		 .createTest("Test 3  - Logging Set based data")
		 .info(MarkupHelper.createOrderedList(setData))
		 .info(MarkupHelper.createUnorderedList(setData));	
		
		
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File("\\Reports\\reportlogs.html").toURI());
	}


}
