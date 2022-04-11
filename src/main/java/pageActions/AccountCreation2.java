package pageActions;

import base.BaseActions;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageLocators.AccountCreationLocators;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


public class AccountCreation2 extends TestBase {

    BaseActions baseActions = new BaseActions();
    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
    AccountCreation1 accountCreation1 = new AccountCreation1();


    public AccountCreation2() throws IOException {
    }


    // validate if entered email displays on create account screen
    public String enteredEmaiCheck(String emailValue) {
        Boolean emailStatus = driver.findElement(accountCreationLocators.emailIdInputField).isDisplayed();
        if (emailStatus == true) {
            String enteredEmailValue = driver.findElement(accountCreationLocators.emailIdInputField).getAttribute("value");
            Assert.assertEquals(emailValue, enteredEmailValue);
            accountCreation1.verrifyTickMark();
        } else {
            Assert.assertTrue(false, "the entered email and new email are not a match");
        }
        accountCreation1.verifyNextButtonEnabled();
        String emaiOnScreen2 = driver.findElement(accountCreationLocators.emailIdInputField).getAttribute("value");
        if(emaiOnScreen2.equalsIgnoreCase(emailValue))
        {
            Assert.assertTrue(true, "Email check on screen 2 is valid");
            accountCreation1.verrifyTickMark();
        }
        else
        {
            Assert.assertTrue(false, "Both the emails are not a match");
        }
        return emailValue;
    }

    //Verify that the user is able to edit the email input field on screen 2
    public void verifyEmailIsEditable(String editEmail)
    {
        try {
            WebElement emailField = driver.findElement(accountCreationLocators.emailIdInputField);
            if (emailField.isDisplayed()) {
                baseActions.randomClickBasedOnOS();
                baseActions.clearInputfieldAndEnterNewData(emailField, editEmail);
            }
        }
        catch(Exception e)
            {
                e.printStackTrace();
            }
    }



    //Enter data in password fields;
    public void enterPassword(String password)
    {
       //baseActions.regexPassword(accountCreationLocators.createPassowrd, password);
        baseActions.regexExpression(accountCreationLocators.createPassowrd, password, properties.getProperty("regexPassword"));
       //Include spl character ` - should not be allowed
    }

    //MaskedPassword for create Password
    public void checkPasswordMasked()
    {
        baseActions.checkPasswordMaskedOrNot(accountCreationLocators.createPassowrd);
    }

    //MaskedPassword for Confirm Password
    public void confirmPasswordMasked()
    {
        baseActions.checkPasswordMaskedOrNot(accountCreationLocators.confirmPassword);
    }

    //check if error message is shown when the password criteria is not met
    public void validateErrorMessageForPassword(String wrongPassword) throws AWTException {
       driver.findElement(accountCreationLocators.createPassowrd).sendKeys(wrongPassword);
        baseActions.randomClickBasedOnOS();
        WebElement passwordError = driver.findElement(accountCreationLocators.passwordErrorCriteria);

        Boolean status = passwordError.isDisplayed();
        if(status == true)
        {
            baseActions.randomClickBasedOnOS();
            Assert.assertTrue(true, "Password criteria is validated");
        }
        else
        {
            Assert.assertTrue(false, "Password criteria is validated");
        }
    }

    //Try wrong password
    public void tryWrongPassword(String wrongPassword)
    {
        baseActions.enterValue(accountCreationLocators.createPassowrd,wrongPassword);
    }

    //Try wrong confirm password
    public void tryConfirmPassword(String wrongPassword)
    {
        baseActions.enterValue(accountCreationLocators.createPassowrd,wrongPassword);
    }

    //check if error message is shown when the password criteria is not met
    public void validateErrorMessageForConfirmPassword(String wrongPassword) throws AWTException {
        driver.findElement(accountCreationLocators.confirmPassword).sendKeys(wrongPassword);
        WebElement passwordError = driver.findElement(accountCreationLocators.passwordDoNotMatchError);

        if(passwordError.isDisplayed())
        {
            baseActions.randomClickBasedOnOS();
            Boolean passwordPresent = passwordError.isDisplayed();
            Assert.assertTrue(passwordPresent == true, "Password criteria is validated");
        }
        else
        {
            Assert.assertTrue((driver.findElement(accountCreationLocators.passwordDoNotMatchError).isDisplayed()), "Password criteria is validated");
        }

    }

    public void clickShowPassword()
    {
        baseActions.clickButton(accountCreationLocators.showPassword);
    }

    public void clickHidePassword()
    {
        baseActions.clickButton(accountCreationLocators.hidePassword);
    }

    //Verify that password and confirm password are a match
    public void verifyPasswordAndConfirmPassword(String password, String confirm)
    {
        baseActions.enterValue(accountCreationLocators.createPassowrd, password);
        baseActions.enterValue(accountCreationLocators.confirmPassword, confirm);
        String createpPassword = driver.findElement(accountCreationLocators.createPassowrd).getText();
        String confirmPassword = driver.findElement(accountCreationLocators.createPassowrd).getText();
        Assert.assertEquals(createpPassword, confirmPassword);
    }


    //Verify Personal details
    public void verifyFirstNameInput(String firstname) throws AWTException {
        baseActions.clickButton(accountCreationLocators.firstnameInput);
        baseActions.randomClickBasedOnOS();
        baseActions.validateErrorMessages(accountCreationLocators.firstNameError);
        baseActions.enterValue(accountCreationLocators.firstnameInput, firstname);
    }

    public void verifyFirstNameRegex()
    {
        baseActions.regexExpression(accountCreationLocators.firstnameInput, properties.getProperty("firstName"), properties.getProperty("regexFirstAndLastName"));
    }

    public void verifyLastNameRegex()
    {
        baseActions.regexExpression(accountCreationLocators.firstnameInput, properties.getProperty("lastName"), properties.getProperty("regexFirstAndLastName"));
    }


    public void verifyLastNameInput(String lastname) throws AWTException {
        baseActions.clickButton(accountCreationLocators.lastNameInput);
        baseActions.randomClickBasedOnOS();
        baseActions.validateErrorMessages(accountCreationLocators.lastNameError);
        baseActions.enterValue(accountCreationLocators.lastNameInput, lastname);

    }

    //verify errors
    public void verifyPhoneNoInput() throws AWTException {
        driver.findElement(accountCreationLocators.phoneNoInput).sendKeys(properties.getProperty("mobileNumber"));
        baseActions.randomClickBasedOnOS();
        baseActions.validateErrorMessages(accountCreationLocators.invalidMobileError);
        regexPhoneNo();
    }

    //regexPhoneNumber
    public void regexPhoneNo()
    {
        baseActions.regexExpression(accountCreationLocators.phoneNoInput, properties.getProperty("mobileNumber"), properties.getProperty("regexMobile"));
    }

    //Verify Phone Number Format
    public void verifyPhoneNoFormat()
    {
        String mobileFormat = driver.findElement(accountCreationLocators.mobileNumberField).getAttribute("value");
        String number = mobileFormat.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");

        Assert.assertEquals(number, mobileFormat, "Mobile number is in the expected format");

    }

    //verify address
    public void verifyAddressInput(String streetAddress, String city, String state, String zipcode ) throws AWTException {
        driver.findElement(accountCreationLocators.streetAddressInput).sendKeys("");
        baseActions.randomClickBasedOnOS();
        baseActions.validateErrorMessages(accountCreationLocators.blankStreetError);
        baseActions.regexAddress(accountCreationLocators.streetAddressInput, streetAddress);

        driver.findElement(accountCreationLocators.cityInput).sendKeys("");
        baseActions.randomClickBasedOnOS();
        baseActions.validateErrorMessages(accountCreationLocators.blankCityError);
        baseActions.regexCity(accountCreationLocators.cityInput, city);

        driver.findElement(accountCreationLocators.stateInput).sendKeys("");
        baseActions.randomClickBasedOnOS();
        baseActions.validateErrorMessages(accountCreationLocators.blankStateError);
//        baseActions.regexState(accountCreationLocators.stateInput, state);

        driver.findElement(accountCreationLocators.zipcodeInput).sendKeys("");
        baseActions.randomClickBasedOnOS();
        baseActions.validateErrorMessages(accountCreationLocators.blankZipcodeError);
//        baseActions.regexZipcode(accountCreationLocators.zipcodeInput, zipcode);
        regexCompleteAddress();
    }

    //Verify that the checkbox for "I have read and agree to Cantaloupe’s:" is not pre- selected
    //Verify that after clicking on the checkbox for "I have read and agree to Cantaloupe’s:" gets selected
    public void isCheckboxPreChecked()
    {
        driver.findElement(accountCreationLocators.completeButton).click();
        Boolean checkboxErrorStatus = driver.findElement(accountCreationLocators.checkBoxErrorMessage).isDisplayed();// WebElement checkboxStatus = driver.findElement(accountCreationLocators.checkboxForTerms);
        if(checkboxErrorStatus == true)
        {
            Assert.assertTrue(checkboxErrorStatus, "Check box is unchecked");
            baseActions.clickButton(accountCreationLocators.checkboxForTerms);
        }
        else
        {
            Assert.assertTrue(true, "Checkbox is already checked");
        }

    }

    //verify the UI elements for consent and terms/Privacy
    public void verifyTermsAndPrivacy()
    {
       WebElement readAgreeText =  driver.findElement(accountCreationLocators.readAndAgreeText);
        WebElement termsLink = driver.findElement(accountCreationLocators.termsOfUseLink);
        WebElement privacyLink = driver.findElement(accountCreationLocators.privacyPolicyLink);

        if ((readAgreeText.isDisplayed()) && (termsLink.isEnabled()) && (privacyLink.isEnabled()))
        {
            WebElement completeButtonEnabled = driver.findElement(accountCreationLocators.completeButton);
            Boolean complteButtonStatus = completeButtonEnabled.isEnabled();
            Assert.assertTrue(complteButtonStatus==true, "Complete button is enabled");
        }
    }

    public void clickCompleteButton()
    {
        driver.findElement(accountCreationLocators.completeButton).click();
    }

    //Confirm Registration
    public void confirmRegistration()
    {
        WebElement goodNews = driver.findElement(accountCreationLocators.goodNewsText);
        WebElement sentAMsg = driver.findElement(accountCreationLocators.sentMsgToCreatedEmail);
        String msgContainsEmail = sentAMsg.getText();

        Assert.assertTrue(goodNews.isDisplayed() == true && msgContainsEmail.contains(properties.getProperty("createNewEmail")), "User registation eas successful");


    }

    //Verify that, all fields are compulsory with the asterick (*) in the placeholder text
    public void verifyPlaceHolders() {

        WebElement emailInputPlaceHolder = driver.findElement(accountCreationLocators.emailIdInputFieldPlaceHolder);
        Character email = baseActions.getLastCharacter(emailInputPlaceHolder.getText());

        WebElement createPasswordPasswordPlaceHolder = driver.findElement(accountCreationLocators.createPasswordInputFieldPlaceHolder);
        Character cp = baseActions.getLastCharacter(createPasswordPasswordPlaceHolder.getText());

        WebElement confirmPasswordPlaceHolder = driver.findElement(accountCreationLocators.confirmPasswordInptFieldPlaceHolder);
        Character pwd =baseActions.getLastCharacter(confirmPasswordPlaceHolder.getText());

        WebElement firstNameInputPlaceHolder = driver.findElement(accountCreationLocators.firstNamePlaceHolder);
        Character fn = baseActions.getLastCharacter(firstNameInputPlaceHolder.getText());

        WebElement lastNameInputPlaceHolder = driver.findElement(accountCreationLocators.lastNamePlaceHolder);
        Character ln = baseActions.getLastCharacter(lastNameInputPlaceHolder.getText());


        WebElement mobileInputPlaceHolder = driver.findElement(accountCreationLocators.mobileNumberFieldPlaceHolder);
        Character mobile = baseActions.getLastCharacter(mobileInputPlaceHolder.getText());


        WebElement streetInputPlaceHolder = driver.findElement(accountCreationLocators.streetAddressInputFieldPlaceHolder);
        Character si = baseActions.getLastCharacter(streetInputPlaceHolder.getText());

        WebElement cityInputPlaceHolder = driver.findElement(accountCreationLocators.cityInputFieldPlaceHolder);
        Character ci = baseActions.getLastCharacter(cityInputPlaceHolder.getText());

        WebElement stateInputPlaceHolder = driver.findElement(accountCreationLocators.stateInptFieldPlaceHolder);
        Character stateI = baseActions.getLastCharacter(stateInputPlaceHolder.getText());

        WebElement zipcodeInputPlaceHolder = driver.findElement(accountCreationLocators.zipcodeInputFieldPlaceHolder);
        Character zi = baseActions.getLastCharacter(zipcodeInputPlaceHolder.getText());

        Character [] myChar={email, cp, pwd, fn, ln, si, stateI, ci, zi, mobile};
        ArrayList<Character> myChar1 = new ArrayList<Character>();
        myChar1.addAll(java.util.List.of(myChar));

        for (Character s : myChar) {
            Character star = '*';
            if (star.equals(s)) {
                Assert.assertTrue(true, "* is added at the end of all the placeHolders");
            } else {
                Assert.assertTrue(false, "Something is missing with the placeHolders");
            }
        }
    }


    //Verify that, the input field for "Email" should be editable
    public void isEmailFieldEditable()
    {
        baseActions.isFieldEditable(accountCreationLocators.emailIdInputField);
    }

    //Verify that, the input field for "Create password" should be editable
    public void isPasswordFieldEditable()
    {
        baseActions.isFieldEditable(accountCreationLocators.createPasswordInputField);
    }

    //Verify that, the input field for "Confirm password" should be editable
    public void isConfirmPasswordFieldEditable()
    {
        baseActions.isFieldEditable(accountCreationLocators.confirmPasswordInptField);
    }

    //Verify that, the input field for "First name" should be editable
    public void isFirstNameEditable() {
        baseActions.isFieldEditable(accountCreationLocators.firstnameInput);
    }

    //Verify that, the input field for "Last name" should be editable
    public void isLastNameEditable() {
        baseActions.isFieldEditable(accountCreationLocators.lastNameInput);
    }

    //Verify that, the input field for "Mobile" should be editable
    public void isMobileEditable() {
        baseActions.isFieldEditable(accountCreationLocators.mobileNumberField);
    }

    //Verify that, the input field for "Street Address" should be editable
    public void isStreetAddressEditable() {
        baseActions.isFieldEditable(accountCreationLocators.streetAddressInput);
    }

    //Verify that, the input field for "City" should be editable
    public void isCityEditable() {
        baseActions.isFieldEditable(accountCreationLocators.streetAddressInput);
    }

    //Verify that, the input field for "State" should be editable
    public void isStateEditable() {
        baseActions.isFieldEditable(accountCreationLocators.streetAddressInput);
    }

    //Verify that, the input field for "Zipcode" should be editable
    public void isZipcodeEditable() {
        baseActions.isFieldEditable(accountCreationLocators.streetAddressInput);
    }

    //Verify that if the input number by user is unique, the number will be accepted with a ✓ on the field
    public void verifyMobileUniquesNessTick()
    {
        Boolean checkTickMark = baseActions.verrifyTickMark(accountCreationLocators.tickMarkImageForMobile);
         if(checkTickMark==true)
        {
            Assert.assertTrue(true, "Mobile No entered is unique");
        }
        else
        {
            Assert.assertTrue(false, "This phone number is already in use. Please use a different phone number or contact customer service at +1-888-561-4748.");
        }
    }

    //Verify that using an already registered number will throw a validation error "This phone number is already in use. Please use a different phone number or contact customer service at +1-888-561-4748"
    public void verifyMobileUniqueNessError()
    {
         Boolean checkPhoneNoUnique_Error = baseActions.verrifyTickMark(accountCreationLocators.phoneNoInUseError);
        if(checkPhoneNoUnique_Error==true)
        {
            Assert.assertTrue(true, "This phone number is already in use. Please use a different phone number or contact customer service at +1-888-561-4748.");
        }
        else
        {
            Assert.assertTrue(false, "Mobile No entered is invalid");
        }
    }

    //Verify that the error message will be displayed after user inputs 10 digits
    public boolean verifyErrorAfter10DigitsEntry()
    {
        String phoneNoText = driver.findElement(accountCreationLocators.mobileNumberField).getAttribute("value");
        WebElement uniquenessError = driver.findElement(accountCreationLocators.phoneNoInUseError);
        String numberOnly = phoneNoText.replaceAll("[^0-9]", "");

        int phoneNoLength = numberOnly.length();
        if(phoneNoLength==10)
        {
           WebElement phoneNoLinkText = driver.findElement(By.linkText ("+1-888-561-4748"));
            Assert.assertTrue(uniquenessError.isDisplayed()==true, "Error message is displayed after entering 10 digits");
            WebDriverWait wait = new WebDriverWait(driver,6);
            // elementToBeClickable expected criteria

            Assert.assertTrue(phoneNoLinkText.isEnabled(), "The link is in enabled mode");
            wait.until(ExpectedConditions.elementToBeClickable (phoneNoLinkText));
            return true;
        }
        else if((driver.findElement(accountCreationLocators.invalidMobileError)).isDisplayed()==true)
        {
            Assert.assertTrue(uniquenessError.isDisplayed()==true, "Invalid mobile number.");
            return true;
        }
        else
        {
            Assert.assertTrue(false, "Error messages for mobile is not displayed properly");
        }
        return false;
    }

    //VerifyRegex for Address fields
    public void regexStreet()
    {
        baseActions.regexExpression(accountCreationLocators.streetAddressInput, properties.getProperty("streetAddress"), properties.getProperty("regexAddress"));

    }

    public void regexCity()
    {
        baseActions.regexExpression(accountCreationLocators.streetAddressInput, properties.getProperty("city"), properties.getProperty("regexCity"));

    }

    public void regexState()
    {
        String stateEntered = properties.getProperty("state");
        if(stateEntered.matches(properties.getProperty("regexStateFullName")) || stateEntered.matches(properties.getProperty("regexStatecode")))
        {
            driver.findElement(accountCreationLocators.stateInput).sendKeys(properties.getProperty("state"));
            Assert.assertTrue(true, "Entered state is valid");
        }
        else
        {
            Assert.assertTrue(false, "The State entered is not valid");
        }
        //baseActions.regexExpression(accountCreationLocators.streetAddressInput, properties.getProperty("state"), stateEntered);

    }

    public void regexZipcode()
    {
        baseActions.regexExpression(accountCreationLocators.zipcodeInputField, properties.getProperty("zipcode"), properties.getProperty("regexZipcode"));

    }

    //Add all the inputs for address and get it into one string
    public void addUpAllAddressInputs() {
        baseActions.addUpAllAddressInputs(accountCreationLocators.streetAddressInput, accountCreationLocators.cityInput);
    }

    //Regx for the final String of address
    public void regexCompleteAddress()
    {
//        String finalStringAddress = addUpAllAddressInputs();
//        Pattern pattern = Pattern.compile(properties.getProperty("regexFinalAddress"));
//        Matcher matcher = pattern.matcher(finalStringAddress);
//
//        Boolean checkPatternCondition = matcher.matches();
//
//        if (checkPatternCondition == true) {
//        } else if ((checkPatternCondition == false)) {
//            Assert.assertTrue(false, "The entered data is not valid");
//        } else {
//            log.info("Create Account Screen : Something is not proper for the entered phone number ");
//        }
        accountCreation1.enterData(accountCreationLocators.streetAddressInput, properties.getProperty("streetAddress"));
       // accountCreation1.enterData(accountCreationLocators.cityInputField, properties.getProperty("city"));
        baseActions.regexCompleteAddress(accountCreationLocators.streetAddressInput, accountCreationLocators.cityInput);

        regexState();
        regexZipcode();
    }



    //Enter details for Address
    public void enterAddressDetails()
    {
        accountCreation1.enterData(accountCreationLocators.streetAddressInput, properties.getProperty("streetAddress"));
        accountCreation1.enterData(accountCreationLocators.cityInputField, properties.getProperty("city"));
    }

    //Verify that, clicking on "Terms Of Use" button will redirect user to the terms of use screen
    public void navigateToTOC()
    {
        driver.findElement(accountCreationLocators.termsOfUseLink).click();
        Assert.assertTrue(driver.findElement(accountCreationLocators.tocConfirm_MoreUserTermsText).isDisplayed()==true, "User is on TOC screen");
    }


    //Verify that, clicking on "PP" button will redirect user to the terms of use screen
    public void navigateToPP()
    {
        driver.findElement(accountCreationLocators.privacyPolicyLink).click();
        Assert.assertTrue(driver.findElement(accountCreationLocators.privacyPolicyText).isDisplayed()==true, "User is on TOC screen");
    }

    public void navigateBackToRegistration()
    {
        baseActions.scrollDown();
        driver.findElement(accountCreationLocators.backToSignUp).click();
        Assert.assertTrue(driver.findElement(accountCreationLocators.createAccountText).isDisplayed()==true);
    }

    //Verify that, all the input fields should have the same value if the user comes back from "Terms of Use And Privacy Policy" screen
    public void verifyInputAfterTOCAndPOPNavigation()
    {
        String email = driver.findElement(accountCreationLocators.emailIdInputField).getAttribute("value");
        String password = driver.findElement(accountCreationLocators.emailIdInputField).getAttribute("value");
        String cinfirmPassword = driver.findElement(accountCreationLocators.emailIdInputField).getAttribute("value");
        String firstName = driver.findElement(accountCreationLocators.emailIdInputField).getAttribute("value");
        String lastName = driver.findElement(accountCreationLocators.emailIdInputField).getAttribute("value");
        String mobileNumber = driver.findElement(accountCreationLocators.emailIdInputField).getAttribute("value");
        String sreetAddress = driver.findElement(accountCreationLocators.emailIdInputField).getAttribute("value");
        String city = driver.findElement(accountCreationLocators.emailIdInputField).getAttribute("value");
        String state = driver.findElement(accountCreationLocators.emailIdInputField).getAttribute("value");
        String zipcode = driver.findElement(accountCreationLocators.emailIdInputField).getAttribute("value");

      //  Assert.assertEquals(email.equals());
    }

}
