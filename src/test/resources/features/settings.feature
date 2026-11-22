Feature: Settings

  Scenario: Open Network and internet
    Given the Settings app is open
    When I open the "Network & internet" section
    Then the "Connected devices" section should not be shown
    
      Scenario Outline: Opening a section leaves the main list
    Given the Settings app is open
    When I open the "<section>" section
    Then the "Connected devices" section should not be shown

    Examples:
      | section             |
      | Apps                |
      | Sound & vibration   |
      | Display & touch     |
      
        Scenario: Search bar text is shown
    Given the Settings app is open
    Then the search bar should say "Search Settings"