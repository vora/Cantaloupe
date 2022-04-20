package pageLocators;

import org.openqa.selenium.By;

public class ChangePasswordLocators {

    public By changePasswordHeader = By.xpath("//*[text()='Change password']");
    public By backLink = By.xpath("//*[text()='BACK']");
    public By oldPasswordInput = By.xpath("//input[@id='id_oldPassword']");
    public By showOldPassword = By.xpath("//input[@id='id_oldPassword']/../span");
    public By createPasswordInput = By.xpath("//input[@id='id_password']");
    public By showCreatePassword = By.xpath("//input[@id='id_password']/../span");
    public By confirmPasswordInput = By.xpath("//input[@id='id_confirmPassword']");
    public By showConfirmPassword = By.xpath("//input[@id='id_confirmPassword']/../span");
    public By creatNewPasswordHeader = By.xpath("//*[text()='Create new password:']");
    public By updateButton = By.xpath("//*[]text()='Update password'");



}
