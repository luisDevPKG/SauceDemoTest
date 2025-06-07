package org.saucedemo.stepdefinitions;


import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

import io.cucumber.java.en.And;
import org.saucedemo.models.User;
import org.saucedemo.tasks.*;
import org.saucedemo.questions.IsOrderConfirmationVisible;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.saucedemo.utilities.ReausableSteps;
import org.saucedemo.utilities.ReusableAssertions;

import java.util.List;

public class RegressionStepDefinitions {

    @Given("that the user opens the SauceDemo homepage")
    public void openSauceDemoHomepage() {
        ReausableSteps.userIsLoginPage(
                "Luis"
        );
        ReusableAssertions.LoginPageIsVisible();
    }

    @When("he enters the user {string} and the password {string}")
    public void enterCredentials(String username, String password) {
        ReausableSteps.userIsLoggedIn(
                new User(username, password)
        );
        ReusableAssertions.assertUserIsLoggedIn();
    }

    @And("adds products to cart")
    public void addsProductsToCart() {
        List<String> addedProducts = ReausableSteps.userIsLoggedInAndHasProducts(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light"
        );
        ReusableAssertions.assertProductsInCart(addedProducts);
    }

    @And("checkout with valid data")
    public void checkoutSuccessful() {
        ReausableSteps.completeCheckout(
                "Luis",
                "Perez",
                "12345"
        );
    }

    @Then("you should see the order confirmation message")
    public void verifyOrderConfirmation() {
        theActorInTheSpotlight().should(seeThat(IsOrderConfirmationVisible.is()));
    }
}
