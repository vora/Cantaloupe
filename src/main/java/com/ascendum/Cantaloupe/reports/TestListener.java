package com.ascendum.Cantaloupe.reports;

import com.ascendum.Cantaloupe.base.TestBase;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends TestBase implements ITestListener {

    public static final Logger log = Logger.getLogger(TestBase.class.getName());

    @Override
    public void onStart(ITestContext context) {
        log.info("*** Test Suite : " + "\"" + context.getSuite().getName() + "\"" + " HAS STARTED ***");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info(("*** Test Suite : " + "\"" + context.getSuite().getName() + "\"" + " HAS ENDED ***"));
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info(("*** Running test method : " + "\"" + result.getMethod().getMethodName() + "\"" + "***"));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("*** Executed " + "\"" + result.getMethod().getMethodName() + "\"" + " SUCCESSFULLY ...");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("*** Test execution " + "\"" + result.getMethod().getMethodName() + "\"" + " FAILED...");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("*** Test " + "\"" + result.getMethod().getMethodName() + "\"" + " SKIPPED...");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("*** Test failed but within percentage % " + "\"" + result.getMethod().getMethodName() + "\"");
    }

}