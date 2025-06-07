package org.saucedemo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.waits.WaitUntil;
import org.saucedemo.ui.LoginPage;
import org.saucedemo.models.User;
import org.saucedemo.interactions.OpenBrowser;
import org.saucedemo.tasks.Login;
import org.saucedemo.questions.LoginError;
import org.saucedemo.utilities.ReusableAssertions;

public class LoginStepDefinitions {

    @Given("the user is on SauceDemo login page")
    public void loadPage() {
        theActorCalled("Luis").wasAbleTo(OpenBrowser.onSauceDemoHome());
        ReusableAssertions.LoginPageIsVisible();
    }

    @When("the user enters username {string} and password {string}")
    public void sendCredentials(String username, String password) {
        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(new User(username, password))
        );
    }

    @Then("the product inventory will be displayed")
    public void validateLoginSuccessful() {
        ReusableAssertions.assertUserIsLoggedIn();
    }

    @Then("he should see a login error message")
    public void validateLoginError() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LoginPage.ERROR_MESSAGE, isVisible()).forNoMoreThan(10).seconds()
        );
        theActorInTheSpotlight().should(seeThat(LoginError.is()));
    }
}
