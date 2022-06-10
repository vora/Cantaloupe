package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pageActions.AccountCreation;
import pageActions.SignInWithExistingAccountActions;
import pageActions.UpdateProfileActions;
import pageLocators.UpdateProfileLocators;

import java.awt.*;
import java.io.IOException;

public class UpdateProfileTests extends TestBase {

    UpdateProfileActions updateProfileActions = new UpdateProfileActions();
    UpdateProfileLocators updateProfileLocators = new UpdateProfileLocators();
    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();
    AccountCreation accountCreation = new AccountCreation();

    public UpdateProfileTests() throws IOException {
    }

    @Test
    public void validtaEditProfileUI() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        driver.findElement(updateProfileLocators.updateButton).click();
        updateProfileActions.verifyUIElements();
    }

    @Test
    public void verifyFieldsAreEditable() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        driver.findElement(updateProfileLocators.updateButton).click();
        updateProfileActions.verifyUIElements();
        updateProfileActions.verifyFieldsAreEditable();
    }

    @Test
    public void verifyEmailFieldAndValue() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        updateProfileActions.verifyEmailFieldISEditableOrNot();
        updateProfileActions.verifyEmailIEdntered();
    }

    @Test
    public void verifyPasswordField() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        updateProfileActions.verifyPasswordField_UpdateProfile();
    }

    @Test
    public void verifyElementsAndErrors() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        updateProfileActions.verifyDetailsFieldsAndErrorsDisplayed();
    }

    @Test
    public void verifyMobileFieldErrors() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        updateProfileActions.verifyDetailsFieldsAndErrorsDisplayed();
        updateProfileActions.updateDetailsFields(properties.getProperty("updateFirstName"), properties.getProperty("updateLastName"), properties.getProperty("updateMobile"), properties.getProperty("updateStreet"), properties.getProperty("updateCity"), properties.getProperty("updateState"), properties.getProperty("zipcode"));
        updateProfileActions.validateErrorsForMobile();
        updateProfileActions.verifyErrorAfter10DigitsEntry();
    }

    @Test
    public void verifyNumberClickableInError() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        updateProfileActions.verifyDetailsFieldsAndErrorsDisplayed();
        updateProfileActions.updateDetailsFields(properties.getProperty("updateFirstName"), properties.getProperty("updateLastName"), properties.getProperty("existingMobileNo"), properties.getProperty("updateStreet"), properties.getProperty("updateCity"),properties.getProperty("updateState"), properties.getProperty("zipcode"));
        updateProfileActions.verifyNumberclickable_InMobileError();
    }


    @Test
    public void updateProfileFields() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        updateProfileActions.verifyDetailsFieldsAndErrorsDisplayed();
        updateProfileActions.verifyUpdateProfileFunctionality(properties.getProperty("updateFirstName"), properties.getProperty("updateLastName"), properties.getProperty("updateMobile"), properties.getProperty("updateStreet"), properties.getProperty("updateCity"), properties.getProperty("updateState"), properties.getProperty("updateZipcode"));
    }

    @Test
    public void verifyMobileFormat() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        updateProfileActions.verifyDetailsFieldsAndErrorsDisplayed();
        updateProfileActions.verifyUpdateProfileFunctionality(properties.getProperty("updateFirstName"), properties.getProperty("updateLastName"), properties.getProperty("updateMobile"), properties.getProperty("updateStreet"), properties.getProperty("updateCity"), properties.getProperty("updateState"), properties.getProperty("updateZipcode"));
        updateProfileActions.validateErrorsForMobile();
        updateProfileActions.verifyPhoneNoFormat();
    }

    @Test
    public void verifyUpdateProfileFunctionality() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        updateProfileActions.verifyDetailsFieldsAndErrorsDisplayed();
        updateProfileActions.verifyUpdateProfileFunctionality(properties.getProperty("updateFirstName"), properties.getProperty("updateLastName"), properties.getProperty("updateMobile"), properties.getProperty("updateStreet"), properties.getProperty("updateCity"),properties.getProperty("updateState"), properties.getProperty("updateZipcode"));
        updateProfileActions.validateErrorsForMobile();
        updateProfileActions.verifyPhoneNoFormat();
        accountCreation.verifyAnyErrorsDisplayedOnScreen();
        updateProfileActions.clickUpdateProfileButton();
    }

    @Test
    public void verifyTestData_AgainstRegistration() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingRegisteredEmail"), properties.getProperty("existingRegisteredPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        updateProfileActions.getEnteredValues_againtRegistration();
    }

    @Test
    public void checkFieldsForBlankData() throws IOException, AWTException, InterruptedException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingRegisteredEmail"), properties.getProperty("existingRegisteredPassword"));
        signInWithExistingAccountActions.clickProfileLink();
//        driver.findElement(updateProfileLocators.firstNameInput).click();
//        driver.findElement(updateProfileLocators.firstNameClearIcon).click();
        updateProfileActions.checkFieldsForBlankData();
    }


}