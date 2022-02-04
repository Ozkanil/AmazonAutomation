package tests.smoketests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class AccountCreationPageTest {

    CreateAccountPage createAccountPage;

    @Test
    public void accountCreationPageTest() throws InterruptedException {

        createAccountPage=new CreateAccountPage();

        Driver.getDriver().get(ConfigurationReader.getProperty("amazon_url"));

        ReusableMethods.hover(createAccountPage.signInTab);

        createAccountPage.startHereText.click();
        createAccountPage.nameBox.sendKeys("name");
        Thread.sleep(3000);
        createAccountPage.emailBox.sendKeys("test@gmail.com");
        createAccountPage.passwordBox.sendKeys("Test.12345");
        createAccountPage.passwordCheck.sendKeys("Test.12345");
        createAccountPage.continueButton.click();
        Assert.assertTrue(createAccountPage.passwordAlertText.isDisplayed());
        createAccountPage.signInText.click();
        Assert.assertEquals(createAccountPage.signInPageAssertion.getText(),"Sign-In");
        Driver.getDriver().navigate().back();
        createAccountPage.businessAccountCreation.click();
        Assert.assertEquals(createAccountPage.businessAccountCreationText.getText(),"Let’s create your free Amazon Business account");

    }
}
