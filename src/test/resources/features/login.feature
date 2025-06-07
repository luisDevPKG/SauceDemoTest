Feature: Login

  Scenario: Successful login with valid user
    Given the user is on SauceDemo login page
    When the user enters username "standard_user" and password "secret_sauce"
    Then the product inventory will be displayed

  Scenario: Failed login with invalid credentials
    Given the user is on SauceDemo login page
    When the user enters username "standard_user" and password "wrong_password"
    Then he should see a login error message