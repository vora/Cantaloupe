package resources;

import base.TestBase2;
import org.openqa.selenium.WebElement;
import pageLocators.HomePageLocators;

import java.io.IOException;

public final class FinalConstants extends TestBase2 {



    public FinalConstants() throws IOException {
    }

    HomePageLocators homePageLocators = new HomePageLocators();


    public final WebElement image1 = driver.findElement(homePageLocators.moreCardimg);
    public final WebElement image2  = driver.findElement(homePageLocators.morePassImg);
    public final WebElement image3 = driver.findElement(homePageLocators.cpayCardImge);
    public final WebElement image4 = driver.findElement(homePageLocators.moreTransactionImg);
    public final WebElement logo = driver.findElement(homePageLocators.logoImg);

}

