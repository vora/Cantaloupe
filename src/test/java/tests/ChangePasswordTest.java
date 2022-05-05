package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pageActions.ChangePasswordActions;
import pageActions.ForgotPasswordActions;
import pageActions.SignInWithExistingAccountActions;

import java.awt.*;
import java.io.IOException;

public class ChangePasswordTest extends TestBase {

   ChangePasswordActions changePasswordActions = new ChangePasswordActions();
   SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();

    public ChangePasswordTest() throws IOException {}


   @Test
   public void verifyFieldsAreEnabled() throws IOException, AWTException {
       signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
       signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
       signInWithExistingAccountActions.clickProfileLink();
       changePasswordActions.clickChangeButton();
       changePasswordActions.checkInputFieldIsEnabledAreEnabled();
   }

   //Verify if all 3 error messages are shown
   @Test
    public void verifyErrorMessages() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        changePasswordActions.clickChangeButton();
        changePasswordActions.verifyCreatePasswordErrors();
        changePasswordActions.verifyConfirmPasswordErrors("dfdgfdg");
    }

    @Test
    // Verify if data entered in create and confirm password is a match and meets the password criteria
    public void verifyPasswordMeetsCriteria() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        changePasswordActions.clickChangeButton();
        changePasswordActions.regexCreatePassword("Mason@123");
        changePasswordActions.regexConfirmPassword("Mason@123");
    }

    @Test
    //Verify if the both password fields matches and validate for regex
    public void verifyMatchAndRegexPasswords() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        changePasswordActions.clickChangeButton();
        changePasswordActions.verifyPasswordMatches("Mason@123", "Mason@123");
    }
    
}
