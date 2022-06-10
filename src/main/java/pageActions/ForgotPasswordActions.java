package pageActions;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageLocators.AccountCreationLocators;
import pageLocators.HomePageLocators;
import pageLocators.SignInWithExistingAccountLocators;

import java.awt.*;
import java.io.IOException;

public class ForgotPasswordActions extends TestBase {

    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();
    SignInWithExistingAccountLocators signInWithExistingAccountLocators = new SignInWithExistingAccountLocators();
    ForgotPasswordLocators forgotPasswordLocators = new ForgotPasswordLocators();
    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
    AccountCreation accountCreation2 = new AccountCreation();
    HomePageLocators homePageLocators = new HomePageLocators();
    public ForgotPasswordActions() throws IOException {
    }

    /*
    TC_01
    Verify that, clicking on "Forgot password" button directs the user to forgot password screen
    Verify that, user is able to input the email in the "Email id" field
    Verify that the "Send me a reset link" button is deactivated if the user does not input any data into email id field
  */
      public void verifyForgotPassword(String existingAccountEmail)
    {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        driver.findElement(signInWithExistingAccountLocators.signInText).isEnabled();
        Boolean forgotPasswordLink = driver.findElement(signInWithExistingAccountLocators.forgotPasswordLink).isEnabled();

        if(forgotPasswordLink==true) {
            driver.findElement(signInWithExistingAccountLocators.forgotPasswordLink).click();
            WebElement restButton = driver.findElement(forgotPasswordLocators.forgotPasswordSendRestLink);
            Assert.assertTrue(!(restButton.isEnabled()));
            driver.findElement(forgotPasswordLocators.forgotPasswordEmailInput).sendKeys(existingAccountEmail);
            Assert.assertTrue(restButton.isEnabled());
            if(!(existingAccountEmail==null) && restButton.isEnabled()==true)
            {
                Assert.assertTrue(true, "Forgot Password functionality is working as expected");
            }
            else
            {
                Assert.assertTrue(false, "Forgot Password functionality is not working as expected" );
            }

        }

    }


    /*
        TC_02
        Verify that, user can return to the sign in screen if he remembers the password by clicking on "Back to welcome screen"
     */
     public void returnToSignInScreen(String existingAccountEmail)
    {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        Boolean signInTextStatus = driver.findElement(signInWithExistingAccountLocators.signInText).isEnabled();
        Boolean forgotPasswordLink = driver.findElement(signInWithExistingAccountLocators.forgotPasswordLink).isEnabled();

        if(forgotPasswordLink==true) {
            driver.findElement(signInWithExistingAccountLocators.forgotPasswordLink).click();
            WebElement restButton = driver.findElement(forgotPasswordLocators.forgotPasswordSendRestLink);
            WebElement backTOLoginLink = driver.findElement(forgotPasswordLocators.backToWelcomeLink);
            Boolean restButtonStatus = restButton.isDisplayed();
            Boolean backToLoginStatus = backTOLoginLink.isEnabled();

            Assert.assertTrue((restButton.isEnabled()) == false);
            driver.findElement(forgotPasswordLocators.forgotPasswordEmailInput).sendKeys(existingAccountEmail);
            Assert.assertTrue(restButtonStatus == true);
            Assert.assertTrue(backToLoginStatus == true);
            backTOLoginLink.click();
            Assert.assertTrue(signInTextStatus==true);
        }
        else
        {
            Assert.assertFalse(false, "Forgot password link is not shown");
        }

        }


   /*
        TC_03
        //Verify that, the forgot password email link takes the user to the password reset screen
   */
    public void forgotPasswordEmailLinkNavigation()
    {
        WebElement backToLoginLink = driver.findElement(forgotPasswordLocators.backToWelcomeLink);
        backToLoginLink.isEnabled();
        backToLoginLink.click();
        Boolean corousalDisplayed = driver.findElement(homePageLocators.corousalHeaders).isDisplayed();
        Assert.assertTrue(corousalDisplayed==true, "User is on the home page - Back to login");
    }


    //Verify the UI elements on forgot password screen
    public void forgotPasswordEmailLinkNavigation(String existingAccountEmail) {
        String email = properties.getProperty("emailIDVerification");
        WebElement createPasswordHeader = driver.findElement(forgotPasswordLocators.createNewPasswordH1);
        WebElement createPasswordWithEmail = driver.findElement(By.xpath("(//*[text()= '"+email + "'])"));



        WebElement createPasswordInput = driver.findElement(accountCreationLocators.createPasswordInputField);
        WebElement confirmPassword = driver.findElement(accountCreationLocators.confirmPasswordInptField);
        WebElement updatePassword = driver.findElement(forgotPasswordLocators.updatePassword);

        if ((createPasswordHeader.isDisplayed()) && (createPasswordWithEmail.isDisplayed()) && (createPasswordInput.isEnabled()) && (confirmPassword.isEnabled()) && (updatePassword.isDisplayed())) {
            Assert.assertTrue(true, "All the elements are present");
        } else {
            Assert.assertTrue(false, "Some elements might be missing");
        }
    }

    /*
        TC_04
         i) Verify if the password criteria is met
    */

        public void validatePasswordCriteria(String enterPassword) throws AWTException
        {
            accountCreation2.validateErrorMessageForPassword(enterPassword);
        }

        //TC_05
        // i) Verify if the password and confirm password are editable and user
    public void checkInputFieldIsEnabled()
    {
        Boolean passwordInput = driver.findElement(accountCreationLocators.createPasswordInputField).isEnabled();
        Boolean confirmInput = driver.findElement(accountCreationLocators.confirmPasswordInptField).isEnabled();
        driver.findElement(accountCreationLocators.confirmPasswordInptField);
        WebElement updatePassword = driver.findElement(forgotPasswordLocators.updatePassword);
        Assert.assertTrue((passwordInput && confirmInput) == true, "Input fields would accept data");
    }

       //TC_05
        // ii) Verify that, user is not able to proceed until both the fields are filled with input data
    public void verifyFieldsDataForPassword(String enterPassword)
    {
        WebElement passwordInput = driver.findElement(accountCreationLocators.createPasswordInputField);
        WebElement confirmInput = driver.findElement(accountCreationLocators.confirmPasswordInptField);

        passwordInput.sendKeys(enterPassword);
        confirmInput.sendKeys(enterPassword);

        String passwordInputData = passwordInput.getAttribute("value");
        String confirmInputData = confirmInput.getAttribute("value");



        if(!(passwordInputData.equalsIgnoreCase(null)) && !(confirmInputData.equalsIgnoreCase(null)))
        {
            Boolean updatePasswordStatus = driver.findElement(forgotPasswordLocators.updatePassword).isEnabled();
            Assert.assertTrue(updatePasswordStatus == true, "User is not able to proceeed further until data is entered");
        }
        else
        {
            Assert.assertFalse(false, "something is wrong");
        }

    }

    // TC_06
    // Verify that, update button remains inactive until the passwords match the criteria
    public void updateButtonStatus(String password, String confirmPassword)
    {
      WebElement passwordField =  driver.findElement(accountCreationLocators.createPasswordInputField);
      passwordField.sendKeys(password);
       WebElement confirmPasswordField = driver.findElement(accountCreationLocators.confirmPasswordInptField);
       confirmPasswordField.sendKeys(confirmPassword);

        String entredPassword = passwordField.getAttribute("value");
        String confirmEnteredPassword = confirmPasswordField.getAttribute("value");
        if((entredPassword.equals(confirmEnteredPassword)) && (entredPassword!=(null)) && (confirmEnteredPassword!=(null)))
       {
           Boolean updateStatusButton = driver.findElement(forgotPasswordLocators.updatePassword).isEnabled();
           Assert.assertTrue(updateStatusButton==true, "Update button is enabled");
       }
       else
       {
           Assert.assertTrue(false, "Update button functionality is not working as expected");
       }
    }



    // @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)
    //Verify if the password criteria is met
    public void validatePasswordAndConfirmError2(String wrongPassword, String createAccountPassword, String createAccountConfirmPassword) throws AWTException {
        String editEmail = " ";

        driver.findElement(accountCreationLocators.createPasswordInputField).click();
        driver.findElement(By.xpath("//html")).click();

        accountCreation2.validateErrorMessageForPassword(wrongPassword);
        accountCreation2.validateErrorMessageForPassword(createAccountPassword);
        accountCreation2.validateErrorMessageForConfirmPassword(wrongPassword);
    }

    // @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)
    //Verify if the password criteria is met
    public void validatePasswordCriteriaAndMatch3(String createAccountPassword, String createAccountConfirmPassword)
    {
        String editEmail = " ";
        accountCreation2.verifyPasswordAndConfirmPassword(createAccountPassword, createAccountConfirmPassword);
    }

    // @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)
    //Verify if the password criteria is met
    public void clickShowAndHide(String createAccountPassword, String createAccountConfirmPassword)
    {
        String editEmail = " ";
        accountCreation2.verifyPasswordAndConfirmPassword(createAccountPassword, createAccountConfirmPassword);
        accountCreation2.clickShowPassword();
        accountCreation2.clickHidePassword();
    }

    // @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)
    //Verify if the password criteria is met
    public void validatePasswordCriteriaAndMatch4(String createAccountPassword, String createAccountConfirmPassword)
    {
        clickShowAndHide(createAccountPassword, createAccountConfirmPassword);
        driver.findElement(forgotPasswordLocators.updatePassword).isEnabled();
    }

    //TC_07
    // Verify that clicking on update password button navigates user to the confirmation screen
    public void clickUpdatePasswordFeature(String enterPassword, String enterConfirmPassword) throws AWTException {
        validatePasswordCriteria(enterPassword);
        updateButtonStatus(enterPassword, enterConfirmPassword );
        driver.findElement(forgotPasswordLocators.updatePassword).click();
    }

    @Test
    //TC_07
    // Verify if the login is possible with the newly changed password after the password update
    public void verifyLoginwithNewPassword(String email, String password) throws IOException, AWTException {
        WebElement signInLink = driver.findElement(homePageLocators.alreadyHaveAnAccountLink);
        signInLink.isEnabled();
        signInLink.click();
       signInWithExistingAccountActions.clickSignIn(email, password);
    }



}
