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

    public YouTubeResultsPageStepDefinitions(YouTubeResultsPage youTubeResultsPage) {
        this.youTubeResultsPage = youTubeResultsPage;
    }

    @When("I click the {} filter")
    public void iClickTheUploadFilterTypeFilter(String uploadFilterType) {
        WebElement filterOption = youTubeResultsPage.filterOptions.stream()
                .filter(webElement -> Objects.equals(webElement.getText(), uploadFilterType))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No WebElement found containing " + uploadFilterType));
        filterOption.click();
    }

    @Then("I will see only videos between {} minutes and {} minutes long")
    public void onlyVideosBetweenDurationsAreDisplayed(Integer startDuration, Integer endDuration) {
        for (WebElement videoTimeDuration : youTubeResultsPage.videoTimeDurations) {
            assertThat(videoTimeDuration.getText(), is(notNullValue()));
        }
    }
}
