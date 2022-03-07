package pageActions;

import base.BaseActions;

import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageLocators.AccountCreationLocators;
import pageLocators.CreateAccountLocators;
import pageLocators.HomePageLocators;
import pageLocators.LandingScreen;
import resources.FinalConstants;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HomePageActions extends TestBase {

    Properties prop = new Properties();
    BaseActions baseActions = new BaseActions();
    HomePageLocators homePageLocators = new HomePageLocators();
    LandingScreen loginScreen = new LandingScreen();
    CreateAccountLocators createAccountLocators = new CreateAccountLocators();
    //ContinueAccountCreationLocators continueAccountCreationLocators = new ContinueAccountCreationLocators();
    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();


    public HomePageActions() throws IOException {
    }


//    public void testIOS(String existingAccountEmail, String existingAccountPassword, String createAccount, String createAccountPassword, String createAccountConfirmPassword,
//                        String firstName, String lastName, String mobileNumber, String streetAddress, String city, String state, String zipcode, String createNewEmail, String newFirstName)
//            throws MalformedURLException {


    @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)
    public void verifyHomePage(String createAccount)
            throws MalformedURLException {

        try {

            WebElement createAccountButton = driver.findElement(loginScreen.createAccountBigButton);

            if (createAccountButton.isDisplayed()) {

                createAccountButton.click();
                WebElement enterEmail = driver.findElement(createAccountLocators.enterYourEmailInput);
                enterEmail.sendKeys(createAccount);

            } else {
                System.out.println("Invalid");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Corousal check and click
    public void verifyCrousal() {
        List<WebElement> corousalList = driver.findElements(homePageLocators.carousel);
        for (WebElement li : corousalList) {
            int listCount = corousalList.size();
            if (listCount == 4) {
                Assert.assertTrue(true);
                li.click();
            } else {
                log.info("The corousal number is a mismatch");
            }
        }
    }



    // image validations
    public void CheckImage() throws Exception {


        WebElement image1 = FinalConstants.image1;
        WebElement image2 = FinalConstants.image2;
        WebElement image3 = FinalConstants.image3;
        WebElement image4 = FinalConstants.image4;
        WebElement logo = FinalConstants.logo;

        List<WebElement> corousalList = driver.findElements(homePageLocators.carousel);
        List<WebElement> listOfAllImages = new ArrayList<WebElement>();
        listOfAllImages.add(FinalConstants.image1);
        listOfAllImages.add(FinalConstants.image2);
        listOfAllImages.add(FinalConstants.image3);
        listOfAllImages.add(FinalConstants.image4);
        listOfAllImages.add(FinalConstants.logo);

        List<String> corousalList1 = new ArrayList<String>();

        corousalList1.add("Cantaloupe More Card");
        corousalList1.add("Cantaloupe Payment Options");
        corousalList1.add("cpay Card");
        corousalList1.add("Google Wallet/Apple Pay Card");
        corousalList1.add("cantaloupe more logo");



        for (WebElement li : corousalList) {
            int i = 0;
            for (String imageList : corousalList1) {


                int j = 0;
                for (WebElement images : listOfAllImages) {
                    images.isDisplayed();


                    li.click();
                    int length = listOfAllImages.size();


                    Boolean image1Present = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image1);
                    Boolean image2Present = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image2);
                    Boolean image3Present = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image3);
                    Boolean image4Present = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image4);
                    Boolean logoPresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", logo);

                   // Assert.assertEquals(images.getAttribute("alt"), imageList);
                    System.out.println(images.getAttribute("alt"));

                    j++;
                    i++;
                    if (!image1Present && !image2Present && !image3Present && !image4Present && !logoPresent) {
                        System.out.println("Image not displayed.");
                    } else {
                        System.out.println("Image displayed.");
                    }
                }
            }
        }
    }
}

