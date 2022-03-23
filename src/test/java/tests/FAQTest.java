package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pageActions.AccountCreation1;
import pageActions.FAQActions;
import pageActions.SignInWithExistingAccountActions;
import resources.FinalConstants;

import java.awt.*;
import java.io.IOException;

public class FAQTest extends TestBase {

    FAQActions faqActions = new FAQActions();
    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();

    public FAQTest() throws IOException {
    }

    @Test
    public void validtaeFAQUI() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(FinalConstants.existingAccountEmail, FinalConstants.existingAccountPassword);
        faqActions.clickFAQLink();
        faqActions.validateUIOnFAQ();
    }

    @Test
    public void verifyFAQQA() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(FinalConstants.existingAccountEmail, FinalConstants.existingAccountPassword);
        faqActions.clickFAQLink();
        faqActions.verifyQuestionsOnFAQ();
    }

    @Test
    public void navigateBackToDashboard() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(FinalConstants.existingAccountEmail, FinalConstants.existingAccountPassword);
        faqActions.clickFAQLink();
        faqActions.navigateBackToDashboard();
    }
}