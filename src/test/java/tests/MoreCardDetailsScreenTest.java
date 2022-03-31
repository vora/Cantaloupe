package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pageActions.AccountCreation1;
import pageActions.MoreCardDetailScreenActions;
import pageActions.SignInWithExistingAccountActions;

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

      signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
      signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
      moreCardDetailScreenActions.verifyAddedMoreCardNumber(properties.getProperty("moreCardNumber"));

   }

   @Test
    public void navigateToAddedMoreCardscreen() throws AWTException, IOException {

        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        moreCardDetailScreenActions.verifyAddedMoreCardNumber(properties.getProperty("moreCardNumber"));
        moreCardDetailScreenActions.navigateToMoreCardDetailsScreen(properties.getProperty("moreCardNumber"));

    }

    @Test
    public void viewBalance() throws AWTException, IOException {

        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        moreCardDetailScreenActions.verifyAddedMoreCardNumber(properties.getProperty("moreCardNumber"));
        moreCardDetailScreenActions.verifyBalance(properties.getProperty("balanceAmount"));
    }

    @Test
    public void verifyUIComponents_DetailsScreen() throws AWTException, IOException {

        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        moreCardDetailScreenActions.verifyAddedMoreCardNumber(properties.getProperty("moreCardNumber"));
        moreCardDetailScreenActions.verifyUIComponents(properties.getProperty("moreCardNumber"));
    }

    @Test
    public void viewAvailableCards() throws AWTException, IOException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        moreCardDetailScreenActions.viewallCardsAvailable();
    }

}