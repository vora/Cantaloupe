package pageActions;

import base.BaseActions;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageLocators.*;


import javax.swing.*;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MoreCardDetailScreenActions extends TestBase {

    Properties prop = new Properties();
    BaseActions baseActions = new BaseActions();


       AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
       LandingScreen loginScreen = new LandingScreen();
       MoreCardDetailScreenLocators moreCardDetailScreenLocators = new MoreCardDetailScreenLocators();
       HomePageLocators homePageLocators = new HomePageLocators();
    LoggedInUserLocators loggedInUserLocators = new LoggedInUserLocators();
    SignInWithExistingAccountLocators signInWithExistingAccountLocators = new SignInWithExistingAccountLocators();


    public MoreCardDetailScreenActions() throws IOException {
    }


   public String verifyAddedMoreCardNumber(String enterCardNo)
   {
       addedMoreCardLast4Numbers = enterCardNo.substring(enterCardNo.length() - 4);
       WebDriverWait wait = new WebDriverWait(driver, 20);
       wait.until(ExpectedConditions.elementToBeClickable(moreCardDetailScreenLocators.lastFourDigitsFromCard(addedMoreCardLast4Numbers)));
       driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

       FluentWait fluentWait = new FluentWait(driver);
       fluentWait.until(ExpectedConditions.visibilityOfElementLocated(moreCardDetailScreenLocators.lastFourDigitsFromCard(addedMoreCardLast4Numbers)));

       baseActions.clickButton(moreCardDetailScreenLocators.lastFourDigitsFromCard(addedMoreCardLast4Numbers));
       driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
       //fluentWait.until(ExpectedConditions.presenceOfElementLocated(moreCardDetailScreenLocators.lastFourDigitsFromCard(addedMoreCardLast4Numbers))); //moreCardDetailScreenLocators.lastFourDigitsFromCard(addedMoreCardLast4Numbers)
       WebElement addedMoreCard = driver.findElement(moreCardDetailScreenLocators.moreCardFourDigits);
       wait.until(ExpectedConditions.elementToBeClickable(moreCardDetailScreenLocators.lastFourDigitsFromCard(addedMoreCardLast4Numbers)));

       Assert.assertTrue(addedMoreCard.isDisplayed()==true);
       String cardNoText = addedMoreCard.getText();
       return cardNoText;
    }

    public void navigateToMoreCardDetailsScreen(String enterCardNo)
    {
        baseActions.getLastFourDigits(enterCardNo);
        baseActions.clickButton(moreCardDetailScreenLocators.lastFourDigitsFromCard(addedMoreCardLast4Numbers));
        Assert.assertTrue(driver.findElement(moreCardDetailScreenLocators.lastFourDigitsFromCard(addedMoreCardLast4Numbers)).isDisplayed()==true);
    }

    public String verifyBalance(String balanceAmount)
    {
        String balanceAmountText = driver.findElement(moreCardDetailScreenLocators.balanceAmountWithDollar).getText();
        //String balancetext = balanceAmount.substring(0, balanceAmountText.length() - 7);
        Assert.assertTrue(balanceAmountText.equalsIgnoreCase(balanceAmount));
        return balanceAmountText;
    }

//    public String verifyBalance()
//    {
//        WebElement balanceAmountText = driver.findElement(moreCardDetailScreenLocators.balanceAmount);
//        return balanceAmountText.getText();
//    }

    public List<String> viewallCardsAvailable()
    {
        List <String> cardsAvailable = baseActions.getListElements(moreCardDetailScreenLocators.viewAllCardsAvaialble);
        System.out.println(cardsAvailable);
        return cardsAvailable;
    }

    public void verifyUIComponents(String lastFourDigits)
    {
        //driver.findElement(moreCardDetailScreenLocators.lastFourDigitsFromCard(lastFourDigits));
        String fourDigits = baseActions.getLastFourDigits(lastFourDigits);

        FluentWait wait = new FluentWait(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(moreCardDetailScreenLocators.lastFourDigitsFromCard(fourDigits)));
        WebElement moreCardNo = driver.findElement(moreCardDetailScreenLocators.lastFourDigitsFromCard(fourDigits));

        WebElement homeLink = driver.findElement(moreCardDetailScreenLocators.homeLink);
      WebElement imgCard = driver.findElement(moreCardDetailScreenLocators.cardImg);
      WebElement balanceText = driver.findElement(moreCardDetailScreenLocators.balanceText);
      WebElement balanceamount = driver.findElement(moreCardDetailScreenLocators.balanceAmount);
      WebElement autoReload = driver.findElement(moreCardDetailScreenLocators.autoReloadText);
      WebElement autoReloadArrow = driver.findElement(moreCardDetailScreenLocators.autoReloadArrow);
      WebElement inactive = driver.findElement(moreCardDetailScreenLocators.inactiveText);
      WebElement autoRelaodMsg = driver.findElement(moreCardDetailScreenLocators.autoReloadInitialMsgToUser);
      WebElement manualLoadImg = driver.findElement(moreCardDetailScreenLocators.manualReloadImg);
      WebElement manualReloadArrow = driver.findElement(moreCardDetailScreenLocators.manualReloadArrow);
      WebElement addToWallet = driver.findElement(moreCardDetailScreenLocators.addToAppleWallet);

      Assert.assertTrue(moreCardNo.isDisplayed()==true);
      Assert.assertTrue(homeLink.isDisplayed()==true);

      Assert.assertTrue(imgCard.isDisplayed()==true);
      Assert.assertTrue(balanceText.isDisplayed()==true);
      Assert.assertTrue(balanceamount.isDisplayed()==true);
      Assert.assertTrue(autoReload.isDisplayed()==true);
      Assert.assertTrue(autoRelaodMsg.isDisplayed()==true);
      Assert.assertTrue(autoReloadArrow.isDisplayed()==true);
      Assert.assertTrue(inactive.isDisplayed()==true);
      Assert.assertTrue(manualLoadImg.isDisplayed()==true);
      Assert.assertTrue(manualReloadArrow.isDisplayed()==true);
      Assert.assertTrue(addToWallet.isDisplayed()==true);
    }


}