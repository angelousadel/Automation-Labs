package POM_LevelSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class GetPaid {
    WebDriver driver;

    public GetPaid(WebDriver driver){
        this.driver=driver;
    }
    public String check(){

        By itemSelector = new By.ByXPath("//div[@class=\"left\"][contains (.,\"Exchange a Waiver\")]");
        By priceSelector = new By.ByXPath("(//span[@class=\"price-amount\"])[5]");
        WebElement expectedItem = driver.findElement(itemSelector);
        WebElement expectedPrice = driver.findElement(priceSelector);
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOf(expectedItem));
        Assert.assertEquals(expectedItem.getText(),"Exchange a Waiver","Page not found");
        return expectedPrice.getText();
    }
}
