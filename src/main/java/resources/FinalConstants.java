package resources;

import base.TestBase;
import org.openqa.selenium.WebElement;
import pageLocators.HomePageLocators;

import java.io.IOException;

public final class FinalConstants extends TestBase {



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
    public static final String newLastName = "TestingLAstNAme";
    public static final String newMobileNumber = "1111111111";
    public static  final String newStreetAddress = "WilliamsTown";
    public static final String newCity = "Mason";
    public static final String newState = "OH";
    public static final String newZipcode = "45040";
    public static final String wrongPassword = "nhujkil";
    public static final String existingAccountEmail = "shahdab.banday26+58@gmail.com";
    public static final String createAccount = "cntlp2@gmail.com";
    public static final String existingAccountPassword = "Pass123@";
    public static final String signInEmail = "shahdab.banday26@gmail.com";




    //
}

