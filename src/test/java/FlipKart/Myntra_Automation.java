package FlipKart;

import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.time.Duration;

import static FlipKart.Constants.driver;

public class Myntra_Automation extends BaseTest {
    @Test
    public void searchingAnyProduct() {
        Assert.assertTrue(driver.findElement(HomePage.searchButton).isDisplayed());
        Constants.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Constants.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(HomePage.searchButton)));
        driver.findElement(HomePage.searchButton).click();
        driver.findElement(SearchPage.searchBar).sendKeys("Boat Smart Watches");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
