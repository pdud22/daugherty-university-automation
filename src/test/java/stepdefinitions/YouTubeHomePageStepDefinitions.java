package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import page.YouTubeHomePage;

public class YouTubeHomePageStepDefinitions {

    private final YouTubeHomePage youTubeHomePage;

    public YouTubeHomePageStepDefinitions(YouTubeHomePage youTubeHomePage) {
        this.youTubeHomePage = youTubeHomePage;
    }

    @Given("I have navigated to YouTube")
    public void aUserNavigatesToStatusCodesPage() {
        youTubeHomePage.webDriver.navigate().to("https://www.youtube.com");
    }

    @And("I have searched for {}")
    public void searchWithInput(String searchInput) {
        youTubeHomePage.searchInput.sendKeys("Mozart");
        youTubeHomePage.searchButton.click();
    }
}
