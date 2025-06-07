package org.saucedemo.questions;

import org.saucedemo.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;

public class CartContainsProducts implements  Question<List<String>> {

    private final List<String> expectedProductNames;

    public CartContainsProducts(List<String> expectedProductNames) {
        this.expectedProductNames = expectedProductNames;
    }

    public static CartContainsProducts correctItems(List<String> expectedProductNames) {
        return new CartContainsProducts(expectedProductNames);
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        List<String> actualProducts = new ArrayList<>();

        if (CartPage.ITEM_BACKPACK.resolveFor(actor).isVisible()) {
            actualProducts.add("Sauce Labs Backpack");
        }
        if (CartPage.ITEM_BIKE_LIGHT.resolveFor(actor).isVisible()) {
            actualProducts.add("Sauce Labs Bike Light");
        }
        return actualProducts;
    }
}
