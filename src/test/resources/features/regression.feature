Feature: Regression testing

  Scenario: Complete purchase flow from login to confirmation
    Given that the user opens the SauceDemo homepage
    When he enters the user "standard_user" and the password "secret_sauce"
    And adds products to cart
    And checkout with valid data
    Then you should see the order confirmation message