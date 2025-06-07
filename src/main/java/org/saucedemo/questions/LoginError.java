package org.saucedemo.questions;

import org.saucedemo.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginError implements Question<Boolean> {

    private static final String EXPECTED_MESSAGE = "Epic sadface: Username and password do not match any user in this service";

    public static LoginError is() {
        return new LoginError ();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // Verify that it is visible
        if (!LoginPage.ERROR_MESSAGE.resolveFor(actor).isVisible()) {
            return false;
        }

        // Verify that the text is exactly as expected
        String actualMessage = Text.of(LoginPage.ERROR_MESSAGE).answeredBy(actor);
        return EXPECTED_MESSAGE.equals(actualMessage);    }
}
