package com.ascendum.Cantaloupe.pageActions;

import com.ascendum.Cantaloupe.base.TestBase;
import com.ascendum.Cantaloupe.pageLocators.AccountCreationLocators;
import com.ascendum.Cantaloupe.pageLocators.ContinueAccountCreationLocators;
import com.ascendum.Cantaloupe.pageLocators.CreateAccountLocators;
import com.ascendum.Cantaloupe.pageLocators.LoginScreen;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Properties;

public class LoginWithExistingActions extends TestBase {

    Properties prop = new Properties();
    LoginScreen loginScreen = new LoginScreen();
    CreateAccountLocators createAccountLocators = new CreateAccountLocators();
    ContinueAccountCreationLocators continueAccountCreationLocators = new ContinueAccountCreationLocators();
    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();

    public LoginWithExistingActions() throws IOException {
    }


    public void loginWithExistingAccount(String existingAccountEmail, String existingAccount, String createAccount, String createAccountPassword, String createAccountConfirmPassword,
                                         String firstName, String lastName, String mobileNumber, String streetAddress, String city, String state, String zipcode) throws IOException
    {
        driver.findElement(loginScreen.alreadyHaveAccountButton).click();
        driver.findElement(createAccountLocators.continueWithEmail).click();
        driver.findElement(By.xpath("//input[@id='id_email']")).sendKeys(existingAccount);
        driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Pass@1234");
        driver.findElement(By.xpath("//button[@class='styles__Button-sc-1bmw993-0 iNrErr']")).click();
        driver.findElement(By.xpath("//span[@class='styles__TextLink-sc-tw500q-2 KcMtV']")).click();


    }
}