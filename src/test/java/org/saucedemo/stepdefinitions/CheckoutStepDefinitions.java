package org.saucedemo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.saucedemo.models.User;
import org.saucedemo.questions.IsOrderConfirmationVisible;
import org.saucedemo.tasks.Checkout;
import org.saucedemo.tasks.GoToCheckoutForm;
import org.saucedemo.utilities.ReausableSteps;
import org.saucedemo.utilities.ReusableAssertions;
import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CheckoutStepDefinitions {

    @Given("that the user is logged in and has products in the cart")
    public void UserHasProductsInCart()  {
        ReausableSteps.userIsLoggedIn(
                "Luis",
                User.STANDARD
        );
        ReusableAssertions.assertUserIsLoggedIn();

        List<String> addedProducts = ReausableSteps.userIsLoggedInAndHasProducts(
                "Luis",
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light"
        );
        ReusableAssertions.assertProductsInCart(addedProducts);
    }

    @When("he completes the checkout process with first name {string}, last name {string} and zip code {string}")
    public void completeCheckout(String firstName, String lastname, String zipCode) {
        theActorInTheSpotlight().attemptsTo(
                GoToCheckoutForm.now()
        );
        ReusableAssertions.FormCheckoutIsVisible();
        theActorInTheSpotlight().attemptsTo(
                Checkout.withData(firstName, lastname, zipCode)
        );
    }

    @Then("he should see the order confirmation message")
    public void validateConfirmationMessage() {
        theActorInTheSpotlight().should(seeThat(IsOrderConfirmationVisible.is()));
    }
}
