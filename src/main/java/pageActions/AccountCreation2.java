package pageActions;

import base.BaseActions;
import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.AccountCreationLocators;
import java.awt.*;
import java.io.IOException;



public class AccountCreation2 extends TestBase {

    BaseActions baseActions = new BaseActions();
    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
    AccountCreation1 accountCreation1 = new AccountCreation1();


    public AccountCreation2() throws IOException {
    }


    // validate if entered email displays on create account screen
    public String enteredEmaiCheck(String emailValue) {
        Boolean emailStatus = driver.findElement(accountCreationLocators.emailIdInputField).isDisplayed();
        if (emailStatus == true) {
            String enteredEmailValue = driver.findElement(accountCreationLocators.emailIdInputField).getAttribute("value");
            Assert.assertEquals(emailValue, enteredEmailValue);
            accountCreation1.verrifyTickMark();
        } else {
            Assert.assertTrue(false, "the entered email and new email are not a match");
        }
        accountCreation1.verifyNextButtonEnabled();
        String emaiOnScreen2 = driver.findElement(accountCreationLocators.emailIdInputField).getAttribute("value");
        if(emaiOnScreen2.equalsIgnoreCase(emailValue))
        {
            Assert.assertTrue(true, "Email check on screen 2 is valid");
            accountCreation1.verrifyTickMark();
        }
        else
        {
            Assert.assertTrue(false, "Both the emails are not a match");
        }
        return emailValue;
    }

    //Verify that the user is able to edit the email input field on screen 2
    public void verifyEmailIsEditable(String editEmail)
    {
        try {
            WebElement emailField = driver.findElement(accountCreationLocators.emailIdInputField);
            if (emailField.isDisplayed()) {
                baseActions.randomClickBasedOnOS();
                baseActions.clearInputfieldAndEnterNewData(emailField, editEmail);
            }
        }
        catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    //Enter data in password fields;
    public void enterPassword(String password)
    {
       baseActions.regexPassword(accountCreationLocators.createPassowrd, password);
       //Include spl character ` - should not be allowed
    }

    //MaskedPassword for create Password
    public void checkPasswordMasked(String password)
    {
        baseActions.checkPasswordMaskedOrNot(accountCreationLocators.createPassowrd);
    }

    //MaskedPassword for Confirm Password
    public void createPasswordMasked(String password)
    {
        baseActions.checkPasswordMaskedOrNot(accountCreationLocators.confirmPassword);
    }

    //check if error message is shown when the password criteria is not met
    public void validateErrorMessageForPassword(String wrongPassword) throws AWTException {
       driver.findElement(accountCreationLocators.createPassowrd).sendKeys(wrongPassword);
        baseActions.randomClickBasedOnOS();
        WebElement passwordError = driver.findElement(accountCreationLocators.passwordErrorCriteria);

        Boolean status = passwordError.isDisplayed();
        if(status == true)
        {
            baseActions.randomClickBasedOnOS();
            Assert.assertTrue(true, "Password criteria is validated");
        }
        else
        {
            Assert.assertTrue(false, "Password criteria is validated");
        }
    }

    //Try wrong password
    public void tryWrongPassword(String wrongPassword)
    {
        baseActions.enterValue(accountCreationLocators.createPassowrd,wrongPassword);
    }

    //Try wrong confirm password
    public void tryConfirmPassword(String wrongPassword)
    {
        baseActions.enterValue(accountCreationLocators.createPassowrd,wrongPassword);
    }

    //check if error message is shown when the password criteria is not met
    public void validateErrorMessageForConfirmPassword(String wrongPassword) throws AWTException {
        driver.findElement(accountCreationLocators.confirmPassword).sendKeys(wrongPassword);
        WebElement passwordError = driver.findElement(accountCreationLocators.passwordDoNotMatchError);

        if(passwordError.isDisplayed())
        {
            baseActions.randomClickBasedOnOS();
            Boolean passwordPresent = passwordError.isDisplayed();
            Assert.assertTrue(passwordPresent == true, "Password criteria is validated");
        }
        else
        {
            Assert.assertTrue((driver.findElement(accountCreationLocators.passwordDoNotMatchError).isDisplayed()), "Password criteria is validated");
        }

    }

    public void clickShowPassword()
    {
        baseActions.clickButton(accountCreationLocators.showPassword);
    }

    public void clickHidePassword()
    {
        baseActions.clickButton(accountCreationLocators.hidePassword);
    }

    //Verify that password and confirm password are a match
    public void verifyPasswordAndConfirmPassword(String password, String confirm)
    {
        baseActions.enterValue(accountCreationLocators.createPassowrd, password);
        baseActions.enterValue(accountCreationLocators.confirmPassword, confirm);
        String createpPassword = driver.findElement(accountCreationLocators.createPassowrd).getText();
        String confirmPassword = driver.findElement(accountCreationLocators.createPassowrd).getText();
        Assert.assertEquals(createpPassword, confirmPassword);
    }


    //Verify Personal details
    public void verifyFirstNameInput(String firstname) throws AWTException {
        baseActions.clickButton(accountCreationLocators.firstnameInput);
        baseActions.randomClickBasedOnOS();
        baseActions.validateErrorMessages(accountCreationLocators.firstNameError);
        baseActions.enterValue(accountCreationLocators.firstnameInput, firstname);
    }


    public void verifyLastNameInput(String lastname) throws AWTException {
        baseActions.clickButton(accountCreationLocators.lastNameInput);
        baseActions.randomClickBasedOnOS();
        baseActions.validateErrorMessages(accountCreationLocators.lastNameError);
        baseActions.enterValue(accountCreationLocators.lastNameInput, lastname);

    }

    //verify errors
    public void verifyPhoneNoInput(String phoneNo) throws AWTException {
        driver.findElement(accountCreationLocators.phoneNoInput).sendKeys("A");
        baseActions.randomClickBasedOnOS();
        baseActions.validateErrorMessages(accountCreationLocators.invalidMobileError);
        baseActions.regexPhoneno(accountCreationLocators.phoneNoInput, phoneNo);
    }

    //verify address
    public void verifyAddressInput(String streetAddress, String city, String state, String zipcode ) throws AWTException {
        driver.findElement(accountCreationLocators.streetAddressInput).sendKeys("");
        baseActions.randomClickBasedOnOS();
        baseActions.validateErrorMessages(accountCreationLocators.blankStreetError);
        baseActions.regexAddress(accountCreationLocators.streetAddressInput, streetAddress);

        driver.findElement(accountCreationLocators.cityInput).sendKeys("");
        baseActions.randomClickBasedOnOS();
        baseActions.validateErrorMessages(accountCreationLocators.blankCityError);
        baseActions.regexCity(accountCreationLocators.cityInput, city);

        driver.findElement(accountCreationLocators.stateInput).sendKeys("");
        baseActions.randomClickBasedOnOS();
        baseActions.validateErrorMessages(accountCreationLocators.blankStateError);
        baseActions.regexState(accountCreationLocators.stateInput, state);

        driver.findElement(accountCreationLocators.zipcodeInput).sendKeys("");
        baseActions.randomClickBasedOnOS();
        baseActions.validateErrorMessages(accountCreationLocators.blankZipcodeError);
        baseActions.regexZipcode(accountCreationLocators.zipcodeInput, zipcode);
    }

    //check the checkbox
    public void checkbox()
    {
        driver.findElement(accountCreationLocators.completeButton).click();
        Boolean checkboxErrorStatus = driver.findElement(accountCreationLocators.checkBoxErrorMessage).isDisplayed();// WebElement checkboxStatus = driver.findElement(accountCreationLocators.checkboxForTerms);
        if(checkboxErrorStatus == true)
        {
            Assert.assertTrue(checkboxErrorStatus, "Check box is unchecked");
            baseActions.clickButton(accountCreationLocators.checkboxForTerms);
        }
        else
        {
            Assert.assertTrue(true, "Checkbox is already checked");
        }

    }

    //verify the UI elements for consent and terms/Privacy
    public void verifyTermsAndPrivacy()
    {
       WebElement readAgreeText =  driver.findElement(accountCreationLocators.readAndAgreeText);
        WebElement termsLink = driver.findElement(accountCreationLocators.termsOfUseLink);
        WebElement privacyLink = driver.findElement(accountCreationLocators.privacyPolicyLink);

        if ((readAgreeText.isDisplayed()) && (termsLink.isEnabled()) && (privacyLink.isEnabled()))
        {
            WebElement completeButtonEnabled = driver.findElement(accountCreationLocators.completeButton);
            Boolean complteButtonStatus = completeButtonEnabled.isEnabled();
            Assert.assertTrue(complteButtonStatus==true, "Complete button is enabled");
        }
    }

    public void clickCompleteButton()
    {
        driver.findElement(accountCreationLocators.completeButton).click();
    }












}
