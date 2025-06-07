Feature: Checkout

  Scenario: Complete checkout process
    Given that the user is logged in and has products in the cart
    When he completes the checkout process with first name "Luis", last name "Perez" and zip code "12345"
    Then he should see the order confirmation message