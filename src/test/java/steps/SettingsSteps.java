package steps;

import static org.junit.jupiter.api.Assertions.*;

import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.SettingsPage;

public class SettingsSteps {
    private SettingsPage settings;

    @Given("the Settings app is open")
    public void settingsAppIsOpen() {
        settings = new SettingsPage(Hooks.getDriver());
        assertEquals("Search Settings", settings.getSearchBarText());
    }

    @When("I open the {string} section")
    public void openSection(String name) {
        settings.openSection(name);
    }

    @Then("the {string} section should not be shown")
    public void sectionNotShown(String name) {
        assertFalse(settings.isSectionShown(name));
    }
    
    @Then("the search bar should say {string}")
    public void the_search_bar_should_say(String expected) {
    	assertEquals(expected, settings.getSearchBarText());
    }
}