package FlipKart;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class FlipKartBaseClass {

    static AndroidDriver driver;
    @BeforeTest
    public static void ConfigureAppium() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");
        options.setPlatformVersion("10");
        options.setAutomationName("UIAutomator2");
        //options.setApp("D:\\Eclipse\\Automation\\src\\test\\java\\Resources\\ApiDemos-debug.apk");
        options.setAppPackage("com.flipkart.android");
        options.setAppActivity("com.flipkart.android.activity.HomeFragmentHolderActivity");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), options);
    }

    public Double getFormattedAmount(String amount, int index){
        Double price = Double.parseDouble(amount.substring(index));
        return price;
    }
    @AfterTest
    public void TearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
        //service.stop();
    }
}
