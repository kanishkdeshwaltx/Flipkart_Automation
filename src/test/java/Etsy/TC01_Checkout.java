package Etsy;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC01_Checkout extends EtsyBaseClass{

    @Test
    public void Checkout(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//android.widget.Button[@text='Continue as guest']")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@text='Search for anything on Etsy']")).click();
        driver.findElement(By.id("com.etsy.android:id/search_src_text")).sendKeys("Jewellery");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElement(AppiumBy.accessibilityId("Birthstone Zodiac Necklace, Silver Aries Jewelry, Astrology Necklace, Taurus Gift, zodiac charms, Astrology Jewelry, aries zodiac necklace Button")).click();
        // driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Primary color\"))"));
        //driver.findElement(By.xpath("(//android.widget.EditText[@text='Select an option'])[0]")).click();
        //driver.findElement(By.xpath("//android.widget.TextView[@text='Silver']")).click();
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Length\"))"));
        //driver.findElement(By.xpath("(//android.widget.EditText[@text='Select an option'])[0]")).click();
        //driver.findElement(By.xpath("////android.widget.TextView[@text='Only Charms Inches']")).click();
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add to cart\"))"));


        driver.findElement(By.xpath("//android.widget.TextView[@text='Add to cart']")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add Personalization\"))"));

        driver.findElement(By.xpath("//android.widget.Button[@text='Add Personalization']")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Personalization\"))"));
        driver.findElement(By.id("com.etsy.android:id/clg_text_input")).sendKeys("Capricorn");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Add to cart']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='View in your cart']")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Estimated total (1 item)\"))"));
        String amount = driver.findElement(By.xpath("(//android.widget.TextView)[2]")).getText();
        System.out.println(amount);



        //driver.hideKeyboard();
        //driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}
