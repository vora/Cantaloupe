package tests;

import base.TestBase;
import com.applitools.ICheckSettings;
import com.applitools.eyes.images.Eyes;
import org.testng.annotations.Test;
import pageActions.FAQActions;
import pageActions.SignInWithExistingAccountActions;
import pageActions.UpdateProfileActions;
import pageLocators.UpdateProfileLocators;

import java.awt.*;
import java.io.IOException;

public class UpdateProfileTests extends TestBase {

    UpdateProfileActions updateProfileActions = new UpdateProfileActions();
    UpdateProfileLocators updateProfileLocators = new UpdateProfileLocators();
    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();


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
        updateProfileActions.verifyPasswordField_UpdateProfie();
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
        updateProfileActions.updateDetailsFields();
        updateProfileActions.validateErrorsForMobile();
    }

    @Test
    public void updateProfileFields() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        updateProfileActions.verifyDetailsFieldsAndErrorsDisplayed();
        updateProfileActions.verifyUpdateProfileFunctionality();
    }

    @Test
    public void verifyUpdateProfileFunctionality() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        updateProfileActions.verifyDetailsFieldsAndErrorsDisplayed();
        updateProfileActions.verifyUpdateProfileFunctionality();
        updateProfileActions.validateErrorsForMobile();
        updateProfileActions.clickUpdateProfileButton();

    }

}