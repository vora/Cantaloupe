package pageActions;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.ForgotPasswordLocators;
import pageLocators.SignInWithExistingAccountLocators;

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

    //Verify if the user has received an email for the entered email Id for forgot password
}
