package tests.smoketests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddProductToCart;
import pages.Checkout;
import pages.SignInPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.JSUtils;

public class AddingProductToCart {

    AddProductToCart addProductToCart;
    Checkout checkout;

    @DataProvider(name="siginInfo")
    public Object[][] getData(){

        String path = "./src/test/java/resources/TestData.xlsx";
        String sheetName="Sheet1";

        ExcelUtil excelUtil = new ExcelUtil(path,sheetName);

        Object[][] signinDetails=excelUtil.getDataArrayWithoutFirstRow();

        return signinDetails;
    }

    @Test(dataProvider = "siginInfo")
    public void setSignInPage(String email, String password) throws InterruptedException {

        addProductToCart = new AddProductToCart();
        checkout=new Checkout();

        Driver.getDriver().get(ConfigurationReader.getProperty("amazon_url"));

        addProductToCart.searchBox.sendKeys("iphone 13", Keys.ENTER);
        Thread.sleep(3000);
        addProductToCart.adressButton.click();
        Thread.sleep(3000);
        addProductToCart.addressBox.sendKeys("95630");
        Thread.sleep(3000);
        addProductToCart.applyButton.click();
        Thread.sleep(2000);
        addProductToCart.continueButton.click();
        Thread.sleep(3000);
        addProductToCart.appleBox.click();
        addProductToCart.minimumPrice.sendKeys("600");
        addProductToCart.maxPrice.sendKeys("2500");
        addProductToCart.doneButton1.click();
        Thread.sleep(3000);
        addProductToCart.modelYear.click();
        Thread.sleep(3000);
        addProductToCart.sortButton.click();
        addProductToCart.highToLoxButton.click();

        for (WebElement product : addProductToCart.products) {

            if (product.getText().contains("iPhone 13")) {

                product.click();
                int actualPrice = Integer.parseInt(addProductToCart.actualPrice.getText().replaceAll("[^0-9]", ""))/100;
                Assert.assertTrue(actualPrice > 500 && actualPrice < 2500);
                Thread.sleep(3000);
                JSUtils.clickElementByJS(addProductToCart.memoryCapacity);
                JSUtils.clickElementByJS(addProductToCart.color);

                String inStockText= addProductToCart.inStockButton.getText();
                Assert.assertFalse(inStockText=="Currently unavailable.");

                addProductToCart.signInToCheckEligibility.click();

                Thread.sleep(5000);
                checkout.emailBox1.sendKeys(email);
                checkout.passwordBox.sendKeys(password);
                checkout.signInButton.click();
                //checkout.notNowButton.click();
                checkout.radioButton.click();
                checkout.addToChartButton.click();
                Thread.sleep(3000);
                checkout.goToChart.click();
                Thread.sleep(3000);
                JSUtils.clickElementByJS(checkout.checkoutButton);
                Assert.assertTrue(checkout.countryVerification.getText().contains("United States"));
                checkout.phoneNumberBox.sendKeys("1235455");
                checkout.adressBox.sendKeys("1004 E Bidwell St Ste 600");
                checkout.cityBox.sendKeys("Folsom");
                Thread.sleep(3000);
                checkout.dropdown.click();
                Thread.sleep(3000);
                Actions actions =new Actions(Driver.getDriver());
                actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
                //new Select(checkout.stateDropdown).selectByVisibleText("California");
                Thread.sleep(5000);
                checkout.submitButton.click();
                Thread.sleep(5000);
                String verificationText= checkout.paymentMethod.getText();
                Assert.assertEquals(verificationText,"Select a payment method");

            }
        }
    }}

