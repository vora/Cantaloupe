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

    @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)
    public void verifyEditProfile(String existingAccountEmail, String existingAccountPassword,
                                  String createAccount, String createAccountPassword, String createAccountConfirmPassword,
                                  String firstName, String lastName, String mobileNumber, String streetAddress, String city,
                                  String state, String zipcode, String createNewEmail, String newFirstName, String newLastName,
                                  String newMobileNumber, String newStreetAddress, String newCity, String newState,
                                  String newZipcode) throws IOException {
        editProfileActions.navigateToProfileScreen(existingAccountEmail,  existingAccountPassword);
        editProfileActions.verifyEnteredEmailIsSimilar(existingAccountEmail);
        editProfileActions.editFirstName(newFirstName);
        editProfileActions.editLastName(newLastName);
        editProfileActions.editMobileNumber(newMobileNumber);
        editProfileActions.editStreetAddress(newStreetAddress);
        editProfileActions.editCity(newCity);
        editProfileActions.editState(newState);
        editProfileActions.editZipcode(newZipcode);
        //editProfileActions.verifyUpdateButton();
    }

}
