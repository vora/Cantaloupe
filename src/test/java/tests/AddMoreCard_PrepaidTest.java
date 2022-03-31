package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pageActions.AddMoreCard_Prepaid;
import pageActions.SignInWithExistingAccountActions;
import resources.FinalConstants;

import java.awt.*;
import java.io.IOException;

public class AddMoreCard_PrepaidTest extends TestBase {

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
      signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
      addMoreCard_prepaid.clickAddMoreCardButton();
      addMoreCard_prepaid.blankInputsForMoreAndSecurity();
   }

   @Test
   public void cardInputData() throws IOException, AWTException {
      signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
      signInWithExistingAccountActions.clickContinueWithEmail();
      signInWithExistingAccountActions.validateErrorMessages();
      signInWithExistingAccountActions.verifySignInDisabled();
      signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
      addMoreCard_prepaid.clickAddMoreCardButton();
      addMoreCard_prepaid.verifyMoreCardInput(properties.getProperty("moreCardNumber"), properties.getProperty("securityNumber"));
   }

   @Test
     public void checkUniquessnessOfCard() throws IOException, AWTException {
      signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
      signInWithExistingAccountActions.clickContinueWithEmail();
      signInWithExistingAccountActions.validateErrorMessages();
      signInWithExistingAccountActions.verifySignInDisabled();
      signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
      addMoreCard_prepaid.clickAddMoreCardButton();
      addMoreCard_prepaid.verifyMoreCardInput(properties.getProperty("moreCardNumberInvalid"), properties.getProperty("securityNumber"));
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
      signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
      addMoreCard_prepaid.clickAddMoreCardButton();
      addMoreCard_prepaid.verifyMoreCardInput(properties.getProperty("moreCardNumberAlreadyRegistered"), properties.getProperty("securityNumber"));
      addMoreCard_prepaid.clickButtonMore();
      addMoreCard_prepaid.checkIfCardHAsBeenRegisteredAlready();
      addMoreCard_prepaid.clickButtonMore();
   }

    @Test
    public void navigateBackToDashboard() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
//        signInWithExistingAccountActions.clickContinueWithEmail();
//        signInWithExistingAccountActions.verifySignInDisabled();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        addMoreCard_prepaid.clickAddMoreCardButton();
        addMoreCard_prepaid.navigateBackToDashboard();
    }

    @Test
    public void navigatewithoutSubmittingData() throws IOException, AWTException {
        signInWithExistingAccountActions.clickAlreadyExistingAccountLink();
//        signInWithExistingAccountActions.clickContinueWithEmail();
//        signInWithExistingAccountActions.verifySignInDisabled();
        signInWithExistingAccountActions.clickSignIn(properties.getProperty("existingAccountEmail"), properties.getProperty("existingAccountPassword"));
        addMoreCard_prepaid.clickAddMoreCardButton();
        addMoreCard_prepaid.navigateBackAfterDataInput(properties.getProperty("moreCardNumber"), properties.getProperty("securityNumber"));
    }


}
