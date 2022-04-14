package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pageActions.FAQActions;
import pageActions.SignInWithExistingAccountActions;
import pageActions.UpdateProfileActions;

import java.awt.*;
import java.io.IOException;

public class UpdateProfileTests extends TestBase {

    UpdateProfileActions updateProfileActions = new UpdateProfileActions();
    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();

    public UpdateProfileTests() throws IOException {
    }

    @Test
    public void validtaeFAQUI() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();

        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        signInWithExistingAccountActions.clickProfileLink();
        updateProfileActions.verifyUIElements();
    }
}