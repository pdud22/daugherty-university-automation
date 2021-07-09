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

    @Then("Application shows that the email has been sent.")
    public void applicationShowsThatTheEmailHasBeenSent() {
        String actualMessage = webDriverManager.getWebDriver().findElement(By.id("content")).getText();
        assertThat(actualMessage.trim(), is("Your e-mail's been sent!"));
    }

    @Then("Application does not show that email has been sent.")
    public void applicationDoesNotShowThatEmailHasBeenSent() {
        String actualMessage = webDriverManager.getWebDriver().findElement(By.id("content")).getText();
        assertThat(actualMessage.trim(), not("Your e-mail's been sent!"));
    }

    @Given("I have navigated to the status codes page")
    public void aUserNavigatesToStatusCodesPage() {
        webDriverManager.getWebDriver().navigate().to("https://the-internet.herokuapp.com/status_codes");
    }

    @When("I click on a status code of {int}")
    public void aUserClicksOnStatusCodeInput(Integer inputCode) {
        webDriverManager.getWebDriver().findElement(By.partialLinkText(inputCode.toString())).click();
    }

    @Then("The application displays the message {int}")
    public void applicationDisplaysTheMessageOutputCode(Integer outputCode) {
        String expectedMessage = "This page returned a " + outputCode.toString() + " status code.";
        String actualMessage = webDriverManager.getWebDriver().findElement(By.cssSelector("h3 + p")).getText();

        assertThat(actualMessage, containsString(expectedMessage));
    }
}