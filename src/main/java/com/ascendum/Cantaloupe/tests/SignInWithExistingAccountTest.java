package com.ascendum.Cantaloupe.tests;

import com.ascendum.Cantaloupe.base.DataProvider;
import com.ascendum.Cantaloupe.base.TestBase;
import com.ascendum.Cantaloupe.pageActions.LoginWithExistingActions;
import com.ascendum.Cantaloupe.pageActions.SignInWithExistingAccountActions;
import com.ascendum.Cantaloupe.pageLocators.AccountCreationLocators;
import com.ascendum.Cantaloupe.pageLocators.ContinueAccountCreationLocators;
import com.ascendum.Cantaloupe.pageLocators.CreateAccountLocators;
import com.ascendum.Cantaloupe.pageLocators.LoginScreen;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignInWithExistingAccountTest extends TestBase {

    LoginWithExistingActions loginWithExistingAccount = new LoginWithExistingActions();
    LoginScreen loginScreen = new LoginScreen();
    DataProvider dataProvider = new DataProvider();
    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
    CreateAccountLocators createAccountLocators = new CreateAccountLocators();
    ContinueAccountCreationLocators continueAccountCreationLocators = new ContinueAccountCreationLocators();
    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();



    public SignInWithExistingAccountTest() throws IOException {
    }


    @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)

    public void validateLogin(String existingAccountEmail, String existingAccountPassword,
                              String createAccount, String createAccountPassword, String createAccountConfirmPassword,
                              String firstName, String lastName, String mobileNumber, String streetAddress, String city,
                              String state, String zipcode, String createNewEmail, String newFirstName, String newLastName,
                              String newMobileNumber, String newStreetAddress, String newCity, String newState,
                              String newZipcode) throws IOException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickContinueWithEmail();
        signInWithExistingAccountActions.validateErrorMessages();
        signInWithExistingAccountActions.clickSignIn(existingAccountEmail, existingAccountPassword);
        signInWithExistingAccountActions.clickSignOut();



    }




}