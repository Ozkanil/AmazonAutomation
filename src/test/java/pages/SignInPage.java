package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignInPage {

    public SignInPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "nav-link-accountList")
    public WebElement signInTab;

    @FindBy(id="ap_email")
    public WebElement emailBox;

    @FindBy(xpath = "//h4")
    public WebElement alertText;

    @FindBy(id="continue")
    public WebElement continueButton;

    @FindBy(id="createAccountSubmit")
    public WebElement accountCreationButton;

    @FindBy(partialLinkText = "Need")
    public WebElement helpButton;

    @FindBy(partialLinkText = "Forgot")
    public WebElement forgotPasswordText;

    @FindBy(tagName = "h1")
    public WebElement passwordAssistanceText;

    @FindBy(xpath = "//h1[contains(text(),'Create account')]")
    public WebElement createAccountText;

}
