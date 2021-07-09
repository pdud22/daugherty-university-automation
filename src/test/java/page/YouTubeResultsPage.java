package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YouTubeResultsPage {

    @FindBy(css = "#button.style-scope.ytd-toggle-button-renderer.style-text")
    public WebElement filterButton;

    @FindBy(css = ".style-scope.ytd-search-filter-group-renderer")
    public List<WebElement> filterOptions;

    private final WebDriver webDriver;

    public YouTubeResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public List<WebElement> getVideoTimeDurations() {
        return webDriver.findElements(By.cssSelector("#text.style-scope.ytd-thumbnail-overlay-time-status-renderer"));
    }
}
