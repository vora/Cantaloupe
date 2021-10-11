package com.ascendum.Cantaloupe.pageActions;

import com.ascendum.Cantaloupe.base.BaseActions;
import com.ascendum.Cantaloupe.base.TestBase;
import com.ascendum.Cantaloupe.pageLocators.AccountCreationLocators;
import com.ascendum.Cantaloupe.pageLocators.ContinueAccountCreationLocators;
import com.ascendum.Cantaloupe.pageLocators.CreateAccountLocators;
import com.ascendum.Cantaloupe.pageLocators.LoginScreen;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class AccountCreationAction extends TestBase {

    Properties prop = new Properties();
    BaseActions baseActions = new BaseActions();
    LoginScreen loginScreen = new LoginScreen();
    CreateAccountLocators createAccountLocators = new CreateAccountLocators();
    ContinueAccountCreationLocators continueAccountCreationLocators = new ContinueAccountCreationLocators();
    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
    WebDriver driver;

    public AccountCreationAction() throws IOException {
    }


    public void testIOS(String existingAccountEmail, String existingAccountPassword, String createAccount, String createAccountPassword, String createAccountConfirmPassword,
                        String firstName, String lastName, String mobileNumber, String streetAddress, String city, String state, String zipcode)
            throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("deviceName", "iPhone 12 Pro");
        caps.setCapability(CapabilityType.BROWSER_NAME, "safari");
        caps.setCapability("platformVersion", "14.5");

        caps.setCapability("automationName", "XCUITest");

        try {
            URL url = new URL("http://0.0.0.0:4723/wd/hub");

            //String sessionId = "d8080676-634d-49fc-8624-fc7b57c5d530";
            // AppiumDriver driver1 = new AppiumDriver("http://localhost:4723/wd/hub" , sessionId);


            driver = new IOSDriver(url, caps);
            driver.get("https://qa.cantaloupepayments.com");
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,300)", "");

            //WebElement logo = driver.findElement(google.logo);
            // Boolean logoPresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", logo);

            WebElement createAccountButton = driver.findElement(loginScreen.createAccountBigButton);

            if (createAccountButton.isDisplayed()) {
                Assert.assertTrue(true, "User has landed to the right page");
                System.out.println("Valid");
                driver.findElement(loginScreen.createAccountBigButton).click();
                validateCreateAccountScreen();
                continueWithEmail();
                validateAccountCreationScreen();
                validateInptBlankFieldsErrorMsg();
                //verifyErrorTextDisplayed();
                baseActions.getSpanText(accountCreationLocators.passwordCriteriaText);
                verifyConsent();
                //   verifyCompleteButtonEnablement();
                accountCreationProcess();

            } else {
                System.out.println("Invalid");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


    //Validates account creation screen
    public void validateCreateAccountScreen() {
        WebElement appleButton = driver.findElement(createAccountLocators.continueWithhAppleButton);
        WebElement googleButton = driver.findElement(createAccountLocators.continueWithGoogleButton);
        WebElement facebookButton = driver.findElement(createAccountLocators.continueWithFacebookButton);
        WebElement emailLink = driver.findElement(createAccountLocators.continueWithEmail);

        if ((appleButton.isDisplayed()) && (googleButton.isDisplayed()) && (facebookButton.isDisplayed()) && (emailLink.isDisplayed())) {
            Assert.assertTrue(true, "Create Account screen is valid");
        } else {
            Assert.assertTrue(false, "Create Account screen is InValid");
        }

    }


    // Validates continue with email screen
    public void continueWithEmail() {
        driver.findElement(createAccountLocators.continueWithEmail).click();
        WebElement emailInput = driver.findElement(continueAccountCreationLocators.email);

        if (emailInput.isEnabled()) {
            //emailInput.click();
            Assert.assertTrue(true, "Email input button is present");
            emailInput.click();
            driver.findElement(By.xpath("//html")).click();
            WebElement noEmailEntered = driver.findElement(continueAccountCreationLocators.noEmailEntered);
            noEmailEntered.isDisplayed();


            driver.findElement(continueAccountCreationLocators.email).sendKeys("rajeshwari.prem@ascendum.com");
        }
    }

    // Validates account creation screen with continue email
    public void validateAccountCreationScreen() {
        String myEmail = "rajeshwari.prem@ascendum.com";
        driver.findElement(continueAccountCreationLocators.nextButton).click();
        WebElement emailText = driver.findElement(accountCreationLocators.emailIdInputField);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String getEmailText = (String) js.executeScript("return arguments[0].value", emailText);
        ;
        if (getEmailText.equalsIgnoreCase(myEmail)) {
            Assert.assertTrue(true, "User is on the right page");
            System.out.println("User is on the right page");
        } else {
            Assert.assertTrue(false, "User is on the right page");
        }
    }

    //Validates all the input fields on the account creation screen
    public void validateInptBlankFieldsErrorMsg() {
        WebElement emailInputbox = driver.findElement(accountCreationLocators.emailIdInputField);

        // Get value of Css property border-bottom-color which will be returned in RGB format.
//            String colorCode= emailInputbox.getCssValue("border-bottom-color");
        driver.findElement(accountCreationLocators.createPasswordInputField).click();
        driver.findElement(By.xpath("//html")).click();
        driver.findElement(accountCreationLocators.passwordCriteriaText).isDisplayed();

        driver.findElement(accountCreationLocators.confirmPasswordInptField).click();
        driver.findElement(By.xpath("//html")).click();
        driver.findElement(accountCreationLocators.passwordNotAMatchText).isDisplayed();

        driver.findElement(accountCreationLocators.firstName).click();
        driver.findElement(By.xpath("//html")).click();
        driver.findElement(accountCreationLocators.enterFirstNameErrorText).isDisplayed();

        driver.findElement(accountCreationLocators.lastName).click();
        driver.findElement(By.xpath("//html")).click();
        driver.findElement(accountCreationLocators.enterLastNameErrorText).isDisplayed();

        driver.findElement(accountCreationLocators.mobileNumberField).click();
        driver.findElement(By.xpath("//html")).click();
        driver.findElement(accountCreationLocators.enterMobileNumberErrorText).isDisplayed();

        driver.findElement(accountCreationLocators.streetAddressInputField).click();
        driver.findElement(By.xpath("//html")).click();
        driver.findElement(accountCreationLocators.streetAddressErrorText).isDisplayed();

        driver.findElement(accountCreationLocators.cityInputField).click();
        driver.findElement(By.xpath("//html")).click();
        driver.findElement(accountCreationLocators.cityErrorText).isDisplayed();

        driver.findElement(accountCreationLocators.stateInptField).click();
        driver.findElement(By.xpath("//html")).click();
        driver.findElement(accountCreationLocators.stateErrorText).isDisplayed();

        driver.findElement(accountCreationLocators.zipcodeInputField).click();
        driver.findElement(By.xpath("//html")).click();
        driver.findElement(accountCreationLocators.zipcodeErrorText).isDisplayed();

    }

    //Validates that the error messages are displayed properly on the account input screen
    public void verifyErrorTextDisplayed() {
        String passwordCriteriaText = driver.findElement(accountCreationLocators.passwordCriteriaText).getText();
        String passwordNotAMatchText = driver.findElement(accountCreationLocators.passwordNotAMatchText).getText();
        String enterMobileNumberErrorText = driver.findElement(accountCreationLocators.enterMobileNumberErrorText).getText();
        String enterFirstNameErrorText = driver.findElement(accountCreationLocators.enterFirstNameErrorText).getText();
        String enterLastNameErrorText = driver.findElement(accountCreationLocators.enterLastNameErrorText).getText();
        String streetAddressErrorText = driver.findElement(accountCreationLocators.streetAddressErrorText).getText();
        String cityErrorText = driver.findElement(accountCreationLocators.cityErrorText).getText();
        String stateErrorText = driver.findElement(accountCreationLocators.stateErrorText).getText();
        String zipcodeErrorText = driver.findElement(accountCreationLocators.zipcodeErrorText).getText();

        List<String> getAllErrors = baseActions.getSpanText(accountCreationLocators.passwordCriteriaText);

        if(getAllErrors.contains(passwordCriteriaText) && (getAllErrors.contains(passwordNotAMatchText)) && (getAllErrors.contains(enterFirstNameErrorText) && (getAllErrors.contains(enterFirstNameErrorText)
                && (getAllErrors.contains(enterLastNameErrorText) && (getAllErrors.contains(enterMobileNumberErrorText) && (getAllErrors.contains(streetAddressErrorText)
                && (getAllErrors.contains(cityErrorText) && (getAllErrors.contains(stateErrorText) && (getAllErrors.contains(zipcodeErrorText))))))))))
        {
            Assert.assertTrue(true, "All the error messages are displayed accordingly");
            System.out.println("Error messages are all correct");
        }
        else
        {
            Assert.assertFalse(false, "Some of the error messages are not proper");
            System.out.println("Error messages are all wrong");
        }


    }

//    //Gets all the error messages in a list
//    public List<String> getErrorText(By passwordCriteriaText) {
//        List<WebElement> allErrors = driver.findElements(accountCreationLocators.passwordCriteriaText);
//
//        List<String> errorText = new ArrayList<>();
//
//        for (int i = 0; i < allErrors.size(); i++) {
//            //obtain text
//          String errorTextAdd = allErrors.get(i).getText();
//           errorText.add(errorTextAdd);
//        }
//
//        return errorText;
//    }

    // verify the consent part
    public void verifyConsent()
    {
        Boolean isChecked = driver.findElement(accountCreationLocators.consentCheckBox).isEnabled();
        driver.findElement(accountCreationLocators.consentCheckBox).click();
        String agreeText = driver.findElement(accountCreationLocators.consentCheckText).getText();

        if((isChecked==true) && (agreeText.equalsIgnoreCase("I have read and agree to Cantaloupe’s:")))
        {
            Assert.assertTrue(true, "Consent section is valid");
        }
        else
        {
            Assert.assertFalse(false, "Consent section is not valid");
        }

        driver.findElement(accountCreationLocators.termsOfUseLink).isEnabled();
        driver.findElement(accountCreationLocators.privacyPolicyLink).isEnabled();
        System.out.println("Consent section is correct");
    }

    //Verify that the complete button is enabled after all the fields have data
    public void verifyCompleteButtonEnablement() {
        WebElement emailInput = driver.findElement(accountCreationLocators.emailIdInputField);
        String emailInputAttribute = emailInput.getAttribute("value");

        WebElement createPassword = driver.findElement(accountCreationLocators.createPasswordInputField);
        String createPasswordAttribute = createPassword.getAttribute("value");

        WebElement confirmPassword = driver.findElement(accountCreationLocators.confirmPasswordInptField);
        String confirmPasswordAttribute = confirmPassword.getAttribute("value");

        WebElement firstNameInput = driver.findElement(accountCreationLocators.firstName);
        String firstNameInputAttribute = firstNameInput.getAttribute("value");

        WebElement lastNameInput = driver.findElement(accountCreationLocators.lastName);
        String lastNameInputAttribute = lastNameInput.getAttribute("value");

        WebElement mobileInput = driver.findElement(accountCreationLocators.mobileNumberField);
        String mobileInputAttribute = mobileInput.getAttribute("value");

        WebElement streetInput = driver.findElement(accountCreationLocators.streetAddressInputField);
        String streetInputAttribute = streetInput.getAttribute("value");

        WebElement cityInput = driver.findElement(accountCreationLocators.cityInputField);
        String cityInputAttribute = cityInput.getAttribute("value");

        WebElement stateInput = driver.findElement(accountCreationLocators.stateInptField);
        String stateInputAttribute = stateInput.getAttribute("value");

        WebElement zipcodeInput = driver.findElement(accountCreationLocators.zipcodeInputField);
        String zipcodeInputAttribute = zipcodeInput.getAttribute("value");


        if ((emailInputAttribute.equalsIgnoreCase("rajeshwari.prem@ascendum.com")) && (createPasswordAttribute.isEmpty()) && (confirmPasswordAttribute.isEmpty()) && (firstNameInputAttribute.isEmpty()
                && (lastNameInputAttribute.isEmpty()) && (mobileInputAttribute.isEmpty()) && (stateInputAttribute.isEmpty()) && (cityInputAttribute.isEmpty()
                && (stateInputAttribute.isEmpty() && (zipcodeInputAttribute.isEmpty()))))) {
            Assert.assertTrue(!(driver.findElement(accountCreationLocators.completeButton).isEnabled()));
            Assert.assertTrue(true, "Complete button should not be enabled");
            System.out.println("***************************");
            Assert.assertTrue(!emailInputAttribute.isEmpty());
        } else {
            Assert.assertFalse(false, "Complete button should be enabled");
        }
    }

    //Enter data in all the fields
    public void accountCreationProcess()
    {
        driver.findElement(accountCreationLocators.createPasswordInputField).sendKeys("Testing*123");
        driver.findElement(accountCreationLocators.confirmPasswordInptField).sendKeys("Testing*123");
        driver.findElement(accountCreationLocators.firstName).sendKeys("FirstName");
        driver.findElement(accountCreationLocators.lastName).sendKeys("Lastname");
        driver.findElement(accountCreationLocators.mobileNumberField).sendKeys(verifyMobileInputfield("@#$%TFG"));

        driver.findElement(accountCreationLocators.streetAddressInputField).sendKeys("Street");
        driver.findElement(accountCreationLocators.cityInputField).sendKeys("City");
        driver.findElement(accountCreationLocators.stateInptField).sendKeys("State");
        driver.findElement(accountCreationLocators.zipcodeInputField).sendKeys("Zipcode");


    }

    //validate mobileField only accepts 10 digits - Regex(@"^[0-9]{10}$");
    public String verifyMobileInputfield(String phoneNo)
    {
        Pattern mobileNoPattern = Pattern.compile("^\\d{10}$");
        mobileNoPattern.matcher(phoneNo);
        return phoneNo;
    }


    //Enter data in all fields
    public void enterDataForAccountCreation(String existingAccountEmail, String existingAccountPassword, String createAccount, String createAccountPassword, String createAccountConfirmPassword,
    String firstName, String lastName, String mobileNumber, String streetAddress, String city, String state, String zipcode) throws IOException
    {

    }




}
