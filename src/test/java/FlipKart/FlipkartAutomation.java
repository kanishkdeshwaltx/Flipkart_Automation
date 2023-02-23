package FlipKart;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static FlipKart.Constants.driver;

public class FlipkartAutomation {

    @Test
    public void testcase() throws InterruptedException {
        driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"English\"]")).click();
        driver.findElement(MobileBy.xpath("//android.widget.Button[@text=\"CONTINUE\"]")).click();
        driver.findElement(MobileBy.id("com.flipkart.android:id/custom_back_icon")).click();
        WebElement element = driver.findElement((By.xpath("//android.widget.TextView[@text=\"Search for products\"]")));
        element.click();
        driver.findElement(By.xpath("//android.widget.EditText[@text=\"Search for Products, Brands and More\"]")).sendKeys("iphone");
        driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"iphone 13\"]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@text=\"NOT NOW\"]")).click();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //..wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiScrollable(new uiSelector)).ScrollIntoView(new UiSelector().text(\"APPLE iPhone 13 (Starlight, 256 GB)\"))")));
        Thread.sleep(2000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new uiSelector)).ScrollIntoView(new UiSelector().text(\"APPLE iPhone 13 (Starlight, 256 GB)\"))")).click();
        driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"Add to cart\"]")).click();
        driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"GO TO CART\"]")).click();
        driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"Place Order \"]")).click();
    }
}
