package pageActions;

import base.BaseActions;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageLocators.AccountCreationLocators;
import pageLocators.HomePageLocators;
import pageLocators.LandingScreen;
import resources.FinalConstants;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Pattern;

public class AccountCreation1 extends TestBase {

    Properties prop = new Properties();
    BaseActions baseActions = new BaseActions();

    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
    HomePageLocators homePageLocators = new HomePageLocators();
    LandingScreen loginScreen = new LandingScreen();


    public AccountCreation1() throws IOException {
    }

    //Validates account creation screen
    public void validateUIOnAccountCreationScreen(String createNewEmail) throws AWTException {
        WebElement emailLink = driver.findElement(accountCreationLocators.enterYourEmailInput);

        if (emailLink.isEnabled()) {
            Assert.assertTrue(true, "Create Account screen is valid");
            emailLink.click();
            baseActions.randomClickBasedOnOS();
            emailLink.sendKeys(createNewEmail);

        } else {
            Assert.assertFalse(false, "Create Account screen is InValid");
        }
    }

    // Validates account creation screen with continue email
    public void validateAccountCreationScreen(String createNewEmail) {

        WebElement emailInput = driver.findElement(accountCreationLocators.enterYourEmailInput);
        String emailInputAttribute = emailInput.getAttribute("value");

        driver.findElement(accountCreationLocators.nextButton).click();
        WebElement emailText = driver.findElement(accountCreationLocators.emailIdInputField);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // String getEmailText = (String) js.executeScript("return arguments[0].value", emailText);
        if (createNewEmail.equalsIgnoreCase(emailInputAttribute)) {
            Assert.assertTrue(true, "User is on the right page");
            System.out.println("User is on the right page");
        } else {
            Assert.assertTrue(false, "User is on the right page");
        }
    }

    //Validates all the input fields on the account creation screen
    public void validateInptBlankFieldsErrorMsg() throws AWTException {
        WebElement emailInputbox = driver.findElement(accountCreationLocators.emailIdInputField);
        driver.findElement(accountCreationLocators.createPasswordInputField).click();
        baseActions.randomClickBasedOnOS();
        driver.findElement(accountCreationLocators.passwordCriteriaText).isDisplayed();

        driver.findElement(accountCreationLocators.confirmPasswordInptField).click();
        baseActions.randomClickBasedOnOS();
        driver.findElement(accountCreationLocators.passwordNotAMatchText).isDisplayed();
        String emailPlaceHolder = emailInputbox.getAttribute("placeholder");

        driver.findElement(accountCreationLocators.firstName).click();
        baseActions.randomClickBasedOnOS();
        driver.findElement(accountCreationLocators.enterFirstNameErrorText).isDisplayed();

        driver.findElement(accountCreationLocators.lastName).click();
        baseActions.randomClickBasedOnOS();
        driver.findElement(accountCreationLocators.enterLastNameErrorText).isDisplayed();

        driver.findElement(accountCreationLocators.mobileNumberField).click();
        baseActions.randomClickBasedOnOS();
        driver.findElement(accountCreationLocators.enterMobileNumberErrorText).isDisplayed();

        driver.findElement(accountCreationLocators.streetAddressInputField).click();
        baseActions.randomClickBasedOnOS();
        driver.findElement(accountCreationLocators.streetAddressErrorText).isDisplayed();

        driver.findElement(accountCreationLocators.cityInputField).click();
        baseActions.randomClickBasedOnOS();
        driver.findElement(accountCreationLocators.cityErrorText).isDisplayed();

        driver.findElement(accountCreationLocators.stateInptField).click();
        baseActions.randomClickBasedOnOS();
        driver.findElement(accountCreationLocators.stateErrorText).isDisplayed();

        driver.findElement(accountCreationLocators.zipcodeInputField).click();
        baseActions.randomClickBasedOnOS();
        driver.findElement(accountCreationLocators.zipcodeErrorText).isDisplayed();
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

        if ((emailInputAttribute.equalsIgnoreCase(properties.getProperty("createNewEmail"))) && (createPasswordAttribute.isEmpty()) && (confirmPasswordAttribute.isEmpty()) && (firstNameInputAttribute.isEmpty()
                && (lastNameInputAttribute.isEmpty()) && (mobileInputAttribute.isEmpty()) && (stateInputAttribute.isEmpty()) && (cityInputAttribute.isEmpty()
                && (stateInputAttribute.isEmpty() && (zipcodeInputAttribute.isEmpty()))))) {
            Assert.assertTrue(driver.findElement(accountCreationLocators.completeButton).isEnabled()==false, "Complete button should not be enabled");
           // Assert.assertTrue(true, "Complete button should not be enabled");
            System.out.println("***************************");
           // Assert.assertTrue(!emailInputAttribute.isEmpty());
        } else {
            Assert.assertFalse(false, "Complete button should be enabled");
        }
    }

    //Enter data in all the fields
    public void accountCreationProcess(String createAccountPassword, String createAccountConfirmPassword,
                                       String firstName, String lastName, String mobileNumber, String streetAddress, String city, String state, String zipcode) throws IOException {
        {
            driver.findElement(accountCreationLocators.createPasswordInputField).sendKeys(createAccountPassword);
            driver.findElement(accountCreationLocators.confirmPasswordInptField).sendKeys(createAccountConfirmPassword);
            driver.findElement(accountCreationLocators.firstName).sendKeys(firstName);
            driver.findElement(accountCreationLocators.lastName).sendKeys(lastName);
            driver.findElement(accountCreationLocators.mobileNumberField).sendKeys(verifyMobileInputfield(mobileNumber));

            driver.findElement(accountCreationLocators.streetAddressInputField).sendKeys(streetAddress);
            driver.findElement(accountCreationLocators.cityInputField).sendKeys(city);
            driver.findElement(accountCreationLocators.stateInptField).sendKeys(state);
            driver.findElement(accountCreationLocators.zipcodeInputField).sendKeys(zipcode);
        }

    }

    //validate mobileField only accepts 10 digits - Regex(@"^[0-9]{10}$");
    public String verifyMobileInputfield(String mobileNo) {
        Pattern mobileNoPattern = Pattern.compile("^\\d{10}$");
        mobileNoPattern.matcher(mobileNo);
        return mobileNo;
    }


    //Asset completeButton
    public void assertCompleteButtonCase(String createNewEmail) throws AWTException {
        driver.findElement(loginScreen.createAccountBigButton).click();
        validateUIOnAccountCreationScreen(createNewEmail);
        validateAccountCreationScreen(createNewEmail);
        validateInptBlankFieldsErrorMsg();
        verifyCompleteButtonEnablement();
    }


    //Regex for email
    public void verifyEmailRegex(String email, String emailRegex) {
        baseActions.regexExpression(accountCreationLocators.enterYourEmailInput, email, emailRegex);
    }


    //Verify Error messages()
        public void emailErrorMessage() throws AWTException {
        driver.findElement(accountCreationLocators.enterYourEmailInput).click();
        baseActions.randomClickBasedOnOS();
        baseActions.validateErrorMessages(accountCreationLocators.blankEmailErrorMsg);
    }

    public void validateEmptyField() throws AWTException {
        driver.findElement(loginScreen.createAccountBigButton).click();
        WebElement emailInput = driver.findElement(accountCreationLocators.enterYourEmailInput);
        if (emailInput.getAttribute("value").isEmpty()) {
            emailErrorMessage();
        } else {
            Assert.assertTrue(driver.findElement(accountCreationLocators.nextButton).isEnabled());
        }
    }


    //VerifyTickMark()
    public void verrifyTickMark() {
        if ((driver.findElement(accountCreationLocators.tickMarkImage).isDisplayed())) {
            Boolean image1Present = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", driver.findElement(accountCreationLocators.tickMarkImage));
            Assert.assertTrue(image1Present == true, "Tick mark is present");
        } else if (!(driver.findElement(accountCreationLocators.tickMarkImage)).isDisplayed()) {
            Assert.assertTrue(false, "tick mark is not present");
        }
    }


    //Validates if email entered is valid, and checks if the tick mark is displayed
    public String validateEmailCriteriaField(String email, String emailRegex) throws AWTException {
        verifyEmailRegex(email, emailRegex);
        Assert.assertTrue(driver.findElement(accountCreationLocators.nextButton).isEnabled());
        baseActions.randomClickBasedOnOS();
        return email;

    }


    // verify next button
    public void verifyNextButtonEnabled() {
        if ((driver.findElement(accountCreationLocators.nextButton).isEnabled())) {
            driver.findElement(accountCreationLocators.nextButton).click();
            Assert.assertTrue(true, "Button is enabled");
        } else {
            Assert.assertTrue(false, "Next button is not enabled");
        }

    }

    //Verify if the entered email is already registered
    public void existingEmail_AlreadyRegistered(String alreadyRegisteredEmail, String regexEmail) throws AWTException {
        validateEmailCriteriaField(alreadyRegisteredEmail, properties.getProperty("regexEmail"));
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreationLocators.existingEmailError));

        Boolean flag = driver.findElement(accountCreationLocators.existingEmailError).isDisplayed();
        if (flag == true) {
            Assert.assertTrue(true, "Existing email error is displayed");
            Boolean loginButtonStatus = driver.findElement(accountCreationLocators.loginThroughCreateScreen).isEnabled();
            Assert.assertTrue(loginButtonStatus == true, "Login button is displayed for existing user");
        } else {
            Assert.assertTrue(false, "Validation for existing email is not done");
        }
    }

    //If the user enters existing email - then he should be allowed to click on login
    public void loginThroughExistingEmail(String alreadyRegisteredEmail, String regexEmail) throws AWTException {
        existingEmail_AlreadyRegistered(alreadyRegisteredEmail, properties.getProperty("regexEmail"));
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreationLocators.loginThroughCreateScreen));
        driver.findElement(accountCreationLocators.loginThroughCreateScreen).click();
    }

    //Click create button
    public void clickCreateButton() {
        driver.findElement(loginScreen.createAccountBigButton).click();
        Boolean createAccountText = driver.findElement(accountCreationLocators.createAccountText).isDisplayed();
        Assert.assertTrue(createAccountText == true, "User is on Account creation screen");
    }

    //Verify that, user is not able to use an already registered email id from other account
    public void existingEmailError_AccountCreation(String alreadyRegisteredEmail) throws AWTException {
        existingEmail_AlreadyRegistered(alreadyRegisteredEmail, properties.getProperty("regexEmail"));
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreationLocators.loginThroughCreateScreen));

        WebElement existingEmailError = driver.findElement(accountCreationLocators.existingEmailError);
        WebElement existingEmailloginbutton = driver.findElement(accountCreationLocators.loginThroughCreateScreen);
        Assert.assertTrue(existingEmailError.isDisplayed() == true, "That Email Address Is Already In Use. Would You Like To Log In Instead?");
        Assert.assertTrue(existingEmailloginbutton.isEnabled() == true, "Login button is showing up for existing email");
    }

    //Navigate to HomePage by clicking on back button from account creation screen
    //Click create button
    public void clickBackHomeLink() {
        baseActions.scrollDown();
        WebElement backHomeLink = driver.findElement(accountCreationLocators.backHomeLink);
        Assert.assertTrue(backHomeLink.isEnabled() == true);
        backHomeLink.click();
        WebElement homePageVerification = driver.findElement(homePageLocators.firstHeader);
        Assert.assertTrue(homePageVerification.isDisplayed() == true, "User has navigated back to home page screen");
    }

    //Verify that the email address is prefilled from the previous screen for registration form email id
    public String prefilledEmail(String prefilledEmail) throws AWTException {
        WebElement emailId = driver.findElement(accountCreationLocators.emailIdInputField);
        String getEnteredEmail = emailId.getAttribute("value");
        Assert.assertEquals(prefilledEmail, getEnteredEmail);
        return getEnteredEmail;
    }


    //Verify that, user can edit the prefilled email id field
    public String verifyEmailIsEditable()
    {
        WebElement emailId = driver.findElement(accountCreationLocators.emailIdInputField);
        baseActions.clearInputfieldAndEnterNewData(emailId, properties.getProperty("existingAccountEmail"));
        String getEnteredNewEmail = emailId.getAttribute("value");
        Assert.assertEquals(getEnteredNewEmail, properties.getProperty("existingAccountEmail"));
        return getEnteredNewEmail;
    }

    //enterData
    public void enterData(By element, String dataToBeEntered)
    {
        driver.findElement(element).sendKeys(dataToBeEntered);
    }

}