package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouTubeHomePage {

    @FindBy(id = "search")
    public WebElement searchInput;

    @FindBy(id = "search-icon-legacy")
    public WebElement searchButton;

    public WebDriver webDriver;

    public YouTubeHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, YouTubeHomePage.class);
    }
}
