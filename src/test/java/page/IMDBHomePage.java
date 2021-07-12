package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IMDBHomePage {

    @FindBy(id = "suggestion-search")
    public WebElement searchInput;

    @FindBy(css = "#button.js-click-for-more-btn")
    public List<WebElement> moreButtons;

    public IMDBHomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
