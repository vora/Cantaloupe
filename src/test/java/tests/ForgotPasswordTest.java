package tests;

import base.DataProvider;
import base.TestBase;
import base.TestBase1;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pageActions.ForgotPasswordActions;
import resources.FinalConstants;

import java.io.IOException;

public class ForgotPasswordTest extends TestBase1 {

    ForgotPasswordActions forgotPasswordActions = new ForgotPasswordActions();

    public ForgotPasswordTest() throws IOException {}


   // @Test
   public void enterEmailToResetPassword1()
    {
        forgotPasswordActions.verifyForgotPassword(FinalConstants.existingAccountEmail);
    }

    public void verifyNavigations_PasswordReset(){
        forgotPasswordActions.forgotPasswordEmailLinkNavigation();
        forgotPasswordActions.returnToSignInScreen(FinalConstants.existingAccountEmail);
    }

   // @Test
    public void validatePasswordCriteria(){
            forgotPasswordActions.validatePasswordCriteria(FinalConstants.wrongPassword);
        }

    // @Test
     public void validateConfirmPasswordFeature(){
             forgotPasswordActions.checkInputFieldIsEnabled();
        forgotPasswordActions.verifyFieldsDataForPassword(FinalConstants.createAccountPassword);
    }

   // @Test
    public void validateUpdateSattusButton(){
        forgotPasswordActions.updateButtonStatus(FinalConstants.createAccountPassword, FinalConstants.createAccountConfirmPassword);
    }

    @Test
    public void verifyLoginWithNewPassword() throws IOException {
        forgotPasswordActions.verifyLoginwithNewPassword(FinalConstants.existingAccountEmail, FinalConstants.newPassword);
    }
}
