package base;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class TestBase {

    public static Properties properties;
    public static BufferedReader reader;
    public static WebDriver driver;

    public static ExtentReports extent;
     public static ExtentTest extentTest;

     //BrowserStack code
    public static final String USERNAME = "*****";
    public static final String AUTOMATE_KEY = "********";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static String addedMoreCardLast4Numbers;
    public static final Logger log = Logger.getLogger(TestBase.class.getName());
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


    @BeforeTest
    public void setExtent(){
        extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
        extent.addSystemInfo("Host Name", "Ascendum Mac");
        extent.addSystemInfo("User Name", "rprem");
        extent.addSystemInfo("Environment", "QA");

    }


    @BeforeMethod
    public void testIO () throws MalformedURLException {
        String iOS = "iOS";
        String Android = "Android";
        String web = "web";


        DesiredCapabilities caps = new DesiredCapabilities();
        if (properties.getProperty("platformName").equalsIgnoreCase(iOS)) {
            caps.setCapability("platformName", "iOS");
            caps.setCapability("deviceName", "iPhone 13 Pro Max");
            caps.setCapability(CapabilityType.BROWSER_NAME, "safari");
            caps.setCapability("platformVersion", "15.2");

            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("autoAcceptAlerts", true);
            caps.setCapability(CapabilityType.APPLICATION_NAME, "Settings");
            getUrlMethod(caps);
        }


            if (properties.getProperty("platformName").equalsIgnoreCase(Android)) {
                DesiredCapabilities andCaps = DesiredCapabilities.chrome();
                andCaps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                andCaps.setCapability("deviceName", "emulator-5554");
                andCaps.setCapability("androidPackage", "com.android.chrome");
                andCaps.setCapability("platformVersion", "12.0");
                andCaps.setCapability("automationName", "Appium");

                ChromeOptions options = new ChromeOptions();
                andCaps.merge(options);
                getUrlMethod(caps);
            }
    }

    public void getUrlMethod(DesiredCapabilities caps)
    {
        try {
            URL url = new URL("http://0.0.0.0:4723/wd/hub");
            driver = new RemoteWebDriver(url, caps);
            driver.get(properties.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,300)", "");
            driver.manage().deleteAllCookies();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void teraDown()
    {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
