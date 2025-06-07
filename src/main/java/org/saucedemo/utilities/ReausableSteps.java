package org.saucedemo.utilities;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import org.saucedemo.models.User;
import org.saucedemo.interactions.OpenBrowser;
import org.saucedemo.tasks.Checkout;
import org.saucedemo.tasks.GoToCheckoutForm;
import org.saucedemo.tasks.Login;
import org.saucedemo.tasks.AddToCart;

import java.util.Arrays;
import java.util.List;

public class ReausableSteps {

    public static void userIsLoginPage(String actorName) {
        theActorCalled(actorName).wasAbleTo(
                OpenBrowser.onSauceDemoHome()
        );
    }

    public static void userIsLoggedIn(User user) {
        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(user)
        );
    }

    public static List<String> userIsLoggedInAndHasProducts(String product1, String product2) {
        theActorInTheSpotlight().attemptsTo(
                AddToCart.toCart(product1, product2)
        );
        return Arrays.asList(product1, product2);
    }

    public static void completeCheckout(String firstName, String lastName, String zipCode) {
        theActorInTheSpotlight().attemptsTo(
                GoToCheckoutForm.now()
        );
        ReusableAssertions.FormCheckoutIsVisible();
        theActorInTheSpotlight().attemptsTo(
                Checkout.withData(firstName, lastName, zipCode)
        );
    }
}
