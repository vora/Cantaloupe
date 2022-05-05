package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pageActions.SignInWithExistingAccountActions;
import resources.FinalConstants;

import java.awt.*;
import java.io.IOException;

public class SignInWithExistingAccountTest extends TestBase {

    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();

    public SignInWithExistingAccountTest() throws IOException {
    }



    @Test
    public void validateLogin() throws IOException, AWTException {

        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickContinueWithEmail();
        signInWithExistingAccountActions.validateErrorMessages();
        signInWithExistingAccountActions.verifySignInDisabled();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickSignOut();
    }




}