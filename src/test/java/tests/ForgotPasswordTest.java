package tests;

import base.DataProvider;
import base.TestBase;
import org.testng.annotations.Test;
import pageActions.ForgotPasswordActions;

import java.io.IOException;

public class ForgotPasswordTest extends TestBase {

    ForgotPasswordActions forgotPasswordActions = new ForgotPasswordActions();


    public ForgotPasswordTest() throws IOException {
    }

    @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)

    public void enterEmailToResetPassword(String existingAccountEmail, String existingAccountPassword,
                                          String createAccount, String createAccountPassword, String createAccountConfirmPassword,
                                          String firstName, String lastName, String mobileNumber, String streetAddress, String city,
                                          String state, String zipcode, String createNewEmail, String newFirstName, String newLastName,
                                          String newMobileNumber, String newStreetAddress, String newCity, String newState,
                                          String newZipcode, String wrongPassword) throws IOException {
        forgotPasswordActions.verifyForgotPassword(existingAccountEmail);
    }

    }
