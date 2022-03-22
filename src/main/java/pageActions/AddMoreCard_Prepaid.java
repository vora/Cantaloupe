package pageActions;

import base.BaseActions;
import base.TestBase;
import base.TestBase1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void verifyMoreCardInput(String cardInput, String securityInput)
    {
         driver.findElement(addMoreCard_prepaidLocators.moreCardInputField);
         driver.findElement(addMoreCard_prepaidLocators.moreCardInputField).isDisplayed();
         driver.findElement(addMoreCard_prepaidLocators.moreCardInputField).isEnabled();

         driver.findElement(addMoreCard_prepaidLocators.securityCodeIputField);
         driver.findElement(addMoreCard_prepaidLocators.securityCodeText).isDisplayed();
         driver.findElement(addMoreCard_prepaidLocators.securityCodeIputField).isEnabled();

        baseActions.regexExpression(addMoreCard_prepaidLocators.moreCardInputField, cardInput, FinalConstants.regexMoreCard );
        baseActions.regexExpression(addMoreCard_prepaidLocators.securityCodeIputField, securityInput, FinalConstants.regexSecurity);
    }

    public void clickButtonMore()
    {
        driver.findElement(addMoreCard_prepaidLocators.addMoreButton).click();
    }

    //TC_02
    public void checkIFTheCardNoIsUnique()
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement alertPopUp = driver.findElement(addMoreCard_prepaidLocators.moreCardAlertPopUp);
        WebElement alert = wait.until(ExpectedConditions.presenceOfElementLocated(addMoreCard_prepaidLocators.moreCardAlertPopUp));
        String alertText = wait.until(ExpectedConditions.visibilityOf(alert)).getText();
        alertPopUp.isDisplayed();
        Assert.assertTrue((FinalConstants.invalidMoreCardNumberAlertText).equals(alertText), "User has entered an invalid card number");
    }
    public void checkIfCardHAsBeenRegisteredAlready()
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement alertPopUp = driver.findElement(addMoreCard_prepaidLocators.moreCardAlertPopUp);
        WebElement alert = wait.until(ExpectedConditions.presenceOfElementLocated(addMoreCard_prepaidLocators.moreCardAlertPopUp));
        String alertText = wait.until(ExpectedConditions.visibilityOf(alert)).getText();
        alertPopUp.isDisplayed();
        Assert.assertTrue((FinalConstants.registeredMoreCardAlertText).equals(alertText), "User has entered an already existing card number");
    }

    //TC_03
    public void confirmAdditionOFMoreCards()
    {
        WebElement confirmAddedCard = driver.findElement(addMoreCard_prepaidLocators.confirmAddedMoreCard);
        Assert.assertTrue(confirmAddedCard.isDisplayed()==true);
    }

    //TC_04
    public void blankInputsForMoreAndSecurity()
    {
        WebElement moreInput = driver.findElement(addMoreCard_prepaidLocators.moreCardInputField);
        WebElement securityInput = driver.findElement(addMoreCard_prepaidLocators.securityCodeIputField);
        WebElement addMoreButton = driver.findElement(addMoreCard_prepaidLocators.addMoreButton);


        if((moreInput.getAttribute("value").equals("")) && (securityInput.getAttribute("value").equals("")) )
        {
            addMoreButton.click();
            WebElement moreBlankError = driver.findElement(addMoreCard_prepaidLocators.blankMoreCardErrorText);
            WebElement securityBlankError = driver.findElement(addMoreCard_prepaidLocators.blankSecuritydErrorText);
            Assert.assertTrue(moreBlankError.isDisplayed() && securityBlankError.isDisplayed());
        }

    }


}
