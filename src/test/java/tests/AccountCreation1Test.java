package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageActions.AccountCreation1;
import pageActions.SignInWithExistingAccountActions;

import java.awt.*;
import java.io.IOException;
import java.util.Properties;

public class AccountCreation1Test extends TestBase {

    AccountCreation1 accountCreation1 = new AccountCreation1();
    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();

    public AccountCreation1Test() throws IOException {
    }

   @Test
    //Validate all errors such as empty input field, then error message, then existing email error message and login button flow
    public void errorValidations() throws AWTException {

        //Regex, error message,enter email, tick mark, check for existing email error, allow to login, if new email - allow user to next screen
        accountCreation1.validateEmptyField();
        accountCreation1.verifyNextButtonEnabled();
    }

    //Validate create new email, tick mark, next button enabled and screen 2
    @Test
    public void newEmailFlow() throws AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation1.verrifyTickMark();
        accountCreation1.verifyNextButtonEnabled();
    }

    @Test
    public void verifyPrefilledEmail_CreationFlow() throws AWTException {
        newEmailFlow();
        accountCreation1.prefilledEmail(properties.getProperty("createNewEmail"));
        accountCreation1.verifyEmailIsEditable();
        accountCreation1.verifyCompleteButtonEnablement();
    }



    //Validate create new email, tick mark, next button enabled and screen 2
    @Test
    public void verifyBackLinkFunctionality() throws AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation1.clickBackHomeLink();
    }

    //
    @Test
    public void validateExisting_EmailError() throws AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.existingEmailError_AccountCreation(properties.getProperty("existingAccountEmail"));
    }

    // validate login through existing user
   @Test
    public void existingEmaillowLogin() throws IOException, AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.loginThroughExistingEmail(properties.getProperty("existingAccountEmail"), properties.getProperty("regexEmail"));
        signInWithExistingAccountActions.verifySignInDisabled();
    }
}