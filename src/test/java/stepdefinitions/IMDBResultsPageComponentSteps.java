package stepdefinitions;


import drivermanagement.WebDriverManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.IMDBResultsPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class IMDBResultsPageComponentSteps {

    private final IMDBResultsPage imdbResultsPage;
    private final WebDriverWait webDriverWait;

    public IMDBResultsPageComponentSteps(WebDriverManager webDriverManager) {
        this.imdbResultsPage = new IMDBResultsPage(webDriverManager.getWebDriver());
        this.webDriverWait = new WebDriverWait(webDriverManager.getWebDriver(), 5);
    }

    @Then("I will see movies with titles that include Batman")
    public void moviesHaveCorrectTitles() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(imdbResultsPage.results));
        List<WebElement> movieTitles = imdbResultsPage.results.subList(0, 1);
        for (WebElement movieTitle : movieTitles) {
            assertThat(movieTitle.getText(), containsString("Batman"));
        }
    }
}
