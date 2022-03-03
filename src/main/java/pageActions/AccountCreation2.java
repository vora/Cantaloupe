package pageActions;

import base.BaseActions;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.AccountCreationLocators;
import pageLocators.CreateAccountLocators;
import pageLocators.LandingScreen;

import java.io.IOException;
import java.util.Properties;


public class AccountCreation2 extends TestBase {

    Properties prop = new Properties();
    BaseActions baseActions = new BaseActions();
    LandingScreen loginScreen = new LandingScreen();
    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
    AccountCreation1 accountCreation1 = new AccountCreation1();
    CreateAccountLocators createAccountLocators = new CreateAccountLocators();


    // WebDriverWait wait = new WebDriverWait(driver,20);

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
                driver.findElement(By.xpath("//html")).click();
                baseActions.clearInputfieldAndEnterNewData(emailField, editEmail);
            }
        }
        catch(Exception e)
            {
                e.printStackTrace();
            }
        // Assert.assertEquals(editEmail, enteredEditedEmail);

    }

    //Enter data in password fields;
    public void enterPassword(String password)
    {
       baseActions.regexPassword(createAccountLocators.createPassowrd, password);
    //Include spl character ` - should not be allowed
    }

    //MaskedPassword for create Password
    public void checkPasswordMasked(String password)
    {
        baseActions.checkPasswordMaskedOrNot(createAccountLocators.createPassowrd);
    }

    //MaskedPassword for Confirm Password
    public void createPasswordMasked(String password)
    {
        baseActions.checkPasswordMaskedOrNot(createAccountLocators.confirmPassword);
    }

    //check if error message is shown when the password criteria is not met
    public void validateErrorMessageForPassword(String wrongPassword)
    {
       driver.findElement(createAccountLocators.createPassowrd).sendKeys(wrongPassword);
        WebElement passwordError = driver.findElement(createAccountLocators.emailErrorMessage);

        if(passwordError.isDisplayed())
        {
            driver.findElement(By.xpath("//html")).click();
            Assert.assertTrue((driver.findElement(createAccountLocators.passwordErrorCriteria).isDisplayed()), "Password criteria is validated");
        }
        else
        {
            Assert.assertTrue((driver.findElement(createAccountLocators.passwordErrorCriteria).isDisplayed()), "Password criteria is validated");

        }

    }

    //Try wrong password
    public void tryWrongPassword(String wrongPassword)
    {
        baseActions.enterValue(createAccountLocators.createPassowrd,wrongPassword);
    }

    //Try wrong confirm password
    public void tryConfirmPassword(String wrongPassword)
    {
        baseActions.enterValue(createAccountLocators.createPassowrd,wrongPassword);
    }

    //check if error message is shown when the password criteria is not met
    public void validateErrorMessageForConfirmPassword(String wrongPassword)
    {
        driver.findElement(createAccountLocators.confirmPassword).sendKeys(wrongPassword);
        WebElement passwordError = driver.findElement(createAccountLocators.passwordDoNotMatchError);

        if(passwordError.isDisplayed())
        {
            driver.findElement(By.xpath("//html")).click();
            Boolean passwordPresent = passwordError.isDisplayed();
            Assert.assertTrue(passwordPresent == true, "Password criteria is validated");
        }
        else
        {
            Assert.assertTrue((driver.findElement(createAccountLocators.passwordDoNotMatchError).isDisplayed()), "Password criteria is validated");

        }

    }

    public void clickShowPassword()
    {
        baseActions.clickButton(createAccountLocators.showPassword);
       // driver.findElement(By.xpath("//span[contains(text(),'Show')]")).click();
    }

    public void clickHidePassword()
    {
        baseActions.clickButton(createAccountLocators.hidePassword);
    }

    //Verify that password and confirm password are a match
    public void verifyPasswordAndConfirmPassword(String password, String confirm)
    {
        baseActions.enterValue(createAccountLocators.createPassowrd, password);
        baseActions.enterValue(createAccountLocators.confirmPassword, confirm);
        String createpPassword = driver.findElement(createAccountLocators.createPassowrd).getText();
        String confirmPassword = driver.findElement(createAccountLocators.createPassowrd).getText();

        Assert.assertEquals(createpPassword, confirmPassword);
    }


    //Verify Personal details
    public void verifyFirstNameInput(String firstname)
    {
        baseActions.clickButton(createAccountLocators.firstnameInput);
        driver.findElement(By.xpath("//html")).click();
        baseActions.validateErrorMessages(createAccountLocators.firstNameError);
        baseActions.enterValue(createAccountLocators.firstnameInput, firstname);
    }


    public void verifyLastNameInput(String lastname)
    {
        baseActions.clickButton(createAccountLocators.lastNameInput);
        driver.findElement(By.xpath("//html")).click();
        baseActions.validateErrorMessages(createAccountLocators.lastNameError);
        baseActions.enterValue(createAccountLocators.lastNameInput, lastname);

    }

    //verify errors
    public void verifyPhoneNoInput(String phoneNo)
    {
       driver.findElement(createAccountLocators.phoneNoInput).sendKeys("A");
        driver.findElement(By.xpath("//html")).click();
        baseActions.validateErrorMessages(createAccountLocators.invalidMobileError);
        baseActions.regexPhoneno(createAccountLocators.phoneNoInput, phoneNo);
    }

    //verify address
    public void verifyAddressInput(String streetAddress, String city, String state, String zipcode )
    {
        driver.findElement(createAccountLocators.streetAddressInput).sendKeys("");
        driver.findElement(By.xpath("//html")).click();
        baseActions.validateErrorMessages(createAccountLocators.blankStreetError);
        baseActions.regexAddress(createAccountLocators.streetAddressInput, streetAddress);

        driver.findElement(createAccountLocators.cityInput).sendKeys("");
        driver.findElement(By.xpath("//html")).click();
        baseActions.validateErrorMessages(createAccountLocators.blankCityError);
        baseActions.regexCity(createAccountLocators.cityInput, city);

        driver.findElement(createAccountLocators.stateInput).sendKeys("");
        driver.findElement(By.xpath("//html")).click();
        baseActions.validateErrorMessages(createAccountLocators.blankStateError);
        baseActions.regexState(createAccountLocators.stateInput, state);

        driver.findElement(createAccountLocators.zipcodeInput).sendKeys("");
        driver.findElement(By.xpath("//html")).click();
        baseActions.validateErrorMessages(createAccountLocators.blankZipcodeError);
        baseActions.regexZipcode(createAccountLocators.zipcodeInput, zipcode);
    }

    //check the checkbox
    public void checkbox()
    {
        driver.findElement(createAccountLocators.completeButton).click();
        WebElement checkboxStatus = driver.findElement(createAccountLocators.checkboxForTerms);
        Boolean checkboxErrorStatus = driver.findElement(createAccountLocators.checkBoxErrorMessage).isDisplayed();

        if(!(checkboxStatus.isSelected()) && checkboxErrorStatus == true)
        {
            Assert.assertTrue(checkboxErrorStatus, "Check box is unchecked");
            baseActions.clickButton(createAccountLocators.checkboxForTerms);
        }
        else
        {
            Assert.assertTrue(true, "Checkbox is already checked");
        }

    }

    //verify the UI elements for consent and terms/Privacy
    public void verifyTermsAndPrivacy()
    {
       WebElement readAgreeText =  driver.findElement(createAccountLocators.readAndAgreeText);
        WebElement termsLink = driver.findElement(createAccountLocators.termsOfUseLink);
        WebElement privacyLink = driver.findElement(createAccountLocators.privacyPolicyLink);

        if ((readAgreeText.isDisplayed()) && (termsLink.isEnabled()) && (privacyLink.isEnabled()))
        {
            WebElement completeButtonEnabled = driver.findElement(createAccountLocators.completeButton);
            Boolean complteButtonStatus = completeButtonEnabled.isEnabled();
            Assert.assertTrue(complteButtonStatus==true, "Complete button is enabled");
        }
    }

    public void clickCompleteButton()
    {
        driver.findElement(createAccountLocators.completeButton).click();
    }











}
