package pageActions;

import base.BaseActions;
import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageLocators.ManualReloadLocators;
import pageLocators.MoreCardDetailScreenLocators;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Properties;

public class ManualReloadActions extends TestBase {

    Properties prop = new Properties();
    BaseActions baseActions = new BaseActions();
    MoreCardDetailScreenLocators moreCardDetailScreenLocators = new MoreCardDetailScreenLocators();
    ManualReloadLocators manualReloadLocators = new ManualReloadLocators();


    public ManualReloadActions() throws IOException {
    }

    //Verify that the user can view the "Manual Reload" button in the prepaid store value card
    public WebElement verifyManualReloadButton() {
        WebElement manualReloadButton = driver.findElement(moreCardDetailScreenLocators.manualReloadText);
        manualReloadButton.isEnabled();
        return manualReloadButton;
    }

    //Verify that after clicking on "Manual Reload" button the user will be navigated to "Reload Card" screen
    public void navigateToManualRelodScreen() {
        WebElement clickManualButton = verifyManualReloadButton();
        clickManualButton.click();
        Assert.assertTrue(driver.findElement(manualReloadLocators.reloadCardHeader).isDisplayed() == true);

    }

    //Verify that the "Reload with" field is editable by the user
    public void manualReloadDropdownValues() {
        driver.findElement(manualReloadLocators.manualReloadDropdown).isEnabled();
        baseActions.getallOptions(manualReloadLocators.manualReloadDropdown);

        Select select = new Select(driver.findElement(manualReloadLocators.manualReloadDropdown));
        WebElement getDropdownValue = select.getFirstSelectedOption();
        System.out.println(getDropdownValue.getText() + "***********************");

        driver.findElement(manualReloadLocators.manualReloadDropdown).click();
        select.selectByValue(properties.getProperty("dropdownChangeValue"));
        WebElement getSelectednValue = select.getFirstSelectedOption();

        if (((getDropdownValue.getText()).equalsIgnoreCase("25")) && (getSelectednValue.getText()).equalsIgnoreCase(properties.getProperty("dropdownChangeValue"))) {
            Assert.assertTrue(true, "Dropdown is in editable mode");
        } else {
            Assert.assertTrue(false, "Dropdown is in disabled mode or not working as expected");
        }
    }


    //Verify that 25$ is the default value in the "Reload with" field
    public String verifyDefaultDropdownValue() {
        Select select = new Select(driver.findElement(manualReloadLocators.manualReloadDropdown));
        WebElement getDropdownValue = select.getFirstSelectedOption();
       // Assert.assertTrue((getDropdownValue.getText()).equalsIgnoreCase(properties.getProperty("defaultDropdownValue")));
        return getDropdownValue.getText();

    }

    //Verify that "Bank Credit Card Number" field is editable by the user
    public void verifyCreditCardIsAndSecurityEditable() {
        WebElement creditCardNumber = driver.findElement(manualReloadLocators.creditCardInput);
        WebElement creditCardMonth = driver.findElement(manualReloadLocators.creditMonthDropdown);
        WebElement creditCardYear = driver.findElement(manualReloadLocators.creditMonthDropdown);
        WebElement securityCVV = driver.findElement(manualReloadLocators.creditMonthDropdown);
        Assert.assertTrue((creditCardNumber.isEnabled()) == true, "Credit card field is in enabled mode");
        Assert.assertTrue((creditCardMonth.isEnabled()) == true, "Credit card field is in enabled mode");
        Assert.assertTrue((creditCardYear.isEnabled()) == true, "Credit card field is in enabled mode");
        Assert.assertTrue((securityCVV.isEnabled()) == true, "Credit card field is in enabled mode");
    }

    //element.sendKeys(properties.getProperty("manualReload_CreditCardNumber"));

    public void verifyCreditCardDigitsChecks(String enterCreditCardNumber) {
        baseActions.creditCardValidation(Long.parseLong(enterCreditCardNumber));
    }

    public Boolean isCreditCardExpired(String yymm) throws ParseException {

        DateTimeFormatter ccMonthFormatter = DateTimeFormatter.ofPattern("MM/yy");
        String input = yymm; // for example
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
        simpleDateFormat.setLenient(false);

        Date expiry = simpleDateFormat.parse(input);
        boolean expired = expiry.before(new Date());
        if(expired==true)
        {
            Assert.assertTrue(false, "Credit card is not valid");
        }
        else if(expired==false)
        {
            Assert.assertTrue(true, "Credit card is valid");
        }
        return expired;
    }


}