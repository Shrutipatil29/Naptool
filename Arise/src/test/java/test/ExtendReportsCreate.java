package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportsCreate
{
    public static ExtentReports generateTestReports()
    {
        ExtentSparkReporter htmlReporter=new ExtentSparkReporter("ExtentsReport.html");
        ExtentReports report=new ExtentReports();
        report.attachReporter(htmlReporter);
        report.setSystemInfo("OS", "MacOS");
        report.setSystemInfo("Created by", "Shruti");
        report.setSystemInfo("Test type", "Regression");
        return report;
    }

}