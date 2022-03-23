package resources;

import org.openqa.selenium.WebElement;
import pageLocators.HomePageLocators;

import java.io.IOException;

public final class FinalConstants extends TestBase1 {



    public FinalConstants() throws IOException {
    }


    public static final WebElement image1 = driver.findElement(HomePageLocators.moreCardimg);
    public static final WebElement image2  = driver.findElement(HomePageLocators.morePassImg);
    public static final WebElement image3 = driver.findElement(HomePageLocators.cpayCardImge);
    public static final WebElement image4 = driver.findElement(HomePageLocators.moreTransactionImg);
    public static final WebElement logo = driver.findElement(HomePageLocators.logoImg);
   // public static final WebElement tickMark = driver.findElement(CreateAccountLocators.tickMarkImage);


    public static final String createAccountPassword = "Mason123@";
    public static final String createAccountConfirmPassword = "Mason123@";
    public static final String firstName = "Raj";
    public static final String lastName = "Prem";
    public static final String mobileNumber = "1237653456";
    public static final String streetAddress = "1234 Wiiljhnserh, ln";
    public static final String city = "Warrensburg";
    public static final String state = "Missouri";
    public static final String zipcode = "87678";
    public static final String createNewEmail = "cntlp3@yopmail.com";
    public static final String newFirstName = "Testing";
    public static final String newLastName = "TestingLAstName";
    public static final String newMobileNumber = "1111111111";
    public static  final String newStreetAddress = "WilliamsTown";
    public static final String newCity = "Mason";
    public static final String newState = "OH";
    public static final String newZipcode = "45040";
    public static final String wrongPassword = "nhujkil";
    public static final String existingAccountEmail = "cntlp1@yopmail.com";
    public static final String createAccount = "cntlp2@gmail.com";
    public static final String existingAccountPassword = "Mason@123";
    public static final String signInEmail = "shahdab.banday26@gmail.com";
    public static final String newPassword = "Mason@123";
    public static final String newConfirmPassword = "Mason@123";



    //MoreCardDetails

    public static final String moreCardNumber = "1234567890123456789";
    public static final String moreCardNumberInvalid = "1234567890123456789";
    public static final String moreCardNumberAlreadyRegistered = "6396212035796818322";
    public static final String secutityNumber = "6396";
    public static final String registeredMoreCardAlertText = "This card has already been registered. Please try another card";
    public static final String invalidMoreCardNumberAlertText = "You entered an invalid card number. Please enter a valid one";





    public static final String regexMoreCard = "^\\d{19}$";
    public static final String regexSecurity = "^\\d{4}$";
    public static final String regexEmail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    public static final String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$";
    public static final String regexFirstAndLastName = "^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{8,20})?)";
    public static final String regexAddress = "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";
    public static final String regexCity = "(?:[A-Z][a-z.-]+[ ]?)+";
    public static final  String regexState = "Alabama|Alaska|Arizona|Arkansas|California|Colorado|Connecticut|Delaware|Florida|Georgia|Hawaii|\n" +
            "Idaho|Illinois|Indiana|Iowa|Kansas|Kentucky|Louisiana|Maine|Maryland|Massachusetts|Michigan|\n" +
            "Minnesota|Mississippi|Missouri|Montana|Nebraska|Nevada|New[ ]Hampshire|New[ ]Jersey|New[ ]Mexico\n" +
            "|New[ ]York|North[ ]Carolina|North[ ]Dakota|Ohio|Oklahoma|Oregon|Pennsylvania|Rhode[ ]Island\n" +
            "|South[ ]Carolina|South[ ]Dakota|Tennessee|Texas|Utah|Vermont|Virginia|Washington|West[ ]Virginia\n" +
            "|Wisconsin|Wyoming";


    public static final String platformName = "Android";
    //
}

