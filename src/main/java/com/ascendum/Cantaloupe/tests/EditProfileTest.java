package com.ascendum.Cantaloupe.tests;

import com.ascendum.Cantaloupe.base.DataProvider;
import com.ascendum.Cantaloupe.base.TestBase;
import com.ascendum.Cantaloupe.pageActions.EditProfileActions;
import org.testng.annotations.Test;

import java.io.IOException;

public class EditProfileTest extends TestBase {

    EditProfileActions editProfileActions = new EditProfileActions();

    public EditProfileTest() throws IOException {
    }

    @Test(dataProvider = "LoanPalTestData", dataProviderClass = DataProvider.class)
    public void verifyEditProfile(String existingAccountEmail, String existingAccountPassword, String createAccount, String createAccountPassword, String createAccountConfirmPassword,
                                  String firstName, String lastName, String mobileNumber, String streetAddress, String city, String state, String zipcode, String newFirstName) throws IOException {
        editProfileActions.navigateToProfileScreen(existingAccountEmail,  existingAccountPassword);
        editProfileActions.verifyEnteredEmailIsSimilar(existingAccountEmail);
        editProfileActions.editFirstName(newFirstName);
    }
}
