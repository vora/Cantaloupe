package pageLocators;

import org.openqa.selenium.By;

public class LandingScreen {

    public By logo = By.name("//(By.xpath(\"//img[contains(@id,'__next')]");
    public By createAccountButton = By.xpath("//button[@class='styles__Button-sc-1uunjfr-0 raRgG']");
    public By signInButton = By.xpath("//div[@class='styles__Text-sc-8sl76n-0 iZHzdd']");
    public By createAccountBigButton = By.xpath("//*[@id='__next']/main/div/div/div[3]/button");
    public By alreadyHaveAccountButton = By.xpath("//*[text()='Already have an account?']");




}