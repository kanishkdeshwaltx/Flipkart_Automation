package FlipKart;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC01_CheckoutFromCart extends FlipKartBaseClass {
    @Test
    public void Checkout() throws InterruptedException {

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            //Select Language
            String LanguageText = driver.findElement(By.xpath("//android.widget.TextView[@text='English']")).getText();
            Assert.assertEquals(LanguageText,"English");
            System.out.println("Assertion for select language page: PASSED");
            driver.findElement(By.xpath("//android.widget.TextView[@text='English']")).click();

            String ContinueButton = driver.findElement(By.id("com.flipkart.android:id/select_btn")).getText();
            Assert.assertEquals(ContinueButton,"CONTINUE");
            System.out.println("Assertion for Continue Button: PASSED");
            driver.findElement(By.id("com.flipkart.android:id/select_btn")).click();


            //Close page for verify number
            driver.hideKeyboard();
            Thread.sleep(3000);
            driver.findElement(By.id("com.flipkart.android:id/custom_back_icon")).click();

            System.out.println("Search bar to be clicked");

            //Search for products page

            System.out.println(driver.getTitle());
            driver.findElement(By.xpath("(//android.widget.TextView[@text='Search for products'])[1]")).click();

            driver.findElement(By.xpath("//android.widget.EditText[@text='Search for Products, Brands and More']")).sendKeys("OnePlus Mobile");
            System.out.println("Search bar is clicked");
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));

            //Deny Location Access

            String AssertTitle = driver.findElement(By.id("com.flipkart.android:id/permission_title")).getText();
            Assert.assertEquals(AssertTitle, "Allow Location Access");
            System.out.println("Assertion for Allow/Deny access: PASSED");

            driver.findElement(By.xpath("//android.widget.Button[@text='NOT NOW']")).click();

            //Scrolling to phone

            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"OnePlus Nord CE 2 Lite 5G (Blue Tide, 128 GB)\"))"));
            String PhoneName = driver.findElement(By.xpath("//android.widget.TextView[@text='OnePlus Nord CE 2 Lite 5G (Blue Tide, 128 GB)']")).getText();
            Assert.assertEquals(PhoneName,"OnePlus Nord CE 2 Lite 5G (Blue Tide, 128 GB)");
            System.out.println("Assertion for Phone Name: PASSED");

            driver.findElement(By.xpath("//android.widget.TextView[@text='OnePlus Nord CE 2 Lite 5G (Blue Tide, 128 GB)']")).click();

            //Add to Cart

            String AddToCartText = driver.findElement(By.xpath("//android.widget.TextView[@text='Add to cart']")).getText();
            Assert.assertEquals(AddToCartText,"Add to cart");
            System.out.println("Assertion for Add to Cart: PASSED");

            driver.findElement(By.xpath("//android.widget.TextView[@text='Add to cart']")).click();

            //To view Cart
            driver.pressKey(new KeyEvent(AndroidKey.BACK));

            driver.findElement(By.id("com.flipkart.android:id/cart_bg_icon")).click();

            //Scroll to Total Amount
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Total Amount\"))"));
            //String amount = driver.findElement(By.xpath("(//android.widget.TextView)[9]")).getText();
            //System.out.println(amount);


            //Assert.assertEquals(DisplayedAmount,"");

            //Remove from Cart
            driver.findElement(By.xpath("//android.widget.TextView[@text='Remove']")).click();

        }
        catch (Exception e) {
            System.out.println("**********Error************");
            e.printStackTrace();
        }
    }
}
