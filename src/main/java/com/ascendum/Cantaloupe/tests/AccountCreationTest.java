package com.ascendum.Cantaloupe.tests;

import com.ascendum.Cantaloupe.base.DataProvider;
import com.ascendum.Cantaloupe.base.TestBase;
import com.ascendum.Cantaloupe.pageActions.AccountCreationActions;
import org.testng.annotations.Test;

import java.io.IOException;

public class AccountCreationTest extends TestBase {

    AccountCreationActions accountCreationActions = new AccountCreationActions();

    public AccountCreationTest() throws IOException {
    }

    @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)

    public void createAccountFeatures(String existingAccountEmail, String existingAccountPassword, String createAccount, String createAccountPassword, String createAccountConfirmPassword,
                          String firstName, String lastName, String mobileNumber, String streetAddress, String city, String state, String zipcode, String newFirstName) throws IOException

    {

       // accountCreationActions.assertCompleteButtonCase();
        accountCreationActions.testIOS(existingAccountEmail,  existingAccountPassword,  createAccount,  createAccountPassword,  createAccountConfirmPassword,
                 firstName,  lastName,  mobileNumber,  streetAddress,  city,  state,  zipcode);
        accountCreationActions. accountCreationProcess( createAccountPassword,  createAccountConfirmPassword,
                firstName,  lastName,  mobileNumber,  streetAddress,  city,  state,  zipcode);


    }
}
