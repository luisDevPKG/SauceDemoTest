package org.saucedemo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.saucedemo.interactions.OpenBrowser;
import org.saucedemo.models.User;
import org.saucedemo.tasks.AddToCart;
import org.saucedemo.tasks.Login;
import org.saucedemo.questions.CartContainsProducts;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddToCartStepDefinitions {

    private List<String> addedProducts;

    @Given("that the user is successfully logged in")
    public void LoginSuccessful()  {
        theActorCalled("Luis").wasAbleTo(OpenBrowser.onSauceDemoHome(),
                Login.withCredentials(User.STANDARD)
        );
    }

    @When("you add the products {string} and {string} to the cart")
    public void addProduct(String product1, String product2) {
        theActorInTheSpotlight().attemptsTo(
                AddToCart.toCart(product1,product2)
        );
        addedProducts = Arrays.asList(product1, product2);
    }

    @Then("you should see the products in the cart")
    public void validateProductsInCart() {
        List<String> actualProducts = theActorInTheSpotlight().asksFor(CartContainsProducts.correctItems(addedProducts));
        assertEquals("The products in the cart do not match the ones you have added", addedProducts, actualProducts);
    }
}
