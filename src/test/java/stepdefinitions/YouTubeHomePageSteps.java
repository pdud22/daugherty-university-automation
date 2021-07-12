package stepdefinitions;

import drivermanagement.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.YouTubeHomePage;

public class YouTubeHomePageSteps {

    private final YouTubeHomePage youTubeHomePage;
    private final WebDriver webDriver;

    public YouTubeHomePageSteps(WebDriverManager webDriverManager) {
        this.webDriver = webDriverManager.getWebDriver();
        this.youTubeHomePage = new YouTubeHomePage(webDriverManager.getWebDriver());
    }

    @Given("I have navigated to YouTube")
    public void navigateToYouTube() {
        webDriver.navigate().to("https://www.youtube.com");
    }

    @And("I have searched for {} in the YouTube search bar")
    public void searchWithInput(String searchInput) {
        youTubeHomePage.searchInput.sendKeys("Mozart");
        youTubeHomePage.searchButton.click();
    }
}
