package pageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UpdateProfileLocators {

    public By homeLink = By.xpath("//*[text()='HOME']");
    public By editProfileHeader = By.xpath("//*[text()='Edit Profile']");
    public By emailFieldNonEditable = By.xpath("//input[@name='email']");
    public By passwordLabel = By.xpath("//*[text()='Password']");
    public By passwordFieldMasked = By.xpath("//input[@name='password']");
    public By passwordEditIcon = By.xpath("//img[@alt='edit icon']");
    public By passwordChange = By.linkText("Change");
    public By detailsLabel = By.xpath("//*[text()='Details']");
    public By firstnameLabel = By.xpath("//*[text()='First Name']");
    public By lastnameLabel = By.xpath("//*[text()='Last Name']");
    public By mobileNumberLabel = By.xpath("//*[text()='Mobile number']");
    public By streetAddressLabel = By.xpath("//*[text()='Street address']");
    public By cityLabel = By.xpath("//*[text()='City']");
    public By stateLabel = By.xpath("//*[text()='State']");
    public By zipcodeLabel = By.xpath("//*[text()='ZIP / Postal code']");
    public By firstNameInput = By.xpath("//input[@name='firstName']");

    public By lastNameInput = By.xpath("//input[@name='lastName']");

    public By mobileInput = By.xpath("//input[@name='mobile']");
    public By warmingIconForMobile = By.xpath("//img[@title='/icons/info-gray.svg']");
    public By warningMsgForMobile = By.xpath("//[text()='This Phone Number Must Be Unique And In Your Possession.']");
    public By streetAddressInput = By.xpath("//input[@name='address1']");

    public By cityInput = By.xpath("//input[@name='city']");

    public By stateInput = By.xpath("//input[@name='state']");

    public By zipcodeInput = By.xpath("//input[@name='postal']");

    public By updateButton = By.xpath("//*[text()='Update profile']");

    // error Messages
    public By firstNameError = By.xpath("//*[text()='Please enter your first name.']");
    public By lastNameError = By.xpath("//*[text()='Please enter your last name.']");
    public By mobileError = By.xpath("//*[text()='Invalid mobile number.']");
    public By mobileUniqueNessError = By.xpath("//input[@name='mobile']/../parent::div/../preceding-sibling::div[1]");
    public By streetAddressError = By.xpath("//*[text()='Please enter your address.']");
    public By cityError = By.xpath("//*[text()='Please enter your city.']");
    public By stateError = By.xpath("//*[text()='Please enter your state.']");
    public By zipcodeError = By.xpath("//*[text()='Please enter your zip code.']");

    //Clear Icons
    public By firstNameClearIcon = By.xpath("//input[@name='firstName']/../span");
    public By lastNameClearIcon = By.xpath("//input[@name='lastName']/../span");
    public By mobileClearIcon = By.xpath("//input[@name='mobile']/../span");
    public By streetAddressClearIcon = By.xpath("//input[@name='address1']/../span");
    public By cityClearIcon = By.xpath("//input[@name='city']/../span");
    public By stateClearIcon = By.xpath("//input[@name='state']/../span");
    public By zipcodeClearIcon = By.xpath("//input[@name='postal']/../span");











}
