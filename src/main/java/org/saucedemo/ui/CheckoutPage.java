package org.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {
    public static final Target CHECKOUT_BUTTON = Target.the("Checkout button").located(By.id("checkout"));
    public static final Target FIRST_NAME = Target.the("First name field").located(By.id("first-name"));
    public static final Target LAST_NAME = Target.the("Last name field").located(By.id("last-name"));
    public static final Target ZIP_CODE = Target.the("Postal code field").located(By.id("postal-code"));
    public static final Target CONTINUE_BUTTON = Target.the("Continue button").located(By.id("continue"));
    public static final Target FINISH_BUTTON = Target.the("Finish button").located(By.id("finish"));
    public static final Target ORDER_CONFIRMATION_TEXT = Target.the("Order confirmation message").located(By.className("complete-header"));
}
