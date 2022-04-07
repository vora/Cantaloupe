package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pageActions.AccountCreation1;
import pageActions.ManualReloadActions;
import pageActions.MoreCardDetailScreenActions;
import pageActions.SignInWithExistingAccountActions;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

public class ManualReloadTest extends TestBase {

    MoreCardDetailsScreenTest moreCardDetailsScreenTest = new MoreCardDetailsScreenTest();
    MoreCardDetailScreenActions moreCardDetailScreenActions = new MoreCardDetailScreenActions();
    ManualReloadActions manualReloadActions = new ManualReloadActions();

    public ManualReloadTest() throws IOException {
    }


        public void verifyDropdownValues() throws IOException, AWTException {
        {
            moreCardDetailsScreenTest.navigateToAddedMoreCardscreen();
            manualReloadActions.verifyDefaultDropdownValue();
        }
    }

    @Test
    public void verifyDefaultDropdownValues() throws IOException, AWTException {
        {
            moreCardDetailsScreenTest.navigateToAddedMoreCardscreen();
            manualReloadActions.verifyDefaultDropdownValue();
            manualReloadActions.manualReloadDropdownValues();
        }
    }

        @Test
        public void verifyCreditCard() throws IOException, AWTException {
            {
                moreCardDetailsScreenTest.navigateToAddedMoreCardscreen();
                manualReloadActions.verifyCreditCardIsAndSecurityEditable();
            }
    }


    @Test
    public void verifyCreditCardLength() throws IOException, AWTException, ParseException {
        {
            moreCardDetailsScreenTest.navigateToAddedMoreCardscreen();
           // manualReloadActions.verifyCreditCardIsAndSecurityEditable();
            manualReloadActions.isCreditCardExpired(properties.getProperty("yymm"));
        }
    }

    @Test
    public void validateCVV() throws IOException, AWTException, ParseException {
        {
            moreCardDetailsScreenTest.navigateToAddedMoreCardscreen();
            // manualReloadActions.verifyCreditCardIsAndSecurityEditable();
            manualReloadActions.validateCVV(properties.getProperty("cvvNo"));
        }
    }




}