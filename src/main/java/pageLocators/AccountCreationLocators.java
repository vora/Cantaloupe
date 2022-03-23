package pageLocators;

import org.openqa.selenium.By;

public class AccountCreationLocators {

    public By createAccountText = By.xpath("//*[@id='registration']/h1");
    public By emailIdInputField = By.xpath("//input[@id='id_email']");
    public By secureYourAccountText = By.xpath("//*[@id='registration']/div[2]/div[1]");
    public By enterPersonalDetailsText = By.xpath("//*[@id='registration']/div[4]/div[1]");
    public By createPasswordInputField = By.xpath("//*[@id='id_password']");
    public By confirmPasswordInptField = By.xpath("//input[@id='id_confirmPassword']");
    public By passwordCriteriaText = By.xpath("//span[@class='styles__Msg-sc-1730kyp-1 fAhVqa']");
    public By passwordNotAMatchText = By.xpath("//span[@class='styles__Msg-sc-1730kyp-1 fAhVqa']");
    public By firstName = By.xpath("//input[@id='id_firstName']");
    public By enterFirstNameErrorText = By.xpath("//span[@class='styles__Msg-sc-1730kyp-1 fAhVqa']");
    public By lastName = By.xpath("//input[@id='id_lastName']");
    public By enterLastNameErrorText = By.xpath("//span[@class='styles__Msg-sc-1730kyp-1 fAhVqa']");
    public By mobileNumberField = By.xpath("//input[@id='id_mobile']");
    public By enterMobileNumberErrorText = By.xpath("//span[@class='styles__Msg-sc-1730kyp-1 fAhVqa']");
    public By streetAddressInputField = By.xpath("//input[@id='id_address']");
    public By streetAddressErrorText = By.xpath("//span[@class='styles__Msg-sc-1730kyp-1 fAhVqa']");
    public By cityInputField = By.xpath("//input[@id='id_city']");
    public By cityErrorText = By.xpath("//span[@class='styles__Msg-sc-1730kyp-1 fAhVqa']");
    public By stateInptField = By.xpath("//input[@id='id_state']");
    public By stateErrorText = By.xpath("//span[@class='styles__Msg-sc-1730kyp-1 fAhVqa']");
    public By zipcodeInputField = By.xpath("//input[@id='id_postal']");
    public By zipcodeErrorText = By.xpath("//span[@class='styles__Msg-sc-1730kyp-1 fAhVqa']");
    public By consentCheckText = By.xpath("//label[@class='styles__Label-sc-89ol7f-0 eeINRw']");
    public By consentCheckBox = By.xpath("//div[@class='styles__StyledCheckbox-sc-89ol7f-3 gBQzxl']");
    public By termsOfUseLink = By.xpath("//*[text()='Terms of Use']");
    public By privacyPolicyLink = By.xpath("//*[text()='Privacy Policy']");
    public By completeButton =By.xpath("//*[text()='Complete']");
    public By backToLoginLink = By.xpath("//div[@class='styles__Text-sc-1r7ypxo-0 fwwrnt']");


    public By enterYourEmailInput = By.xpath("//*[@id='id_email']");
    public By blankEmailErrorMsg = By.xpath("//*[contains(text(), 'Please enter a valid email address.')]");
    public By nextButton = By.xpath("//*[@id='registration']/div[2]/button");
    public By emailErrorMessage = By.xpath("//*[contains(text(),'Password must be between 8 and 20 characters. It must contain at least 1 uppercase letter, 1 lowercase letter, 1 number, and a special character from this list')]");
    public static By tickMarkImage = By.xpath("//*[@id='registration']/div[1]/div/span/img");
    public By existingEmailError = By.xpath("//*[@id='registration']/div[1]/div[1]/span");
    public By loginThroughCreateScreen = By.xpath("//*[@id='registration']/div[1]/div[1]/button");


    //Password section
    public By createPassowrd = By.id("id_password");
    public By confirmPassword = By.id("id_confirmPassword");
    public By passwordsCriteria = By.xpath("//*[@id='registration']/div[2]/div[2]/div");
    public By passwordMatch = By.xpath("//*[@id='registration']/div[3]/div[1]/div");
    public By showPassword = By.xpath("//span[contains(text(),'Show')]");
    public By hidePassword = By.xpath("//span[contains(text(),'Hide')]");
    //public By passwordErrorCriteria = By.xpath("//*[contains(text(),'Password must be between 8 and 20 characters. It must contain at least 1 uppercase letter, 1 lowercase letter, and a special character from this list");
    public By passwordError = By.xpath("//*[@id='registration']/div[2]/div[3]");
    public By passwordDoNotMatchError = By.xpath("//div[contains(text(), 'Passwords Do Not Match')]");
    public By passwordErrorCriteria = By.xpath("//*[contains(text(),'Password must be between 8 and 20 characters')]");




    public By firstnameInput = By.id("id_firstName");
    public By lastNameInput = By.id("id_lastName");
    public By firstNameError = By.xpath("//span[contains(text(),'Please enter your first name.')]");
    public By lastNameError = By.xpath("//span[contains(text(),'Please enter your last name.')]");
    public By phoneNoInput = By.id("id_mobile");
    public By uniquePhoneNumberText = By.xpath("//span[contains(text(), 'This Phone Number Must Be Unique And In Your Possession.')]");
    public By alreadyUsedPhoneNoText = By.xpath("//span[contains(text(), 'If You Already Used This Phone Number, Please Try Resetting The User Information Via User Profile Update.')]");

    public By invalidMobileError = By.xpath("//span[contains(text(), 'Invalid mobile number.')]");

    public By streetAddressInput = By.id("id_address");
    public By cityInput = By.id("id_city");
    public By stateInput = By.id("id_state");
    public By zipcodeInput = By.id("id_postal");

    public By blankStreetError = By.xpath("//span[contains(text(), 'Please enter your address.')]");
    public By blankCityError = By.xpath("//span[contains(text(), 'Please enter your city.')]");
    public By blankStateError = By.xpath("//span[contains(text(), 'Please enter your state.')]");
    public By blankZipcodeError = By.xpath("//span[contains(text(), 'Please enter your zip code.')]");



    //public By consentToPrivacyText = By.xpath("//span[contains(text(), 'You must consent to our Privacy Policy and Terms of Use.')]");
    public By checkboxForTerms = By.xpath("//input[@id='agreement']");
    public By checkBoxErrorMessage = By.xpath("//span[contains(text(), 'You must consent to our Privacy Policy and Terms of Use.')]");
    public By readAndAgreeText = By.xpath("//*[@id='registration']/label");
    //public By termsOfUseLink = By.xpath("//*[@id='registration']/div[11]");
  //  public By privacyPolicyLink = By.xpath("//*[@id='registration']/div[12]");


    //Initial Screen
    public By backHomeLink = By.xpath("//*[text()='Back home']");
}
