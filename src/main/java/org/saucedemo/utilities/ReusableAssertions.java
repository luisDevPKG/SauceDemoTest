package org.saucedemo.utilities;

import org.openqa.selenium.TimeoutException;
import org.saucedemo.ui.CartPage;
import org.saucedemo.ui.CheckoutPage;
import org.saucedemo.ui.LoginPage;
import org.saucedemo.questions.ProductPageIsVisible;
import org.saucedemo.questions.CartContainsProducts;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import net.serenitybdd.screenplay.targets.Target;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ReusableAssertions {

    public static void LoginPageIsVisible() {
        List<Target> elementsToValidate = Arrays.asList(
                LoginPage.USERNAME_FIELD,
                LoginPage.PASSWORD_FIELD,
                LoginPage.LOGIN_BUTTON
        );
        try {
            for (Target element : elementsToValidate) {
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(element, isVisible())
                                .forNoMoreThan(Duration.ofSeconds(10))
                );
            }
        } catch (TimeoutException e) {
            System.out.println("One or more LoginPage elements did NOT become visible after 10 seconds.");
            throw e;
        }
    }

    public static void assertUserIsLoggedIn() {
        String actualUrl = theActorInTheSpotlight().asksFor(ProductPageIsVisible.value());
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        assertEquals("The URL is not as expected", expectedUrl, actualUrl);
    }

    /**
     * Validate that the products in the cart are as expected.
     *
     * @param expectedProducts List of expected products in the shopping cart.
     */
    public static void assertProductsInCart(List<String> expectedProducts) {
        List<String> actualProducts = theActorInTheSpotlight().asksFor(CartContainsProducts.correctItems(expectedProducts));
        assertEquals("The products in the cart do not match the ones you have added", expectedProducts, actualProducts);
        try {
            theActorInTheSpotlight().attemptsTo(
                    WaitUntil.the(CartPage.CHECKOUT_BUTTON, isVisible()).forNoMoreThan(10).seconds()
            );
        } catch (TimeoutException e) {
            System.out.println("The Checkout button did not become visible after 10 seconds");
            throw e;
        }
    }

    public static void FormCheckoutIsVisible() {
        List<Target> elementsToValidate = Arrays.asList(
                CheckoutPage.FIRST_NAME,
                CheckoutPage.LAST_NAME,
                CheckoutPage.ZIP_CODE,
                CheckoutPage.CONTINUE_BUTTON
        );
        try {
            for (Target element : elementsToValidate) {
                theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(element, isVisible())
                                .forNoMoreThan(Duration.ofSeconds(10))
                );
            }
        } catch (TimeoutException e) {
            System.out.println("One or more form elements did NOT become visible after 10 seconds.");
            throw e;
        }
    }
}
