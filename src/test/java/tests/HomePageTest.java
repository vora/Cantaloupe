package tests;

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
    public void validateHomePageElements() throws Exception {

        homePageActions.verifyHomePage(FinalConstants.createNewEmail);
    }

    @Test
    public void validateCorousalAndHeaders() throws Exception {

        homePageActions.verifyCrousal();
    }
}