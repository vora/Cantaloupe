package pageLocators;

import org.openqa.selenium.By;

public class CreateAccountLocators {

    public By emailIdInputField = By.xpath("//*[@id='id_email']");
    public By enterYourEmailInput = By.xpath("//*[@id='id_email']");
    public By nextButton = By.xpath("//*[@id='registration']/div[2]/button");
    public By emailErrorMessage = By.xpath("//*[@id='registration']/div/div[1]/span");
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
    public By passwordErrorCriteria = By.xpath("//*[@id='registration']/div[2]/div[2]/span");
    public By passwordError = By.xpath("//*[@id='registration']/div[2]/div[3]");
    public By passwordDoNotMatchError = By.xpath("//*[@id='registration']/div[3]/div[2]/span");




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
    public By checkboxForTerms = By.id("agreement");
    public By checkBoxErrorMessage = By.xpath("//span[contains(text(), 'You must consent to our Privacy Policy and Terms of Use.')]");
    public By readAndAgreeText = By.xpath("//*[@id='registration']/label");
    public By termsOfUseLink = By.xpath("//*[@id='registration']/div[11]");
    public By privacyPolicyLink = By.xpath("//*[@id='registration']/div[12]");
    public By completeButton = By.xpath("//*[@id='registration']/div[13]/button");



}
