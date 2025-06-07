Feature: Add products to cart

  Scenario: Add products to cart successfully
    Given that the user is successfully logged in
    When you add the products "Sauce Labs Backpack" and "Sauce Labs Bike Light" to the cart
    Then you should see the products in the cart