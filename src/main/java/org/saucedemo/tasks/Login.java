package org.saucedemo.tasks;

import org.saucedemo.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static org.saucedemo.ui.LoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;

public class Login implements Task {

    private final User user;

    public Login(User user) {
        this.user = user;
    }

    public static Login withCredentials(User user) {
        return instrumented(Login.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getUsername()).into(USERNAME_FIELD),
                Enter.theValue(user.getPassword()).into(PASSWORD_FIELD),
                Click.on(LOGIN_BUTTON)
        );
    }
}
