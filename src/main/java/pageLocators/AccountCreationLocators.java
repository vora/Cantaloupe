package pageLocators;

import org.openqa.selenium.By;

public class AccountCreationLocators {

    public By listOfAllSpanErrors = By.xpath("//span[@class='styles__Msg-sc-1b7g2ge-1 eitdLI']");
    public By createAccountText = By.xpath("//*[@id='registration']/h1");
    public By emailIdInputField = By.xpath("//input[@id='id_email']");
    public By emailIdInputFieldPlaceHolder = By.xpath("//input[@id='id_email']/../label");
    public By createPasswordInputField = By.xpath("//*[@id='id_password']");
    public By createPasswordInputFieldPlaceHolder = By.xpath("//*[@id='id_password']/../label");
    public By confirmPasswordInptField = By.xpath("//input[@id='id_confirmPassword']");
    public By confirmPasswordInptFieldPlaceHolder = By.xpath("//input[@id='id_confirmPassword']/../label");
    public By passwordCriteriaText = By.xpath("//*[text()='Password Meets Criteria']");
    public By passwordNotAMatchText = By.xpath("//*[text()='Passwords Do Not Match']");
    public By firstName = By.xpath("//input[@id='id_firstName']");
    public By firstNamePlaceHolder = By.xpath("//input[@id='id_firstName']/../label");
    public By enterFirstNameErrorText = By.xpath("//*[text()='Please enter your first name.']");
    public By lastName = By.xpath("//input[@id='id_lastName']");
    public By lastNamePlaceHolder = By.xpath("//input[@id='id_lastName']/../label");
    public By enterLastNameErrorText = By.xpath("//*[text()='Please enter your last name.']");
    public By mobileNumberField = By.xpath("//input[@id='id_mobile']");
    public By mobileNumberInput = By.xpath("//input[@name='id_mobile']");
    public By mobileNumberFieldPlaceHolder = By.xpath("//input[@id='id_mobile']/../label");
    public By enterMobileNumberErrorText = By.xpath("//*[text()='Invalid mobile number.']");
    public By streetAddressInputField = By.xpath("//input[@id='id_address']");
    public By streetAddressInputFieldPlaceHolder = By.xpath("//input[@id='id_address']/../label");
    public By streetAddressErrorText = By.xpath("//*[text()='Please enter your address.']");
    public By cityInputField = By.xpath("//input[@id='id_city']");
    public By cityInputFieldPlaceHolder = By.xpath("//input[@id='id_city']/../label");
    public By cityErrorText = By.xpath("//*[text()='Please enter your city.']");
    public By stateInptField = By.xpath("//input[@id='id_state']");
    public By stateInptFieldPlaceHolder = By.xpath("//input[@id='id_state']/../label");
    public By stateErrorText = By.xpath("//*[text()='Please enter your state.']");
    public By zipcodeInputField = By.xpath("//input[@id='id_postal']");
    public By zipcodeInputFieldPlaceHolder = By.xpath("//input[@id='id_postal']/../label");
    public By zipcodeErrorText = By.xpath("//*[text()='Please enter your zip code.']");
    public By termsOfUseLink = By.xpath("//*[text()='Terms of Use']");
    public By privacyPolicyLink = By.xpath("//*[text()='Privacy Policy']");
    public By completeButton =By.xpath("//*[text()='Complete']");



    public By enterYourEmailInput = By.xpath("//*[@id='id_email']");
    public By blankEmailErrorMsg = By.xpath("//*[contains(text(), 'Please enter a valid email address.')]");
    public By nextButton = By.xpath("//*[text()='Next Step']");
    public By tickMarkImage = By.xpath("//input[@id='id_email']/parent::div/span/img");
    public By emailError = By.xpath("//*[text()='Please enter a valid email address.']");


    public By existingEmailError = By.xpath("//span[contains(text(), 'That Email Address Is Already In Use. Would You Like To Log In Instead?')]");


    public By loginThroughCreateScreen = By.xpath("//button[contains(text(),'Login')]");


    //Password section
    public By createPassowrd = By.id("id_password");
    public By confirmPassword = By.id("id_confirmPassword");
    public By showPassword = By.xpath("//span[contains(text(),'Show')]");
    public By hidePassword = By.xpath("//span[contains(text(),'Hide')]");
    public By passwordDoNotMatchError = By.xpath("//div[contains(text(), 'Passwords Do Not Match')]");
    public By passwordErrorCriteria = By.xpath("//*[contains(text(),'Password must be between 8 and 20 characters')]");
    public By passwordNotAMatchError = By.xpath("//*[text()='Passwords Do Not Match']");




    public By firstnameInput = By.id("id_firstName");
    public By lastNameInput = By.id("id_lastName");
    public By firstNameError = By.xpath("//span[contains(text(),'Please enter your first name.')]");
    public By lastNameError = By.xpath("//span[contains(text(),'Please enter your last name.')]");
    public By phoneNoInput = By.id("id_mobile");
    public By phoneNoValidTick = By.xpath("//input[@id='id_mobile']/../span/img");
    public By phoneNoInUseError = By.xpath("//input[@id='id_mobile']/../preceding-sibling::div/span");
    public By invalidMobileError = By.xpath("//span[contains(text(), 'Invalid mobile number.')]");
    public By tickMarkImageForMobile = By.xpath("//*[@id='id_mobile']/../span/img");

    public By streetAddressInput = By.id("id_address");
    public By cityInput = By.id("id_city");
    public By stateInput = By.id("id_state");
    public By zipcodeInput = By.id("id_postal");

    public By blankStreetError = By.xpath("//span[contains(text(), 'Please enter your address.')]");
    public By blankCityError = By.xpath("//span[contains(text(), 'Please enter your city.')]");
    public By blankStateError = By.xpath("//span[contains(text(), 'Please enter your state.')]");
    public By blankZipcodeError = By.xpath("//span[contains(text(), 'Please enter your zip code.')]");



    public By checkboxForTerms = By.xpath("//div[@class='styles__StyledCheckbox-sc-6jchgp-3 czmFPq']");
    public By checkBoxErrorMessage = By.xpath("//span[contains(text(), 'You must consent to our Privacy Policy and Terms of Use.')]");
    public By readAndAgreeText = By.xpath("//*[@id='registration']/label");


    //Initial Screen
    public By backHomeLink = By.xpath("//*[text()='Back home']");
    public By backToLoginOptions = By.xpath("//*[text()='Back to login options']");

    //Registration complete
    public By goodNewsText = By.xpath("//*[text()='Good News!']");
    public By sentMsgToCreatedEmail = By.xpath("//div[@class='styles__Message-sc-o3aos0-3 dIocUV']");

    //Terms Of Condition && PP
    public By tocConfirm_MoreUserTermsText = By.xpath("//*[text()='MORE User Terms']");
    public By privacyPolicyText = By.xpath("//*[text()='Privacy Policy']");
    public By backToSignUp = By.xpath("//*[text()='Back to Sign Up']");

    public By continueWithEmail = By.xpath("//*[@id='id_email']");


}
