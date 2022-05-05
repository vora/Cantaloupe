package pageActions;

import base.BaseActions;
import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageLocators.*;
import java.io.IOException;

public class AddMoreCard_Prepaid extends TestBase {

        BaseActions baseActions = new BaseActions();
        AddMoreCard_PrepaidLocators addMoreCard_prepaidLocators = new AddMoreCard_PrepaidLocators();
        LoggedInUserLocators loggedInUserLocators = new LoggedInUserLocators();

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

        baseActions.regexExpression(addMoreCard_prepaidLocators.moreCardInputField, cardInput, properties.getProperty("regexMoreCard"));
        baseActions.regexExpression(addMoreCard_prepaidLocators.securityCodeIputField, securityInput, properties.getProperty("regexSecurity"));
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
        Assert.assertTrue((properties.getProperty("invalidMoreCardNumberAlertText").equals(alertText)), "User has entered an invalid card number");
    }
    public void checkIfCardHAsBeenRegisteredAlready()
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement alertPopUp = driver.findElement(addMoreCard_prepaidLocators.moreCardAlertPopUp);
        WebElement alert = wait.until(ExpectedConditions.presenceOfElementLocated(addMoreCard_prepaidLocators.moreCardAlertPopUp));
        String alertText = wait.until(ExpectedConditions.visibilityOf(alert)).getText();
        alertPopUp.isDisplayed();
        Assert.assertTrue((properties.getProperty("registeredMoreCardAlertText")).equals(alertText), "User has entered an already existing card number");
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

    public void navigateBackToDashboard()
    {
        baseActions.scrollUp();
        baseActions.clickButton(addMoreCard_prepaidLocators.backLink);
        WebElement profileLink = driver.findElement(loggedInUserLocators.profileLink);
        Assert.assertTrue((profileLink.isDisplayed())==true, "User has navigated back to Dashboard screen");
    }

    public void navigateBackAfterDataInput(String moreCardNo, String securityNo)
    {
        verifyMoreCardInput(moreCardNo, securityNo);
        navigateBackToDashboard();
        driver.findElement(addMoreCard_prepaidLocators.addMoreCardLink).click();
        WebElement moreCardInput = driver.findElement(addMoreCard_prepaidLocators.moreCardInputField);
        WebElement securityInput = driver.findElement(addMoreCard_prepaidLocators.securityCodeIputField);
        String blankMore = moreCardInput.getAttribute("value");
        String blankSecurity = securityInput.getAttribute("value");
        Assert.assertTrue(blankMore.equalsIgnoreCase("") && blankSecurity.equalsIgnoreCase(""), "User inputs have not been saved");
    }
}
