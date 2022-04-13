package tests;

import base.BaseActions;
import base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageActions.AccountCreation1;
import pageActions.AccountCreation;
import pageActions.SignInWithExistingAccountActions;
import pageLocators.AccountCreationLocators;

import java.awt.*;
import java.io.IOException;

public class AccountCreationTest extends TestBase {

    AccountCreation1 accountCreation1 = new AccountCreation1();
    AccountCreation accountCreation = new AccountCreation();
    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();
    BaseActions baseActions = new BaseActions();


    public AccountCreationTest() throws IOException {
    }

    @Test
    //Validate all errors such as empty input field, then error message, then existing email error message and login button flow
    public void errorValidations() throws AWTException {

        //Regex, error message,enter email, tick mark, check for existing email error, allow to login, if new email - allow user to next screen
        accountCreation.validateEmptyField();
        accountCreation.verifyNextButtonEnabled();
    }

    //Validate create new email, tick mark, next button enabled and screen 2
    @Test
    public void newAccountCreation() throws AWTException {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.verrifyTickMark();
        accountCreation.verifyNextButtonEnabled();
    }

    @Test
    public void verifyPrefilledEmail_CreationFlow() throws AWTException {
        newAccountCreation();
        accountCreation.prefilledEmail(properties.getProperty("createNewEmail"));
        accountCreation.verifyEmailIsEditable();
        accountCreation.verifyPlaceHolders();
    }



    //Validate create new email, tick mark, next button enabled and screen 2
    @Test
    public void verifyBackLinkFunctionality() throws AWTException {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.clickBackHomeLink();
    }

    //
    @Test
    public void validateExisting_EmailError() throws AWTException {
        accountCreation.clickCreateButton();
        accountCreation.existingEmailError_AccountCreation(properties.getProperty("existingAccountEmail"));
    }

    // validate login through existing user
    @Test
    public void existingEmaillowLogin() throws IOException, AWTException {
        accountCreation.clickCreateButton();
        accountCreation.loginThroughExistingEmail(properties.getProperty("existingAccountEmail"), properties.getProperty("regexEmail"));
        signInWithExistingAccountActions.verifySignInDisabled();
    }

    @Test

    //Validate all errors such as empty input field, then error message, then existing email error message and login button flow
    public void verifyEmailFieldInputData() throws IOException, AWTException
    {
        // Verify email entered, tick mark
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.enteredEmaiCheck(properties.getProperty("createNewEmail"));

    }

    //Verify if the email is editable
    @Test

    //Validate all errors such as empty input field, then error message, then existing email error message and login button flow
    public void verifyEmailIsEditable() throws IOException, AWTException
    {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.verifyNextButtonEnabled();
        accountCreation.verrifyTickMark();
        //Feedback - assert text entered n getAttribute - Remove js
        //accountCreation.enteredEmaiCheck(properties.getProperty("createNewEmail"));
        accountCreation.verifyEmailIsEditable(properties.getProperty("existingAccountEmail"));
    }

    //Verify wrong password fields
    @Test
    public void verifyPassword() throws IOException, AWTException
    {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.verifyNextButtonEnabled();
        accountCreation.tryWrongPassword(properties.getProperty("wrongPassword"));
        baseActions.clearData(driver.findElement(By.id("id_password")));
        accountCreation.validateErrorMessageForPassword(properties.getProperty("wrongPassword"));
        accountCreation.tryConfirmPassword(properties.getProperty("wrongPassword"));
        accountCreation.validateErrorMessageForConfirmPassword(properties.getProperty("wrongPassword"));
    }

    //Verify if both the password and confirm password matches adn click on show icon and hide icon
    @Test
    public void showPasswordAndHide() throws IOException, AWTException
    {
        verifyPassword();
        accountCreation.clickShowPassword();
        accountCreation.clickHidePassword();
    }

    @Test
    //Check if password/confirmPassword fields are editable, masked
    public void checkPasswordFields() throws AWTException {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.verifyNextButtonEnabled();
        accountCreation.isPasswordFieldEditable();
        accountCreation.isConfirmPasswordFieldEditable();
        accountCreation.checkPasswordMasked();
        accountCreation.confirmPasswordMasked();

    }

    //verify if the password and confirm passwords are a match
    @Test
    public void verifyPasswordAndConfirmPassword() throws AWTException {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));

        accountCreation.verrifyTickMark();
        accountCreation.verifyNextButtonEnabled();
        accountCreation.enterPassword(properties.getProperty("createAccountPassword"));
        accountCreation.checkPasswordMasked();
        accountCreation.isConfirmPasswordFieldEditable();
        accountCreation.verifyPasswordAndConfirmPassword(properties.getProperty("createAccountPassword"), properties.getProperty("createAccountConfirmPassword"));
    }

    //verify personal details section
    @Test
    public void verifyPersonalDetailsSection() throws IOException, AWTException {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.verrifyTickMark();
        accountCreation.verifyNextButtonEnabled();
        accountCreation.verifyPasswordAndConfirmPassword(properties.getProperty("createAccountPassword"), properties.getProperty("createAccountConfirmPassword"));
        accountCreation.verifyFirstNameInput(properties.getProperty("firstName"));
        accountCreation.verifyLastNameInput(properties.getProperty("lastName"));
        accountCreation.verifyPhoneNoInput();
        accountCreation.verifyAddressInput(properties.getProperty("streetAddress"), properties.getProperty("city"), properties.getProperty("state"), properties.getProperty("zipcode"));
    }


    //verify if checkbox is not checked and validate the links
    @Test
    public void verifyConsentSection() throws IOException, AWTException {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.verrifyTickMark();
        accountCreation.verifyNextButtonEnabled();
        accountCreation.verifyPasswordAndConfirmPassword(properties.getProperty("createAccountPassword"), properties.getProperty("createAccountConfirmPassword"));
        accountCreation.verifyFirstNameInput(properties.getProperty("firstName"));
        accountCreation.verifyLastNameInput(properties.getProperty("lastName"));
        accountCreation.verifyPhoneNoInput();
        accountCreation.verifyAddressInput(properties.getProperty("streetAddress"), properties.getProperty("city"), properties.getProperty("state"), properties.getProperty("zipcode"));
        accountCreation.isCheckboxPreChecked();
        accountCreation.verifyTermsAndPrivacy();
    }

    @Test
    public void completeRegistration() throws IOException, AWTException {
        verifyConsentSection();
        accountCreation.clickCompleteButton();
        accountCreation.confirmRegistration();

    }

    //Verify if all the fields are in editable mode
    @Test
    public void verifyIfFieldsAreEditable() throws IOException, AWTException {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.isEmailFieldEditable();
        accountCreation.isPasswordFieldEditable();
        accountCreation.isConfirmPasswordFieldEditable();
        accountCreation.isFirstNameEditable();
        accountCreation.isLastNameEditable();
        accountCreation.isMobileEditable();
        accountCreation.isStreetAddressEditable();
        accountCreation.isCityEditable();
        accountCreation.isStateEditable();
        accountCreation.isZipcodeEditable();
    }

    @Test
    public void verifyFirstAndLastNameRegex() throws AWTException {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.verifyNextButtonEnabled();
        accountCreation.verifyFirstNameRegex();
        accountCreation.verifyFirstNameRegex();
    }

    @Test
    public void verifyMobile() throws AWTException {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.verifyNextButtonEnabled();
        accountCreation.enterData(accountCreationLocators.phoneNoInput, properties.getProperty("mobileNumber"));
        accountCreation.regexPhoneNo();
        accountCreation.verifyPhoneNoFormat();
    }

    @Test
    public void verifyMobileUniqueNessAndError() throws AWTException {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.verifyNextButtonEnabled();
        accountCreation.enterData(accountCreationLocators.phoneNoInput, properties.getProperty("mobileNumber"));
        accountCreation.regexPhoneNo();
        accountCreation.verifyPhoneNoFormat();
        try {
            accountCreation.verifyMobileUniquesNessTick();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try {
            accountCreation.verifyMobileUniqueNessError();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Test
    public void verifyError_After10DigitsInputOnly() throws AWTException {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.verifyNextButtonEnabled();
        accountCreation.enterData(accountCreationLocators.phoneNoInput, properties.getProperty("existingMobileNo"));
        accountCreation.verifyErrorAfter10DigitsEntry();

    }

    @Test
    public void verifyAddressFields() throws AWTException {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.verifyNextButtonEnabled();
        accountCreation.enterAddressDetails();
        accountCreation.regexCompleteAddress();
    }

    @Test
    public void verifyTOC_PPNavigations() throws AWTException {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.verifyNextButtonEnabled();
        baseActions.scrollDown();
        accountCreation.navigateToTOC();
        accountCreation.navigateBackToRegistration();
        accountCreation.navigateToPP();
        accountCreation.navigateBackToRegistration();
    }

    @Test
    public void checkInputsBeforeAndAfterNavigations() throws AWTException {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.verrifyTickMark();
        accountCreation.verifyNextButtonEnabled();
        accountCreation.verifyPasswordAndConfirmPassword(properties.getProperty("createAccountPassword"), properties.getProperty("createAccountConfirmPassword"));
        accountCreation.verifyFirstNameInput(properties.getProperty("firstName"));
        accountCreation.verifyLastNameInput(properties.getProperty("lastName"));
        accountCreation.verifyPhoneNoInput();
        accountCreation.verifyAddressInput(properties.getProperty("streetAddress"), properties.getProperty("city"), properties.getProperty("state"), properties.getProperty("zipcode"));
        accountCreation.isCheckboxPreChecked();
        accountCreation.verifyTermsAndPrivacy();
        accountCreation.checkInputsAfterNavigation();
    }

    @Test
    public void verifyScreenForSignInSignOut() throws IOException, AWTException {
        accountCreation.verifyScreenForSignInAndOut();
    }

    @Test
    public void backToLoginLink() throws AWTException {
        accountCreation.clickCreateButton();
        accountCreation.validateEmailCriteria(properties.getProperty("createNewEmail"), properties.getProperty("regexEmail"));
        accountCreation.verrifyTickMark();
        accountCreation.verifyNextButtonEnabled();
        baseActions.scrollDown();
        accountCreation.clickBackToLoginOptions();
    }


}
