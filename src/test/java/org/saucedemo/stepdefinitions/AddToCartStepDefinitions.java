package org.saucedemo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.saucedemo.models.User;
import org.saucedemo.tasks.AddToCart;
import org.saucedemo.utilities.ReausableSteps;
import org.saucedemo.utilities.ReusableAssertions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.Arrays;
import java.util.List;

public class AddToCartStepDefinitions {

    private List<String> addedProducts;

    @Given("that the user is successfully logged in")
    public void LoginSuccessful()  {
        ReausableSteps.userIsLoginPage(
                "Luis"
        );
        ReausableSteps.userIsLoggedIn(
                User.STANDARD
        );
        ReusableAssertions.assertUserIsLoggedIn();
    }

    @When("you add the products {string} and {string} to the cart")
    public void addProduct(String product1, String product2) {
        addedProducts =ReausableSteps.userIsLoggedInAndHasProducts(product1, product2);
    }

    @Then("you should see the products in the cart")
    public void validateProductsInCart() {
        ReusableAssertions.assertProductsInCart(addedProducts);
    }
}
