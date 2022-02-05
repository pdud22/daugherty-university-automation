package stepdefinitions;

import drivermanagement.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.YouTubeHomePage;

public class YouTubeHomePageStepDefinitions {

    private final YouTubeHomePage youTubeHomePage;
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public YouTubeHomePageStepDefinitions(WebDriverManager webDriverManager) {
        this.webDriver = webDriverManager.getWebDriver();
        this.youTubeHomePage = new YouTubeHomePage(webDriverManager.getWebDriver());
        this.webDriverWait = new WebDriverWait(webDriverManager.getWebDriver(), 5);
    }

    @Given("I have navigated to YouTube")
    public void navigateToYouTube() {
        webDriver.navigate().to("https://www.youtube.com");
    }

    @And("I have searched for {}")
    public void searchWithInput(String searchInput) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(youTubeHomePage.SEARCH_INPUT));
        youTubeHomePage.SEARCH_INPUT.sendKeys(searchInput);
        youTubeHomePage.searchButton.click();
    }
}
