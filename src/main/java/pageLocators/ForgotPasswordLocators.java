package pageLocators;

import org.openqa.selenium.By;

public class ForgotPasswordLocators {

    public By forgotPasswordText = By.xpath("//h1[@class='styles__Text-sc-1ualdcc-0 iMfJqE']");
    public By forgotPasswordEmailInput = By.xpath("//input[@id='id_email']");
    public By forgotPasswordSendRestLink = By.xpath("//*[@id='forgot']/div[2]/button");
}
