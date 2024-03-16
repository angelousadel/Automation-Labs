
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Test {
    private WebDriver driver;
    String price = "$29.99";
    String itemName = "Sauce Labs Backpack";
    String priceSelector = "//div[@class=\"inventory_item_name \" and contains(text(),\"Sauce Labs Backpack\")]/ancestor::div[@class=\"inventory_item\"]//following-sibling::div[@class=\"pricebar\"]/div";
    String addToCartSelector = "//div[@class=\"inventory_item_name \" and contains(text(),\"Sauce Labs Backpack\")]/ancestor::div[@class=\"inventory_item\"]//following-sibling::div[@class=\"pricebar\"]/button";

    String cartLogo = "//div/div/div/div/div/div[@id='shopping_cart_container']/a";
    String cartItem = "//div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div[@class=\"inventory_item_name\"]";
    String nameCart;



    @org.testng.annotations.Test
    public void TestCase1() {

        //Sign in
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        By loginPageUserInputSelector = By.id("user-name");
        By loginPagePasswordInputSelector = By.id("password");
        By submitButtonSelector = By.id("login-button");
        WebElement usernameInput = driver.findElement(loginPageUserInputSelector);
        WebElement passwordInput = driver.findElement(loginPagePasswordInputSelector);
        WebElement submitButton = driver.findElement(submitButtonSelector);
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        submitButton.click();

        //Search for item
        String locator = "//div[@class=\"inventory_item_name \" and contains(.,\"%s\")]";
        String.format(locator, itemName);

        WebElement priceOfItem = driver.findElement(By.xpath(priceSelector));
        String foundPrice = priceOfItem.getAttribute("innerHTML");
        Assert.assertEquals(foundPrice, price, "Price Not Valid!");

        // Add to cart
        WebElement addToCartButton = driver.findElement(By.xpath(addToCartSelector));
        addToCartButton.click();

        //Ensure item in cart
        driver.findElement(By.xpath(cartLogo)).click();
        nameCart = driver.findElement(By.xpath(cartItem)).getText();
        Assert.assertEquals(nameCart, itemName, "Not the same item");



    }
    @AfterMethod
    public void takeScreenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot.toPath(), new File("src/main/resources/screenshots" + result.getName() + ".png").toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       // driver.quit();
    }
}