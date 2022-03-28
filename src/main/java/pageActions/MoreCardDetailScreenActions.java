package pageActions;

import base.BaseActions;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.AccountCreationLocators;
import pageLocators.LandingScreen;
import pageLocators.MoreCardDetailScreenLocators;
import pageLocators.SignInWithExistingAccountLocators;

import java.io.IOException;
import java.util.Properties;

public class MoreCardDetailScreenActions extends TestBase {

    Properties prop = new Properties();
    BaseActions baseActions = new BaseActions();

       AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
       LandingScreen loginScreen = new LandingScreen();
       MoreCardDetailScreenLocators moreCardDetailScreenLocators = new MoreCardDetailScreenLocators();
    SignInWithExistingAccountLocators signInWithExistingAccountLocators = new SignInWithExistingAccountLocators();


    public MoreCardDetailScreenActions() throws IOException {
    }


   public void verifyAddedMoreCardNumber(String addedMoreCardLast4Numbers)
   {

       String fourDigits = addedMoreCardLast4Numbers.substring(addedMoreCardLast4Numbers.length() - 4);
       WebElement addedMoreCard = driver.findElement(By.xpath("//*[contains(text(),'More Card •• " +fourDigits+"')]"));
       Assert.assertTrue(addedMoreCard.isDisplayed());
       String cardNoText = addedMoreCard.getText();
       System.out.println(cardNoText);
    }

    public void navigateToMoreCardDetailsScreen(String addedMoreCardLast4Numbers)
    {
        String fourDigits = addedMoreCardLast4Numbers.substring(addedMoreCardLast4Numbers.length() - 4);
        WebElement addedMoreCard = driver.findElement(By.xpath("//*[contains(text(),'More Card •• " +fourDigits+"')]"));
        baseActions.clickButton(By.xpath("//*[contains(text(),'More Card •• " +fourDigits+"')]"));
        Assert.assertTrue(addedMoreCard.isDisplayed() == true);
    }

    public void verifyBalance(String balanceAmount)
    {
        String balanceAmountText = driver.findElement(moreCardDetailScreenLocators.balanceAmount).getText();
        Assert.assertTrue(balanceAmountText.equalsIgnoreCase(balanceAmount));
    }

    public void verifyBalance()
    {
        WebElement balanceAmountText = driver.findElement(moreCardDetailScreenLocators.balanceAmount);
        System.out.println(balanceAmountText.getText());
    }

    public void viewallCardsAvailable()
    {
        baseActions.getListElements(moreCardDetailScreenLocators.viewAllCardsAvaialble);
    }


}