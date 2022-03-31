package tests;

import base.BaseActions;
import base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageActions.AccountCreation1;
import pageActions.AccountCreation2;

import java.awt.*;
import java.io.IOException;

public class AccountCreation2Test extends TestBase {

    AccountCreation1 accountCreation1 = new AccountCreation1();
    AccountCreation2 accountCreation2 = new AccountCreation2();
    BaseActions baseActions = new BaseActions();


    public AccountCreation2Test() throws IOException {
    }

    @Test

    //Validate all errors such as empty input field, then error message, then existing email error message and login button flow
    public void verifyEmailValidationFlow() throws IOException, AWTException
    {
        // Verify email entered, tick mark
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation2.enteredEmaiCheck(properties.getProperty("createNewEmail"));

    }

    //Verify if the email is editable
    @Test

    //Validate all errors such as empty input field, then error message, then existing email error message and login button flow
    public void verifyEmailIsEditable() throws IOException, AWTException
    {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation2.enteredEmaiCheck(properties.getProperty("createNewEmail"));
        accountCreation2.verifyEmailIsEditable(properties.getProperty("existingAccountEmail"));
    }

    //Verify wrong password fields
    @Test
    public void verifyPassword() throws IOException, AWTException
    {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation1.verrifyTickMark();
        accountCreation1.verifyNextButtonEnabled();
        accountCreation2.tryWrongPassword(properties.getProperty("wrongPassword"));
        baseActions.clearData(driver.findElement(By.id("id_password")));
        accountCreation2.validateErrorMessageForPassword(properties.getProperty("wrongPassword"));
        accountCreation2.tryConfirmPassword(properties.getProperty("wrongPassword"));
        accountCreation2.validateErrorMessageForConfirmPassword(properties.getProperty("wrongPassword"));
    }

    //Verify if both the password and confirm password matches adn click on show icon and hide icon
    @Test
    public void showPasswordAndHide() throws IOException, AWTException
    {
        verifyPassword();
        accountCreation2.clickShowPassword();
        accountCreation2.clickHidePassword();
    }

    //verify if the password and confirm passwords are a match
    @Test
    public void verifyPasswords() throws AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));

        accountCreation1.verrifyTickMark();
        accountCreation1.verifyNextButtonEnabled();
        accountCreation2.enterPassword(properties.getProperty("createAccountPassword"));
        accountCreation2.verifyPasswordAndConfirmPassword(properties.getProperty("createAccountPassword"), properties.getProperty("createAccountConfirmPassword"));
    }

    //verify personal details section
    @Test
    public void verifyPersonalDetailsSection() throws IOException, AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation1.verrifyTickMark();
        accountCreation1.verifyNextButtonEnabled();
        accountCreation2.verifyPasswordAndConfirmPassword(properties.getProperty("createAccountPassword"), properties.getProperty("createAccountConfirmPassword"));
        accountCreation2.verifyFirstNameInput(properties.getProperty("firstName"));
        accountCreation2.verifyLastNameInput(properties.getProperty("lastName"));
        accountCreation2.verifyPhoneNoInput(properties.getProperty("mobileNumber"));
        accountCreation2.verifyAddressInput(properties.getProperty("streetAddress"), properties.getProperty("city"), properties.getProperty("state"), properties.getProperty("zipcode"));
    }


    //verify if checkbox is not checked and validate the links
    @Test
    public void verifyConsentSection() throws IOException, AWTException {
        verifyPersonalDetailsSection();
        accountCreation2.checkbox();
        accountCreation2.verifyTermsAndPrivacy();
        accountCreation2.clickCompleteButton();

    }

}
