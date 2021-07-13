package stepdefinitions;


import drivermanagement.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import page.IMDBResultsPage;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
        List<String> sectionHeaders = imdbResultsPage.sectionHeaders
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(sectionHeaders, containsInAnyOrder("Titles", "Names", "Keywords", "Companies"));
    }

    @Then("I will see that no results were found for {}")
    public void iWillSeeThatNoResultsWereFound(String searchInput) {
        assertThat(imdbResultsPage.header.getText(), is(equalTo("No results found for " + '"' + searchInput + '"')));
    }
}
