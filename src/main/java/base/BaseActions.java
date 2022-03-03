package base;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

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

    //Method to enter text in the search text box
    public String searchText(By locator, String enterText) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(enterText);
        return enterText;
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
        String s = StringUtils.substringBetween(retrievedText, "'", "'");
        String expected = searchText;
        Assert.assertEquals(expected, s);
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
    public List<String> getSpanText(By element) {
        List<WebElement> allErrors = driver.findElements(element);

        List<String> errorText = new ArrayList<>();

        for (int i = 0; i < allErrors.size(); i++) {
            //obtain text
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

    //Edit InputFilds and update with new test data

    public void EditAndUpdateInputFields(By element, String newTestData)
    {
        WebElement webElement = driver.findElement(element);
        TouchAction touchActions = new TouchAction(driver);
        touchActions.tap((TapOptions) webElement);
        deleteInputCharacters(element);
        webElement.sendKeys(newTestData);
    }

    public void EditAndUpdateInputFields(By element, Integer newTestData)
    {
        WebElement webElement = driver.findElement(element);
        TouchAction touchActions = new TouchAction(driver);
        touchActions.tap((TapOptions) webElement);
        deleteInputCharacters(element);
        webElement.sendKeys(String.valueOf(newTestData));
    }

    public void clickButton(By element)
    {
        WebElement webElement = driver.findElement(element);
        webElement.click();
    }

    public void enterValue(By element, String sendKeysData)
    {
         driver.findElement(element).sendKeys(sendKeysData);
    }

    public void enterPhoneNo(By element, String sendKeysData)
    {
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
        } else if((checkPatternCondition == false))
        {
            Assert.assertTrue(true, "The entered email is not valid");
        }
        else
        {
            log.info("Create Account Screen : Something is not proper for email ");
        }
    }

    public String validateErrorMessages(By element)
    {
        WebElement webElement = driver.findElement(element);
        String errorMessage = webElement.getText();
        if(webElement.isDisplayed())
        {

            Assert.assertTrue(true, errorMessage + " is showing up");
        }
        else
        {
            Assert.assertTrue(false, errorMessage + " is not shown");
        }

        return webElement.getText();
    }

    //Tick marks for email, phone number
    public static void verifyTick(WebElement element)
    {
        if(element.isDisplayed())
        {
            Boolean image1Present = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
            Assert.assertTrue(image1Present == true, "Tick mark is present" );
        }
        else if(!(element).isDisplayed())
        {
            Assert.assertTrue(false, "tick mark is not present");
        }
    }

    public void regexPassword(By element, String password)
    {

       String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$";

        WebElement webElement = driver.findElement(element);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        Boolean checkPatternCondition = matcher.matches();

        if (checkPatternCondition == true) {
            webElement.sendKeys(password);
        } else if((checkPatternCondition == false))
        {
            Assert.assertTrue(false, "The entered email is not valid");
        }
        else
        {
            log.info("Create Account Screen : Something is not proper for email ");
        }
    }

    //Verify if the password fields are masked before clicking show
    public void checkPasswordMaskedOrNot(By element)
    {
        WebElement passwordMasked = driver.findElement(element);
        if (passwordMasked.isDisplayed()){

            Boolean showTrue = driver.findElement(element).isEnabled();
            Assert.assertTrue(showTrue);
        }else {
            Boolean showTrue = driver.findElement(element).isEnabled();
            Assert.assertFalse(showTrue);
        }
    }

    //Clear and re-enter data in input field through js
    public void clearInputfieldAndEnterNewData(WebElement element, String editValue)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].value=' "+ editValue + " ';", element);

    }

    public void regexFirstAndLastName(By element, String name)
    {
        String regex = "^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{8,20})?)";
        WebElement webElement = driver.findElement(element);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);

        Boolean checkPatternCondition = matcher.matches();

        if (checkPatternCondition == true) {
            webElement.sendKeys(name);
        } else if((checkPatternCondition == false))
        {
            Assert.assertTrue(true, "The entered name is not valid");
        }
        else
        {
            log.info("Create Account Screen : Something is not proper for the entered name ");
        }
    }

    //regex phone no
    public void regexPhoneno(By element, String phoneNo)
    {
        String regex = "^\\d{10}$";
        WebElement webElement = driver.findElement(element);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNo);

        Boolean checkPatternCondition = matcher.matches();

        if (checkPatternCondition == true) {
            webElement.sendKeys(phoneNo);
        } else if((checkPatternCondition == false))
        {
            Assert.assertTrue(true, "The entered nmber is not valid");
        }
        else
        {
            log.info("Create Account Screen : Something is not proper for the entered phone number ");
        }

    }

      //regex phone no
    public void regexAddress(By element, String phoneNo)
    {

        String regex = "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";
        //String regex = "^\\b\\d{1,8}(-)?[a-z]?\\W[a-z|\\W|\\.]{1,}\\W(road|drive|avenue|boulevard|circle|street|lane|waylrd\\.|st\\.|dr\\.|ave\\.|blvd\\.|cir\\.|In\\.|rd|dr|ave|blvd|cir|ln)";
        WebElement webElement = driver.findElement(element);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNo);

        Boolean checkPatternCondition = matcher.matches();

        if (checkPatternCondition == true) {
            webElement.sendKeys(phoneNo);
        } else if((checkPatternCondition == false))
        {
            Assert.assertTrue(true, "The entered address is not valid");
        }
        else
        {
            log.info("Create Account Screen : Something is not proper for the entered address ");
        }

    }

    //regex phone no
    public void regexZipcode(By element, String zipcode) {
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
    }

    ///^[a-zA-Z]+$/
    public void regexCity(By element, String cityOrState)
    {
        String regex = "(?:[A-Z][a-z.-]+[ ]?)+";
        WebElement webElement = driver.findElement(element);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cityOrState);

        Boolean checkPatternCondition = matcher.matches();

        if (checkPatternCondition == true) {
            webElement.sendKeys(cityOrState);
        } else if((checkPatternCondition == false))
        {
            Assert.assertTrue(true, "The entered address is not valid");
        }
        else
        {
            log.info("Create Account Screen : Something is not proper for the entered address ");
        }

    }


    ///^[a-zA-Z]+$/
    public void regexState(By element, String State)
    {
        String regex = "Alabama|Alaska|Arizona|Arkansas|California|Colorado|Connecticut|Delaware|Florida|Georgia|Hawaii|\n" +
                "Idaho|Illinois|Indiana|Iowa|Kansas|Kentucky|Louisiana|Maine|Maryland|Massachusetts|Michigan|\n" +
                "Minnesota|Mississippi|Missouri|Montana|Nebraska|Nevada|New[ ]Hampshire|New[ ]Jersey|New[ ]Mexico\n" +
                "|New[ ]York|North[ ]Carolina|North[ ]Dakota|Ohio|Oklahoma|Oregon|Pennsylvania|Rhode[ ]Island\n" +
                "|South[ ]Carolina|South[ ]Dakota|Tennessee|Texas|Utah|Vermont|Virginia|Washington|West[ ]Virginia\n" +
                "|Wisconsin|Wyoming";
        WebElement webElement = driver.findElement(element);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(State);

        Boolean checkPatternCondition = matcher.matches();

        if (checkPatternCondition == true) {
            webElement.sendKeys(State);
        } else if((checkPatternCondition == false))
        {
            Assert.assertTrue(true, "The entered address is not valid");
        }
        else
        {
            log.info("Create Account Screen : Something is not proper for the entered address ");
        }

    }
}