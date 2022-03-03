package pageActions;

import base.BaseActions;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageLocators.AccountCreationLocators;
import pageLocators.CreateAccountLocators;
import pageLocators.LandingScreen;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.regex.Pattern;

public class AccountCreation1 extends TestBase {

    Properties prop = new Properties();
    BaseActions baseActions = new BaseActions();

       AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
       LandingScreen loginScreen = new LandingScreen();
       CreateAccountLocators createAccountLocators = new CreateAccountLocators();



    public AccountCreation1() throws IOException {
    }

   // @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)
    public void testIOS(String createAccount)
            throws MalformedURLException {

        try {

            WebElement createAccountButton = driver.findElement(loginScreen.createAccountBigButton);

            if (createAccountButton.isDisplayed()) {
                Assert.assertTrue(true, "User has landed to the right page");
                System.out.println("Valid");
                driver.findElement(loginScreen.createAccountBigButton).click();
                validateCreateAccountScreen(createAccount);
                validateAccountCreationScreen(createAccount);
                validateInptBlankFieldsErrorMsg();
                verifyCompleteButtonEnablement();
            } else {
                System.out.println("Invalid");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Validates account creation screen
    public void validateCreateAccountScreen(String createNewEmail) {
        WebElement emailLink = driver.findElement(createAccountLocators.enterYourEmailInput);

        if (emailLink.isEnabled()) {
            Assert.assertTrue(true, "Create Account screen is valid");
            emailLink.click();
            driver.findElement(By.xpath("//html")).click();
            emailLink.sendKeys(createNewEmail);

        } else {
            Assert.assertFalse(false, "Create Account screen is InValid");
        }
    }

    // Validates account creation screen with continue email
    public void validateAccountCreationScreen(String createNewEmail) {

        WebElement emailInput = driver.findElement(createAccountLocators.enterYourEmailInput);
        String emailInputAttribute = emailInput.getAttribute("value");

        driver.findElement(createAccountLocators.nextButton).click();
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
    public void assertCompleteButtonCase(String createNewEmail) {
        driver.findElement(loginScreen.createAccountBigButton).click();
        validateCreateAccountScreen(createNewEmail);
        validateAccountCreationScreen(createNewEmail);
        validateInptBlankFieldsErrorMsg();
        verifyCompleteButtonEnablement();
    }


   //Regex for email
    public void verifyEmailRegex(String email)
    {
        baseActions.validateEmailInputs(createAccountLocators.enterYourEmailInput, email);
    }


    //Verify Error messages()
    public void emailErrorMessage()
    {
       // driver.findElement(loginScreen.createAccountBigButton).click();
        driver.findElement(createAccountLocators.enterYourEmailInput).click();
        driver.findElement(By.xpath("//html")).click();
        baseActions.validateErrorMessages(createAccountLocators.emailErrorMessage);
    }

    public void validateEmptyField()
    {
       driver.findElement(loginScreen.createAccountBigButton).click();
        WebElement emailInput = driver.findElement(createAccountLocators.enterYourEmailInput);
        if(emailInput.getAttribute("value").isEmpty())
        {
            emailErrorMessage();
        }
        else
        {
            Assert.assertTrue(driver.findElement(createAccountLocators.nextButton).isEnabled());
        }
    }



    //VerifyTickMark()
    public void verrifyTickMark()
    {
        if((driver.findElement(CreateAccountLocators.tickMarkImage).isDisplayed()))
        {
            Boolean image1Present = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", driver.findElement(CreateAccountLocators.tickMarkImage));
            Assert.assertTrue(image1Present == true, "Tick mark is present" );
        }
        else if(!(driver.findElement(CreateAccountLocators.tickMarkImage)).isDisplayed())
        {
            Assert.assertTrue(false, "tick mark is not present");
        }
    }


    //Validates if email entered is valid, and checks if the tick mark is displayed
    public String validateEmailCriteriaField(String email)
    {
        //driver.findElement(loginScreen.createAccountBigButton).click();
        verifyEmailRegex(email);
        Assert.assertTrue(driver.findElement(createAccountLocators.nextButton).isEnabled());
        driver.findElement(By.xpath("//html")).click();
       // verrifyTickMark();
        return email;

    }



    // verify next button
    public void verifyNextButtonEnabled()
    {
       // validateEmailCriteriaField(email);
        if((driver.findElement(createAccountLocators.nextButton).isEnabled()))
        {
            driver.findElement(createAccountLocators.nextButton).click();
            Assert.assertTrue(true, "Button is enabled");
        }
        else
        {
            Assert.assertTrue(false, "Next button is not enabled");
        }

    }

    //Verify if the entered email is already registered
    public void existingEmail_AlreadyRegistered(String alreadyRegisteredEmail)
    {
        //driver.findElement(loginScreen.createAccountBigButton).click();
        validateEmailCriteriaField(alreadyRegisteredEmail);

       // WebElement element = driver.findElement(createAccountLocators.existingEmailError);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountLocators.existingEmailError));

        Boolean flag = driver.findElement(createAccountLocators.existingEmailError).isDisplayed();
        if(flag == true)
        {
            Assert.assertTrue(true, "Existing email error is displayed");
            Boolean loginButtonStatus = driver.findElement(createAccountLocators.loginThroughCreateScreen).isEnabled();
            Assert.assertTrue(loginButtonStatus == true, "Login button is displayed for existing user");


        }
        else
        {
            Assert.assertTrue(false, "Validation for existing email is not done");
        }

//        Boolean emailNewOrExistingCondition = element.isDisplayed();

        //return flag;
    }

    //If the user enters existing email - then he should be allowed to click on login
    public void loginThroughExistingEmail(String alreadyRegisteredEmail)
    {
            existingEmail_AlreadyRegistered(alreadyRegisteredEmail);
            driver.findElement(createAccountLocators.loginThroughCreateScreen).click();
    }

       //Click create button
        public void clickCreateButton()
        {
            driver.findElement(loginScreen.createAccountBigButton).click();
        }

}