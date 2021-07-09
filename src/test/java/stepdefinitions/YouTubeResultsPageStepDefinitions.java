package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import page.YouTubeResultsPage;

import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class YouTubeResultsPageStepDefinitions {

    private final YouTubeResultsPage youTubeResultsPage;

    public YouTubeResultsPageStepDefinitions(WebDriverManager webDriverManager) {
        this.youTubeResultsPage = new YouTubeResultsPage(webDriverManager.getWebDriver());
    }

    @When("I click the {} filter")
    public void iClickTheUploadFilterTypeFilter(String uploadFilterType) {
        youTubeResultsPage.filterButton.click();
        WebElement filterOption = youTubeResultsPage.filterOptions.stream()
                .filter(webElement -> Objects.equals(webElement.getText(), uploadFilterType))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No WebElement found containing " + uploadFilterType));
        filterOption.click();
    }

    @Then("I will see only videos between {int} minutes and {int} minutes long")
    public void onlyVideosBetweenDurationsAreDisplayed(int arg1, int arg2) {
        int hello = arg1;
        int bye = arg2;
        for (WebElement videoTimeDuration : youTubeResultsPage.videoTimeDurations) {
            assertThat(videoTimeDuration.getText(), is(notNullValue()));
        }
    }
}
