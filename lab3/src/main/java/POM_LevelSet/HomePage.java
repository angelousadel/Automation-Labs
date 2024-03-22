package POM_LevelSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class HomePage {
    WebDriver driver;
    String baseURL ="https://www.levelset.com/";


    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void navigateHome (){
        driver.get(baseURL);
        By getPaidSelector = new By.ByXPath("//a[@class='btn btn-info btn-outline mob-dropdown-btn']");
        WebElement expectedHome = driver.findElement(getPaidSelector);
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOf(expectedHome));
        Assert.assertEquals(expectedHome.getText(),"Get paid","element not found");
    }
    public GetPaid clickGetPaid(){

        By getPaidSelector2 = new By.ByXPath("//a[@class='btn btn-info btn-outline mob-dropdown-btn']");
        WebElement getPaidButton = driver.findElement(getPaidSelector2);
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOf(getPaidButton));
        getPaidButton.click();
        return new GetPaid(driver);
    }
}
