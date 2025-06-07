package org.saucedemo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

import org.saucedemo.models.User;
import org.saucedemo.interactions.OpenBrowser;
import org.saucedemo.questions.ProductPageIsVisible;
import org.saucedemo.questions.LoginError;
import org.saucedemo.tasks.Login;

public class LoginStepDefinitions {

    @Given("the user is on SauceDemo login page")
    public void loadPage() {
        theActorCalled("Luis").wasAbleTo(OpenBrowser.onSauceDemoHome());
    }

    @When("the user enters username {string} and password {string}")
    public void sendCredentials(String username, String password) {
        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(new User(username, password))
        );
    }

    @Then("the product inventory will be displayed")
    public void validateLoginSuccessful() {
        theActorInTheSpotlight().should(seeThat(ProductPageIsVisible.is()));
    }

    @Then("he should see a login error message")
    public void validateLoginError() {
        theActorInTheSpotlight().should(seeThat(LoginError.is()));
    }
}
