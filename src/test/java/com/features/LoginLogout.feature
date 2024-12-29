Feature: As a Amazon user I should be able to login and logout with valid credentials

  Background:
    Given I open the application
    Then I click on sign in button and wait for sign in page
    Then I should see Sign In Page
    When I enter username as "testusername"
    And I Click on Continue button
    And I enter password as "testpassword"
    And click on login button
    Then I am logged in and should see homepage

  Scenario: Login into the application with valid credentials

    Then I choose Electronincs and click on Smartwatches
    Then I click on Apple icon and Apple Smartwatches list out
    Then I add first availabe Smartwatches to cart
    Then I search "Iphone 15" and add two available item to cart
    Then I Select cart from home and remove the earlier added Smartwatches
    Then I Reduce the Quantity of the mobile product to one and proceed to checkout
    And I Click on Sign out
    Then I got log out from the application and land on sign in page



