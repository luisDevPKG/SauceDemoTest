package org.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static org.saucedemo.ui.DisplayProduct.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.List;

public class AddToCart implements Task {

    private final String product1;
    private final String product2;

    public AddToCart(String product1, String product2) {
        this.product1 = product1;
        this.product2 = product2;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Target> targetsToClick = new ArrayList<>();
        // map Product 1 and 2
        targetsToClick.add(mapProductToTarget(product1));
        targetsToClick.add(mapProductToTarget(product2));

        // Click on the products
        for (Target target : targetsToClick) {
            actor.attemptsTo(Click.on(target));
        }
        actor.attemptsTo(Click.on(CART_ICON));
    }

    private Target mapProductToTarget(String productName) {
        return switch (productName) {
            case "Sauce Labs Backpack" -> ADD_BACKPACK;
            case "Sauce Labs Bike Light" -> ADD_BIKE_LIGHT;
            default -> throw new IllegalArgumentException("Product not mapped: " + productName);
        };
    }

    public static AddToCart toCart(String product1, String product2) {
        return instrumented(AddToCart.class, product1, product2);
    }
}
