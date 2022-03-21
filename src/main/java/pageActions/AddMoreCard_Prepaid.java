package pageActions;

import base.BaseActions;
import base.TestBase;
import base.TestBase1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.AccountCreationLocators;
import pageLocators.AddMoreCard_PrepaidLocators;
import pageLocators.LandingScreen;
import resources.FinalConstants;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Properties;

public class AddMoreCard_Prepaid extends TestBase {

        Properties prop = new Properties();
        BaseActions baseActions = new BaseActions();
        AddMoreCard_PrepaidLocators addMoreCard_prepaidLocators = new AddMoreCard_PrepaidLocators();


        AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
        LandingScreen loginScreen = new LandingScreen();

    public AddMoreCard_Prepaid() throws IOException {
    }

    //TC_01
    public void clickAddMoreCardButton()
    {
        baseActions.clickButton(addMoreCard_prepaidLocators.addMoreCardLink);
        Boolean screenConfirm = driver.findElement(addMoreCard_prepaidLocators.addMoreCardText).isDisplayed();
        Assert.assertTrue(screenConfirm == true, "User is on the right screen");
    }

    //TC_02
    public void verifyMoreCardInput()
    {
        WebElement moreCardInputField = driver.findElement(addMoreCard_prepaidLocators.moreCardInputField);
        Boolean morecardInputText = driver.findElement(addMoreCard_prepaidLocators.moreCardInputField).isDisplayed();
        Boolean morecardInputFieldBoolean = driver.findElement(addMoreCard_prepaidLocators.moreCardInputField).isEnabled();

        WebElement securityInputField = driver.findElement(addMoreCard_prepaidLocators.securityCodeIputField);
        Boolean securitydInputText = driver.findElement(addMoreCard_prepaidLocators.securityCodeText).isDisplayed();
        Boolean securityInputFieldBoolean = driver.findElement(addMoreCard_prepaidLocators.securityCodeIputField).isEnabled();

        baseActions.regexExpression(addMoreCard_prepaidLocators.moreCardInputField, FinalConstants.moreCardNumber, FinalConstants.regexMoreCard );
        baseActions.regexExpression(addMoreCard_prepaidLocators.securityCodeIputField, FinalConstants.secutityNumber, FinalConstants.regexSecurity);
    }


}
