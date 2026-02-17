Feature: WordPress Photo Directory validation
 
  Scenario: Verify WordPress navigation and photo search
    Given the user launches the browser
    And the user navigates to the WordPress site
    When the user opens the responsive menu if visible
    And the user extends the submenu
    Then the page title should contain "WordPress"
 
    When the user clicks Get WordPress
    Then the page heading should be "Get WordPress"
 
    When the user navigates to Photo Directory
    Then photos should be displayed
 
    When the user searches photos with keyword "nature"
    And the user clicks the first photo
    Then the alternative text should contain "nature"
 