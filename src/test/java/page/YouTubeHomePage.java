package page;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;

public class YouTubeHomePage {

//    final public WebElement SEARCH_INPUT = (WebElement) By.id("search");


    @FindBy(xpath = "//input[@id='search']")
    public WebElement SEARCH_INPUT;
//    public WebElement searchInput;

    @FindBy(id = "search-icon-legacy")
    public WebElement searchButton;

    public YouTubeHomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
