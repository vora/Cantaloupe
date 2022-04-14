package pageActions;

import base.BaseActions;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageLocators.AccountCreationLocators;
import pageLocators.HomePageLocators;
import pageLocators.UpdateProfileLocators;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UpdateProfileActions extends TestBase {

    BaseActions baseActions = new BaseActions();
    UpdateProfileLocators updateProfileLocators = new UpdateProfileLocators();
    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
    AccountCreation1 accountCreation1 = new AccountCreation1();
    HomePageLocators homePageLocators = new HomePageLocators();
    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();

    public UpdateProfileActions() throws IOException {
    }

    //Verify UI elements
    public List<WebElement> verifyUIElements()
    {
        WebElement homeLink = driver.findElement(updateProfileLocators.homeLink);
        WebElement editProfileHeader = driver.findElement(updateProfileLocators.editProfileHeader);
        WebElement emailFieldDisabled = driver.findElement(updateProfileLocators.emailFieldNonEditable);
        WebElement passwordLabel = driver.findElement(updateProfileLocators.passwordLabel);
        WebElement passwordEditIcon = driver.findElement(updateProfileLocators.passwordEditIcon);
        WebElement passwordChange = driver.findElement(updateProfileLocators.passwordChange);
        WebElement passwordInput = driver.findElement(updateProfileLocators.passwordFieldMasked);
        WebElement detailsLabel = driver.findElement(updateProfileLocators.detailsLabel);
        WebElement firstNameLabel = driver.findElement(updateProfileLocators.firstnameLabel);
        WebElement lastNameLabel = driver.findElement(updateProfileLocators.lastnameLabel);
        WebElement mobileNumberLabel = driver.findElement(updateProfileLocators.mobileNumberLabel);
        WebElement streetAddressLabel = driver.findElement(updateProfileLocators.streetAddressLabel);
        WebElement cityLabel = driver.findElement(updateProfileLocators.cityLabel);
        WebElement stateLabel = driver.findElement(updateProfileLocators.stateLabel);
        WebElement zipcodeLebel = driver.findElement(updateProfileLocators.zipcodeInput);
        WebElement updateButton = driver.findElement(updateProfileLocators.updateButton);

        Assert.assertTrue(homeLink.isDisplayed()==true, "Home Link is displayed");
        Assert.assertTrue(editProfileHeader.isDisplayed()==true, "editProfileHeader is displayed");
        Assert.assertTrue(emailFieldDisabled.isDisplayed()==true, "emailFieldDisabled is displayed");
        Assert.assertTrue(passwordLabel.isDisplayed()==true, "passwordLabel is displayed");
        Assert.assertTrue(passwordEditIcon.isDisplayed()==true, "passwordEditIcon is displayed");
        Assert.assertTrue(passwordChange.isDisplayed()==true, "passwordChange is displayed");
        Assert.assertTrue(passwordInput.isDisplayed()==true, "passwordInput is displayed");
        Assert.assertTrue(detailsLabel.isDisplayed()==true, "detailsLabel is displayed");
        Assert.assertTrue(firstNameLabel.isDisplayed()==true, "firstNameLabel is displayed");
        Assert.assertTrue(lastNameLabel.isDisplayed()==true, "lastNameLabel is displayed");
        Assert.assertTrue(mobileNumberLabel.isDisplayed()==true, "mobileNumberLabel is displayed");
        Assert.assertTrue(streetAddressLabel.isDisplayed()==true, "streetAddressLabel is displayed");
        Assert.assertTrue(cityLabel.isDisplayed()==true, "cityLabel is displayed");
        Assert.assertTrue(stateLabel.isDisplayed()==true, "stateLabel is displayed");
        Assert.assertTrue(zipcodeLebel.isDisplayed()==true, "zipcodeLebel is displayed");

        List<WebElement> updateProfileElements = new ArrayList<WebElement>();
        updateProfileElements.add(homeLink);
        updateProfileElements.add(editProfileHeader);
        updateProfileElements.add(emailFieldDisabled);
        updateProfileElements.add(passwordLabel);
        updateProfileElements.add(passwordEditIcon);
        updateProfileElements.add(passwordChange);
        updateProfileElements.add(passwordInput);
        updateProfileElements.add(detailsLabel);
        updateProfileElements.add(firstNameLabel);
        updateProfileElements.add(lastNameLabel);
        updateProfileElements.add(mobileNumberLabel);
        updateProfileElements.add(streetAddressLabel);
        updateProfileElements.add(cityLabel);
        updateProfileElements.add(stateLabel);
        updateProfileElements.add(zipcodeLebel);
        updateProfileElements.add(updateButton);

        return updateProfileElements;
    }
}
