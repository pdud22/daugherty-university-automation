package stepdefinitions;

import drivermanagement.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import page.IMDBHomePage;

public class IMDBHomePageSteps {

    private final IMDBHomePage imdbHomePage;
    private final WebDriver webDriver;

    public IMDBHomePageSteps(WebDriverManager webDriverManager) {
        this.webDriver = webDriverManager.getWebDriver();
        this.imdbHomePage = new IMDBHomePage(webDriverManager.getWebDriver());
    }

    @Given("I have navigated to IMDB")
    public void navigateToYouTube() {
        webDriver.navigate().to("https://www.imdb.com");
    }

    @When("I have searched for {} in the IMDB search bar")
    public void searchWithInput(String searchInput) {
        imdbHomePage.searchInput.sendKeys("Batman");
        imdbHomePage.searchInput.sendKeys(Keys.ENTER);
    }
}
