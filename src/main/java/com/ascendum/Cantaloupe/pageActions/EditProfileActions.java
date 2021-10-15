package com.ascendum.Cantaloupe.pageActions;

import com.ascendum.Cantaloupe.base.BaseActions;
import com.ascendum.Cantaloupe.base.TestBase;
import com.ascendum.Cantaloupe.pageLocators.EditProfileLocators;
import com.ascendum.Cantaloupe.pageLocators.LoggedInUserLocators;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class EditProfileActions extends TestBase {

    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();
    EditProfileLocators editProfileLocators = new EditProfileLocators();
    LoggedInUserLocators loggedInUserLocators = new LoggedInUserLocators();
    BaseActions baseActions = new BaseActions();

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
        WebElement firstName = driver.findElement(editProfileLocators.editProfileFirstnameInput);
        TouchAction touchActions = new TouchAction(driver);
        touchActions.tap(firstName);
        baseActions.deleteInputCharacters(editProfileLocators.editProfileFirstnameInput);
        firstName.sendKeys(newFirstName);
        driver.findElement(editProfileLocators.editProfileFirstnameInput);
    }

    //Edit LastName
    public void editLastName(String newLastName)
    {
        baseActions.EditAndUpdateInputFields(editProfileLocators.editProfileLastNameInput, newLastName);
    }

    //Edit Mobile Number
    public void editMobileNumber(String mobileNumber)
    {
        baseActions.EditAndUpdateInputFields(editProfileLocators.editProfileMobileNoInput, mobileNumber);
    }

    //Edit Street Address
    public void editStreetAddress(String streetAddress)
    {
        baseActions.EditAndUpdateInputFields(editProfileLocators.editProfileStreetAddressInput, streetAddress);
    }

    //Edit City
    public void editCity(String city)
    {
        baseActions.EditAndUpdateInputFields(editProfileLocators.editProfileCityInput, city);
    }

    //Edit State
    public void editState(String state)
    {
        baseActions.EditAndUpdateInputFields(editProfileLocators.editProfileStateInput, state);
    }

    //Edit Zipcode
    public void editZipcode(String zipcode)
    {
        baseActions.EditAndUpdateInputFields(editProfileLocators.editProfileZipcodeInput, zipcode);
    }

    //Verify if the update button is in enabled mode after clicking on Profile link
    public void verifyUpdateButton()
    {
        WebElement updateButton = driver.findElement(editProfileLocators.editProfileUpdateButton);
        updateButton.isEnabled();
        updateButton.click();

        if(driver.findElement(By.xpath("//div[@id='3vng9nklu']")).isDisplayed())
        {
            Assert.assertTrue(true, "Profile is updated succesffully");
        }
        else
        {
            Assert.assertTrue(false, "Profile is not updated succesffully");
        }
    }

}
