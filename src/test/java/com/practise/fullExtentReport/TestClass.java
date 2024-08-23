package com.practise.fullExtentReport;

import org.testng.annotations.Test;

public class TestClass extends BaseTest{
	@Test
	public void TestGoogle() throws Exception {
		driver.get("https://www.google.com");
		
	}

}
