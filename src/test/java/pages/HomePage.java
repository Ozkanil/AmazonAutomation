package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {

    public HomePage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "//span[@class='icp-nav-link-inner']")
    public WebElement languageDropdown;

    @FindBy(xpath = "//a[@href ='#switch-lang=de_DE']")
    public WebElement languageRadioButton;

    @FindBy(id = "nav-link-accountList")
    public WebElement signInTab;

    @FindBy(id="nav-search-submit-button")
    public WebElement searchInitiator;

    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    public WebElement searchedText;

    @FindBy(xpath = "(//*[@class='nav-action-inner'])[1]")
    public WebElement signInButton;

    @FindBy(id= "searchDropdownBox")
    public WebElement dropdownBox;

    @FindBy(xpath = "//*[@id='searchDropdownBox']/option")
    public List<WebElement> dropdownList;

    @FindBy(xpath = "(//span[@class='icp-color-base'])[1]")
    public WebElement languageButton;

    @FindBy(id="nav-hamburger-menu")
    public WebElement allDropdown;

    @FindBy(linkText = "Anmelden")
    public WebElement signInButtonDropdown;

    @FindBy(id="nav-cart-count")
    public WebElement chartCount;
}
