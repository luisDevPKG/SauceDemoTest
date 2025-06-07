package org.saucedemo.questions;

import net.serenitybdd.screenplay.questions.Text;
import org.saucedemo.ui.CheckoutPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class IsOrderConfirmationVisible implements Question<Boolean>{

    private static final String EXPECTED_MESSAGE = "Thank you for your order!";

    public static IsOrderConfirmationVisible is() {
        return new IsOrderConfirmationVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // Verify that it is visible
        if (!CheckoutPage.ORDER_CONFIRMATION_TEXT.resolveFor(actor).isVisible()) {
            return false;
        }
        // Verify that the text is exactly as expected
        String actualMessage = Text.of(CheckoutPage.ORDER_CONFIRMATION_TEXT).answeredBy(actor);
        return EXPECTED_MESSAGE.equals(actualMessage);
    }
}
