package tests.smoketests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignInPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class SignInPageTest {

    SignInPage signInPage;

    @Test
    public void setSignInPage(){

      signInPage=new SignInPage();

        Driver.getDriver().get(ConfigurationReader.getProperty("amazon_url"));

        signInPage.signInTab.click();
        signInPage.emailBox.sendKeys(Faker.instance().internet().emailAddress());
        signInPage.continueButton.click();
        String alertText= signInPage.alertText.getText();
        Assert.assertEquals(alertText,"There was a problem");

        signInPage.helpButton.click();
        signInPage.forgotPasswordText.click();

        String assistanceText= signInPage.passwordAssistanceText.getText();
        Assert.assertEquals(assistanceText,"Password assistance");

        Driver.getDriver().navigate().back();

        Driver.getDriver().navigate().back();

        signInPage.accountCreationButton.click();

        String createAccountText= signInPage.createAccountText.getText();
        Assert.assertEquals(createAccountText,"Create account");

    }
}
