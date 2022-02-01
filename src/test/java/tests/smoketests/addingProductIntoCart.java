package tests.smoketests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProductToCart;
import pages.SignInPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.JSUtils;

public class addingProductIntoCart {

    AddProductToCart addProductToCart;

    @Test
    public void setSignInPage() throws InterruptedException {

        addProductToCart = new AddProductToCart();

        Driver.getDriver().get(ConfigurationReader.getProperty("amazon_url"));

        addProductToCart.searchBox.sendKeys("iphone 13", Keys.ENTER);
        addProductToCart.adressButton.click();
        addProductToCart.addressBox.sendKeys("95630");
        Thread.sleep(3000);
        addProductToCart.applyButton.click();
        Thread.sleep(2000);
        addProductToCart.continueButton.click();
        Thread.sleep(3000);
        addProductToCart.appleBox.click();
        addProductToCart.minimumPrice.sendKeys("500");
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
                Assert.assertTrue(actualPrice > 1000 && actualPrice < 2000);
                Thread.sleep(3000);
                JSUtils.clickElementByJS(addProductToCart.memoryCapacity);
                JSUtils.clickElementByJS(addProductToCart.color);
                addProductToCart.signInToCheckEligibility.click();
            }
        }
    }}

