package Test_LevelSet;

import POM_LevelSet.GetPaid;
import POM_LevelSet.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetPaidTest {



        WebDriver driver = new FirefoxDriver();
        HomePage Home = new HomePage(driver);
        GetPaid getPaid = new GetPaid(driver);



        @Test
        public void Test1() {
        Home.navigateHome();
        Home.clickGetPaid();
        getPaid.check();
        }
 }



