package tests;

import base.DataProvider;
import base.TestBase;
import org.testng.annotations.Test;
import pageActions.HomePageActions;

import java.io.IOException;

public class HomePageTest extends TestBase {

    HomePageActions homePageActions = new HomePageActions();

    public HomePageTest() throws IOException {
    }

    @Test(dataProvider = "CantaloupeTestData", dataProviderClass = DataProvider.class)

    public void validateHomePage
            (String existingAccountEmail, String existingAccountPassword,
             String createAccount, String createAccountPassword, String createAccountConfirmPassword,
             String firstName, String lastName, String mobileNumber, String streetAddress, String city,
             String state, String zipcode, String createNewEmail, String newFirstName, String newLastName,
             String newMobileNumber, String newStreetAddress, String newCity, String newState,
             String newZipcode, String wrongPassword) throws Exception {
       // accountCreationActions.assertCompleteButtonCase();


        homePageActions.verifyCrousal();
        homePageActions.CheckImage();
        homePageActions.verifyHomePage(createNewEmail);
    }
}