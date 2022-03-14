package pageLocators;

import org.openqa.selenium.By;

public class ForgotPasswordLocators {

    String email;

    public By forgotPasswordText = By.xpath("//h1[@class='styles__Text-sc-1ualdcc-0 iMfJqE']");
    public By forgotPasswordEmailInput = By.xpath("//input[@id='id_email']");
    public By forgotPasswordSendRestLink = By.xpath("//*[@id='forgot']/div[2]/button");
    public By createNewPasswordH1 = By.xpath("//*[text()='Create new password']");
    public By createNewPasswordWithEmail = By.xpath("//*[text()='Create new password'" + email + "']");
    public By updatePassword = By.xpath("//*[text()='Update password']");
    public By backToWelcomeLink = By.xpath("//*[text()='Back to welcome screen']");
}
