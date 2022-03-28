package pageLocators;

import org.openqa.selenium.By;

public class MoreCardDetailScreenLocators {

    String addedMoreCardLast4Numbers;

    public By addedMoreCard = By.xpath("//*[contains(text(),'More Card •• " +addedMoreCardLast4Numbers+"')]");
    public By balanceAmount = By.xpath("//*[contains(text(),'More Card •• 9435')]//preceding::div[1]");
    public By viewAllCardsAvaialble = By.xpath("//*[contains(text(),'More Card •• ')]");
}
