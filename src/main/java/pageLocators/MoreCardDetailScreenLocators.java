package pageLocators;

import base.TestBase;
import org.openqa.selenium.By;

public class MoreCardDetailScreenLocators extends TestBase {



//    public By balanceAmount = By.xpath("//*[contains(text(),'More Card •• 9435')]//preceding::div[1]");
    public By viewAllCardsAvaialble = By.xpath("//*[contains(text(),'More Card •• ')]");
    public By homeLink = By.xpath("//*[contains(text(),'HOME')]");
    public By cardImg = By.xpath("//img[@src='/images/card-more-prepaid.svg']");
    public By balanceText = By.xpath("//div[contains(text(),'Balance')]");
    public By balanceAmountWithDollar = By.xpath("//*[contains(text(),'Balance')]/span");
    public By autoReloadText = By.xpath("//*[contains(text(),'Auto Reload')]");
    public By inactiveText = By.xpath("//*[contains(text(),'Inactive')]");
    public By autoReloadArrow =   By.xpath("//img[@src='/icons/arrow-gray.svg']");
    public By autoReloadInitialMsgToUser = By.xpath("//*[contains(text(), 'This adds money to your card when the balance falls below a threshold.')]");
    public By manualReloadImg = By.xpath("//img[@src='/icons/balance.svg']");
    public By manualReloadArrow = By.xpath("//img[@src='/icons/arrow-gray.svg']");
    public By addToAppleWallet = By.xpath("//img[@src='/images/apple-wallet.svg']");
    public By balanceAmount = By.xpath("//*[contains(text(),'More Card •• 9435')]//preceding::div[1]");
    public By moreCardFourDigits = By.xpath("//div[contains(text(),'Balance')]/following-sibling::div");

    String addedMoreCard = "//*[contains(text(),'More Card •• " +addedMoreCardLast4Numbers+"')]";

    public By lastFourDigitsFromCard(String addedMoreCardLast4Numbers) {
        String lastFourDigits = "//*[contains(text(),'More Card •• " +addedMoreCardLast4Numbers+"')]";
        return By.xpath(lastFourDigits);
    }
}


