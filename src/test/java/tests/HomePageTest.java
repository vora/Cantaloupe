package tests;

import base.DataProvider;
import base.TestBase;
import org.testng.annotations.Test;
import pageActions.HomePageActions;
import resources.FinalConstants;

import java.io.IOException;

public class HomePageTest extends TestBase {

    HomePageActions homePageActions = new HomePageActions();

    public HomePageTest() throws IOException {
    }

    @Test
    public void validateHomePage() throws Exception {
       // accountCreationActions.assertCompleteButtonCase();
        homePageActions.verifyCrousal();
        homePageActions.CheckImage();
        homePageActions.verifyHomePage(FinalConstants.createNewEmail);
    }
}