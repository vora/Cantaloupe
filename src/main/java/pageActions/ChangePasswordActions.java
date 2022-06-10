package pageActions;

import base.BaseActions;
import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.*;

import java.awt.*;
import java.io.IOException;

public class ChangePasswordActions extends TestBase {

    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();
    SignInWithExistingAccountLocators signInWithExistingAccountLocators = new SignInWithExistingAccountLocators();
    ForgotPasswordLocators forgotPasswordLocators = new ForgotPasswordLocators();
    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
    AccountCreation accountCreation = new AccountCreation();
    HomePageLocators homePageLocators = new HomePageLocators();
    ForgotPasswordActions forgotPasswordActions = new ForgotPasswordActions();
    BaseActions baseActions = new BaseActions();
    UpdateProfileLocators updateProfileLocators = new UpdateProfileLocators();
    ChangePasswordLocators changePasswordLocators = new ChangePasswordLocators();
    LoggedInUserLocators loggedInUserLocators = new LoggedInUserLocators();

    public ChangePasswordActions() throws IOException {
    }


    public void checkInputFieldIsEnabledAreEnabled()
    {
        baseActions.checkFieldsAreEditable(changePasswordLocators.oldPasswordInput, changePasswordLocators.createPasswordInput, changePasswordLocators.createPasswordInput);
    }

    public void verifyCreatePasswordErrors() throws AWTException
    {
        driver.findElement(changePasswordLocators.createPasswordInput).click();
        baseActions.randomClickBasedOnOS();
        baseActions.validateErrorMessages(changePasswordLocators.invalidErrorCreatePassword);
    }

    public void verifyConfirmPasswordErrors(String enterConfirmPassword) throws AWTException
    {
        driver.findElement(changePasswordLocators.createPasswordInput).click();
        baseActions.randomClickBasedOnOS();
        driver.findElement(changePasswordLocators.confirmPasswordInput).sendKeys(enterConfirmPassword);
        baseActions.validateErrorMessages(changePasswordLocators.invalidErrorConfirmPassword);
    }

    public void clickChangeButton()
    {
        baseActions.clickButton(updateProfileLocators.passwordChange);
    }

    public void clickUpdateButton()
    {
        baseActions.clickButton(updateProfileLocators.updateButton);
        Assert.assertTrue(driver.findElement(loggedInUserLocators.profileLink).isEnabled(), "User has updated the password successfully");
    }

    public void updateButtonStatus(String password, String confirmPassword)
    {
        forgotPasswordActions.updateButtonStatus(password, confirmPassword);
    }

    // verify regex for createPassword field
    public void regexCreatePassword(String enterCreatePassword)
    {
        boolean isPasswordValid = baseActions.regexPassword(changePasswordLocators.createPasswordInput,enterCreatePassword);
       if(isPasswordValid==true) {
           driver.findElement(changePasswordLocators.createPasswordInput).sendKeys(enterCreatePassword);
       }
       else
       {
           Assert.assertFalse(false, "Password did not meet the criteria or is invalid");
       }
    }

    // verify regex for confirmPassword field
    public void regexConfirmPassword(String enterConfirmPassword)
    {
        boolean isPasswordValid = baseActions.regexPassword(changePasswordLocators.confirmPasswordInput,enterConfirmPassword);
        if(isPasswordValid==true) {
            driver.findElement(changePasswordLocators.confirmPasswordInput).sendKeys(enterConfirmPassword);
        }
        else
        {
            Assert.assertFalse(false, "Password did not meet the criteria or is invalid");
        }
    }

    //verify if the password and the confirm password is a match
    public boolean verifyPasswordMatches(String password, String confirmPassword)
    {
        boolean isEqual = accountCreation.verifyPasswordAndConfirmPassword(password, confirmPassword);
        baseActions.clearData(driver.findElement(changePasswordLocators.createPasswordInput));
        baseActions.clearData(driver.findElement(changePasswordLocators.confirmPasswordInput));
        if(isEqual==true)
        {
            regexCreatePassword(password);
            regexCreatePassword(confirmPassword);
//            driver.findElement(changePasswordLocators.createPasswordInput).sendKeys(password);
//            driver.findElement(changePasswordLocators.confirmPasswordInput).sendKeys(confirmPassword);
        }
        return isEqual;
    }

    public void clickShowAndHide(String createAccountPassword, String createAccountConfirmPassword)
    {
        String editEmail = " ";
        accountCreation.verifyPasswordAndConfirmPassword(createAccountPassword, createAccountConfirmPassword);
        accountCreation.clickShowPassword();
        accountCreation.clickHidePassword();
    }

  public void verifyLoginwithNewPassword(String email, String password) throws IOException, AWTException {
        WebElement signInLink = driver.findElement(homePageLocators.alreadyHaveAnAccountLink);
        signInLink.isEnabled();
        signInLink.click();
        signInWithExistingAccountActions.clickSignIn(email, password);
    }

    public void verifyOldPassowrd_Updatedisable()
    {
        WebElement oldPasswordInput = driver.findElement(changePasswordLocators.oldPasswordInput);
        WebElement updatePassword = driver.findElement(changePasswordLocators.updateButton);
        oldPasswordInput.isEnabled();
        oldPasswordInput.click();
        String value = oldPasswordInput.getAttribute("value");
        Assert.assertTrue( value.equals(null) && updatePassword.isEnabled()==false, "Update password button should be in disabled mode until old password is entered");
    }

    public void verifyOldPassowrd_UpdateEnabled(String password)
    {
        WebElement oldPasswordInput = driver.findElement(changePasswordLocators.oldPasswordInput);
        WebElement updatePassword = driver.findElement(changePasswordLocators.updateButton);
        oldPasswordInput.isEnabled();
        oldPasswordInput.click();
        oldPasswordInput.sendKeys(password);
        Assert.assertTrue( updatePassword.isEnabled()==true, "Update password button should be in disabled mode until old password is entered");
    }



}

