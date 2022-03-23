package tests;

import base.TestBase;

import org.testng.annotations.Test;
import pageActions.AccountCreation1;
import pageActions.HomePageActions;
import pageActions.SignInWithExistingAccountActions;
import resources.FinalConstants;

import java.awt.*;
import java.io.IOException;

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
    }

    //Validate create new email, tick mark, next button enabled and screen 2
    @Test
    public void newEmailFlow() throws AWTException {
        //accountCreation1.verifyEmailRegex(createNewEmail);
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(FinalConstants.createNewEmail, FinalConstants.regexEmail);
        accountCreation1.verrifyTickMark();
        accountCreation1.verifyNextButtonEnabled();

    }


    // validate login through existing user
   @Test
    public void existingEmaillowLogin() throws IOException, AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.loginThroughExistingEmail(FinalConstants.existingAccountEmail, FinalConstants.regexEmail);
        signInWithExistingAccountActions.verifySignInDisabled();
    }
}