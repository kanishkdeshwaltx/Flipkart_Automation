package FlipKart;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static FlipKart.FlipKartBaseClass.driver;

public class BaseTest {

    @Test
    public void LaunchingAPP() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setChromedriverExecutable("");
        options.setApp(System.getProperty("user.dir") + "\\src\\test\\resources\\flipkart.apk");
        //driverInvoke
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
}
