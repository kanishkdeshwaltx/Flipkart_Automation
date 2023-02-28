package FlipKart;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static FlipKart.Constants.driver;

public class BaseTest {

    @BeforeTest
    public void LaunchingAPP() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setChromedriverExecutable("");
          options.setApp(System.getProperty("user.dir") + "\\src\\test\\resources\\flipkart.apk");
        //options.setApp(System.getProperty("user.dir") + "\\src\\test\\resources\\Myntra.apk");
        //options.setCapability("appActivity", "com.myntra.android.SplashActivity");
        //options.setCapability("appPackage", "com.myntra.android");        //driverInvoke
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterTest
    public void terminateApp() {
        driver.quit();
    }
}
