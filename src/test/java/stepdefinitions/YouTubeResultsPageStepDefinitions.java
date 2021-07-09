package stepdefinitions;

import drivermanagement.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.YouTubeResultsPage;

import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class YouTubeResultsPageStepDefinitions {

    private final YouTubeResultsPage youTubeResultsPage;
    private final WebDriverWait webDriverWait;

    public YouTubeResultsPageStepDefinitions(WebDriverManager webDriverManager) {
        this.youTubeResultsPage = new YouTubeResultsPage(webDriverManager.getWebDriver());
        this.webDriverWait = new WebDriverWait(webDriverManager.getWebDriver(), 5);
    }

    @When("I click the {} filter")
    public void iClickTheUploadFilterTypeFilter(String uploadFilterType) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(youTubeResultsPage.filterButton));
        youTubeResultsPage.filterButton.click();
        WebElement filterOption = youTubeResultsPage.filterOptions.stream()
                .filter(webElement -> Objects.equals(webElement.getText(), uploadFilterType))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No WebElement found containing " + uploadFilterType));
        filterOption.click();
    }

    @Then("I will see only videos uploaded in the past {}")
    public void onlyVideosShownInTimeSpan(String timeSpan) {
        for (WebElement videoTimeDuration : youTubeResultsPage.videoMetaData) {
            // This is a generic and not valuable assertion -- we'd want to build upon it to assert on date and time
            assertThat(videoTimeDuration.getAttribute("innerHTML"), is(notNullValue()));
        }
    }
}
