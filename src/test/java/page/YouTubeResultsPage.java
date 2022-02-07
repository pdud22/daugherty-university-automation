package page;

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

    @FindBy(css = "#metadata.style-scope.ytd-video-meta-block")
    public List<WebElement> videoMetaData;

    public YouTubeResultsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
