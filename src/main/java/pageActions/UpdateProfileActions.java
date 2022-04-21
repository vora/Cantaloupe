package pageActions;

import base.BaseActions;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageLocators.AccountCreationLocators;
import pageLocators.ChangePasswordLocators;
import pageLocators.HomePageLocators;
import pageLocators.UpdateProfileLocators;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

public class UpdateProfileActions extends TestBase {

    BaseActions baseActions = new BaseActions();
    UpdateProfileLocators updateProfileLocators = new UpdateProfileLocators();
    AccountCreationLocators accountCreationLocators = new AccountCreationLocators();
    ChangePasswordLocators changePasswordLocators = new ChangePasswordLocators();
    AccountCreation accountCreation = new AccountCreation();

    HomePageLocators homePageLocators = new HomePageLocators();
    SignInWithExistingAccountActions signInWithExistingAccountActions = new SignInWithExistingAccountActions();

    public UpdateProfileActions() throws IOException {
    }

    //
    //Verify UI elements
    public List<WebElement> verifyUIElements() {
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

        Assert.assertTrue(homeLink.isDisplayed() == true, "Home Link is displayed");
        Assert.assertTrue(editProfileHeader.isDisplayed() == true, "editProfileHeader is displayed");
        Assert.assertTrue(emailFieldDisabled.isDisplayed() == true, "emailFieldDisabled is displayed");
        Assert.assertTrue(passwordLabel.isDisplayed() == true, "passwordLabel is displayed");
        Assert.assertTrue(passwordEditIcon.isDisplayed() == true, "passwordEditIcon is displayed");
        Assert.assertTrue(passwordChange.isDisplayed() == true, "passwordChange is displayed");
        Assert.assertTrue(passwordInput.isDisplayed() == true, "passwordInput is displayed");
        Assert.assertTrue(detailsLabel.isDisplayed() == true, "detailsLabel is displayed");
        Assert.assertTrue(firstNameLabel.isDisplayed() == true, "firstNameLabel is displayed");
        Assert.assertTrue(lastNameLabel.isDisplayed() == true, "lastNameLabel is displayed");
        Assert.assertTrue(mobileNumberLabel.isDisplayed() == true, "mobileNumberLabel is displayed");
        Assert.assertTrue(streetAddressLabel.isDisplayed() == true, "streetAddressLabel is displayed");
        Assert.assertTrue(cityLabel.isDisplayed() == true, "cityLabel is displayed");
        Assert.assertTrue(stateLabel.isDisplayed() == true, "stateLabel is displayed");
        Assert.assertTrue(zipcodeLebel.isDisplayed() == true, "zipcodeLebel is displayed");

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

    //Verify if Email is non editable
    public void verifyEmailFieldISEditableOrNot() {
        WebElement emailInputNotEditable = driver.findElement(updateProfileLocators.emailFieldNonEditable);
        Assert.assertTrue((emailInputNotEditable.isEnabled()) == false, "Email field i snot editable");
    }

    //Verify if the email field value has the same email as login
    public String verifyEmailIEdntered() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(updateProfileLocators.emailFieldNonEditable));
        WebElement emailInputNotEditable = driver.findElement(updateProfileLocators.emailFieldNonEditable);
        String enteredEmail = emailInputNotEditable.getAttribute("value");
        String emailDisplayed = properties.getProperty("existingAccountEmail");
        Assert.assertTrue(enteredEmail.equals(emailDisplayed), "email value is equal");
        return enteredEmail;
    }

    // Verify if Password is masked and check if Change Icon and text is available
    public void verifyPasswordField_UpdateProfie() {
        WebElement passwordMasked = driver.findElement(updateProfileLocators.passwordFieldMasked);
        WebElement passwordIcon = driver.findElement(updateProfileLocators.passwordEditIcon);
        WebElement passwordChangeText = driver.findElement(updateProfileLocators.passwordChange);
        baseActions.checkPasswordMaskedOrNot(updateProfileLocators.passwordFieldMasked);
        passwordChangeText.click();
        WebElement changePasswordHeader = driver.findElement(changePasswordLocators.changePasswordHeader);
        Assert.assertTrue((changePasswordHeader.isDisplayed()) == true, "User has navigated to Change Password Screen");
        driver.findElement(changePasswordLocators.backLink).click();
    }

    // Verify Details fields
    public void verifyDetailsFieldsAndErrorsDisplayed() throws AWTException {
        WebElement firstName = driver.findElement(updateProfileLocators.firstNameInput);
        WebElement lastName = driver.findElement(updateProfileLocators.lastNameInput);
        WebElement mobileNumber = driver.findElement(updateProfileLocators.mobileInput);
        WebElement streetAddress = driver.findElement(updateProfileLocators.streetAddressInput);
        WebElement city = driver.findElement(updateProfileLocators.cityInput);
        WebElement state = driver.findElement(updateProfileLocators.stateInput);
        WebElement zipcode = driver.findElement(updateProfileLocators.zipcodeInput);

        Assert.assertTrue((firstName.isDisplayed()) && (lastName.isDisplayed()) && (mobileNumber.isDisplayed()
                && (streetAddress.isDisplayed() && (city.isDisplayed()) && (state.isDisplayed()) && (zipcode.isDisplayed()))));

        clickandAssertError(firstName, updateProfileLocators.firstNameClearIcon, updateProfileLocators.firstNameError);
        clickandAssertError(lastName, updateProfileLocators.lastNameClearIcon, updateProfileLocators.lastNameError);

        mobileNumber.click();
        driver.findElement(updateProfileLocators.mobileClearIcon).click();
        baseActions.clearInputfieldAndEnterNewData(updateProfileLocators.mobileInput, "werer");
        mobileNumber.sendKeys(Keys.BACK_SPACE);
        baseActions.randomClickBasedOnOS();
        Assert.assertTrue(driver.findElement(updateProfileLocators.mobileError).isDisplayed());
        mobileNumber.isEnabled();

        clickandAssertError(streetAddress, updateProfileLocators.streetAddressClearIcon, updateProfileLocators.streetAddressError);
        clickandAssertError(city, updateProfileLocators.cityClearIcon, updateProfileLocators.cityError);
        clickandAssertError(state, updateProfileLocators.stateClearIcon, updateProfileLocators.stateError);
        clickandAssertError(zipcode, updateProfileLocators.zipcodeClearIcon, updateProfileLocators.zipcodeError);
    }

    //Click a button, clear the field, random click on screen, and asset if an element is available
    public void clickandAssertError(WebElement elementToClick, By clickClearIcon, By errorDisplayed) throws AWTException {
        elementToClick.click();
        driver.findElement(clickClearIcon).click();
        baseActions.randomClickBasedOnOS();
        Assert.assertTrue(driver.findElement(errorDisplayed).isDisplayed());
        elementToClick.isEnabled();
    }

    //public update firstNAme, LastName, Mobile, StreetAddress, City, State and Zipcode fields
    public void updateDetailsFields() throws AWTException {
        updateFirstName();
        updateLastName();
        updateMobile();
        updateStreetAddress();
        updateCity();
        updateState("CA");
        updateZipcode();
    }

    //Verify if user is able to edit and enter new value in the firstname fields
    public String updateFirstName() throws AWTException {
        WebElement firstNameInput = driver.findElement(updateProfileLocators.firstNameInput);
        String firstName = baseActions.regexFirstAndLastName(updateProfileLocators.firstNameInput, properties.getProperty("updateFirstName"));
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);
        return firstName;
    }

    //Verify if user is able to edit and enter new value in the lastname fields
    public String updateLastName() {
        WebElement lastNameInput = driver.findElement(updateProfileLocators.lastNameInput);
        String lastName = baseActions.regexFirstAndLastName(updateProfileLocators.lastNameInput, properties.getProperty("updateLastName"));
        lastNameInput.click();
        lastNameInput.sendKeys(lastName);
        return lastName;
    }

    //Verify if user is able to edit and enter new value in the mobile fields
    public String updateMobile() {
        WebElement mobileInput = driver.findElement(updateProfileLocators.mobileInput);
        String mobileNumber = baseActions.regexPhoneno(updateProfileLocators.mobileInput, properties.getProperty("updateMobile"));
        mobileInput.click();
        baseActions.clearInputfieldAndEnterNewData(updateProfileLocators.mobileInput, mobileNumber);
        driver.findElement(updateProfileLocators.mobileClearIcon).click();
        mobileInput.sendKeys(mobileNumber);
        return mobileNumber;
    }

    //Verify if user is able to edit and enter new value in the street fields
    public String updateStreetAddress() {
        WebElement streetAddressInput = driver.findElement(updateProfileLocators.streetAddressInput);
        String streetAddress = baseActions.regexPhoneno(updateProfileLocators.streetAddressInput, properties.getProperty("updateStreet"));
        streetAddressInput.click();
        streetAddressInput.sendKeys(streetAddress);
        return streetAddress;
    }

    //Verify if user is able to edit and enter new value in the street fields
    public String updateCity() {
        WebElement cityInput = driver.findElement(updateProfileLocators.cityInput);
        String city = baseActions.regexPhoneno(updateProfileLocators.cityInput, properties.getProperty("updateCity"));
        cityInput.click();
        cityInput.sendKeys(city);
        return city;
    }

    //Verify if user is able to edit and enter new value in the street fields
    public String updateState(String enterState) {
        WebElement stateInput = driver.findElement(updateProfileLocators.stateInput);
        boolean state = baseActions.regexState(updateProfileLocators.stateInput, properties.getProperty("updateState"));
        if(state==true)
        {
            stateInput.click();
            stateInput.sendKeys(enterState);
        }
        return enterState;
    }

    //Verify if user is able to edit and enter new value in the zipcode fields
    public String  updateZipcode() {
        WebElement zipcodeInput = driver.findElement(updateProfileLocators.zipcodeInput);
        String zipcode = baseActions.regexZipcode(updateProfileLocators.zipcodeInput, properties.getProperty("updateZipcode"));
        zipcodeInput.click();
        return zipcode;
    }

    //check all possibilitis for mobile field
    public boolean validateErrorsForMobile() throws AWTException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(updateProfileLocators.mobileUniqueNessError));
        WebElement checkError = driver.findElement(updateProfileLocators.mobileUniqueNessError);
        if((checkError.getText()).contains("Invalid mobile number.") || (checkError.getText()).contains("already in use")) {
            Assert.assertTrue(false, "Mobile field has invalid data");
        }
        else if(driver.findElement(updateProfileLocators.mobileInputTickMark).getAttribute("src").equals("/icons/check-circle-orange.svg"))
        {
            Assert.assertFalse(true, "The entered mobile data is valid and will not display any errors");
        }
        return true;
    }

    //verify update profile functionality
    public void verifyUpdateProfileFunctionality() throws AWTException {
        String firstname = updateFirstName();
        String lastName = updateLastName();
        String mobileNumber = updateMobile();
        String streetAddress = updateStreetAddress();
        String city = updateCity();
        String state = updateState("CA");
          String zipcode = updateZipcode();

        String firstNameValue = driver.findElement(updateProfileLocators.firstNameInput).getAttribute("value");
        String lastNameValue = driver.findElement(updateProfileLocators.lastNameInput).getAttribute("value");
        String mobileValue = driver.findElement(updateProfileLocators.mobileInput).getAttribute("value");
        String streetAddressValue = driver.findElement(updateProfileLocators.streetAddressInput).getAttribute("value");
        String cityValue = driver.findElement(updateProfileLocators.cityInput).getAttribute("value");
        String stateValue = driver.findElement(updateProfileLocators.stateInput).getAttribute("value");
        String zipcodeValue = driver.findElement(updateProfileLocators.zipcodeInput).getAttribute("value");

        String formattedMobileNumber = baseActions.extractNumbers(mobileValue);

        Assert.assertEquals(firstNameValue, firstname, "Firstname is equal");
        Assert.assertEquals(lastNameValue, lastName, "LastName is equal");
        Assert.assertEquals(formattedMobileNumber, mobileNumber, "Mobile Number is equal");
        Assert.assertEquals(streetAddressValue, streetAddress, "Street Address is equal");
        Assert.assertEquals(cityValue, city, "City is equal");
        Assert.assertEquals(stateValue, state, "State is equal");
        Assert.assertEquals(zipcodeValue, zipcode, "Zipcode is equal");
    }

      //Confirm Update Profile
        public void clickUpdateProfileButton() throws AWTException {
            driver.findElement(updateProfileLocators.updateButton).click();
            WebElement alertUpdateProfileSuccess = driver.findElement(By.xpath("//div[contains(@class, 'Toastify__toast-body')]"));
            String confirmText = "Your profile has been updated.";
            Assert.assertTrue(alertUpdateProfileSuccess.getText().equals(confirmText));
        }

    //Verify Phone Number Format
    public void verifyPhoneNoFormat()
    {
        baseActions.verifyPhoneNoFormat(updateProfileLocators.mobileInput);
    }

    //verify Errors After 10 Digit Entry for Mobile
    public void verifyErrorAfter10DigitsEntry()
    {
        baseActions.verifyErrorAfter10DigitsEntry(updateProfileLocators.mobileInput, updateProfileLocators.mobileUniqueNessError, updateProfileLocators.mobileInputTickMark);
    }

    //verify uniqueness error will have a number clickable
    public boolean verifyNumberclickable_InMobileError()
    {
        WebElement uniquenessError = driver.findElement(updateProfileLocators.mobileUniqueNessError);
        WebElement phoneNoLinkText = driver.findElement(By.linkText ("+1-888-561-4748"));
        Assert.assertTrue((uniquenessError.isDisplayed())==true && (phoneNoLinkText.isEnabled())==true, "The link in the error message is clickable");
        WebDriverWait wait = new WebDriverWait(driver,6);
        wait.until(ExpectedConditions.elementToBeClickable (phoneNoLinkText));
        return true;
    }


    //Cross check test data when is same as per registration
    public List<String> getEnteredValues_againtRegistration()
    {
        String email = baseActions.getEneteredValue(updateProfileLocators.emailFieldNonEditable);
        String firstName = baseActions.getEneteredValue(updateProfileLocators.firstNameInput);
        String lastName = baseActions.getEneteredValue(updateProfileLocators.lastNameInput);
        String mobileNumber = baseActions.getEneteredValue(updateProfileLocators.mobileInput);
        String streetAddress = baseActions.getEneteredValue(updateProfileLocators.streetAddressInput);
        String city = baseActions.getEneteredValue(updateProfileLocators.cityInput);
        String state = baseActions.getEneteredValue(updateProfileLocators.stateInput);
        String zipcode = baseActions.getEneteredValue(updateProfileLocators.zipcodeInput);

        System.out.println(email + "**********");
        System.out.println(properties.getProperty("registeredEmail"));

        List<String> profileValues = new ArrayList<>();
        profileValues.add(email);
        profileValues.add(mobileNumber);
        profileValues.add(streetAddress);
        profileValues.add(city);
        profileValues.add(state);
        profileValues.add(zipcode);

        //Check against registered values

        Assert.assertEquals(email, properties.getProperty("registeredEmail"), "Email is equal");
        Assert.assertEquals(mobileNumber, properties.getProperty("registeredMobileNumber"), "Mobile Number is equal");
        Assert.assertEquals(firstName, properties.getProperty("registeredFirstName"), "FirstName is equal");
        Assert.assertEquals(lastName, properties.getProperty("registeredLastName"), "LastName is equal");
        Assert.assertEquals(streetAddress, properties.getProperty("registeredStreetAddress"), "Street Address is equal");
        Assert.assertEquals(city, properties.getProperty("registeredCity"), "City is equal");
        Assert.assertEquals(state, properties.getProperty("registeredState"), "State is equal");
        Assert.assertEquals(zipcode, properties.getProperty("registeredZipcode"), "Zipcode is equal");
        return profileValues;
    }

    //Verify profile button will be activated only if all the fields are filled with data
    public void checkFieldsForBlankData() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 70);
        wait.until(ExpectedConditions.visibilityOfElementLocated(updateProfileLocators.passwordFieldMasked)).getAttribute("value");
        baseActions.checkFiedIsBlankOrHasData(updateProfileLocators.passwordFieldMasked);
        baseActions.checkFiedIsBlankOrHasData(updateProfileLocators.firstNameInput);
        baseActions.checkFiedIsBlankOrHasData(updateProfileLocators.lastNameInput);
        baseActions.checkFiedIsBlankOrHasData(updateProfileLocators.mobileInput);
        baseActions.checkFiedIsBlankOrHasData(updateProfileLocators.streetAddressInput);
        baseActions.checkFiedIsBlankOrHasData(updateProfileLocators.cityInput);
        baseActions.checkFiedIsBlankOrHasData(updateProfileLocators.stateInput);
        baseActions.checkFiedIsBlankOrHasData(updateProfileLocators.zipcodeInput);
    }


}
