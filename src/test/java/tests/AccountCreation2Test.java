package tests;

import base.BaseActions;
import base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageActions.AccountCreation1;
import pageActions.AccountCreation2;
import pageLocators.AccountCreationLocators;

import java.awt.*;
import java.io.IOException;

public class AccountCreation2Test extends TestBase {

    AccountCreation1 accountCreation1 = new AccountCreation1();
    AccountCreation2 accountCreation2 = new AccountCreation2();
    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
    BaseActions baseActions = new BaseActions();


    public AccountCreation2Test() throws IOException {
    }

    @Test

    //Validate all errors such as empty input field, then error message, then existing email error message and login button flow
    public void verifyEmailFieldInputData() throws IOException, AWTException
    {
        // Verify email entered, tick mark
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation2.enteredEmaiCheck(properties.getProperty("createNewEmail"));

    }

    //Verify if the email is editable
    @Test

    //Validate all errors such as empty input field, then error message, then existing email error message and login button flow
    public void verifyEmailIsEditable() throws IOException, AWTException
    {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation1.verifyNextButtonEnabled();
        accountCreation1.verrifyTickMark();
        //Feedback - assert text entered n getAttribute - Remove js
        //accountCreation2.enteredEmaiCheck(properties.getProperty("createNewEmail"));
        accountCreation2.verifyEmailIsEditable(properties.getProperty("existingAccountEmail"));
    }

    //Verify wrong password fields
    @Test
    public void verifyPassword() throws IOException, AWTException
    {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation1.verifyNextButtonEnabled();
        accountCreation2.tryWrongPassword(properties.getProperty("wrongPassword"));
        baseActions.clearData(driver.findElement(By.id("id_password")));
        accountCreation2.validateErrorMessageForPassword(properties.getProperty("wrongPassword"));
        accountCreation2.tryConfirmPassword(properties.getProperty("wrongPassword"));
        accountCreation2.validateErrorMessageForConfirmPassword(properties.getProperty("wrongPassword"));
    }

    //Verify if both the password and confirm password matches adn click on show icon and hide icon
    @Test
    public void showPasswordAndHide() throws IOException, AWTException
    {
        verifyPassword();
        accountCreation2.clickShowPassword();
        accountCreation2.clickHidePassword();
    }

    @Test
    //Check if password/confirmPassword fields are editable, masked
    public void checkPasswordFields() throws AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation1.verifyNextButtonEnabled();
        accountCreation2.isPasswordFieldEditable();
        accountCreation2.isConfirmPasswordFieldEditable();
        accountCreation2.checkPasswordMasked();
        accountCreation2.confirmPasswordMasked();

    }

    //verify if the password and confirm passwords are a match
    @Test
    public void verifyPasswordAndConfirmPassword() throws AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));

        accountCreation1.verrifyTickMark();
        accountCreation1.verifyNextButtonEnabled();
        accountCreation2.enterPassword(properties.getProperty("createAccountPassword"));
        accountCreation2.checkPasswordMasked();
        accountCreation2.isConfirmPasswordFieldEditable();
        accountCreation2.verifyPasswordAndConfirmPassword(properties.getProperty("createAccountPassword"), properties.getProperty("createAccountConfirmPassword"));
    }

    //verify personal details section
    @Test
    public void verifyPersonalDetailsSection() throws IOException, AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation1.verrifyTickMark();
        accountCreation1.verifyNextButtonEnabled();
        accountCreation2.verifyPasswordAndConfirmPassword(properties.getProperty("createAccountPassword"), properties.getProperty("createAccountConfirmPassword"));
        accountCreation2.verifyFirstNameInput(properties.getProperty("firstName"));
        accountCreation2.verifyLastNameInput(properties.getProperty("lastName"));
        accountCreation2.verifyPhoneNoInput();
        accountCreation2.verifyAddressInput(properties.getProperty("streetAddress"), properties.getProperty("city"), properties.getProperty("state"), properties.getProperty("zipcode"));
    }


    //verify if checkbox is not checked and validate the links
    @Test
    public void verifyConsentSection() throws IOException, AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation1.verrifyTickMark();
        accountCreation1.verifyNextButtonEnabled();
        accountCreation2.verifyPasswordAndConfirmPassword(properties.getProperty("createAccountPassword"), properties.getProperty("createAccountConfirmPassword"));
        accountCreation2.verifyFirstNameInput(properties.getProperty("firstName"));
        accountCreation2.verifyLastNameInput(properties.getProperty("lastName"));
        accountCreation2.verifyPhoneNoInput();
        accountCreation2.verifyAddressInput(properties.getProperty("streetAddress"), properties.getProperty("city"), properties.getProperty("state"), properties.getProperty("zipcode"));
        accountCreation2.isCheckboxPreChecked();
        accountCreation2.verifyTermsAndPrivacy();
    }

    @Test
    public void completeRegistration() throws IOException, AWTException {
        verifyConsentSection();
        accountCreation2.clickCompleteButton();
        accountCreation2.confirmRegistration();

    }

    //Verify if all the fields are in editable mode
    @Test
    public void verifyIfFieldsAreEditable() throws IOException, AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation2.isEmailFieldEditable();
        accountCreation2.isPasswordFieldEditable();
        accountCreation2.isConfirmPasswordFieldEditable();
        accountCreation2.isFirstNameEditable();
        accountCreation2.isLastNameEditable();
        accountCreation2.isMobileEditable();
        accountCreation2.isStreetAddressEditable();
        accountCreation2.isCityEditable();
        accountCreation2.isStateEditable();
        accountCreation2.isZipcodeEditable();
    }

    @Test
    public void verifyFirstAndLastNameRegex() throws AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation1.verifyNextButtonEnabled();
        accountCreation2.verifyFirstNameRegex();
        accountCreation2.verifyFirstNameRegex();
    }

    @Test
    public void verifyMobile() throws AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation1.verifyNextButtonEnabled();
        accountCreation1.enterData(accountCreationLocators.phoneNoInput, properties.getProperty("mobileNumber"));
        accountCreation2.regexPhoneNo();
        accountCreation2.verifyPhoneNoFormat();
    }

    @Test
    public void verifyMobileUniqueNessAndError() throws AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation1.verifyNextButtonEnabled();
        accountCreation1.enterData(accountCreationLocators.phoneNoInput, properties.getProperty("mobileNumber"));
        accountCreation2.regexPhoneNo();
        accountCreation2.verifyPhoneNoFormat();
        try {
            accountCreation2.verifyMobileUniquesNessTick();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try {
            accountCreation2.verifyMobileUniqueNessError();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Test
    public void verifyError_After10DigitsInputOnly() throws AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation1.verifyNextButtonEnabled();
        accountCreation1.enterData(accountCreationLocators.phoneNoInput, properties.getProperty("existingMobileNo"));
        accountCreation2.verifyErrorAfter10DigitsEntry();

    }

    @Test
    public void verifyAddressFields() throws AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation1.verifyNextButtonEnabled();
        accountCreation2.enterAddressDetails();
        accountCreation2.regexCompleteAddress();
    }

    @Test
    public void verifyTOC_PPNavigations() throws AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation1.verifyNextButtonEnabled();
        baseActions.scrollDown();
        accountCreation2.navigateToTOC();
        accountCreation2.navigateBackToRegistration();
        accountCreation2.navigateToPP();
        accountCreation2.navigateBackToRegistration();

    }


}
