package base;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BaseActions extends TestBase {

    String url = "";
    String homePage = "";
    String link = "";
    String state;

    public BaseActions() throws IOException {
    }


    // Verify if the element is present and prints the text of the element accordingly
    public void checkIfWebElementIsPresent(By locator) {
        WebElement element = driver.findElement(locator);
        final Boolean checkElementPresent = element.isDisplayed();
        if (checkElementPresent.equals(true)) {
            log.info("The webelement : " + retrieveText(locator) + " is present on the web page.");
        } else {
            log.info("The welelment : " + "" + retrieveText(locator) + "\""
                    + " is miising - There might be some error in loading of the page. Please refresh and try again.");
        }
    }

    //Method to get all the anchor tags in a list
    public void checkAllAnchorTags() {
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = allLinks.iterator();
        while (it.hasNext()) {

            url = it.next().getAttribute("href");
            if (url == null || url.equals("")) {
                continue;
            }

            if (!url.startsWith(homePage)) {
                log.info(url + " - URL belongs to another domain. Hence, skipping it.");
                continue;
            }
            validateUrl(url);
        }
    }

    // verify if the url is valid or broken
    public void validateUrl(String link) {
        try {
            URL url = new URL(link);

            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setConnectTimeout(2000);
            httpConn.connect();

            if (httpConn.getResponseCode() == 200) {
                log.info(link + " " + httpConn.getResponseMessage() + ". The url is valid");
            }

            this.checkFor200Status(httpConn.getResponseCode());

            if (httpConn.getResponseCode() >= 300) {
                log.info(link + " - " + httpConn.getResponseMessage() + ". The URL is being redirected");
            }

            if (httpConn.getResponseCode() >= 400) {
                System.out.println(link + " - " + httpConn.getResponseMessage() + ". The URL is either broken or not configured");
            }

            if (httpConn.getResponseCode() >= 500) {
                System.out.println(link + " - " + httpConn.getResponseMessage() + ". There are server errors");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Method to validate the http - status code
    public void checkFor200Status(int statusCode) {
        switch (statusCode) {
            case 201: {
                log.info(link + " - Created");
            }
            case 202: {
                log.info(link + " - Accepted");
            }
            case 203: {
                log.info(link + " - Non-Authoritative Information");
            }
            case 204: {
                log.info(link + " - No Content");
            }
            case 205: {
                log.info(link + " - Reset Content");
            }
            case 206: {
                log.info(link + " - Partial Content");
            }
            case 207: {
                log.info(link + " - Multi Status (WebDAV)");
            }
            case 208: {
                log.info(link + " - Non-Authoritative Information (WebDAV)");
            }
            case 226: {
                log.info(link + " - IM Used");
            }
        }

    }

    // Method to fetch the retrieved text
    public String retrieveText(By locator) {
        WebElement element = driver.findElement(locator);
        final String elementText = element.getText();
        return elementText;
    }

    //Method to click on an elemenet based on the element locator
    public void clickLinksAndButtons(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    // Method to validate the search results (if entered text and retrieved text are same)
    public void retrievedSearchResults(By locator, String searchText) {
        WebElement element = driver.findElement(locator);
        String retrievedText = element.getText();
        String expectedText = searchText;
        Assert.assertEquals(retrievedText, expectedText);
    }

    //Mouse over on the webelement
    public void mousehover(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void enterText(By locator, String str) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(str);
    }

    public void verifyElementPresent(By locator) {
        WebElement element = driver.findElement(locator);
        element.isDisplayed();
    }

    //Gets all the error messages in a list
    public List<String> getListElements(By element) {
        List<WebElement> allErrors = driver.findElements(element);

        List<String> errorText = new ArrayList<>();

        for (int i = 0; i < allErrors.size(); i++) {
            String errorTextAdd = allErrors.get(i).getAttribute("innerHTML");
            errorText.add(errorTextAdd);
        }

        return errorText;
    }

    public void deleteInputCharacters(By element) {
        String inputField = driver.findElement(element).getAttribute("value");
        List<String> one = new ArrayList<>();

        for (int i = 0; i <= inputField.length(); i++) {
            //char c = inputField.charAt(i);
            driver.findElement(element).sendKeys(Keys.BACK_SPACE);
        }
    }

    public void clickButton(By element) {
        WebElement webElement = driver.findElement(element);
        webElement.click();
    }

    public void enterValue(By element, String sendKeysData) {
        driver.findElement(element).sendKeys(sendKeysData);
    }

    //Regex for Email
    public void validateEmailInputs(By element, String email) {
        // String regex = "^(.+)@(\\S+)$";
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        WebElement webElement = driver.findElement(element);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        Boolean checkPatternCondition = matcher.matches();

        if (checkPatternCondition == true) {
            webElement.sendKeys(email);
        } else if ((checkPatternCondition == false)) {
            Assert.assertTrue(true, "The entered email is not valid");
        } else {
            log.info("Create Account Screen : Something is not proper for email ");
        }
    }

    public String validateErrorMessages(By element) {
        WebElement webElement = driver.findElement(element);
        String errorMessage = webElement.getText();
        if (webElement.isDisplayed()) {

            Assert.assertTrue(true, errorMessage + " is showing up");
        } else {
            Assert.assertTrue(false, errorMessage + " is not shown");
        }

        return webElement.getText();
    }

    public boolean regexPassword(By element, String password) {
        String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$";
        boolean isPasswordValid = regexExpression(element, password, regexPassword);
        return isPasswordValid;
    }

    //Verify if the password fields are masked before clicking show
    public void checkPasswordMaskedOrNot(By element) {
        WebElement passwordMasked = driver.findElement(element);
        if (passwordMasked.getAttribute("type").equals("password")){
            Assert.assertTrue(true, "Field is masked");
        } else {
            Assert.assertTrue(false, "Field is not masked");
        }
    }

    //Clear and re-enter data in input field through js
    public void clearInputfieldAndEnterNewData(By element, String editValue) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value=' " + editValue + " ';", driver.findElement(element));

    }

    public String regexFirstAndLastName(By element, String name) {
        String regex = "^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{8,20})?)";
        WebElement webElement = driver.findElement(element);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);

        Boolean checkPatternCondition = matcher.matches();

        if (checkPatternCondition == true) {
            webElement.sendKeys(name);
        } else if ((checkPatternCondition == false)) {
            Assert.assertTrue(true, "The entered name is not valid");
        } else {
            log.info("Create Account Screen : Something is not proper for the entered name ");
        }
        return name;
    }

    //regex phone no
    public String regexPhoneno(By element, String phoneNo) {
        String regex = "^\\d{10}$";
        WebElement webElement = driver.findElement(element);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNo);

        Boolean checkPatternCondition = matcher.matches();

        if (checkPatternCondition == true) {
            webElement.sendKeys(phoneNo);
        } else if ((checkPatternCondition == false)) {
            Assert.assertTrue(true, "The entered nmber is not valid");
        } else {
            log.info("Create Account Screen : Something is not proper for the entered phone number ");
        }
        return phoneNo;

    }

    //regex phone no
    public void regexAddress(By element, String streetAddress) {
        String regex = "^[\\.a-zA-Z0-9,!? ]*$";
        WebElement webElement = driver.findElement(element);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(streetAddress);

        Boolean checkPatternCondition = matcher.matches();

        if (checkPatternCondition == true) {
            webElement.sendKeys(streetAddress);
        } else if ((checkPatternCondition == false)) {
            Assert.assertTrue(true, "The entered address is not valid");
        } else {
            log.info("Create Account Screen : Something is not proper for the entered address ");
        }

    }

    //regex zipcode
    public String regexZipcode(By element, String zipcode) {
        String regex = "\\b\\d{5}(?:-\\d{4})?\\b";
        WebElement webElement = driver.findElement(element);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(zipcode);

        Boolean checkPatternCondition = matcher.matches();

        if (checkPatternCondition == true) {
            webElement.sendKeys(zipcode);
        } else if ((checkPatternCondition == false)) {
            Assert.assertTrue(false, "The entered zipcode is not valid");
        } else {
            log.info("Create Account Screen : Something is not proper for the entered zipcode ");
        }
        return zipcode;
    }

    ///regexcity
    public void regexCity(By element, String cityOrState) {
        String regex = "(?:[A-Z][a-z.-]+[ ]?)+";
        WebElement webElement = driver.findElement(element);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cityOrState);

        Boolean checkPatternCondition = matcher.matches();

        if (checkPatternCondition == true) {
            webElement.sendKeys(cityOrState);
        } else if ((checkPatternCondition == false)) {
            Assert.assertTrue(true, "The entered address is not valid");
        } else {
            log.info("Create Account Screen : Something is not proper for the entered address ");
        }

    }


    //Regex for state
    public boolean regexState(By element, String state)
    {
        String regexState = "^(?:(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY]))$";
        boolean isStateValid = regexExpression(element, state, regexState);
        return isStateValid;
    }

    //JS
    public void clearData(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value= ''", element);


    }

    //Random click()
    public void randomClickOnScreen() throws AWTException {
        Actions actions = new Actions(driver);
        Robot robot = new Robot();
        robot.mouseMove(0, 0);
        actions.click().build().perform();
    }

    public boolean regexExpression(By element, String enterData, String regexType) {
        WebElement webElement = driver.findElement(element);
        Pattern pattern = Pattern.compile(regexType);
        Matcher matcher = pattern.matcher(enterData);

        Boolean checkPatternCondition = matcher.matches();

        if (checkPatternCondition == true) {
            webElement.sendKeys(enterData);
        } else if ((checkPatternCondition == false)) {
            Assert.assertTrue(false, "The entered data is not valid");
        } else {
            log.info("Create Account Screen : Something is not proper for the entered phone number ");
        }
        return checkPatternCondition;

    }

    public void randomClickBasedOnOS() throws AWTException {
        if ((properties.getProperty("platformName")).equalsIgnoreCase("iOS")) {
            driver.findElement(By.xpath("//html")).click();
        } else if ((properties.getProperty("platformName")).equalsIgnoreCase("Android")) {
            randomClickOnScreen();
        }
    }

    //Scroll to top of the screen
    public void scrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,0)");
    }

    //Scroll to top of the screen
    public void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }


    //Last 4 digits of the card
    public String getLastFourDigits(String enterCardNo) {
        addedMoreCardLast4Numbers = enterCardNo.substring(enterCardNo.length() - 4);
        return addedMoreCardLast4Numbers;
    }

    //GetDropdownOptions
    public List<String> getallOptions(By element) {
        {
            List<String> options = new ArrayList<String>();
            for (WebElement option : new Select(driver.findElement(element)).getOptions()) {
                String getDropdownValue = option.getText();
                if (option.getAttribute("value") != "") options.add(getDropdownValue);
            }
            System.out.println(options);
            return options;
        }

    }

    //Credit card Validation checks

    public void creditCardValidation(long creditCardNumber) {
        Assert.assertTrue(checkLengthOfCreditCard(creditCardNumber)>= 13 && checkLengthOfCreditCard(creditCardNumber) <= 16 &&
                (checkPrefixDigitsForCC(creditCardNumber, 4) || checkPrefixDigitsForCC(creditCardNumber, 5) ||
                        checkPrefixDigitsForCC(creditCardNumber, 37) || checkPrefixDigitsForCC(creditCardNumber, 6)) &&
                (sumOfEvenPlaces_CC(creditCardNumber)+sumOfOddPlaces_CC(creditCardNumber)) % 10 == 0);
    }

    public int checkLengthOfCreditCard(long creditCardNumber) {
        String num = creditCardNumber+"";
        return num.length();
    }
    public boolean checkPrefixDigitsForCC(long creditCardNumber, int startingNumberForCards) {
        return getprefixForCC(creditCardNumber, checkLengthOfCreditCard(startingNumberForCards)) == startingNumberForCards;
    }
    public long getprefixForCC(long creditCardNumber, int startingNumberForCards) {
        if(checkLengthOfCreditCard(creditCardNumber)>startingNumberForCards) {
            String num = creditCardNumber + "";
            return Long.parseLong(num.substring(0, startingNumberForCards));
        }
        return creditCardNumber;
    }

    public int sumOfOddPlaces_CC(long creditCardNumber) {
        int sum = 0;
        String num = creditCardNumber + "";
        for(int i = checkLengthOfCreditCard(creditCardNumber)-1; i >= 0; i -= 2) {
            sum += Integer.parseInt(num.charAt(i)+"");
        }
        return sum;
    }

    public int sumOfEvenPlaces_CC(long creditCardNumber) {
        int sum = 0;
        String num = creditCardNumber + "";
        for(int i = checkLengthOfCreditCard(creditCardNumber)-1; i >= 0; i -= 2) {
            sum += isCreditCardNumberDivisible(Integer.parseInt(num.charAt(i)+""));
        }
        return sum;
    }
    public int isCreditCardNumberDivisible(int number) {
        if(number<9)
            return number;
        return number/10 + number%10;
    }

    //Get the last character from the string
    public Character getLastCharacter(String str)
    {
        Character newString =  str.charAt(str.length()-1);
        return newString;
    }

    public void checkFieldsAreEditable(By element)
    {
        Assert.assertTrue((driver.findElement(element).isEnabled())==true, "Element is in enable mode");
    }

    //VerifyTickMark()
    public Boolean verrifyTickMark(By ele) {
        Boolean element = driver.findElements(ele).size()>0;
        if (element == true) {
            //Boolean image1Present = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", driver.findElement(ele));
            Assert.assertTrue(true, "Tick mark is present");
        } else {
            Assert.assertTrue(false, "tick mark is not present");
        }
        return element;
    }



    //Add all the inputs for address and get it into one string
    public String addUpAllAddressInputs(By street, By city) {
        String addressEntered = driver.findElement(street).getAttribute("value");
        String cityEntered = driver.findElement(city).getAttribute("value");
        String streetAddressAndCity = addressEntered + " " + cityEntered + " ";
        return streetAddressAndCity;
    }

    //Regx for the final String of address
    public void regexCompleteAddress(By street,  By city )
    {
        String regexFinalAddress = "^[\\.a-zA-Z0-9,!? ]*$";
        String finalStringAddress = addUpAllAddressInputs(street, city);

        Pattern pattern = Pattern.compile(regexFinalAddress);
        Matcher matcher = pattern.matcher(finalStringAddress);

        Boolean checkPatternCondition = matcher.matches();

        if (checkPatternCondition == true) {

        }
        else if (checkPatternCondition == false)
        {
            Assert.assertTrue(false, "The entered data is not valid");
        } else {
            log.info("Create Account Screen : Something is not proper for the entered phone number ");
        }
    }

    //Vlidate mobile data entered and errors
    public boolean verifyMobileEntered(By element, By errorForUniqueness, By invalidError)
    {
        String phoneNoText = driver.findElement(element).getAttribute("value");
        WebElement uniquenessError = driver.findElement(errorForUniqueness);
        String numberOnly = phoneNoText.replaceAll("[^0-9]", "");

        int phoneNoLength = numberOnly.length();
        if(phoneNoLength==10)
        {
            WebElement phoneNoLinkText = driver.findElement(By.linkText ("+1-888-561-4748"));
            Assert.assertTrue(uniquenessError.isDisplayed()==true, "Error message is displayed after entering 10 digits");
            WebDriverWait wait = new WebDriverWait(driver,6);
            // elementToBeClickable expected criteria

            Assert.assertTrue(phoneNoLinkText.isEnabled(), "The link is in enabled mode");
            wait.until(ExpectedConditions.elementToBeClickable (phoneNoLinkText));
            return true;
        }
        else if((driver.findElement(invalidError)).isDisplayed()==true)
        {
            Assert.assertTrue(uniquenessError.isDisplayed()==true, "Invalid mobile number.");
            return true;
        }
        else
        {
            Assert.assertTrue(false, "Error messages for mobile is not displayed properly");
        }
        return false;
    }

    //Extract only numbers from a string
    public String extractNumbers(String mobileNo)
    {
        String mobileNumberOnly= mobileNo.replaceAll("[^0-9]", "");
        return mobileNumberOnly;
    }

    //Verify Phone Number Format
    public void verifyPhoneNoFormat(By element)
    {
        String mobileFormat = driver.findElement(element).getAttribute("value");
        String number = mobileFormat.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        Assert.assertEquals(number, mobileFormat, "Mobile number is in the expected format");
    }

    //Verify that the error message will be displayed after user inputs 10 digits
    public boolean verifyErrorAfter10DigitsEntry(By mobileInput, By mobileUniquenessError, By tickMark)
    {
        String phoneNoText = driver.findElement(mobileInput).getAttribute("value");
        WebElement uniquenessError = driver.findElement(mobileUniquenessError);
        String numberOnly = phoneNoText.replaceAll("[^0-9]", "");

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileUniquenessError));
        WebElement checkError = driver.findElement(mobileUniquenessError);

        int phoneNoLength = numberOnly.length();
        if((phoneNoLength==10) && (checkError.getText()).contains("Invalid mobile number.") || (checkError.getText()).contains("already in use"))
        {
            Assert.assertTrue(false, "Mobile field has invalid data");

        }
        else if(driver.findElement(tickMark).isDisplayed()==true)
        {
            Assert.assertTrue(true, "Entered phone number is unique");
        }
        return false;
    }

    //Verify entered value in the input fields
    public String getEneteredValue(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        WebElement emailInputNotEditable = driver.findElement(element);
        String enteredEmail = emailInputNotEditable.getAttribute("value");
        return enteredEmail;
    }

    //Chck if a field is empty or has data
    public boolean checkFiedIsBlankOrHasData(By element)
    {
        WebElement inputBox = driver.findElement(element);
        String textInsideInputBox = inputBox.getAttribute("value");
        if(textInsideInputBox.isEmpty())
        {
            Assert.assertTrue(false, element + " is blank.");
            return false;
        }
        else if(!(textInsideInputBox.isEmpty()))
        {
            Assert.assertTrue(true, element + "has data.");
            return true;
        }
        return true;
    }

    //check if error message is shown when the password criteria is not met
    public void validateErrorMessageForPassword(By createPassword, By errorCriteria, String wrongPassword) throws AWTException {
        driver.findElement(createPassword).sendKeys(wrongPassword);
        randomClickBasedOnOS();
        WebElement passwordError = driver.findElement(errorCriteria);

        Boolean status = passwordError.isDisplayed();
        if(status == true)
        {
            randomClickBasedOnOS();
            Assert.assertTrue(true, "Password criteria is validated");
        }
        else
        {
            Assert.assertTrue(false, "Password criteria is validated");
        }
    }

    //Wrong Scenarios
    public void validateWrongScenarios(By elementInput, By elementErrorMessage, String wrongEntry) throws AWTException {
        driver.findElement(elementInput).click();
        randomClickBasedOnOS();
        driver.findElement(elementInput).sendKeys(wrongEntry);
        randomClickBasedOnOS();
        WebElement errorMessage = driver.findElement(elementErrorMessage);

        Boolean status = errorMessage.isDisplayed();
        if(status == true)
        {
            randomClickBasedOnOS();
            Assert.assertTrue(true, " Input riteria is valid");
        }
        else
        {
            Assert.assertTrue(false, "Input criteria is not  valid");
        }
    }

    public void clickBlankInputAndCheckErrors(By elementInput, By errorMessage) throws AWTException {
        clickLinksAndButtons(elementInput);
        randomClickBasedOnOS();
        isErrorDisplayed(errorMessage);
    }

    //Check if an element existis or not
    public void isErrorDisplayed(By element)
    {
        Boolean isPresent = driver.findElements(element).size() > 0;
        if(isPresent==true)
        {
            Assert.assertTrue(true, "Error message is present");
        }
        else
        {
            Assert.fail();
        }
    }

    //enterData
    public void enterData(By element, String dataToBeEntered)
    {
        driver.findElement(element).sendKeys(dataToBeEntered);
    }

    //Blank fields validations
    public void verifyBlankFields(By elementInput, By elementError) throws AWTException {
        driver.findElement(elementInput).click();
        randomClickBasedOnOS();
        driver.findElement(elementError).isDisplayed();
    }

    //getAttribute
    public String getElementAttribute(By element)
    {
        WebElement emailInput = driver.findElement(element);
        String inputAttribute = emailInput.getAttribute("value");
        return inputAttribute;
    }

    public void verifyAnyErrorsDisplayedOnScreen(By element)
    {
        List<WebElement> allErrors = driver.findElements(element);
        if(allErrors.size() != 0){
            for (int i = 0; i < allErrors.size(); i++) {
                Assert.assertTrue(true, allErrors.get(i).getText());
            }
        }
        else{
            Assert.assertFalse(false,"No error message is present on the screen" );
        }
    }

    public void checkFieldsAreEditable(By element1, By element2, By element3)
    {
        Boolean inpuFields1 = driver.findElement(element1).isEnabled();
        Boolean inputField2 = driver.findElement(element2).isEnabled();
        Boolean inputField3 = driver.findElement(element3).isEnabled();
        Assert.assertTrue((inpuFields1 && inputField2 && inputField3) == true, "Input fields would accept data");
    }

    public void checkFieldsAreEditable(By element1, By element2)
    {
        Boolean inpuFields1 = driver.findElement(element1).isEnabled();
        Boolean inputField2 = driver.findElement(element2).isEnabled();
        Assert.assertTrue((inpuFields1 && inputField2) == true, "Input fields would accept data");
    }


}
