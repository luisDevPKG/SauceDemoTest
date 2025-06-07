package org.saucedemo.tasks;

import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.Actor;
import static org.saucedemo.ui.CheckoutPage.*;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;

public class Checkout implements Task {
    private final String firstName;
    private final String lastName;
    private final String zipCode;

    public Checkout(String firstName, String lastName, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    public static Checkout withData(String firstName, String lastName, String zipCode) {
        return instrumented(Checkout.class, firstName, lastName, zipCode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(firstName).into(FIRST_NAME),
            Enter.theValue(lastName).into(LAST_NAME),
            Enter.theValue(zipCode).into(ZIP_CODE),
            Click.on(CONTINUE_BUTTON),
            Click.on(FINISH_BUTTON)
        );
    }
}

