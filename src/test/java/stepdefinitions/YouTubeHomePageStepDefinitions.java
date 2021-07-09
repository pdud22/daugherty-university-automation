package stepdefinitions;

import drivermanagement.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import page.YouTubeHomePage;

public class YouTubeHomePageStepDefinitions {

    private final YouTubeHomePage youTubeHomePage;
    private final WebDriver webDriver;

    public YouTubeHomePageStepDefinitions(WebDriverManager webDriverManager) {
        this.webDriver = webDriverManager.getWebDriver();
        this.youTubeHomePage = new YouTubeHomePage(webDriverManager.getWebDriver());
    }

    @Given("I have navigated to YouTube")
    public void aUserNavigatesToStatusCodesPage() {
        webDriver.navigate().to("https://www.youtube.com");
    }

    @And("I have searched for {}")
    public void searchWithInput(String searchInput) {
        youTubeHomePage.searchInput.sendKeys("Mozart");
        youTubeHomePage.searchButton.click();
    }
}
