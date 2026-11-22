package hooks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.net.URI;

public class Hooks {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() { return driver; }

    @Before
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("Pixel 8")
                .setAppPackage("com.android.settings")
                .setAppActivity(".Settings");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}