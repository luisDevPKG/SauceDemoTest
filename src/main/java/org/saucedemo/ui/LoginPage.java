package org.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target USERNAME_FIELD = Target.the("Username field").located(By.id("user-name"));
    public static final Target PASSWORD_FIELD = Target.the("Password field").located(By.id("password"));
    public static final Target LOGIN_BUTTON = Target.the("Login button").located(By.id("login-button"));
    public static final Target ERROR_MESSAGE = Target.the("Login error message").located(By.cssSelector("[data-test='error']"));
}
