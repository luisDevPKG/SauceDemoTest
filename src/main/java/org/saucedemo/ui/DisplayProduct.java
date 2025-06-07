package org.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DisplayProduct {
    public static final Target ADD_BACKPACK = Target.the("Add Backpack").located(By.id("add-to-cart-sauce-labs-backpack"));
    public static final Target ADD_BIKE_LIGHT = Target.the("Add Bike Light").located(By.id("add-to-cart-sauce-labs-bike-light"));
    public static final Target CART_ICON = Target.the("Cart icon").located(By.className("shopping_cart_link"));
}
