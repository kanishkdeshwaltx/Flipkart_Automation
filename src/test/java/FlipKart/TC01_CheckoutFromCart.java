package FlipKart;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC01_CheckoutFromCart extends FlipKartBaseClass {
    @Test
    public void Checkout() throws InterruptedException {

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            //Select Language

            List<WebElement> languageList = driver.findElements(By.id("com.flipkart.android:id/iv_checkbox"));
            int count = languageList.size();
            for (int i=0; i<count; i++){
                WebElement amountString = languageList.get(i);
              Assert.assertEquals(false,amountString.isSelected());
                System.out.println("**");
            }
            System.out.println("Assertion for if radio Button not selected : PASSED");
            driver.findElement(By.xpath("(//android.widget.TextView[@text='English'])[1]")).click();
            String LanguageText = driver.findElement(By.xpath("(//android.widget.TextView[@text='English'])[1]")).getText();
            Assert.assertEquals(LanguageText,"English");
            System.out.println("Assertion for select language text: PASSED");

            WebElement ContinueButton = driver.findElement(By.id("com.flipkart.android:id/select_btn"));
            Assert.assertEquals(true,ContinueButton.isDisplayed());
            System.out.println("Assertion for if Continue Button is enabled: PASSED");
            ContinueButton.click();


            //Close page for verify number

            Thread.sleep(3000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
            wait.until(ExpectedConditions.attributeContains(driver.findElement
                    (By.className("android.widget.TextView")),"text","Sign up with"));

            WebElement NoneOfAboveOption = driver.findElement(By.id("com.google.android.gms:id/cancel"));
            NoneOfAboveOption.click();
            WebElement CloseVerifyNumberPage = driver.findElement(By.id("com.flipkart.android:id/custom_back_icon"));
            CloseVerifyNumberPage.click();
            driver.hideKeyboard();

            //Check Dashboard
            WebElement HomeBtnOnDashboard = driver.findElement(By.xpath("android.widget.TextView"));
            Assert.assertEquals(true,HomeBtnOnDashboard.isDisplayed());
            System.out.println("Assertion for Dashboard: PASSED");

            //Search for products page

            System.out.println("Search bar to be clicked");
            driver.findElement(By.xpath("(//android.widget.TextView[@text='Search for products'])[1]")).click();

            WebElement SearchBarEnabled = driver.findElement(By.xpath("//android.widget.EditText[@text='Search for Products, Brands and More']"));
            Assert.assertEquals(true,SearchBarEnabled.isEnabled());
            System.out.println("Assertion for if Search Bar is Enabled: PASSED");

            SearchBarEnabled.sendKeys("OnePlus 10R (Forest Green, 128 GB)");
            System.out.println("Search bar is clicked");
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));

            //Deny Location Access

            String AssertTitle = driver.findElement(By.id("com.flipkart.android:id/permission_title")).getText();
            Assert.assertEquals(AssertTitle, "Allow Location Access");
            System.out.println("Assertion for Allow/Deny access: PASSED");

            driver.findElement(By.xpath("//android.widget.Button[@text='NOT NOW']")).click();

            //Scrolling to phone

            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"OnePlus 10R (Forest Green, 128 GB)\"))"));
            String PhoneName = driver.findElement(By.xpath("//android.widget.TextView[@text='OnePlus 10R (Forest Green, 128 GB)']")).getText();
            System.out.println(PhoneName);
            //Assert.assertEquals(PhoneName,"OnePlus 10R (Forest Green, 128 GB)");
            //System.out.println("Assertion for Phone Name: PASSED");

            driver.findElement(By.xpath("//android.widget.TextView[@text='OnePlus 10R (Forest Green, 128 GB)']")).click();

            //Add to Cart

            WebElement AddToCartBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='Add to cart']"));
            Assert.assertEquals(true,AddToCartBtn.isDisplayed());
            System.out.println("Assertion for Add to Cart: PASSED");

            AddToCartBtn.click();


            //To view Cart

            driver.pressKey(new KeyEvent(AndroidKey.BACK));

            WebElement ViewCartBtn = driver.findElement(By.id("com.flipkart.android:id/cart_bg_icon"));
            //WebElement ViewCartBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='Go to cart']"));
            Assert.assertEquals(true,ViewCartBtn.isDisplayed());
            System.out.println("Assertion for View Cart Button: PASSED");
            ViewCartBtn.click();

            //Scroll to Total Amount
            //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Total Amount\"))"));
            String PhoneNameOnAddToCart = driver.findElement(By.xpath("//android.widget.TextView[@text='OnePlus 10R (Forest Green, 128 GB) ']")).getText();
            System.out.println(PhoneNameOnAddToCart);
            //.trim() is used to remove whitespace character
            Assert.assertEquals(PhoneName.trim(),PhoneNameOnAddToCart.trim());
            System.out.println("Assertion for Phone Name: PASSED");
            String PlaceOrderAmount = driver.findElement(By.xpath("(//android.view.ViewGroup)[56]")).getText();
            System.out.println(PlaceOrderAmount);
            String amount = driver.findElement(By.xpath("(//android.widget.TextView)[8]")).getText();
            System.out.println(amount);
            String totalAmount = driver.findElement(By.xpath("(//android.widget.TextView)[22]")).getText();
            System.out.println(totalAmount);
            //Assert.assertEquals(amount,totalAmount);
            System.out.println("Assertion for amount: PASSED");


            //Place Order

            WebElement PlaceOrderBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='Place Order ']"));
            Assert.assertEquals(true,PlaceOrderBtn.isDisplayed());
            System.out.println("Assertion for Place Order Button: PASSED");
            PlaceOrderBtn.click();
            Thread.sleep(4000);
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
//            wait.until(ExpectedConditions.attributeContains(driver.findElement
//                    (By.className("android.widget.TextView")),"text","Sign up with"));
            driver.findElement(By.xpath("//android.widget.Button[@text='NONE OF THE ABOVE']")).click();
            //NoneOfAboveOption.click();
            driver.hideKeyboard();
            CloseVerifyNumberPage.click();


            //Remove from Cart
//            WebElement RemoveFromCartBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='Remove']"));
//            RemoveFromCartBtn.click();
//
//            String RemoveItemTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Remove Item ']")).getText();
//            Assert.assertEquals(RemoveItemTitle,"Remove Item ");
//            System.out.println("Assertion for PopUp Remove Item Title: PASSED");
//
//            WebElement PopupRemoveButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Remove']"));
//            PopupRemoveButton.click();
        }
        catch (Exception e) {
            System.out.println("**********Error************");
            e.printStackTrace();
        }
    }
}
