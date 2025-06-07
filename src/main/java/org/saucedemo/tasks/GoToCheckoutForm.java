package org.saucedemo.tasks;

import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import static org.saucedemo.ui.CheckoutPage.CHECKOUT_BUTTON;

public class GoToCheckoutForm implements Task {
    public static GoToCheckoutForm now() {
        return instrumented(GoToCheckoutForm.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CHECKOUT_BUTTON)
        );
    }
}
