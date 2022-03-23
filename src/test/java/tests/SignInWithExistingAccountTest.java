package tests;

import base.DataProvider;
import base.TestBase;
import org.testng.annotations.Test;
import pageActions.HomePageActions;
import pageActions.SignInWithExistingAccountActions;
import pageLocators.AccountCreationLocators;
import pageLocators.CreateOrLoginInitialLocators;
import pageLocators.LandingScreen;
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
        signInWithExistingAccountActions.clickSignIn(FinalConstants.existingAccountEmail, FinalConstants.existingAccountPassword);
        signInWithExistingAccountActions.clickSignOut();
    }




}