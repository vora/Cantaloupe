package com.ascendum.Cantaloupe.pageLocators;

import org.openqa.selenium.By;

public class SignInWithExistingAccountLocators {

    public By signInText = By.xpath("//h1[@class='styles__Text-sc-1ualdcc-0 iMfJqE']");
    public By emailInput = By.xpath("//input[@id='id_email']");
    public By emailInputClearIcon = By.xpath("//span[@class='styles__ClearButton-sc-ghu8hj-4 gTnkhk']/img/@src");
    public By errorMessages = By.xpath("//span[@class='styles__Msg-sc-1730kyp-1 fAhVqa']");
    public By passwordInput = By.xpath("//input[@id='id_password']");
    //public By noPasswordEntered = By.xpath("//span[@class='styles__Msg-sc-1730kyp-1 fAhVqa']");
    public By showPasswordEye = By.xpath("//span[@class='styles__ClearButton-sc-ghu8hj-4 gTnkhk']/img/@src");
    public By nextButton = By.xpath("//button[@class='styles__Button-sc-1bmw993-0 iNrErr']");
    public By backToLoginText = By.xpath("//div[@class='styles__Text-sc-1r7ypxo-0 fwwrnt']");
    public By forgotPasswordLink = By.xpath("//div[@class='styles__Text-sc-1r7ypxo-0 iTbwbW']");
    public By signInButton = By.xpath("//button[@class='styles__Button-sc-1bmw993-0 iNrErr']");
    public By backToLogin = By.xpath("//div[@class='styles__Text-sc-1r7ypxo-0 fwwrnt']");
}

