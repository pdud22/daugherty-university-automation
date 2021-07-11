package stepdefinitions;

import drivermanagement.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Hooks {
    private final WebDriverManager webDriverManager;

    public Hooks(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
    }

    @After
    public void tearDown() {
        if (webDriverManager.getWebDriver() != null) {
            webDriverManager.getWebDriver().close();
            webDriverManager.getWebDriver().quit();
        }
    }
}