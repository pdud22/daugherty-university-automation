package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.YouTubeHomePage;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class YouTubeHomePageStepDefinitions {

    private YouTubeHomePage youTubeHomePage;

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
