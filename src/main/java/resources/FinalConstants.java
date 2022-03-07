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
    //public static final WebElement tickMark = driver.findElement(CreateAccountLocators.tickMarkImage);
}

