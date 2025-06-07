package org.saucedemo.questions;

import org.saucedemo.ui.DisplayProduct;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ProductPageIsVisible implements Question<Boolean> {

    public static ProductPageIsVisible is() {
        return new ProductPageIsVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return DisplayProduct.PRODUCT_TITLE.resolveFor(actor).isVisible();
    }
}