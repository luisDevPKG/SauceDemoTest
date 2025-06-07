package org.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {
    public static final Target ITEM_BACKPACK = Target.the("Backpack in cart").located(By.xpath("//div[text()='Sauce Labs Backpack']"));
    public static final Target ITEM_BIKE_LIGHT = Target.the("Bike Light in cart").located(By.xpath("//div[text()='Sauce Labs Bike Light']"));
    public static final Target CHECKOUT_BUTTON = Target.the("Checkout button").located(By.id("checkout"));
}
