package tests;

import static org.junit.jupiter.api.Assertions.*;
import pages.SettingsPage;
import io.appium.java_client.AppiumBy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URI;
import org.junit.jupiter.api.*;

public class FirstAppiumTest {
    AndroidDriver driver;

    @BeforeEach
    void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("Pixel 8")
                .setAppPackage("com.android.settings")
                .setAppActivity(".Settings");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void settingsAppOpens() {
        String source = driver.getPageSource();
        assertTrue(source.contains("com.android.settings"));
        
        
    }
    @Test
    void printScreen() {
        System.out.println(driver.getPageSource());
    }
    
    @Test
    void openNetworkAndInternet() {
    	driver.findElement(
    			AppiumBy.xpath("//android.widget.TextView[@text='Network & internet']")).click();
    	boolean homseStillShown = !driver.findElements(
    			AppiumBy.xpath("//android.widget.TextView[@text='Connected devices']")).isEmpty();
    	assertFalse(homseStillShown);
    	}
    
    @Test
    void searchBarHasText() {
        String text = driver.findElement(
            AppiumBy.id("com.android.settings:id/search_bar_title")).getText();
        assertEquals("Search Settings", text);
    }
    
    @Test
    void openSectionUsingPage() {
        SettingsPage settings = new SettingsPage(driver);
        assertEquals("Search Settings", settings.getSearchBarText());
        settings.openSection("Network & internet");
        assertFalse(settings.isSectionShown("Connected devices"));
    }
}