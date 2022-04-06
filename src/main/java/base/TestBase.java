package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import resources.FinalConstants;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static Properties properties;
    public static BufferedReader reader;
    public static WebDriver driver;


    public ExtentReports reports;
    public ExtentTest test;

   public static String addedMoreCardLast4Numbers;


    public static final Logger log = Logger.getLogger(TestBase2.class.getName());
    public static final String propertyFilePath = System.getProperty("user.dir") + "/src/main/java/resources/config.properties";
    public static final String log4jpropertyFilepPath = System.getProperty("user.dir") + "/src/main/java/resources/log4j.properties";


    public TestBase() {

        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
                PropertyConfigurator.configure(log4jpropertyFilepPath);
            } catch (final IOException e) {
                e.printStackTrace();
            }
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    @BeforeMethod
    public void testIO () {
        String iOS = "iOS";
        String Android = "Android";
        DesiredCapabilities caps = new DesiredCapabilities();
        if (properties.getProperty("platformName").equalsIgnoreCase(iOS)) {
            //  DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "iOS");
            caps.setCapability("deviceName", "iPhone 12 Pro Max");
            caps.setCapability(CapabilityType.BROWSER_NAME, "safari");
            caps.setCapability("platformVersion", "14.5");

            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("autoAcceptAlerts", true);
//            try {
//                URL url = new URL("http://0.0.0.0:4723/wd/hub");
//                // URL url = new URL("http://0.0.0.0:4726/wd/hub");
//                driver = new RemoteWebDriver(url, caps);
//                // driver.get("http://url614.cantaloupe.com/ls/click?upn=EjjkrhVv-2Fih3UeS6XUkye-2BxJ5-2F1GyHaMpBCQ7tFCameMdE-2FLQXJ8DKxiY-2FSTbgAm-2FUKOFRuP40OOIgvdcJ3ueEUzfR3orU-2Bdcz6ZxgZDvXfaNv3HOaWF2J2yqwefV5TemRy3AYUv8xn29p6NRjtU-2Fw-3D-3DLHyf_-2B5RXcraW6kUOw6bUo2JlhQ9pJo63EytkOIRLn-2F1bR-2FZQfspglE4Q2sK4DByj9GkvectfxEkR1BEdAJEX1NbDHQzJSYeSjZZR7Vu2UUwoXRTvSJrQ4Yy5YKHQMA6E9scB3Iw4xmmDmU84lEmf40IbW7sjihmb4H-2B29BhHuttDC2TXB3fCeD-2Bwpm3nGeGT2-2Fd9W39x5jpDCGB4T8TjJ4zFzZhXS4t5rAic0BwHLL3guzlmKf3XFpj3uSgQIGKchWEIv-2BDhYmmSLuysnMDyQ1AX9g-3D-3D");
//                driver.get("https://more-qa.mycantaloupe.com");
//                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//                JavascriptExecutor js = (JavascriptExecutor) driver;
//                js.executeScript("window.scrollBy(0,300)", "");
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//                //   }
//            }
        }
//        if(properties.getProperty("platformName").equalsIgnoreCase(Android)) {
//          //  DesiredCapabilities andCaps = DesiredCapabilities.chrome();
//            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//            caps.setCapability("deviceName", "emulator-5554");
//            caps.setCapability("androidPackage", "com.android.chrome");
//            caps.setCapability("platformVersion", "12.0");
//            caps.setCapability("automationName", "Appium");
//
//            ChromeOptions options = new ChromeOptions();
//            caps.merge(options);
//
////            try {
////                URL url = new URL("http://0.0.0.0:4723/wd/hub");
////                driver = new RemoteWebDriver(url,
////                        caps);
////                // driver.get("http://url614.cantaloupe.com/ls/click?upn=EjjkrhVv-2Fih3UeS6XUkye-2BxJ5-2F1GyHaMpBCQ7tFCameMdE-2FLQXJ8DKxiY-2FSTbgAm-2FUKOFRuP40OOIgvdcJ3ueEUzfR3orU-2Bdcz6ZxgZDvXfaNv3HOaWF2J2yqwefV5TemRy3AYUv8xn29p6NRjtU-2Fw-3D-3DLHyf_-2B5RXcraW6kUOw6bUo2JlhQ9pJo63EytkOIRLn-2F1bR-2FZQfspglE4Q2sK4DByj9GkvectfxEkR1BEdAJEX1NbDHQzJSYeSjZZR7Vu2UUwoXRTvSJrQ4Yy5YKHQMA6E9scB3Iw4xmmDmU84lEmf40IbW7sjihmb4H-2B29BhHuttDC2TXB3fCeD-2Bwpm3nGeGT2-2Fd9W39x5jpDCGB4T8TjJ4zFzZhXS4t5rAic0BwHLL3guzlmKf3XFpj3uSgQIGKchWEIv-2BDhYmmSLuysnMDyQ1AX9g-3D-3D");
////                driver.get("https://more-qa.mycantaloupe.com");
////                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
////                JavascriptExecutor js = (JavascriptExecutor) driver;
////                js.executeScript("window.scrollBy(0,300)", "");
////
////            } catch (MalformedURLException malformedURLException) {
////                malformedURLException.printStackTrace();
////            }
//        }
//        try {
//            URL url = new URL("http://0.0.0.0:4723/wd/hub");
//            driver = new RemoteWebDriver(url, caps);
//            // driver.get("http://url614.cantaloupe.com/ls/click?upn=EjjkrhVv-2Fih3UeS6XUkye-2BxJ5-2F1GyHaMpBCQ7tFCameMdE-2FLQXJ8DKxiY-2FSTbgAm-2FUKOFRuP40OOIgvdcJ3ueEUzfR3orU-2Bdcz6ZxgZDvXfaNv3HOaWF2J2yqwefV5TemRy3AYUv8xn29p6NRjtU-2Fw-3D-3DLHyf_-2B5RXcraW6kUOw6bUo2JlhQ9pJo63EytkOIRLn-2F1bR-2FZQfspglE4Q2sK4DByj9GkvectfxEkR1BEdAJEX1NbDHQzJSYeSjZZR7Vu2UUwoXRTvSJrQ4Yy5YKHQMA6E9scB3Iw4xmmDmU84lEmf40IbW7sjihmb4H-2B29BhHuttDC2TXB3fCeD-2Bwpm3nGeGT2-2Fd9W39x5jpDCGB4T8TjJ4zFzZhXS4t5rAic0BwHLL3guzlmKf3XFpj3uSgQIGKchWEIv-2BDhYmmSLuysnMDyQ1AX9g-3D-3D");
//            driver.get("https://more-qa.mycantaloupe.com");
//            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("window.scrollBy(0,300)", "");
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
    // }
     if(properties.getProperty("platformName").equalsIgnoreCase(Android)) {
        DesiredCapabilities andCaps = DesiredCapabilities.chrome();
        andCaps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        andCaps.setCapability("deviceName", "emulator-5554");
        andCaps.setCapability("androidPackage", "com.android.chrome");
        andCaps.setCapability("platformVersion", "12.0");
        andCaps.setCapability("automationName", "Appium");

//        ChromeOptions options = new ChromeOptions();
//        andCaps.merge(options);

        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new RemoteWebDriver(url,
                    andCaps);
            // driver.get("http://url614.cantaloupe.com/ls/click?upn=EjjkrhVv-2Fih3UeS6XUkye-2BxJ5-2F1GyHaMpBCQ7tFCameMdE-2FLQXJ8DKxiY-2FSTbgAm-2FUKOFRuP40OOIgvdcJ3ueEUzfR3orU-2Bdcz6ZxgZDvXfaNv3HOaWF2J2yqwefV5TemRy3AYUv8xn29p6NRjtU-2Fw-3D-3DLHyf_-2B5RXcraW6kUOw6bUo2JlhQ9pJo63EytkOIRLn-2F1bR-2FZQfspglE4Q2sK4DByj9GkvectfxEkR1BEdAJEX1NbDHQzJSYeSjZZR7Vu2UUwoXRTvSJrQ4Yy5YKHQMA6E9scB3Iw4xmmDmU84lEmf40IbW7sjihmb4H-2B29BhHuttDC2TXB3fCeD-2Bwpm3nGeGT2-2Fd9W39x5jpDCGB4T8TjJ4zFzZhXS4t5rAic0BwHLL3guzlmKf3XFpj3uSgQIGKchWEIv-2BDhYmmSLuysnMDyQ1AX9g-3D-3D");
            driver.get("https://more-qa.mycantaloupe.com");
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,300)", "");

        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }
    }
    }
    @AfterMethod

    public void tearDown(ITestResult result) {
        String path = null;
        DateFormat dateformat = new SimpleDateFormat("dd-MMM-YYYY hh:mm:ss a");
        Calendar cal = Calendar.getInstance();
        String timestamp = dateformat.format(cal.getTime());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            if (ITestResult.FAILURE == result.getStatus()) {
                path = "./FailedScreenshots/" + result.getParameters()[0] + "_" + "_" + timestamp + ".png";
                FileUtils.copyFile(source, new File(path));
                log.info("Screenshot captured for the Failed testcase");

            } else if (ITestResult.SUCCESS == result.getStatus()) {
                path = "./PASS_Screenshots/" + result.getParameters()[0] +  "_" + timestamp + ".png";
                FileUtils.copyFile(source, new File(path));
                log.info("Screenshot captured for the Passed testcase");
            }
        }catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        driver.quit();
    }
}
