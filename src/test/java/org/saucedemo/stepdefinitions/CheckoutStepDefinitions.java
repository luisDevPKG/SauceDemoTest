package org.saucedemo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.saucedemo.models.User;
import org.saucedemo.questions.IsOrderConfirmationVisible;
import org.saucedemo.utilities.ReausableSteps;
import org.saucedemo.utilities.ReusableAssertions;
import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CheckoutStepDefinitions {

    @Given("that the user is logged in and has products in the cart")
    public void UserHasProductsInCart()  {
        ReausableSteps.userIsLoginPage(
                "Luis"
        );
        ReausableSteps.userIsLoggedIn(
                User.STANDARD
        );
        ReusableAssertions.assertUserIsLoggedIn();

        List<String> addedProducts = ReausableSteps.userIsLoggedInAndHasProducts(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light"
        );
        ReusableAssertions.assertProductsInCart(addedProducts);
    }

    @When("he completes the checkout process with first name {string}, last name {string} and zip code {string}")
    public void completeCheckout(String firstName, String lastname, String zipCode) {
        ReausableSteps.completeCheckout(firstName, lastname, zipCode);
    }

    @Then("he should see the order confirmation message")
    public void validateConfirmationMessage() {
        theActorInTheSpotlight().should(seeThat(IsOrderConfirmationVisible.is()));
    }
}
