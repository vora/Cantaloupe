package tests;

import base.DataProvider;
import base.TestBase;
import base.TestBase1;
import org.testng.annotations.Test;
import pageActions.HomePageActions;
import resources.FinalConstants;

import java.io.IOException;

public class HomePageTest extends TestBase1 {

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