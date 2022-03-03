package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
    public static IOSDriver driver;

    public ExtentReports reports;
    public ExtentTest test;

    public static final Logger log = Logger.getLogger(TestBase.class.getName());
    public static final String propertyFilePath = System.getProperty("user.dir") + "/src/main/java/resources/config.properties";
    public static final String log4jpropertyFilepPath = System.getProperty("user.dir") + "/src/main/java/resources/log4j.properties";

    public String existingAccountEmail;
    public String existingAccountPassword;
    public String createAccount;
    public String createAccountPassword;
    public String createAccountConfirmPassword;
    public String firstName;
    public String lastName;
    public String mobileNumber;
    public String streetAddress;
    public String city;
    public String state;
    public String zipcode;
    public String createNewEmail;
    public String newFirstName;
    public String newLastName;
    public String newMobileNumber;
    public String newStreetAddress;
    public String newCity;
    public String newState;
    public String newZipcod;




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
    public void testIO (){
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "iOS");
            caps.setCapability("deviceName", "iPhone 12 Pro Max");
            caps.setCapability(CapabilityType.BROWSER_NAME, "safari");
            caps.setCapability("platformVersion", "14.5");

            caps.setCapability("automationName", "XCUITest");

            try {
                URL url = new URL("http://0.0.0.0:4723/wd/hub");

                //String sessionId = "d8080676-634d-49fc-8624-fc7b57c5d530";
                // AppiumDriver driver1 = new AppiumDriver("http://localhost:4723/wd/hub" , sessionId);


                driver = new IOSDriver(url, caps);
                driver.get("https://more-qa.mycantaloupe.com");
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,300)", "");

            } catch (MalformedURLException e) {
                e.printStackTrace();
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

    public void callExcelHeaders(String existingAccountEmail, String existingAccountPassword,
                                 String createAccount, String createAccountPassword, String createAccountConfirmPassword,
                                 String firstName, String lastName, String mobileNumber, String streetAddress, String city,
                                 String state, String zipcode, String createNewEmail, String newFirstName, String newLastName,
                                 String newMobileNumber, String newStreetAddress, String newCity, String newState,
                                 String newZipcode) throws IOException
    {
        return;
    }
}