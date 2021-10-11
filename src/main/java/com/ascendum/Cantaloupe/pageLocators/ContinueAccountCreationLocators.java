package com.ascendum.Cantaloupe.pageLocators;

import org.openqa.selenium.By;

public class ContinueAccountCreationLocators {

    public By email = By.xpath("//input[@id='id_email']");
    public By noEmailEntered = By.xpath("//span[@class='styles__Msg-sc-1730kyp-1 fAhVqa']");
    public By nextButton = By.xpath("//button[@class='styles__Button-sc-1bmw993-0 iNrErr']");
    public By backToLoginText = By.xpath("//div[@class='styles__Text-sc-1r7ypxo-0 fwwrnt']");
}
