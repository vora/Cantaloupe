package tests;

import base.DataProvider;
import base.TestBase;
import org.testng.annotations.Test;
import pageActions.AddMoreCard_Prepaid;
import pageActions.HomePageActions;
import pageActions.SignInWithExistingAccountActions;
import pageLocators.AccountCreationLocators;
import pageLocators.CreateOrLoginInitialLocators;
import pageLocators.LandingScreen;
import resources.FinalConstants;

import java.awt.*;
import java.io.IOException;

public class AddMoreCard_PrepaidTest extends TestBase {

   LandingScreen loginScreen = new LandingScreen();
   AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
   CreateOrLoginInitialLocators createAccountLocators = new CreateOrLoginInitialLocators();
   SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();
   AddMoreCard_Prepaid addMoreCard_prepaid = new AddMoreCard_Prepaid();


   public AddMoreCard_PrepaidTest() throws IOException {
   }


   @Test
   public void verifyBlankInputFields() throws IOException, AWTException {


      signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
      signInWithExistingAccountActions.clickContinueWithEmail();
      signInWithExistingAccountActions.validateErrorMessages();
      signInWithExistingAccountActions.verifySignInDisabled();
      signInWithExistingAccountActions.clickSignIn(FinalConstants.existingAccountEmail, FinalConstants.existingAccountPassword);
      addMoreCard_prepaid.clickAddMoreCardButton();
      addMoreCard_prepaid.blankInputsForMoreAndSecurity();
   }

   @Test
   public void cardInputData() throws IOException, AWTException {
      signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
      signInWithExistingAccountActions.clickContinueWithEmail();
      signInWithExistingAccountActions.validateErrorMessages();
      signInWithExistingAccountActions.verifySignInDisabled();
      signInWithExistingAccountActions.clickSignIn(FinalConstants.existingAccountEmail, FinalConstants.existingAccountPassword);
      addMoreCard_prepaid.clickAddMoreCardButton();
      addMoreCard_prepaid.verifyMoreCardInput(FinalConstants.moreCardNumber, FinalConstants.secutityNumber);
   }

   @Test
     public void checkUniquessnessOfCard() throws IOException, AWTException {
      signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
      signInWithExistingAccountActions.clickContinueWithEmail();
      signInWithExistingAccountActions.validateErrorMessages();
      signInWithExistingAccountActions.verifySignInDisabled();
      signInWithExistingAccountActions.clickSignIn(FinalConstants.existingAccountEmail, FinalConstants.existingAccountPassword);
      addMoreCard_prepaid.clickAddMoreCardButton();
      addMoreCard_prepaid.verifyMoreCardInput(FinalConstants.moreCardNumberInvalid, FinalConstants.secutityNumber);
      addMoreCard_prepaid.clickButtonMore();
      addMoreCard_prepaid.checkIFTheCardNoIsUnique();
      addMoreCard_prepaid.clickButtonMore();
   }

   @Test
   public void checkForAlreadyRegisteredCard() throws IOException, AWTException {
      signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
      signInWithExistingAccountActions.clickContinueWithEmail();
      signInWithExistingAccountActions.validateErrorMessages();
      signInWithExistingAccountActions.verifySignInDisabled();
      signInWithExistingAccountActions.clickSignIn(FinalConstants.existingAccountEmail, FinalConstants.existingAccountPassword);
      addMoreCard_prepaid.clickAddMoreCardButton();
      addMoreCard_prepaid.verifyMoreCardInput(FinalConstants.moreCardNumberAlreadyRegistered, FinalConstants.secutityNumber);
      addMoreCard_prepaid.clickButtonMore();
      addMoreCard_prepaid.checkIfCardHAsBeenRegisteredAlready();
      addMoreCard_prepaid.clickButtonMore();
   }


}
