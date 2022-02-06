package stepdefinitions;

import drivermanagement.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.YouTubeHomePage;

import java.time.Duration;

public class YouTubeHomePageSteps {

    private final YouTubeHomePage youTubeHomePage;
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public YouTubeHomePageSteps(WebDriverManager webDriverManager) {
        this.webDriver = webDriverManager.getWebDriver();
        this.youTubeHomePage = new YouTubeHomePage(webDriverManager.getWebDriver());
        this.webDriverWait = new WebDriverWait(webDriverManager.getWebDriver(), Duration.ofSeconds(5));
    }

    @Given("I have navigated to YouTube")
    public void navigateToYouTube() {
        webDriver.navigate().to("https://www.youtube.com");
    }

    @And("I have searched for {} in the YouTube search bar")
    public void searchWithInput(String searchInput) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(youTubeHomePage.SEARCH_INPUT));
        youTubeHomePage.SEARCH_INPUT.sendKeys(searchInput);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(youTubeHomePage.searchButton));
        youTubeHomePage.searchButton.click();
    }
}
