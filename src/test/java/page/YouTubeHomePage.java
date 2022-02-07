package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class YouTubeHomePage {

    @FindBy(xpath = "//input[@id='search']")
    public WebElement SEARCH_INPUT;

    @FindBy(xpath = "//button[@id='search-icon-legacy']/yt-icon")
//    @FindBy(id = "search-icon-legacy")
    public WebElement searchButton;

    public YouTubeHomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
