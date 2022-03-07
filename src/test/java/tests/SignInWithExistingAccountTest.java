package tests;

import base.DataProvider;
import base.TestBase;
import org.testng.annotations.Test;
import pageActions.SignInWithExistingAccountActions;
import pageLocators.AccountCreationLocators;
import pageLocators.CreateOrLoginInitialLocators;
import pageLocators.LandingScreen;

import java.io.IOException;

public class SignInWithExistingAccountTest extends TestBase {

    //LoginWithExistingActions loginWithExistingAccount = new LoginWithExistingActions();
    LandingScreen loginScreen = new LandingScreen();
    DataProvider dataProvider = new DataProvider();
    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
    CreateOrLoginInitialLocators createAccountLocators = new CreateOrLoginInitialLocators();
   // ContinueAccountCreationLocators continueAccountCreationLocators = new ContinueAccountCreationLocators();
    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();



    public SignInWithExistingAccountTest() throws IOException {
    }


    @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)

    public void validateLogin(String existingAccountEmail, String existingAccountPassword,
                              String createAccount, String createAccountPassword, String createAccountConfirmPassword,
                              String firstName, String lastName, String mobileNumber, String streetAddress, String city,
                              String state, String zipcode, String createNewEmail, String newFirstName, String newLastName,
                              String newMobileNumber, String newStreetAddress, String newCity, String newState,
                              String newZipcode, String wrongPassword) throws IOException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickContinueWithEmail();
        signInWithExistingAccountActions.validateErrorMessages();
        signInWithExistingAccountActions.verifySignInDisabled();
        signInWithExistingAccountActions.clickSignIn(existingAccountEmail, existingAccountPassword);
        signInWithExistingAccountActions.clickSignOut();



    }




}