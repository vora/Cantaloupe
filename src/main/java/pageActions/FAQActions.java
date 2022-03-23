package pageActions;

import base.BaseActions;
import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.AccountCreationLocators;
import pageLocators.FAQLocators;
import pageLocators.LandingScreen;
import pageLocators.LoggedInUserLocators;
import resources.FinalConstants;

import java.io.IOException;
import java.util.Properties;

public class FAQActions extends TestBase {

    BaseActions baseActions = new BaseActions();
    FAQLocators faqLocators = new FAQLocators();
    LoggedInUserLocators loggedInUserLocators = new LoggedInUserLocators();


    public FAQActions() throws IOException {
    }

//    WebElement homeLink = driver.findElement(faqLocators.homeLink);
//    WebElement faqHeader = driver.findElement(faqLocators.faqHeader);
//    WebElement q1 = driver.findElement(faqLocators.question1);
//    WebElement a1 = driver.findElement(faqLocators.answer1);
//    WebElement q2 = driver.findElement(faqLocators.question2);
//    WebElement a2 = driver.findElement(faqLocators.answer2);
//    WebElement q3 = driver.findElement(faqLocators.question3);
//    WebElement a3 = driver.findElement(faqLocators.answer3);
//    WebElement q4 = driver.findElement(faqLocators.question4);
//    WebElement a4 = driver.findElement(faqLocators.answer4);
//    WebElement q5 = driver.findElement(faqLocators.question5);
//    WebElement a5 = driver.findElement(faqLocators.answer5);

    public void navigateBackToDashboard()
    {
        baseActions.clickButton(faqLocators.homeLink);
    }

    public void validateUIOnFAQ()
    {
        WebElement homeLink = driver.findElement(faqLocators.homeLink);
        WebElement faqHeader = driver.findElement(faqLocators.faqHeader);
        WebElement q1 = driver.findElement(faqLocators.question1);
        WebElement a1 = driver.findElement(faqLocators.answer1);
        WebElement q2 = driver.findElement(faqLocators.question2);
        WebElement a2 = driver.findElement(faqLocators.answer2);
        WebElement q3 = driver.findElement(faqLocators.question3);
        WebElement a3 = driver.findElement(faqLocators.answer3);
        WebElement q4 = driver.findElement(faqLocators.question4);
        WebElement a4 = driver.findElement(faqLocators.answer4);
        WebElement q5 = driver.findElement(faqLocators.question5);
        WebElement a5 = driver.findElement(faqLocators.answer5);
        Assert.assertTrue((homeLink.isDisplayed()) && (faqHeader.isDisplayed()) && (q1.isDisplayed()) && (a1.isDisplayed())
        && (q2.isDisplayed()) && (a2.isDisplayed()) && (q3.isDisplayed()) && (a3.isDisplayed()) && (q4.isDisplayed()) && (a4.isDisplayed())
        && (q5.isDisplayed()) && (a5.isDisplayed()));
    }

    public void verifyQuestionsOnFAQ()
    {
        WebElement homeLink = driver.findElement(faqLocators.homeLink);
        WebElement faqHeader = driver.findElement(faqLocators.faqHeader);
        WebElement q1 = driver.findElement(faqLocators.question1);
        WebElement a1 = driver.findElement(faqLocators.answer1);
        WebElement q2 = driver.findElement(faqLocators.question2);
        WebElement a2 = driver.findElement(faqLocators.answer2);
        WebElement q3 = driver.findElement(faqLocators.question3);
        WebElement a3 = driver.findElement(faqLocators.answer3);
        WebElement q4 = driver.findElement(faqLocators.question4);
        WebElement a4 = driver.findElement(faqLocators.answer4);
        WebElement q5 = driver.findElement(faqLocators.question5);
        WebElement a5 = driver.findElement(faqLocators.answer5);
        String question1 = q1.getText();
        String answer1 = a1.getText();
        String question2 = q2.getText();
        String answer2 = a2.getText();
        String question3 = q3.getText();
        String answer3 = a3.getText();
        String question4 = q4.getText();
        String answer4 = a4.getText();
        String question5 = q5.getText();
        String answer5 = a5.getText();

        Assert.assertEquals(question1, FinalConstants.faqQ1, "FAQQ1 is valid");
        Assert.assertEquals(answer1, FinalConstants.faqA1, "FAQA1 is valid");
        Assert.assertEquals(question2, FinalConstants.faqQ2, "FAQQ2 is valid");
        Assert.assertEquals(answer2, FinalConstants.faqA2, "FAQA2 is valid");
        Assert.assertEquals(question3, FinalConstants.faqQ3, "FAQQ3 is valid");
        Assert.assertEquals(answer3, FinalConstants.faqA3, "FAQA3 is valid");
        Assert.assertEquals(question4, FinalConstants.faqQ4, "FAQQ4 is valid");
        Assert.assertEquals(answer4, FinalConstants.faqA4, "FAQA4 is valid");
        Assert.assertEquals(question5, FinalConstants.faqQ5, "FAQQ5 is valid");
        Assert.assertEquals(answer5, FinalConstants.faqA5, "FAQA5 is valid");
    }

    public void clickFAQLink()
    {
        baseActions.clickButton(loggedInUserLocators.faqLink);
    }
}

