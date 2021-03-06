package com.ascendum.Cantaloupe.pageActions;

import com.ascendum.Cantaloupe.base.BaseActions;
import com.ascendum.Cantaloupe.base.TestBase;
import com.ascendum.Cantaloupe.pageLocators.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class SignInWithExistingAccountActions extends TestBase {

        BaseActions baseActions = new BaseActions();
        LoginScreen loginScreen = new LoginScreen();
        SignInWithExistingAccountLocators signInWithExistingAccountLocators = new SignInWithExistingAccountLocators();
        CreateAccountLocators createAccountLocators = new CreateAccountLocators();
        ContinueAccountCreationLocators continueAccountCreationLocators = new ContinueAccountCreationLocators();
        AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
        LoggedInUserLocators loggedInUserLocators = new LoggedInUserLocators();

    public SignInWithExistingAccountActions() throws IOException {
    }

    //Click on already have an account link
    public void clickAlreadyExistingAccountLink()
        {
            driver.findElement(loginScreen.alreadyHaveAccountButton).isEnabled();
            driver.findElement(loginScreen.alreadyHaveAccountButton).click();
        }

        //clicks on continue with email link
        public void clickContinueWithEmail()
        {
            driver.findElement(createAccountLocators.continueWithEmail).isEnabled();
            driver.findElement(createAccountLocators.continueWithEmail).click();
        }


        //Verify error messages displayed whn there are no data entered
        public void validateErrorMessages()
        {
            driver.findElement(signInWithExistingAccountLocators.emailInput).click();
            driver.findElement(By.xpath("//html")).click();
            driver.findElement(signInWithExistingAccountLocators.passwordInput).click();
            driver.findElement(By.xpath("//html")).click();
            String emailErrorText = "Please enter your email.";
            String passwordErrorText = "Please enter your password.";
            List<String> getAllErrors = baseActions.getSpanText(signInWithExistingAccountLocators.errorMessages);
            if((getAllErrors.contains(emailErrorText)) && (getAllErrors).contains(passwordErrorText))
            {
                Assert.assertTrue(true, "Error messages are displayed");
            }
            else
            {
                Assert.assertTrue(false, "Error messages are missing");
            }
        }



    //Validate all the fields on Sign in screen and enter data in email and password fields and verify sign in button mode
    public void verifySignInScreen(String existingAccountEmail, String existingAccountPassword) throws IOException {

        String signInText = driver.findElement(signInWithExistingAccountLocators.signInText).getText();

        if(signInText.equalsIgnoreCase("Sign In")) {
            Boolean emailInnut = driver.findElement(signInWithExistingAccountLocators.emailInput).isEnabled();
            Boolean passwordInput = driver.findElement(signInWithExistingAccountLocators.passwordInput).isEnabled();
            Boolean forgotPasswordLink = driver.findElement(signInWithExistingAccountLocators.forgotPasswordLink).isEnabled();

            Assert.assertTrue(emailInnut);
            Assert.assertTrue(passwordInput);
            Assert.assertTrue(forgotPasswordLink);

            driver.findElement(signInWithExistingAccountLocators.emailInput).sendKeys(existingAccountEmail);
            driver.findElement(By.xpath("//html")).click();
            driver.findElement(signInWithExistingAccountLocators.passwordInput).sendKeys(existingAccountPassword);
            driver.findElement(By.xpath("//html")).click();

            Boolean buttonNotEnabled = driver.findElement(signInWithExistingAccountLocators.signInButton).isEnabled();


            if(buttonNotEnabled==false)
            Assert.assertTrue(true, "Button should be enabled and is working as expected");
        }

            else {
                Assert.assertTrue(false, "Sign in button is not working as expected");
            }
        }

    //Verify if the sign in button is in disabled mode when there is no data entered
    public void verifySignInDisabled()
    {

        WebElement buttonNotEnabled = (driver.findElement(signInWithExistingAccountLocators.signInButton));
        if(buttonNotEnabled.isEnabled())
        {
            Assert.assertTrue(false, "Sign iin button is enabled and is not working as expected");
        }
        else
        {
            Assert.assertTrue(true, "Sign in button is wprking according to the functionality");
        }
    }


    //Verify user is able to login successfully
    public void clickSignIn(String existingAccountEmail, String existingAccountPassword) throws IOException {
            verifySignInScreen(existingAccountEmail, existingAccountPassword);
            driver.findElement(signInWithExistingAccountLocators.signInButton).click();
           if(driver.findElement(loggedInUserLocators.profileLink).isEnabled())
           {
               Assert.assertTrue(true, "User is logged in successfully and is on the initial home screen");
           }
           else
           {
               Assert.assertTrue(false, "User is not logged in successfully and is not on the initial home screen");
           }

        }

        //lick sign out link
    public void clickSignOut()
    {
        driver.findElement(loggedInUserLocators.signOutLink).click();
    }
}
