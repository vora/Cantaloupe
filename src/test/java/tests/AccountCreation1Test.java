package tests;

import base.DataProvider;
import base.TestBase;

import org.testng.annotations.Test;
import pageActions.AccountCreation1;
import pageActions.SignInWithExistingAccountActions;

import java.io.IOException;

public class AccountCreation1Test extends TestBase {

    AccountCreation1 accountCreation1 = new AccountCreation1();
    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();

    public AccountCreation1Test() throws IOException {
    }

    @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)

    //Validate all errors such as empty input field, then error message, then existing email error message and login button flow
    public void errorValidations
            (String existingAccountEmail, String existingAccountPassword,
             String createAccount, String createAccountPassword, String createAccountConfirmPassword,
             String firstName, String lastName, String mobileNumber, String streetAddress, String city,
             String state, String zipcode, String createNewEmail, String newFirstName, String newLastName,
             String newMobileNumber, String newStreetAddress, String newCity, String newState,
             String newZipcode, String wrongPassword) throws IOException {

        //Regex, error message,enter email, tick mark, check for existing email error, allow to login, if new email - allow user to next screen

        accountCreation1.validateEmptyField();
        accountCreation1.emailErrorMessage();


    }

    //Validate create new email, tick mark, next button enabled and screen 2
    @Test(dataProvider = "CantaloupeTestData", dataProviderClass = base.DataProvider.class)
    public void newEmailFlow
    (String existingAccountEmail, String existingAccountPassword,
     String createAccount, String createAccountPassword, String createAccountConfirmPassword,
     String firstName, String lastName, String mobileNumber, String streetAddress, String city,
     String state, String zipcode, String createNewEmail, String newFirstName, String newLastName,
     String newMobileNumber, String newStreetAddress, String newCity, String newState,
     String newZipcode, String wrongPassword) throws IOException {

        //accountCreation1.verifyEmailRegex(createNewEmail);
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(createNewEmail);

        accountCreation1.verrifyTickMark();
        accountCreation1.verifyNextButtonEnabled();

    }


    // validate login through existing user
    @Test(dataProvider = "CantaloupeTestData", dataProviderClass = base.DataProvider.class)
    public void existingEmaillowLogin
    (String existingAccountEmail, String existingAccountPassword,
     String createAccount, String createAccountPassword, String createAccountConfirmPassword,
     String firstName, String lastName, String mobileNumber, String streetAddress, String city,
     String state, String zipcode, String createNewEmail, String newFirstName, String newLastName,
     String newMobileNumber, String newStreetAddress, String newCity, String newState,
     String newZipcode, String wrongPassword) throws IOException {

        accountCreation1.clickCreateButton();
        accountCreation1.loginThroughExistingEmail(existingAccountEmail);
        signInWithExistingAccountActions.verifySignInDisabled();


    }
}