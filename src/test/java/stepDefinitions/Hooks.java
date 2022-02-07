package stepDefinitions;

import driverManagement.WebDriverManager;
import io.cucumber.java.After;

import static org.hamcrest.MatcherAssert.assertThat;

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