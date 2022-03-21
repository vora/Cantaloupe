package tests;

import base.BaseActions;
import base.DataProvider;
import base.TestBase;
import base.TestBase1;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageActions.AccountCreation1;
import pageActions.AccountCreation2;
import pageActions.SignInWithExistingAccountActions;
import resources.FinalConstants;

import java.awt.*;
import java.io.IOException;

public class AccountCreation2Test extends TestBase1 {

    AccountCreation1 accountCreation1 = new AccountCreation1();
    AccountCreation2 accountCreation2 = new AccountCreation2();
    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();
    BaseActions baseActions = new BaseActions();

    public AccountCreation2Test() throws IOException {
    }

    @Test

    //Validate all errors such as empty input field, then error message, then existing email error message and login button flow
    public void verifyEmailValidationFlow()throws IOException {

        // Verify email entered, tick mark
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(FinalConstants.createNewEmail, FinalConstants.regexEmail);
        accountCreation2.enteredEmaiCheck(FinalConstants.createNewEmail);

    }

    //Verify if the email is editable
    @Test

    //Validate all errors such as empty input field, then error message, then existing email error message and login button flow
    public void verifyEmailIsEditable() throws IOException {

        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(FinalConstants.createNewEmail, FinalConstants.regexEmail);
        accountCreation2.enteredEmaiCheck(FinalConstants.createNewEmail);
        accountCreation2.verifyEmailIsEditable(FinalConstants.existingAccountEmail);
    }

    //Verify wrong password fields
    @Test
    public void verifyPassword() throws IOException, AWTException {

        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(FinalConstants.createNewEmail, FinalConstants.regexEmail);
        accountCreation1.verrifyTickMark();
        accountCreation1.verifyNextButtonEnabled();
        accountCreation2.tryWrongPassword(FinalConstants.wrongPassword);
        baseActions.clearData(driver.findElement(By.id("id_password")));
        accountCreation2.validateErrorMessageForPassword(FinalConstants.wrongPassword);
        accountCreation2.tryConfirmPassword(FinalConstants.wrongPassword);
        accountCreation2.validateErrorMessageForConfirmPassword(FinalConstants.wrongPassword);
    }

    //Verify if both the password and confirm password matches adn click on show icon and hide icon
    @Test
    public void showPasswordAndHide() throws IOException, AWTException {

        verifyPassword();
        accountCreation2.clickShowPassword();
        accountCreation2.clickHidePassword();
    }

    //verify if the password and confirm passwords are a match
    @Test
    public void verifyPasswords()
    {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(FinalConstants.createNewEmail, FinalConstants.regexEmail);
        accountCreation1.verrifyTickMark();
        accountCreation1.verifyNextButtonEnabled();
        accountCreation2.enterPassword(FinalConstants.createAccountPassword);
        accountCreation2.verifyPasswordAndConfirmPassword(FinalConstants.createAccountPassword, FinalConstants.createAccountConfirmPassword);
    }

    //verify personal details section
    @Test
    public void verifyPersonalDetailsSection() throws IOException, AWTException {
        accountCreation1.clickCreateButton();
        accountCreation1.validateEmailCriteriaField(FinalConstants.createNewEmail, FinalConstants.regexEmail);
        accountCreation1.verrifyTickMark();
        accountCreation1.verifyNextButtonEnabled();
        accountCreation2.verifyPasswordAndConfirmPassword(FinalConstants.createAccountPassword, FinalConstants.createAccountConfirmPassword);
        accountCreation2.verifyFirstNameInput(FinalConstants.firstName);
        accountCreation2.verifyLastNameInput(FinalConstants.lastName);
        accountCreation2.verifyPhoneNoInput(FinalConstants.mobileNumber);
        accountCreation2.verifyAddressInput(FinalConstants.streetAddress, FinalConstants.city, FinalConstants.state, FinalConstants.zipcode);
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
