package pageLocators;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ManualReloadLocators extends TestBase {

    public By backLink = By.xpath("//*[text()='Back']");
    public By reloadCardHeader = By.xpath("//*[text()='Reload Card']");
    public By cardImg = By.xpath("//img[@src='/images/card-more-prepaid.svg']");
    public By balanceText = By.xpath("//div[contains(text(),'Balance')]");

    public By balanceAmountWithDollar = By.xpath("styles__Amount-sc-1j3b2s7-3 ljkyLm");
    public By manualReloadDropdown = By.xpath("//*[@name='replenish']");
    public By creditCardInput = By.xpath("//input[@id='id_cardnumber']");
    public By creditMonthDropdown = By.xpath("//*[@name='ccmonth']");
    public By creditYearDropdown = By.xpath("//*[@name='ccyear']");
    public By creditSecurityCVV = By.xpath("//input[@id='id_cvc']");
    public By manualReloadAddress = By.xpath("//*[@name='address1']");
    public By manualReloadAddressCheckbox = By.xpath("//input[@id='agreement']");
    public By reloadCardbutton = By.xpath("//*[text()='Reload Card']");








}
