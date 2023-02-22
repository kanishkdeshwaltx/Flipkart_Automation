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

public class TC01_CheckoutFromCart extends FlipKartBaseClass{
    @Test
    public void Checkout() throws InterruptedException {

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Thread.sleep(9000);
            driver.findElement(By.xpath("//android.widget.TextView[@text='English']")).click();
            //Thread.sleep(4000);
            driver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE']")).click();
           // Thread.sleep(9000);
            driver.hideKeyboard();
            //Close page for verify number
            driver.findElement(By.id("com.flipkart.android:id/custom_back_icon")).click();
            Thread.sleep(5000);
            System.out.println("Search bar to be clicked");
            //Search for products page
            Thread.sleep(7000);
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.attributeContains(driver.findElement
//                    (By.className("android.widget.TextView")),"text","Search for products"));
            driver.findElement(By.xpath("(//android.widget.TextView[@text='Search for products'])[1]")).click();
            //Thread.sleep(2000);
            driver.findElement(By.xpath("//android.widget.EditText[@text='Search for Products, Brands and More']")).sendKeys("OnePlus");
            System.out.println("Search bar is clicked");
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));

            //Deny Location Access
            //Thread.sleep(3000);
            String AssertTitle= driver.findElement(By.id("com.flipkart.android:id/permission_title")).getText();
            Assert.assertEquals(AssertTitle,"Allow Location Access");

            //Thread.sleep(3000);
            driver.findElement(By.xpath("//android.widget.Button[@text='NOT NOW']")).click();

            //Scrolling to phone
            Thread.sleep(4000);
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"OnePlus 10 Pro 5G (Volcanic Black, 128 GB) (8 GB RAM)\"))"));

            //Thread.sleep(3000);
            driver.findElement(By.xpath("//android.widget.TextView[@text='OnePlus 10 Pro 5G (Volcanic Black, 128 GB) (8 GB RAM)']")).click();

            //Add to Cart
            //Thread.sleep(3000);
            driver.findElement(By.xpath("//android.widget.TextView[@text='Add to cart']")).click();

            //To view Cart
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            //Thread.sleep(3000);
            driver.findElement(By.id("com.flipkart.android:id/cart_bg_icon")).click();

            //Scroll to Total Amount
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Total Amount\"))"));
            String amount = driver.findElement(By.xpath("(//android.widget.TextView)[9]")).getText();
            System.out.println(amount);
            //double DisplayedAmount = getFormattedAmount(amount,1);
            //int totaolsum = 19987;
            //Assert.assertEquals(DisplayedAmount,"");

            //Remove from Cart
            driver.findElement(By.xpath("//android.widget.TextView[@text='Remove']")).click();
            driver.findElement(By.xpath("//android.widget.TextView[@text='Remove']")).click();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("**********Error************");
        }
    }
}
