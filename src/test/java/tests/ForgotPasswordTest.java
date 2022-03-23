package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pageActions.ForgotPasswordActions;
import pageActions.HomePageActions;
import resources.FinalConstants;

import java.awt.*;
import java.io.IOException;

public class ForgotPasswordTest extends TestBase {

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
    public void validatePasswordCriteria() throws AWTException {
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
    public void verifyLoginWithNewPassword() throws IOException, AWTException {
        forgotPasswordActions.verifyLoginwithNewPassword(FinalConstants.existingAccountEmail, FinalConstants.newPassword);
    }
}
