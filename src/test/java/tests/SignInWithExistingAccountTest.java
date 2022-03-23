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

import java.io.IOException;

public class SignInWithExistingAccountTest extends TestBase {

    //LoginWithExistingActions loginWithExistingAccount = new LoginWithExistingActions();
    LandingScreen loginScreen = new LandingScreen();
    DataProvider dataProvider = new DataProvider();
    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
    CreateOrLoginInitialLocators createAccountLocators = new CreateOrLoginInitialLocators();
   // ContinueAccountCreationLocators continueAccountCreationLocators = new ContinueAccountCreationLocators();
    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();
    HomePageActions homePageActions = new HomePageActions();



    public SignInWithExistingAccountTest() throws IOException {
    }



    @Test
    public void validateLogin() throws IOException {

        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickContinueWithEmail();
        signInWithExistingAccountActions.validateErrorMessages();
        signInWithExistingAccountActions.verifySignInDisabled();
        signInWithExistingAccountActions.clickSignIn(FinalConstants.existingAccountEmail, FinalConstants.existingAccountPassword);
        signInWithExistingAccountActions.clickSignOut();
    }




}