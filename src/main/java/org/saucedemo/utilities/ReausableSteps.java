package org.saucedemo.utilities;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

import org.saucedemo.models.User;
import org.saucedemo.interactions.OpenBrowser;
import org.saucedemo.tasks.Login;
import org.saucedemo.tasks.AddToCart;

import java.util.Arrays;
import java.util.List;

public class ReausableSteps {

    public static void userIsLoggedIn(String actorName, User user) {
        theActorCalled(actorName).wasAbleTo(
                OpenBrowser.onSauceDemoHome(),
                Login.withCredentials(user)
        );
    }

    public static List<String> userIsLoggedInAndHasProducts(String actorName, String product1, String product2) {
        theActorCalled(actorName).wasAbleTo(
                AddToCart.toCart(product1, product2)
        );
        return Arrays.asList(product1, product2);
    }
}
