package com.ascendum.Cantaloupe.tests;

import com.ascendum.Cantaloupe.base.DataProvider;
import com.ascendum.Cantaloupe.base.TestBase;
import com.ascendum.Cantaloupe.pageActions.ForgotPasswordActions;
import org.testng.annotations.Test;

import java.io.IOException;

public class ForgotPasswordTest extends TestBase {

    ForgotPasswordActions forgotPasswordActions = new ForgotPasswordActions();


    public ForgotPasswordTest() throws IOException {
    }

    @Test(dataProvider = "LoanPalTestData", dataProviderClass = DataProvider.class)

    public void enterEmailToResetPassword(String existingAccountEmail, String existingAccountPassword, String createAccount, String createAccountPassword, String createAccountConfirmPassword,
                String firstName, String lastName, String mobileNumber, String streetAddress, String city, String state, String zipcode, String newFirstName) throws IOException {


            forgotPasswordActions.verifyForgotPassword(existingAccountEmail);
    }

    }
