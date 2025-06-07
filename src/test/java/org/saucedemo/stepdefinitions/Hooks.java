package org.saucedemo.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Hooks {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Before
    public void setStage() {
        // Automatically configures the correct ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();

        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Luis").can(BrowseTheWeb.with(driver));
    }
}