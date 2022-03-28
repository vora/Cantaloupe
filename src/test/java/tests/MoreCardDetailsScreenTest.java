package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pageActions.AccountCreation1;
import pageActions.MoreCardDetailScreenActions;
import pageActions.SignInWithExistingAccountActions;
import resources.FinalConstants;

import java.awt.*;
import java.io.IOException;

public class MoreCardDetailsScreenTest extends TestBase {

    AccountCreation1 accountCreation1 = new AccountCreation1();
    MoreCardDetailScreenActions moreCardDetailScreenActions = new MoreCardDetailScreenActions();
    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();

    public MoreCardDetailsScreenTest() throws IOException {
    }

   @Test
    //Validate all errors such as empty input field, then error message, then existing email error message and login button flow
    public void verifyAddedMoreCardNumber() throws AWTException, IOException {
       // moreCardDetailScreenActions.verifyAddedMoreCardNumber();
       signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
       signInWithExistingAccountActions.clickContinueWithEmail();
       signInWithExistingAccountActions.validateErrorMessages();
       signInWithExistingAccountActions.verifySignInDisabled();
       signInWithExistingAccountActions.clickSignIn(FinalConstants.existingAccountEmail, FinalConstants.existingAccountPassword);
       moreCardDetailScreenActions.verifyAddedMoreCardNumber(FinalConstants.moreCardNumber);

   }

   @Test
    public void navigateToAddedMoreCardscreen() throws AWTException, IOException {
        // moreCardDetailScreenActions.verifyAddedMoreCardNumber();
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickContinueWithEmail();
        signInWithExistingAccountActions.validateErrorMessages();
        signInWithExistingAccountActions.verifySignInDisabled();
        signInWithExistingAccountActions.clickSignIn(FinalConstants.existingAccountEmail, FinalConstants.existingAccountPassword);
        moreCardDetailScreenActions.verifyAddedMoreCardNumber(FinalConstants.moreCardNumber);
        moreCardDetailScreenActions.navigateToMoreCardDetailsScreen(FinalConstants.moreCardNumber);

    }

    @Test
    public void viewBalance() throws AWTException, IOException {
        // moreCardDetailScreenActions.verifyAddedMoreCardNumber();
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickContinueWithEmail();
        signInWithExistingAccountActions.validateErrorMessages();
        signInWithExistingAccountActions.verifySignInDisabled();
        signInWithExistingAccountActions.clickSignIn(FinalConstants.existingAccountEmail, FinalConstants.existingAccountPassword);
        moreCardDetailScreenActions.verifyAddedMoreCardNumber(FinalConstants.moreCardNumber);
        moreCardDetailScreenActions.verifyBalance(FinalConstants.balanceAmount);
        moreCardDetailScreenActions.viewallCardsAvailable();
    }

}