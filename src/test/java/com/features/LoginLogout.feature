Feature: As a Amazon user I should be able to login and logout with valid credentials

  Background:
    Given I open the application
    Then I click on sign in button and wait for sign in page
    Then I should see Sign In Page
    When I enter username as "xyz@gmail.com"
    And I Click on Continue button
    And I enter password as "xyz@123"
    And click on signin button
    Then I am logged in and should see homepage

  Scenario: Login into the application with valid credentials

    Then I search "Apple watch"
    Then I click on second watch and click on add to cart and increase the quantity to 2
    Then I search "Iphone 15" and click on first item and add to cart
    Then I Select cart from home and reduce the Smartwatches quantity by 1
    Then I verify proceed to buy button
    And I Click on Sign out
    Then I got log out from the application and land on sign in page



