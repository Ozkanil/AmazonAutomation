package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Checkout {

    public Checkout() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name="email")
    public WebElement emailBox1;

    @FindBy(id="ap_password")
    public WebElement passwordBox;

    @FindBy(id="signInSubmit")
    public WebElement signInButton;

    @FindBy(id="ap-account-fixup-phone-skip-link")
    public WebElement notNowButton;

    @FindBy(xpath = "//input[@type='radio']")
    public WebElement radioButton;

    @FindBy(xpath = "//input[@title='Add to Shopping Cart']")
    public WebElement addToChartButton;

    @FindBy(id="sw-gtc")
    public WebElement goToChart;

    @FindBy(name = "proceedToRetailCheckout")
    public WebElement checkoutButton;

    @FindBy(xpath= "(//*[@class='a-dropdown-prompt'])[1]")
    public WebElement countryVerification;

    @FindBy(id="address-ui-widgets-enterAddressPhoneNumber")
    public WebElement phoneNumberBox;

    @FindBy(id="address-ui-widgets-enterAddressLine1")
    public WebElement adressBox;

    @FindBy(id="address-ui-widgets-enterAddressCity")
    public WebElement cityBox;

    @FindBy(id="address-ui-widgets-enterAddressStateOrRegion")
    public WebElement dropdown;

    @FindBy(id="address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")
    public WebElement stateDropdown;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitButton;

    @FindBy(tagName = "h1")
    public WebElement paymentMethod;


}
