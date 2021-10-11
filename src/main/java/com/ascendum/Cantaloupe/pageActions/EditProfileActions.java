package com.ascendum.Cantaloupe.pageActions;

import com.ascendum.Cantaloupe.base.TestBase;
import com.ascendum.Cantaloupe.pageLocators.EditProfileLocators;
import com.ascendum.Cantaloupe.pageLocators.LoggedInUserLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class EditProfileActions extends TestBase {

    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();
    EditProfileLocators editProfileLocators = new EditProfileLocators();
    LoggedInUserLocators loggedInUserLocators = new LoggedInUserLocators();

    public EditProfileActions() throws IOException {

    }

    public void navigateToProfileScreen(String existingAccountEmail, String existingAccountPassword) throws IOException {

        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickContinueWithEmail();
        signInWithExistingAccountActions.clickSignIn(existingAccountEmail, existingAccountPassword);
    }

    //verify entered email address is present in edit screen
    public void verifyEnteredEmailIsSimilar(String existingAccountEmail)
    {
        driver.findElement(loggedInUserLocators.profileLink).click();
        WebElement editProfileEmail = driver.findElement(editProfileLocators.editProfileEmail);
        String editProfileEmailAttribute = editProfileEmail.getAttribute("value");

        if(editProfileEmailAttribute.equalsIgnoreCase(existingAccountEmail))
        {
            Assert.assertTrue(true, "Functionality os working as expected");
        }
        else
        {
            Assert.assertTrue(false, "Functionality is not working as expected");
        }
    }

    //Edit FirstName
    public void editFirstName(String newFirstName)
    {
        editProfileFields(editProfileLocators.editProfileFirstnameInput,  newFirstName);
    }

    //edit fields
    public void editProfileFields(By element, String requiredFieldData)
    {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(requiredFieldData);
    }

    //String existingAccountEmail, String existingAccountPassword, String createAccount, String createAccountPassword, String createAccountConfirmPassword,
    //                                  String firstName, String lastName, String mobileNumber, String streetAddress, String city, String state, String zipcode) throws IOException {
    //

}
