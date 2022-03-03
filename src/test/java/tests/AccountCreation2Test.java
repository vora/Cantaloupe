package tests;

import base.DataProvider;
import base.TestBase;

import org.testng.annotations.Test;
import pageActions.AccountCreation1;
import pageActions.AccountCreation2;
import pageActions.SignInWithExistingAccountActions;

import java.io.IOException;

public class AccountCreation2Test extends TestBase {

    AccountCreation1 accountCreation1 = new AccountCreation1();
    AccountCreation2 accountCreation2 = new AccountCreation2();
    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();

    public AccountCreation2Test() throws IOException {
    }

    @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)

    //Validate all errors such as empty input field, then error message, then existing email error message and login button flow
    public void verifyEmailValidationFlow
            (String existingAccountEmail, String existingAccountPassword,
             String createAccount, String createAccountPassword, String createAccountConfirmPassword,
             String firstName, String lastName, String mobileNumber, String streetAddress, String city,
             String state, String zipcode, String createNewEmail, String newFirstName, String newLastName,
             String newMobileNumber, String newStreetAddress, String newCity, String newState,
             String newZipcode, String wrongPassword) throws IOException {

        // Verify email entered, tick mark
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(createNewEmail);
        accountCreation2.enteredEmaiCheck(createNewEmail);

    }

        //Verify if the email is editable
        @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)

        //Validate all errors such as empty input field, then error message, then existing email error message and login button flow
        public void verifyEmailIsEditable (String existingAccountEmail, String existingAccountPassword,
                String createAccount, String createAccountPassword, String createAccountConfirmPassword,
                String firstName, String lastName, String mobileNumber, String streetAddress, String city,
                String state, String zipcode, String createNewEmail, String newFirstName, String newLastName,
                String newMobileNumber, String newStreetAddress, String newCity, String newState,
                String newZipcode, String wrongPassword) throws IOException {

            accountCreation1.clickCreateButton();
            accountCreation1.validateEmailCriteriaField(createNewEmail);
            accountCreation2.enteredEmaiCheck(createNewEmail);
            accountCreation2.verifyEmailIsEditable(existingAccountEmail);
        }

        //Verify wrong password fields
        @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)
        public void verifyPassword
        (String existingAccountEmail, String existingAccountPassword,
         String createAccount, String createAccountPassword, String createAccountConfirmPassword,
         String firstName, String lastName, String mobileNumber, String streetAddress, String city,
         String state, String zipcode, String createNewEmail, String newFirstName, String newLastName,
         String newMobileNumber, String newStreetAddress, String newCity, String newState,
         String newZipcode, String wrongPassword) throws IOException {

        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(createNewEmail);
        accountCreation1.verrifyTickMark();
        accountCreation1.verifyNextButtonEnabled();
        accountCreation2.tryWrongPassword(wrongPassword);
        accountCreation2.validateErrorMessageForPassword(createAccountPassword);
        accountCreation2.tryConfirmPassword(createAccountPassword);
        accountCreation2.validateErrorMessageForConfirmPassword(wrongPassword);
    }

    //Verify if both the password and confirm password matches adn click on show icon and hide icon
    @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)
    public void showPasswordAndHide
            (String existingAccountEmail, String existingAccountPassword,
             String createAccount, String createAccountPassword, String createAccountConfirmPassword,
             String firstName, String lastName, String mobileNumber, String streetAddress, String city,
             String state, String zipcode, String createNewEmail, String newFirstName, String newLastName,
             String newMobileNumber, String newStreetAddress, String newCity, String newState,
             String newZipcode, String wrongPassword) throws IOException {

        verifyPassword(existingAccountEmail,  existingAccountPassword,
                 createAccount,  createAccountPassword,  createAccountConfirmPassword,
                 firstName,  lastName,  mobileNumber,  streetAddress,  city,
                 state,  zipcode,  createNewEmail,  newFirstName,  newLastName,
                 newMobileNumber,  newStreetAddress,  newCity,  newState,
                 newZipcode,  wrongPassword);
        accountCreation2.clickShowPassword();
        accountCreation2.clickHidePassword();
    }

    //verify if the password and confirm passwords are a match
    @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)
    public void verifyPasswords(String existingAccountEmail, String existingAccountPassword,
                                String createAccount, String createAccountPassword, String createAccountConfirmPassword,
                                String firstName, String lastName, String mobileNumber, String streetAddress, String city,
                                String state, String zipcode, String createNewEmail, String newFirstName, String newLastName,
                                String newMobileNumber, String newStreetAddress, String newCity, String newState,
                                String newZipcode, String wrongPassword)
    {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(createNewEmail);
        accountCreation1.verrifyTickMark();
        accountCreation1.verifyNextButtonEnabled();
        accountCreation2.enterPassword(createAccountPassword);
        accountCreation2.verifyPasswordAndConfirmPassword(createAccountPassword, createAccountConfirmPassword);
    }

    //verify personal details section
    @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)
    public void verifyPersonalDetailsSection(String existingAccountEmail, String existingAccountPassword,
                                String createAccount, String createAccountPassword, String createAccountConfirmPassword,
                                String firstName, String lastName, String mobileNumber, String streetAddress, String city,
                                String state, String zipcode, String createNewEmail, String newFirstName, String newLastName,
                                String newMobileNumber, String newStreetAddress, String newCity, String newState,
                                String newZipcode, String wrongPassword) throws IOException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(createNewEmail);
        accountCreation1.verrifyTickMark();
        accountCreation1.verifyNextButtonEnabled();
        accountCreation2.verifyPasswordAndConfirmPassword(createAccountPassword, createAccountConfirmPassword);
        accountCreation2.verifyFirstNameInput(firstName);
        accountCreation2.verifyLastNameInput(lastName);
        accountCreation2.verifyPhoneNoInput(mobileNumber);
        accountCreation2.verifyAddressInput(streetAddress, city, state, zipcode);
        }


     //verify if checkbox is not checked and validate the links
   @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)
    public void verifyConsentSection(String existingAccountEmail, String existingAccountPassword,
                                     String createAccount, String createAccountPassword, String createAccountConfirmPassword,
                                     String firstName, String lastName, String mobileNumber, String streetAddress, String city,
                                     String state, String zipcode, String createNewEmail, String newFirstName, String newLastName,
                                     String newMobileNumber, String newStreetAddress, String newCity, String newState,
                                     String newZipcode, String wrongPassword) throws IOException {
       {
           verifyPersonalDetailsSection(existingAccountEmail, existingAccountPassword,
                   createAccount, createAccountPassword, createAccountConfirmPassword,
                   firstName, lastName, mobileNumber, streetAddress, city,
                   state, zipcode, createNewEmail, newFirstName, newLastName,
                   newMobileNumber, newStreetAddress, newCity, newState,
                   newZipcode, wrongPassword);
           accountCreation2.checkbox();
           accountCreation2.verifyTermsAndPrivacy();
           accountCreation2.clickCompleteButton();

       }


   }
}