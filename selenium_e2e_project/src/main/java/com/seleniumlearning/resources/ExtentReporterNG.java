package com.seleniumlearning.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Result");
		
		ExtentReports exreport=new ExtentReports() ;
		exreport.attachReporter(reporter);
		exreport.setSystemInfo("Tester Infor", "Saniya");
		
		return exreport;
	}

}
