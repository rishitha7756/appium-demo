package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SettingsPage {
    private final AndroidDriver driver;
    private final By searchBarTitle = AppiumBy.id("com.android.settings:id/search_bar_title");

    public SettingsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public String getSearchBarText() {
        return driver.findElement(searchBarTitle).getText();
    }

    public void openSection(String name) {
        driver.findElement(sectionTitle(name)).click();
    }

    public boolean isSectionShown(String name) {
        return !driver.findElements(sectionTitle(name)).isEmpty();
    }

    private By sectionTitle(String name) {
        return AppiumBy.xpath("//android.widget.TextView[@text='" + name + "']");
    }
}