package com.ascendum.Cantaloupe.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extentReports;

    private static String reportFileName = "SMLoanPal-Automation" + ".html";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") + fileSeperator + "ExtentReports";
    public static String reportFileLocation = reportFilepath + fileSeperator + reportFileName;

    public static ExtentReports getInstance() {
        if (extentReports == null)
            createInstance();
        return extentReports;

    }

    // Create an extent report instance
    public static ExtentReports createInstance() {
        String fileName = getReportPath(reportFilepath);

        @Deprecated
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        // Set environment details
        extentReports.setSystemInfo("OS", "Mac");
        extentReports.setSystemInfo("Report", "SMLoanPal Automation Report");

        return extentReports;
    }

    // Create the report path
    private static String getReportPath(String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!");
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
        return reportFileLocation;
    }

}