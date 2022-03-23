package pageLocators;

import org.openqa.selenium.By;

public class LoggedInUserLocators {

    public By profileLink = By.xpath("//*[text()='Profile']");
    public By signOutLink = By.xpath("//*[@id='__next']/main/div/div/div/div/div[2]/a/span[2]");
    public By faqLink = By.xpath("//*[text()='FAQ']");
}


