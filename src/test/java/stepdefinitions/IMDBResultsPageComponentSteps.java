package stepdefinitions;


import drivermanagement.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.IMDBResultsPage;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;

public class IMDBResultsPageComponentSteps {

    private final IMDBResultsPage imdbResultsPage;

    public IMDBResultsPageComponentSteps(WebDriverManager webDriverManager) {
        this.imdbResultsPage = new IMDBResultsPage(webDriverManager.getWebDriver());
    }

    @Then("I will see movies with titles that include {}")
    public void moviesHaveCorrectTitles(String resultingMovieTitle) {
        for (WebElement movieTitle : imdbResultsPage.getMovieTitles()) {
            assertThat(movieTitle.getText(), containsString(resultingMovieTitle));
        }
    }

    @And("I will see sections for titles, names, keywords, and companies")
    public void iWillSeeSectionsForTitlesNamesKeywordsAndCompanies() {
        List<String> sectionHeaders = imdbResultsPage.foundSectionHeaders
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(sectionHeaders, containsInAnyOrder("Titles", "Names", "Keywords", "Companies"));
    }
}
