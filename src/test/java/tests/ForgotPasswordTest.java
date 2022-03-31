package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pageActions.ForgotPasswordActions;

import java.awt.*;
import java.io.IOException;

public class ForgotPasswordTest extends TestBase {

    ForgotPasswordActions forgotPasswordActions = new ForgotPasswordActions();

    public ForgotPasswordTest() throws IOException {}


   // @Test
   public void enterEmailToResetPassword1()
    {
        forgotPasswordActions.verifyForgotPassword(properties.getProperty("existingAccountEmail"));
    }

    public void verifyNavigations_PasswordReset(){
        forgotPasswordActions.forgotPasswordEmailLinkNavigation();
        forgotPasswordActions.returnToSignInScreen(properties.getProperty("existingAccountEmail"));
    }

   // @Test
    public void validatePasswordCriteria() throws AWTException {
            forgotPasswordActions.validatePasswordCriteria(properties.getProperty("wrongPassword"));
        }

    // @Test
     public void validateConfirmPasswordFeature(){
             forgotPasswordActions.checkInputFieldIsEnabled();
        forgotPasswordActions.verifyFieldsDataForPassword(properties.getProperty("createAccountPassword"));
    }

   // @Test
    public void validateUpdateSattusButton(){
        forgotPasswordActions.updateButtonStatus(properties.getProperty("createAccountPassword"), properties.getProperty("createAccountConfirmPassword"));
    }

    @Test
    public void verifyLoginWithNewPassword() throws IOException, AWTException {
        forgotPasswordActions.verifyLoginwithNewPassword(properties.getProperty("existingAccountEmail"), properties.getProperty("newPassword"));
    }
}
