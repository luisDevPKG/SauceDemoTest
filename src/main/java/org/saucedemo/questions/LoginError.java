package org.saucedemo.questions;

import org.saucedemo.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LoginError implements Question<Boolean> {

    public static LoginError is() {
        return new LoginError ();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LoginPage.ERROR_MESSAGE.resolveFor(actor).isVisible();
    }
}
