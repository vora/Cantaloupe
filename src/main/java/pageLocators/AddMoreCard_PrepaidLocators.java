package pageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

public class AddMoreCard_PrepaidLocators {

    String stringValue;

    public By addMoreCardLink = By.xpath("//*[text()='Add More Card']");
    public By addMoreCardText = By.xpath("//h1[text()='Add More Card']");
    public By addMoreCardNumber = By.xpath("//*[text()='More Card Number:']");
    public By moreCardInputField = By.id("id_cardNumber");
    public By securityCodeText = By.xpath("//*[text()='Security Code:']");
    public By securityCodeIputField = By.id("id_securityCode");
    public By addMoreButton = By.xpath("//button[contains(text(),'Add More Card')]");


    //More Card Added Landing ScreenOrientation
    public By moreCardAddedText = By.xpath("//*[text(), 'More Card Added']");
    public By moreCardSuccessMsg = By.xpath("//*[text(), 'More card was successfully added to your account' ]");
    public By proceedToHomeButton = By.xpath("//button[contains(text(),'Proceed To Home')]");
    public By confirmAddedMoreCard = By.xpath("//*[text(), 'More Card •• '"+stringValue+"]");

    //Home Page
    public By moreCardArrowMark = By.xpath("//img[@alt='gray arrow icon']");

    //MoreCardImage
    public By moreCardImage = By.xpath("//img[@alt='more card PREPAID CARD']");
    public By balanceText = By.xpath("//div[contains(text(), 'Balance')]");
    public By balanceValue = By.xpath("//div[contains(text(), 'Balance')]/span");
    public By confirmmoreCardNumberLastDigits = By.xpath("//*[text(), 'More Card •• '"+stringValue+"]");
    public By autoreload = By.xpath("//div[contains(text(), 'Auto Reload')]");
    public By autoreloadInitialStatus = By.xpath("//div[contains(text(), 'Auto Reload')]/span");
    public By autoreloadInitialStatusMsg = By.xpath("//span[contains(text(), 'This adds money to your card when the balance falls below a threshold.')]");
    public By autoreloadArrow = By.xpath("//span[contains(text(), 'This adds money to your card when the balance falls below a threshold.')]/span");


    //Manual Reload
    public By manualReloadText = By.xpath("//span[contains(text(), 'Manually Reload')]");
    public By manualReloadArrow = By.xpath("//span[contains(text(), 'Manually Reload')]/span");


    //Add to Apple Wallet
    public By addToWallet =  By.xpath("//img[@alt='apple wallet']");






}
