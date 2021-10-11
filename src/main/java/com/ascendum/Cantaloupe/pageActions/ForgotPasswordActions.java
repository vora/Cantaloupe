package com.ascendum.Cantaloupe.pageActions;

import com.ascendum.Cantaloupe.base.TestBase;
import com.ascendum.Cantaloupe.pageLocators.ForgotPasswordLocators;
import com.ascendum.Cantaloupe.pageLocators.SignInWithExistingAccountLocators;
import org.testng.Assert;

import java.io.IOException;

public class ForgotPasswordActions extends TestBase {

    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();
    SignInWithExistingAccountLocators signInWithExistingAccountLocators = new SignInWithExistingAccountLocators();
    ForgotPasswordLocators forgotPasswordLocators = new ForgotPasswordLocators();

    public ForgotPasswordActions() throws IOException {
    }

    //verify forgot password functionality
    public void verifyForgotPassword(String existingAccountEmail)
    {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickContinueWithEmail();
        driver.findElement(signInWithExistingAccountLocators.signInText).isEnabled();
        Boolean forgotPasswordLink = driver.findElement(signInWithExistingAccountLocators.forgotPasswordLink).isEnabled();

        if(forgotPasswordLink==true) {
            driver.findElement(signInWithExistingAccountLocators.forgotPasswordLink).click();
            driver.findElement(forgotPasswordLocators.forgotPasswordEmailInput).sendKeys(existingAccountEmail);

            Boolean restButton = driver.findElement(forgotPasswordLocators.forgotPasswordSendRestLink).isEnabled();

            if(restButton==true)
            {
                Assert.assertTrue(true, "Forgot Password functionality is working as expected");
            }
            else
            {
                Assert.assertTrue(false, "Forgot Password functionality is not working as expected" );
            }

        }

    }
}
