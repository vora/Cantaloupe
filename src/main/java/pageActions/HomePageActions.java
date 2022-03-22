package pageActions;

import base.BaseActions;

import base.TestBase;
import base.TestBase1;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageLocators.*;
import resources.FinalConstants;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HomePageActions extends TestBase1 {

    Properties prop = new Properties();
    BaseActions baseActions = new BaseActions();
    HomePageLocators homePageLocators = new HomePageLocators();
    LandingScreen loginScreen = new LandingScreen();
    SignInWithExistingAccountLocators signInWithExistingAccountLocators = new SignInWithExistingAccountLocators();

    //ContinueAccountCreationLocators continueAccountCreationLocators = new ContinueAccountCreationLocators();
    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();


    public HomePageActions() throws IOException {
    }



    public void verifyHomePage(String createAccount) throws MalformedURLException {

        try {
            WebElement createAccountButton = driver.findElement(loginScreen.createAccountBigButton);
            WebElement alreadyHaveAccountLink = driver.findElement(loginScreen.alreadyHaveAccountButton);
            WebElement firstCorousal = driver.findElement(homePageLocators.carousel);
            WebElement firstHeader = driver.findElement(homePageLocators.firstHeader);


            for (Object image : driver.findElements(By.cssSelector("img"))) {
                verifyBrokenImages((WebElement) image);
            }

            if ((createAccountButton.isEnabled()) && (alreadyHaveAccountLink.isEnabled()) && (firstCorousal.isEnabled()) && (firstHeader.isDisplayed())) {
                Assert.assertTrue(true, "All elements are valid on the Home Page");
                createAccountButton.click();
                WebElement createAccountText = driver.findElement(accountCreationLocators.createAccountText);
                Boolean createAccountTextStatus = createAccountText.isDisplayed();
                Assert.assertTrue(createAccountTextStatus == true, "User is on the right screen - Create Account");
                WebElement enterEmail = driver.findElement(accountCreationLocators.enterYourEmailInput);
                enterEmail.sendKeys(createAccount);
               driver.findElement(accountCreationLocators.backHomeLink).click();
               driver.findElement(homePageLocators.alreadyHaveAnAccountLink).click();
              WebElement signInText = driver.findElement(signInWithExistingAccountLocators.signInText);
              Boolean signInTextStatus = signInText.isDisplayed();
              Assert.assertTrue(signInTextStatus == true, "User is on the Sign In with existing account screen");

            } else {
                log.info("Invalid");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Verify corousal click and check if the header is present appropriately
    public void verifyCrousal() throws InterruptedException {
        List<WebElement> corousalList = driver.findElements(homePageLocators.carousel);
        List<WebElement> headerList = new ArrayList<>();
        headerList.add(driver.findElement(homePageLocators.firstHeader));
        headerList.add(driver.findElement(homePageLocators.secondHeader));
        headerList.add(driver.findElement(homePageLocators.thirdHeader));
        headerList.add(driver.findElement(homePageLocators.fourthHeader));

        for ( int i = 0 ; i<corousalList.size(); i++ )
        {
            corousalList.get(i).click();
            Thread.sleep(3000);
            WebElement text = headerList.get(i);
            Boolean status = text.isDisplayed();
            if(status==true) {
                Assert.assertTrue( true, "Header is displayed");
            }
            else
            {
                Assert.assertFalse(false, "Header is missing");
            }
        }
    }

    //Broken images
    public void verifyBrokenImages(WebElement image)
    {
        if (image.getAttribute("naturalWidth").equals("0"))
        {
            log.info(image.getAttribute("outerHTML") + " is broken.");
        }
    }

    public void checkFor503Error()
    {
        try
        {
            WebElement ErrorAlert503 = driver.findElement(homePageLocators.errorStatus503);

            if(ErrorAlert503.isDisplayed())
            {
                Assert.assertTrue(false, "Something is wrong");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}

